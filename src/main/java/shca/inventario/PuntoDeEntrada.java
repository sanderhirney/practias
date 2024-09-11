/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shca.inventario;

import inventario.Ventana_Principal;

/**
 *
 * @author sander
 */
public class PuntoDeEntrada {
    private static PuntoDeEntrada inicio;
    private PuntoDeEntrada(){
        Ventana_Principal ventana = new Ventana_Principal();
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }
    
    
    public static synchronized PuntoDeEntrada getInicio(){
        System.out.println("Inicio vale: "+inicio);
        if(inicio==null){
            inicio=new PuntoDeEntrada();
        }
        return inicio;
    }
}
