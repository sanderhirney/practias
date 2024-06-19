
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class ConexionCrearConceptos {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    int ejecutar;
    int resultado;
    int codigo;
    String descripcion;
    String tipo;//E si es entrada y S si es salda
   
    public void crear()
    {
        
        
        
        
        
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("insert into conceptos values (?, ?,?)");
        
        consulta.setInt(1, codigo);
        consulta.setString(2, descripcion);
        consulta.setString(3, tipo);
        
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
        JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de guardar el concepto.\n Ventana Crear Conceptos \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
    public int respuesta()
    {
        return resultado;
    }
    
    
    public void setCodigo(int codig)
    {
        codigo=codig;
    }
    public void setDescripcion(String desc)
    {
        descripcion=desc;
    }
    public void setTipo(String tip)
    {
        tipo=tip;
    }
    
}//clase
