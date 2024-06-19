
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class ConexionDatosdeReporte {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    int ejecutar;
    int resultado;
    int seccion;
    int mesInicio;
    int mesFin;
    int anio;
    int codigoConcepto;
    
    public void limpiar(){
        try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("delete from datosreportes");
        ejecutar=consulta.executeUpdate();
        
       
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de limpieza de los datos del Reporte.\n Ventana guardar datos de Reportes\n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }
   
    public void guardar()
    {
       try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("insert into datosreportes values (DEFAULT, ?, ?, ?, ?,?)");
        
        consulta.setInt(1, seccion);
        consulta.setInt(2, mesInicio);
        consulta.setInt(3, mesFin);
        consulta.setInt(4, anio);
        consulta.setInt(5, codigoConcepto);
              
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
        JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de guardar los datos del Reporte.\n Ventana guardar datos de Reportes\n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    
    public int respuesta()
    {
        return resultado;
    }
    
    
    public void setConcepto(int recibido)
    {
        codigoConcepto=recibido;
    }
    public void setMesInicio(int recibido)
    {
        mesInicio=recibido;
    }
    public void setMesFin(int recibido)
    {
        mesFin=recibido;
    }
    public void setAnio(int recibido)
    {
        anio=recibido;
    }
    public void setSeccion(int recibido){
        seccion=recibido;
    }
    
}//clase
