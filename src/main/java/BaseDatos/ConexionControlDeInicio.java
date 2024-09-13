
package BaseDatos;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class ConexionControlDeInicio {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    int control=0;
    int resultado=0;
      
    public void consulta()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select estado from inicios");
        ejecutar=consulta.executeQuery();
        while( ejecutar.next() )
        {
             control=ejecutar.getInt("estado");
        }//if
        conectar.Cerrar();
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion del estado de la aplicacion .\n Ventana Conexion Control de Inicio \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
    public void abrir(){
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("update inicios set estado=1");
        resultado=consulta.executeUpdate();
        conectar.Cerrar();
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de la apertura de la aplicacion .\n Ventana Conexion Control de Inicio \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//abrir
    public void cerar(){
                try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("update inicios set estado=0");
        resultado=consulta.executeUpdate();
        conectar.Cerrar();
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion del cierre de la apliacion .\n Ventana Conexion Control de Inicio \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//cerrar
    
    public int getControl()
    {
        return control;
    }
    public int getResultado()
    {
         return resultado;       
    }
    
    
    
}//clase
