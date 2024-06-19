
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class ConexionVerServicios {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
   
    List<String> descripciones=new ArrayList<>();
    List<Integer> codigos=new ArrayList<>();
    public void consulta()
    {
       
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select cod_servicio, nombre_servicio from servicios");
        ejecutar=consulta.executeQuery();
        while( ejecutar.next() )
        {
                     descripciones.add(ejecutar.getString("nombre_servicio"));
                     codigos.add(ejecutar.getInt("cod_servicio"));
                     conectar.Cerrar();
                     
        }//if
       
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de los Servicios.\n Ventana Ver Servicios \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
        
    }//consulta
    
    public List<Integer> codigo()
    {
        return codigos;
    }
    
    public List<String> descripcion()
    {
        return descripciones;
    }
   
}//clase
