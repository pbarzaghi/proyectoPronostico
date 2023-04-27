/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpi.ar.programa.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tpi.ar.programa.conexion.Conexion;
import tpi.ar.programa.conexion.ConexionBd;
import tpi.ar.programa.exception.FileIntegradorException;
import resources.MsgProperty;
import tpi.ar.programa.entidades.Punto;
import tpi.ar.programa.util.ClaseUtil;

/**
 *
 * @author pbarzaghi
 */
public class RepositorioBdPunto {
    
    
      /*
       Este metodose conecta a la BD y  ejecuta la consulta para obtener los valores de la tabla Punto, crea un Objeto
       Punto y los carga en un HashMap que se encuentra en la clase
       ClaseUtil el cual tiene una variable de clase Map.
       
      */
      public  void obtenerPtosDeTablaPunto() throws FileIntegradorException {
       
     
        
            PreparedStatement stmt = null;
            ResultSet rs = null;
            Connection conn = null;
            Conexion conexion= new ConexionBd();
            Punto punto=null;
            String qry="Select * from punto";
        try{
            conn = (Connection) conexion.abrirConexion();
            stmt = conn.prepareStatement(qry);
            rs = stmt.executeQuery(qry);
            // Procesa los resultados
            if (rs.next()) {
                punto= new Punto();
                punto.setPuntoGanar(rs.getInt("ptosGanar"));
                punto.setPuntoEmpatar(rs.getInt("ptosEmpatar"));  
                punto.setPuntoPerder(rs.getInt("ptosPerder"));
                punto.setPuntoAcierto(rs.getInt("ptosAcertar"));
                punto.setPuntosRonda(rs.getInt("ptosRonda"));
                punto.setPuntosFase(rs.getInt("ptosFase"));
                ClaseUtil.agregarObjeto(Punto.class.toString(), punto);
            }
         
            conexion.cerrarConexion();
             
        } catch (SQLException ex) {
            throw new FileIntegradorException(MsgProperty.getMensaje("error.sentenciaSql"));
        }
  
    }
    
    
}
