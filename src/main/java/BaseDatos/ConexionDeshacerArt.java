
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class ConexionDeshacerArt {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    int resultado=0;//variable que devolvera 1 en caso de ser la consulta positiva
 
    //listas para guardar datos
    
    
    
    public void ejecutar()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("delete from from articulos where codigo=(Select Max(codigo)from articulos)");
        resultado=consulta.executeUpdate();
        if( resultado >0)
        {
                    
                    resultado=1;
        }//if
        if(resultado==0)
        {
            resultado=0;
        }
        
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de deshacer cambios.\n Ventana Conexion Deshacer Articulos \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
 
    
    public int resultado()
    {
        return resultado;
    }
    
    
}//clase
