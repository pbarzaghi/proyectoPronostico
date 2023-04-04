/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectointegrador;

import java.awt.HeadlessException;
import java.util.List;
import tpi.ar.programa.exception.FileIntegradorException;
import tpi.ar.programa.exception.GolesNegativoException;
import tpi.ar.programa.lectura.file.ReadAllFileCsv;
import tpi.ar.programa.pronostico.GanadorPronostico;
import tpi.ar.programa.pronostico.participante.Participante;


/**
 *
 * @author pbarzaghi
 */
public class ProyectoIntegrador {

    public static void main(String[] args) {
      try {
    
        System.out.println("Path de archivo 1 .. "+args[0]);
        System.out.println("Path de archivo 2 .."+args[1]);
        System.out.println("Path de archivo 3 .."+args[2]);
        String csvResultado = args[0];
        String csvPronostico  = args[1];
        String csvPuntos = args[2];
       // Se dejo de unsar esta clase porque no podia realizar el empaquetamiento
       // con la dependencia que esta en el pom
       // FileCvs file= new FileCvs();
       
       ReadAllFileCsv file = new ReadAllFileCsv();
       
        List<Participante> listaParticipante;
        listaParticipante = file.leerArchivoPronostico(csvPuntos,
                    csvResultado,
                    csvPronostico);
         
        // Invocar los metodos para obtebner los resulados una ves cargados los objetos
          GanadorPronostico ganador= new GanadorPronostico();
         
           for (Participante participante : listaParticipante) {
                 System.out.println(ganador.puntajeParticipantePronostico(participante));
            }
                
        } catch(GolesNegativoException ex1){
             System.out.println( ex1.getMensajeError() );
             System.exit(1);
         }
      
          catch (FileIntegradorException ex) {
                System.out.println( ex.getMensajeError() );
                System.exit(1);
        
        } catch (NullPointerException e){
             System.out.println( "El sistema cerro de forma Abrupta" +e.getMessage() );
             System.exit(1);
             
        
        }catch (HeadlessException e){
           System.out.println( "El sistema sufrio un error inesperado"  );
           System.exit(1);
        }
    
    
    }
}