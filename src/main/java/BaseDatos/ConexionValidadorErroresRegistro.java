
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ConexionValidadorErroresRegistro {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    
    List<String> codigoDocumentoEntrada=new ArrayList<>();
    List<String> codigoHistorial=new ArrayList<>();
    List<Integer> codigoDocumentoSalida=new ArrayList<>();
   
    private void consultaDocumentosEntrada()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select doc_entradas.numero_doc as documento, historiales.numero_doc as historial \n"+
        "from doc_entradas\n" +
        "full join\n" +
        "historiales\n" +
        "on\n" +
        "doc_entradas.numero_doc = historiales.numero_doc\n" +
        "where \n" +
         "valor_entrada>0 \n"+
           "and \n"     +
        "doc_entradas is null \n" +
        "or\n" +
        "historiales is null");
        ejecutar=consulta.executeQuery();
        while( ejecutar.next() )
        {
                     codigoDocumentoEntrada.add(ejecutar.getString("documento"));
                     codigoHistorial.add(ejecutar.getString("historial"));
                     conectar.Cerrar();
                     
        }//if
       
    }
              catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo revisar la integridad de los documentos de Entrada.\n Ventana Validador de Registro Entradas \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
          
    }//consulta
     private void consultaDocumentosSalida(){
         try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select doc_salidas.id as documento, historiales.numero_doc as historial \n" +
            "from doc_salidas\n" +
            "left join\n" +
            "historiales\n" +
            "on\n" +
            "doc_salidas.id::varchar = historiales.numero_doc\n" +
            "where\n" +
                " valor_salida>0\n"+
                "and \n"+
            "historiales is null");
        ejecutar=consulta.executeQuery();
        while( ejecutar.next() )
        {
                     codigoDocumentoSalida.add(ejecutar.getInt("documento"));
                    codigoHistorial.add(ejecutar.getString("historial"));
                     conectar.Cerrar();
                     
        }//if
       
    }
              catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo revisar la integridad de los documentos de Salida.\n Ventana Validador de Registro Salida \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }
    
   private void borrarDocumentoConErrorEntrada(){
       try
    {
        for(int i=0; i<codigoDocumentoEntrada.size(); i++){
            if(codigoDocumentoEntrada.get(i) != null){
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("delete from doc_entrada where numero_doc=?");
        consulta.setString(1, codigoDocumentoEntrada.get(i));
        consulta.executeUpdate();
            }
        }
        
   }catch(SQLException ex){
       JOptionPane.showMessageDialog(null, "No se pudo comprobar efectivamente la integridad de la Base de datos.\n Ventana Errores en registros de Entrada\n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
   }
   }
   private void borrarDocumentoConErrorSalida(){
           
       try
    {
       
        for(int i=0; i<codigoDocumentoSalida.size(); i++){
            if(codigoDocumentoSalida.get(i) != null){
               
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("delete from doc_salidas where id=?");
        consulta.setInt(1, codigoDocumentoSalida.get(i));
        consulta.executeUpdate();
            }
        }
        
   }catch(SQLException ex){
       JOptionPane.showMessageDialog(null, "No se pudo comprobar efectivamente la integridad de la Base de datos.\n Ventana Errores en registros de Salida\n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
   }
   }
   private void borrarHistorialConErrorEntrada(){
       try
    {
        for(int i=0; i<codigoHistorial.size(); i++){
            if(codigoHistorial.get(i) != null){
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("delete from historiales where numero_doc=?");
        consulta.setString(1, codigoHistorial.get(i));
        consulta.executeUpdate();
            }
        }
        
   }catch(SQLException ex){
       JOptionPane.showMessageDialog(null, "No se pudo comprobar efectivamente la integridad de la Base de datos.\n Ventana Errores en registros \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
   }
   }
   
   public void consulta(int llamada){
       //llamada 1 para entrada
       //llamada 2 para salida
       if(llamada==1){
             consultaDocumentosEntrada();
             borrarDocumentoConErrorEntrada();
             borrarHistorialConErrorEntrada();
       }
       if(llamada==2){
           consultaDocumentosSalida();
           borrarDocumentoConErrorSalida();
        
       }
      
       
   }
}
