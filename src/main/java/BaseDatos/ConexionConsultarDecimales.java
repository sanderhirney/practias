
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class ConexionConsultarDecimales {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    int seccion;
    int decimal_campo;
    int decimal_total;
    public void consulta()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select campo, total from decimales where cod_seccion=?");
        consulta.setInt(1, seccion);
        ejecutar=consulta.executeQuery();
        while( ejecutar.next() )
        {
              decimal_campo=ejecutar.getInt("campo");
              decimal_total=ejecutar.getInt("total");
                
               
        }//if
       conectar.Cerrar();
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de la cantidad de decimales a usar en los calculos.\n Ventana Conexion Decimales \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
   
    
    public void setSeccion(int recibido)
    {
        seccion=recibido;
    }
    public int getDecimalCampo()
    {
        return decimal_campo;
    }
   public int getDecimalTotal()
   {
       return decimal_total;
   }
   
    
   
}//clase
