
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class ConexionCrearGrupos {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    int ejecutar;
    int resultado;
    String codigosub;
    String descripcion;
    int codigo_grupo;//E si es entrada y S si es salda
   
    public void crear()
    {
        
        
        
        
        
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("insert into grupos values (?, ?,?)");
        
        consulta.setString(1, codigosub);
        consulta.setString(2, descripcion);
        consulta.setInt(3, codigo_grupo);
        
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
        JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de guardar el grupo.\n Ventana Crear Grupos \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
    public int respuesta()
    {
        return resultado;
    }
    
    
    public void setSubGrupo(String codig)
    {
        codigosub=codig;
    }
    public void setDescripcion(String desc)
    {
        descripcion=desc;
    }
    public void setGrupo(int grupo)
    {
        codigo_grupo=grupo;
    }
    
}//clase
