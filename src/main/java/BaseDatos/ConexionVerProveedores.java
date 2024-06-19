
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class ConexionVerProveedores {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    
    List<String> nombres=new ArrayList<>();
    List<String> rif=new ArrayList<>();
    public void consulta()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select nombre, rif_proveedor from proveedores");
        ejecutar=consulta.executeQuery();
        while( ejecutar.next() )
        {
                     nombres.add(ejecutar.getString("nombre"));
                     rif.add(ejecutar.getString("rif_proveedor"));
                     conectar.Cerrar();
                     
        }//if
       
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de los proveedores.\n Ventana Ver Proveedores \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
    public List<String> nombres()
    {
        return nombres;
    }
    
    public List<String> rif_proveedor()
    {
        return rif;
    }
}//clase
