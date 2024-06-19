//esta clase se usara para actualizar la tabla de temporal documento salida
//y temporal documento articulo
//teniendo en cuenta que al darle en modificar, se almacena en una variable el
//el documento a modificar. Una vez se modifica y almacena y verificado que todo
//el proceso de almacenamiento quedo bien. Se borra de temporal documeto salida
//y articulo todo lo referente a dicho documento
//reiterando si y solo si; el documento  a modificar se guarda nuevamente.
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class ConexionActualizarTempSalida {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    int resultado;
    int seccion;
    int respuesta;
   int documento;
    public void actualizarTempDoc()
    {
        System.out.println("codigo que se va a actualizar: "+documento);
        System.out.println("seccion: "+seccion);
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("delete from temporal_doc_salida where numero_documentos=? and seccion=?");
        consulta.setInt(1, documento);
        consulta.setInt(2, seccion);
        
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
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion del estado del documento en la base temporal.\n Ventana Conexion Actualizar Documento temporal \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    public void actualizarArtDoc()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("delete from temporal_articulo where documento=? and seccion=?");
        consulta.setString(1, String.valueOf(documento));
        consulta.setInt(2, seccion);
        
        respuesta=consulta.executeUpdate();
        
        
        
       
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion temporal de articulos.\n Ventana Conexion Actualizar Articulos temporal \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
    
    
    public int resultado()
    {
        return resultado;
        
    }
    public void setDocumento(int recibido)
    {
        documento=recibido;
    }
    public void setSeccion(int recibido)

    {
        seccion=recibido;
    }}//clase
