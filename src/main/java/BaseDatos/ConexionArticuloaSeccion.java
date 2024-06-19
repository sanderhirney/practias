
package BaseDatos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.Date;
public class ConexionArticuloaSeccion {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    int ejecutar;
    int resultado;
    int codigo_articulo;
    int codigo_seccion;
    
   
    Date fecha= new Date();
    java.sql.Date sqlFecha=new java.sql.Date(fecha.getTime());
   
    public void Existencias()
    {
      
          try
    {
       
        
        conectar.Conectar();
        conex= conectar.getConexion();
      
        consulta= conex.prepareStatement("insert into existencias values(DEFAULT, ?, ?, ?, ?, ?)");
        consulta.setInt(1, codigo_articulo);
        consulta.setInt(2, 0);
        consulta.setDate(3,sqlFecha );
        consulta.setString(4, "N/A");
        consulta.setInt(5, codigo_seccion);
        ejecutar=consulta.executeUpdate();
        if( ejecutar> 0 )
        {
          resultado=1;         
        }//if
        else
        {
            resultado=0;
        }
        conectar.Cerrar();
        
       
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de la seccion en la cual trabajar.\n Ventana Conexion Articulo a Seccion Existencias \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
    
    public void Costos()
    {
      
          try
    {
       
        
        conectar.Conectar();
        conex= conectar.getConexion();
      
       consulta= conex.prepareStatement("insert into costos values(DEFAULT, ?, ?, ?, ?, ?, ?)");
        consulta.setInt(1, codigo_articulo);
        consulta.setString(2, "N/A");
        consulta.setInt(3,0 );
        consulta.setFloat(4, 0);
        consulta.setDate(5, sqlFecha);
        consulta.setInt(6, codigo_seccion);
        ejecutar=consulta.executeUpdate();
        if( ejecutar> 0 )
        {
          resultado=1;         
        }//if
        else
        {
            resultado=0;
        }
       
         conectar.Cerrar();
        conectar.Cerrar();
        
       
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de la seccion en la cual trabajar.\n Ventana Conexion Articulo a Seccion Existencias \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
    
    public int resultado()
    {
        return resultado;
        
    }
    public void setCodigoArticulo(int codigo)
    {
        codigo_articulo=codigo;
    }
    public void setCodigoSeccion(int codigo)
    {
        codigo_seccion=codigo;
    }
}//clase
