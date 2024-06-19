
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
public class ConexionConsultarFirmas {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    
    List<Integer> codigo_cargos=new ArrayList<>();
    List<Integer> cargos_firmantes=new ArrayList<>();
    List<String> nombres_firmantes=new ArrayList<>();
    List<String> apellidos_firmantes=new ArrayList<>();
    List<String> cedula_firmantes=new ArrayList<>();
    List<String> descripcion_cargos=new ArrayList<>();
    public void Cargos()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select * from cargos");
        ejecutar=consulta.executeQuery();
        while( ejecutar.next() )
        {
              descripcion_cargos.add(ejecutar.getString("descripcion"));
              codigo_cargos.add(ejecutar.getInt("codigo"));      
               
        }//if
       conectar.Cerrar();
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de la seccion en la cual trabajar.\n Ventana Conexion Seccion \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
    public void firmantes()
    {
             try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select * from firmas");
        ejecutar=consulta.executeQuery();
        while( ejecutar.next() )
        {
                   cargos_firmantes.add(ejecutar.getInt("cargo"));
                   nombres_firmantes.add(ejecutar.getString("nombre"));
                   apellidos_firmantes.add(ejecutar.getString("apellido"));
                   cedula_firmantes.add(ejecutar.getString("cedula"));
                     
               
        }//if
       conectar.Cerrar();
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de la seccion en la cual trabajar.\n Ventana Conexion Seccion \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
    
    public List<String> nombre_firmas()
    {
        return nombres_firmantes;
    }
    public List<String> apellido_firmas()
    {
        return apellidos_firmantes;
    }
    public List<String> cedula_firmas()
    {
        return cedula_firmantes;
    }
    public List<Integer> cargos_firmas()
    {
        return cargos_firmantes;
    }
    public List<Integer> codigos_cargos()
    {
        return codigo_cargos;
    }
    public List<String> nombres_cargos()
    {
        return descripcion_cargos;
    }
   
    
   
}//clase
