
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class ConexionCrearProveedores {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    int ejecutar;
    int resultado;
   
    String nombre;
    String direccion;
    String telefono;
    String rif;
    public void crear()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("insert into proveedores values (?, ?, ?, ?)");
        
        consulta.setString(1, nombre);
        consulta.setString(2, direccion);
        consulta.setString(3, telefono);
        consulta.setString(4, rif);
        
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
        JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de guardar el proveedor.\n Ventana Crear Proveedor \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
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
    public void setDireccion(String dir)
    {
        direccion=dir;
    }
    public void setTelefono(String tlf)
    {
        telefono=tlf;
    }
    public void setRif(String rif_proveedor)
    {
        rif=rif_proveedor;
    }
   
}//clase
