/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.tpi.ar.entidades;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tpi.ar.programa.entidades.Equipo;

/**
 *
 * @author pbarzaghi
 */
public class EquipoTest {
    
    @Test
    public void nombreEquipoCorrecto(){
          Equipo equipo = new Equipo("ARGENTINA","SELECCION");
          Assertions.assertEquals("ARGENTINA", equipo.getNombre());
        
    }
    
}
