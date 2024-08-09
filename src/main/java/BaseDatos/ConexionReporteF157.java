
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
   
    List<Integer> codigoConceptos= new ArrayList<>();
    List<String> descripcionConceptos=new ArrayList<>();
    List<Integer> codigo_medida=new ArrayList<>();
    List<String> descripcion_medida=new ArrayList<>();
    List<String> nombre_art=new ArrayList<>();
    List<Double> IngresosBs=new ArrayList<>();
    List<Double> EgresosBs=new ArrayList<>();
    List<Integer> grupo=new ArrayList<>();
    List<String> tipoConceptos=new ArrayList<>();
    List<Integer> consecutivoDesde=new ArrayList<>();
    List<Integer> consecutivoHasta=new ArrayList<>();
    
    int seccion;
    int mesInicio;
    int mesFin;
    int anio;
    
    Date fecha;
    
    String consultaConsecutivosEntrada="""
                                      select MIN(consecutivo) as minimo, MAX(consecutivo) as maximo from doc_entradas where
                                      extract(month from fecha_operacion)=? and extract (year from fecha_operacion)=?
                                      and seccion=?
                                      and concepto_entrada=?
                                      """;
    String consultaConsecutivosSalidas="""
                                       select MIN(consecutivo) as minimo, MAX(consecutivo) as maximo from doc_salidas where
                                       extract(month from fecha_documento)=? and extract (year from fecha_documento)=?
                                       and secciones=?
                                       and concepto_salidas=?
                                       """;
    private void consultaGrupos()
    {        
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select *from conceptos order by codigo asc");
        ejecutar=consulta.executeQuery();
        while( ejecutar.next())
        {
              codigoConceptos.add(ejecutar.getInt("codigo"));
              descripcionConceptos.add(ejecutar.getString("descripcion"));
              tipoConceptos.add(ejecutar.getString("tipo"));
        }//if
      
      
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de lectura de conceptos.\n Ventana Crear Reporte SalidaF 15-7 \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
 
     private  void consultarDatosReporte(){
        try{
            conectar.Conectar();
            conex= conectar.getConexion();
            consulta= conex.prepareStatement("select seccion, mesinicio, mesfin, anio from datosreportes");
            ejecutar=consulta.executeQuery();
            while(ejecutar.next()){
              seccion=ejecutar.getInt("seccion");
              mesInicio=ejecutar.getInt("mesinicio");
              mesFin=ejecutar.getInt("mesfin");
              anio=ejecutar.getInt("anio");
            }
            
            conectar.Cerrar();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de Reporte de Consulta de Datos del reporte.\n Ventana Crear Reporte Salidas Historial \n Contacte al Desarrollador \n "+e ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
        }
    }
     private void consultarConsecutivos(){
         for(int i=0; i<codigoConceptos.size(); i++){
             if(tipoConceptos.get(i).equals("E")){
                            try{
                       conectar.Conectar();
                       conex= conectar.getConexion();
                       consulta= conex.prepareStatement(consultaConsecutivosEntrada);
                       consulta.setInt(1, mesFin);
                       consulta.setInt(2, anio);
                       consulta.setInt(3, seccion);
                       consulta.setInt(4, codigoConceptos.get(i));
                       ejecutar=consulta.executeQuery();
                       while(ejecutar.next()){
                       consecutivoDesde.add(ejecutar.getInt("minimo"));
                       consecutivoHasta.add(ejecutar.getInt("maximo"));
                       }

                       conectar.Cerrar();
                   }
                   catch(SQLException e){
                       JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de Reporte de Consulta consecutivos de entrada.\n Ventana Crear Reporte Salidas Historial \n Contacte al Desarrollador \n "+e ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
                   }
            }
             if(tipoConceptos.get(i).equals("S"))
             {
                 try{
                       conectar.Conectar();
                       conex= conectar.getConexion();
                       consulta= conex.prepareStatement(consultaConsecutivosSalidas);
                       consulta.setInt(1, mesFin);
                       consulta.setInt(2, anio);
                       consulta.setInt(3, seccion);
                       consulta.setInt(4, codigoConceptos.get(i));
                       ejecutar=consulta.executeQuery();
                       while(ejecutar.next()){
                       consecutivoDesde.add(ejecutar.getInt("minimo"));
                       consecutivoHasta.add(ejecutar.getInt("maximo"));
                       }

                       conectar.Cerrar();
                   }
                   catch(SQLException e){
                       JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de Reporte de Consulta consecutivos de salida.\n Ventana Crear Reporte Salidas Historial \n Contacte al Desarrollador \n "+e ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
                   }
             }
             
         }         
     }
    public void consultas(){
      
        consultarDatosReporte();
        consultaGrupos();
        consultarConsecutivos();
     for(int i=0; i<codigoConceptos.size(); i++){
         System.out.println( "-> "+codigoConceptos.get(i)+" : "+descripcionConceptos.get(i)+" DESDE "+consecutivoDesde.get(i)+" HASTA "+consecutivoHasta.get(i));
     }
     
        
    }
    
  
   
    
    public List<Integer> getGrupo()
    {
        return grupo;
    }
    public List<String> getDescripcionConcepto()
    {
        return descripcionConceptos;
    }
    public List<String> getMedida()
    {
        return descripcion_medida;
    }
    public List<Integer> getCodigosConceptos(){
        return codigoConceptos;
    }
     public List<String> getDescripcionArticulos()
    {
        return nombre_art;
    }
   
     public Date getFecha(){
            return fecha;
     }

   
  
   
}//clase
