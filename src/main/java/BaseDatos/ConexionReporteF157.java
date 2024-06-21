
package BaseDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class ConexionReporteF157 {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    int resultado;
   
    List<Integer> codigoConcepto= new ArrayList<>();
    List<String> descripcionConcepto=new ArrayList<>();
    List<String> tipo=new ArrayList<>();
    List<Integer> codigo_medida=new ArrayList<>();
    List<String> descripcion_medida=new ArrayList<>();
    List<String> nombre_art=new ArrayList<>();
    List<Double> precioArticulos=new ArrayList<>();
    List<Double> cantidadArticulos=new ArrayList<>();
    List<Integer> grupo=new ArrayList<>();
    int codigoDocumento;
    Date fecha;
   
 
    int consecutivo=0;
    private void consultaGrupos()
    {
        
          try
    {
       
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select *from conceptos");
        
        ejecutar=consulta.executeQuery();
        while( ejecutar.next())
        {
              codigoConcepto.add(ejecutar.getInt("codigo"));
              descripcionConcepto.add(ejecutar.getString("descripcion"));
              tipo.add(ejecutar.getString("tipo"));
              
        }//if
      
      
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de lectura de conceptos.\n Ventana Crear Reporte SalidaF 15-7 \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
    private void consultaMedida()
    {
          try
    {
        for(int i=0; i<codigoConcepto.size(); i++)
        {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select nombre from unidades where cod_unidad=?");
        consulta.setInt(1, codigo_medida.get(i));
        ejecutar=consulta.executeQuery();
        while( ejecutar.next())
        {
               descripcion_medida.add(ejecutar.getString("nombre"));
               
               
        }//if
      
        }//for
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de Reporte de unidades de medida.\n Ventana Crear Reporte Salidas \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta_medida
    
    private void consultarUltimoIngreso(){
        try{
            conectar.Conectar();
            conex= conectar.getConexion();
            consulta= conex.prepareStatement("select fecha_documento, id, concepto_salidas, consecutivo from doc_salidas where id=(select MAX(id) from doc_salidas)");
            ejecutar=consulta.executeQuery();
            if(ejecutar.next()){
                codigoDocumento=ejecutar.getInt("id");
                fecha=ejecutar.getDate("fecha_documento");
                
                consecutivo=ejecutar.getInt("consecutivo");
            }
            
            conectar.Cerrar();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de Reporte de Consulta de Documento.\n Ventana Crear Reporte Salidas Documento \n Contacte al Desarrollador \n "+e ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
        }
    }
   
    private  void consultarHistorial(){
        try{
            conectar.Conectar();
            conex= conectar.getConexion();
            consulta= conex.prepareStatement("select cod_articulo, valor_salida, precio from historiales where numero_doc=?");
            consulta.setString(1, String.valueOf(codigoDocumento));//convertir codigoDocumento a string
            ejecutar=consulta.executeQuery();
            
            while(ejecutar.next()){
              
              
              cantidadArticulos.add(ejecutar.getDouble("valor_salida"));
              precioArticulos.add(ejecutar.getDouble("precio"));  
            }
            
            conectar.Cerrar();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de Reporte de Consulta de Documento.\n Ventana Crear Reporte Salidas Historial \n Contacte al Desarrollador \n "+e ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void consultas(){
        consultarUltimoIngreso();
        consultarHistorial();
        consultaGrupos();
        consultaMedida();
     
        
    }
    
  
   
    
    public List<Integer> getGrupo()
    {
        return grupo;
    }
    public List<String> getDescripcionConcepto()
    {
        return descripcionConcepto;
    }
    public List<String> getMedida()
    {
        return descripcion_medida;
    }
    public List<Integer> getCodigosConceptos(){
        return codigoConcepto;
    }
     public List<String> getDescripcionArticulos()
    {
        return nombre_art;
    }
     public List<Double> getCantidades(){
         return cantidadArticulos;
     }
     public List<Double> getPrecios(){
         return precioArticulos;
     }
     public Date getFecha(){
            return fecha;
     }

    
     public int getCodigoDocumento(){
         return codigoDocumento;
     }
     public int getConsecutivo(){
         return consecutivo;
     }
   
   
}//clase
