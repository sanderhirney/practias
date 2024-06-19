/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


    
    
/**
 *
 * @author Informatic HSDM
 */
public class ConexionFormateadorReporte {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    int codigo_seccion;
    int decimal=0;
    int resultado=0;//1 si obtuvo respuesta; 0 no obtuvo 
    String cadena="#.";
    public void consulta()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select total from decimales where cod_seccion=?");
        consulta.setInt(1, codigo_seccion);
        ejecutar=consulta.executeQuery();
        if ( ejecutar.next())
        {
            decimal=ejecutar.getInt("total");
            conectar.Cerrar();
        }//if
        
        else
        {
           
        }
        
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de los Decimales .\n Ventana Conexion Formatear Reporte \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
   public void setMascara()
   {
        int a=decimal;
       
       if(a==0)
       {
            cadena="#";
       }//if
       else
       {
        for(int i=0; i<a; i++)
        {
            cadena=cadena+"#";//concateno la cadena al numero de decimales que hay
        }
       }//else
      
   }//get
   public void setSeccion(int recibido)
   {
       codigo_seccion=recibido;
   }
   
   public String getMascara()
   {
       
       return cadena;
   }
    
}//clase
