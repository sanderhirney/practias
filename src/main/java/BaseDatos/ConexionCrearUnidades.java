
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class ConexionCrearUnidades {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    int ejecutar;
    int resultado;
    int codigo_empresa;
    String nombre;
    String abreviatura;
    
    public void crear()
    {
         
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("insert into unidades values (DEFAULT, ?, ?)");
        consulta.setString(1, nombre);
        consulta.setString(2, abreviatura);
        
        ejecutar=consulta.executeUpdate();
        if( ejecutar> 0 )
        {
          resultado=1;         
        }//if
        else
        {
            resultado=0;
        }
       
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de guardar la Unidad.\n Ventana Crear Unidad \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
    public int respuesta()
    {
        return resultado;
    }
    
   
    public void setNombre(String nomb)
    {
        nombre=nomb;
    }
    public void setAbreviatura(String abrev)
    {
        abreviatura=abrev;
    }
    
    
}//clase
