
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class ConexionComprobarGrupos {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    
    List<String> codigosub=new ArrayList<>();
    List<Integer> codigogrup=new ArrayList<>();
    List<String> descripcion=new ArrayList<>();
    
    public void validar()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select codigo_sub,codigo_grupo, descripcion from grupos");
        ejecutar=consulta.executeQuery();
        while( ejecutar.next() )
        {
                     codigosub.add(ejecutar.getString("codigo_sub"));
                     descripcion.add(ejecutar.getString("descripcion"));
                     codigogrup.add(ejecutar.getInt("codigo_grupo"));
                
                     conectar.Cerrar();
               
        }//if
       
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de la seccion en la cual trabajar.\n Ventana Conexion Seccion \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
    public List<String> codigos()
    {
        return codigosub;
    }
    public List<String> descripciones()
    {
        return descripcion;
    }
     public List<Integer> grupos()
    {
        return codigogrup;
    }
    
   
}//clase
