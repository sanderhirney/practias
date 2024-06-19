
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class ConexionActualizarDecimal {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    int resultado;
    int codigo_empresa;
    int campo;
    int total;
    int respuesta;
   String nombre_empresa;
    public void actualizar()
    {
        System.out.println("codigo que se va a actualizar: "+codigo_empresa);
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("update decimales set campo=?, total=? where cod_seccion=?");
        consulta.setInt(1, campo);
        consulta.setInt(2, total);
        consulta.setInt(3, codigo_empresa);
        respuesta=consulta.executeUpdate();
        if(respuesta>0)
        {
            resultado=1;
        }
        if(respuesta==0)
        {
            resultado=0;
        }
        
        
       
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de la seccion en la cual trabajar.\n Ventana Conexion Actualizar Seccion \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    public void buscar_codigo()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select cod_empresas from empresas where descripcion=?");
        consulta.setString(1, nombre_empresa);
        
        ejecutar=consulta.executeQuery();
        while(ejecutar.next())
        {
            codigo_empresa=ejecutar.getInt("cod_empresas");
        }
        
        
       
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de la seccion en la cual trabajar.\n Ventana Conexion Actualizar Seccion \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
    
    
    public int resultado()
    {
        return resultado;
        
    }
    public void setNombre(String recibido)
    {
        nombre_empresa=recibido;
    }
    public void setDecimalCampo(int recibido)
    {
        campo=recibido;
    }
    public void setDecimalTotal(int recibido)
    {
        total=recibido;
    }
}//clase
