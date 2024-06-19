
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class ConexionDeshacerDocEntradas {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    int resultado=0;//variable que devolvera 1 en caso de ser la consulta positiva
 
    //listas para guardar datos
    
    //leo el documento a borrar para borrarlo tambien de historiales y temporales
    
    public void ejecutar()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("delete from doc_entradas where id=(Select Max(id)from doc_entradas);");
        resultado=consulta.executeUpdate();
        if( resultado >0)
        {
                    
                    resultado=1;
        }//if
        if(resultado==0)
        {
            resultado=0;
        }
        
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo deshacer la informacion del documento que se intento ingresar.\n Ventana Conexion Deshacer Entrada \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
 
    
    public int resultado()
    {
        return resultado;
    }
    
    
}//clase
