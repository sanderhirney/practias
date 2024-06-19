
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class ConexionModificarSeccion {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    
    List<String> nombres=new ArrayList<>();
    List<Integer> codigos=new ArrayList<>();
    public void consulta()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select cod_empresas, descripcion from empresas");
        ejecutar=consulta.executeQuery();
        while( ejecutar.next() )
        {
                     nombres.add(ejecutar.getString("descripcion"));
                     codigos.add(ejecutar.getInt("cod_empresas"));
                     conectar.Cerrar();
                     
        }//if
       
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de las secciones.\n Ventana Actualizar Secciones \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
    public List<Integer> codigo()
    {
        return codigos;
    }
    
    public List<String> nombre()
    {
        return nombres;
    }
}//clase
