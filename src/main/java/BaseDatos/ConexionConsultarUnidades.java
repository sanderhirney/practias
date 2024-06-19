
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
public class ConexionConsultarUnidades {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    
    List<Integer> codigo=new ArrayList<>();
    List<String> nombres=new ArrayList<>();
    public void validar()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select cod_unidad, nombre from unidades");
        ejecutar=consulta.executeQuery();
        while( ejecutar.next() )
        {
                     codigo.add(ejecutar.getInt("cod_unidad"));
                     nombres.add(ejecutar.getString("nombre"));
                     conectar.Cerrar();
               
        }//if
       
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de la seccion en la cual trabajar.\n Ventana Conexion Seccion \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
    public List<Integer> codigos()
    {
        return codigo;
    }

    public List<String> nombre()
    {
        return nombres;
    }
    
   
}//clase
