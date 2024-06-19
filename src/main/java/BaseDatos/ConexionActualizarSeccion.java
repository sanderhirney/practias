
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class ConexionActualizarSeccion {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    int resultado_final;
    int codigo_empresa;
    int resultado_primero;
    String nombre_empresa;
  
    public void actualizar()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("update empresas set seleccionado=0");
        resultado_primero=consulta.executeUpdate();
        
        if( resultado_primero>0 )
        {
            consulta= conex.prepareStatement("update empresas set seleccionado=1 where cod_empresas=?");
            consulta.setInt(1, codigo_empresa);
             resultado_final=consulta.executeUpdate();
             conectar.Cerrar();
                     
        }//if
        if(resultado_primero==0)
        {
            resultado_final=0;
        }
        
       
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de la seccion en la cual trabajar.\n Ventana Conexion Actualizar Seccion \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
    
    
    public int resultado()
    {
        return resultado_final;
        
    }
    public void setCodigo(int codigo)
    {
        codigo_empresa=codigo;
    }
}//clase
