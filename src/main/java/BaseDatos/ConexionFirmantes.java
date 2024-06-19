
package BaseDatos;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class ConexionFirmantes {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    int resultado=0;//variable que devolvera 1 en caso de ser la consulta positiva
    int codigo_empresa;
    String nombre_empresa;
    //listas para guardar datos
    
    List<String> cedulas=new ArrayList<>();
    List<String> nombres=new ArrayList<>();
    List<String> apellidos=new ArrayList<>();
    List<String> cargos=new ArrayList<>();
    
    public void consulta()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select * from firmas");
        ejecutar=consulta.executeQuery();
        while( ejecutar.next() )
        {
                    cedulas.add(ejecutar.getString("cedula"));
                    nombres.add(ejecutar.getString("nombre"));
                    apellidos.add(ejecutar.getString("apellido"));
                    cargos.add(ejecutar.getString("cargo"));
                    resultado=1;
        }//if
        
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de la seccion en la cual trabajar.\n Ventana Conexion Seccion \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
    
    public List<String> cedulas()
    {
        return cedulas;
        
    }
    public List<String> nombres()
    {
        return nombres;
    }
    public List<String> apellidos()
    {
        return apellidos;
    }
    public List<String> cargos()
    {
        return cargos;
    }
    
    public int resultado()
    {
        return resultado;
    }
    
    
}//clase
