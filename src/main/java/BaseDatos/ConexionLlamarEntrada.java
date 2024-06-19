
package BaseDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class ConexionLlamarEntrada {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    List<Date> fecha=new ArrayList<>();
    List<String> documento=new ArrayList<>();
    List<String> concepto=new ArrayList<>();
    List<Integer> cod_concepto=new ArrayList<>();
    List<Integer> articulos=new ArrayList<>();
    List<Float> valor=new ArrayList<>();
    String cod_proveedor;
    String nombre_proveedor;
    int seccion;
    int resultado;
    public void consulta()
    {
       
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select fecha_operacion, numero_doc, num_articulos, concepto_entrada, valor_operacion from doc_entradas where seccion=?");
        consulta.setInt(1, seccion);
        ejecutar=consulta.executeQuery();
        while( ejecutar.next() )
        {
                     fecha.add(ejecutar.getDate("fecha_operacion"));
                     documento.add(ejecutar.getString("numero_doc"));
                     articulos.add(ejecutar.getInt("num_articulos"));
                     cod_concepto.add(ejecutar.getInt("concepto_entrada"));
                     valor.add(ejecutar.getFloat("valor_operacion"));
                    cod_proveedor=ejecutar.getString("cod_proveedor");

                     
                     
        }//while
       conectar.Cerrar();
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de los Documento de entrada.\n Ventana Ver Documentos de entrada \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
        
    }//consulta
    
     public void conceptos()
    {
       
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        
        
        for(int i=0; i<cod_concepto.size(); i++)//i del tamaño de la lista cod_concepto
        {
           
        consulta= conex.prepareStatement("select descripcion from conceptos where codigo=?");
        consulta.setInt(1, cod_concepto.get(i));
        ejecutar=consulta.executeQuery();
        if(ejecutar.next())
        {
        concepto.add(ejecutar.getString("descripcion"));
        }//if
        }//for
        
       conectar.Cerrar();
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de la descripcion de los conceptos.\n Ventana Ver Documentos de entrada \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
        
    }//consulta seccion
     public void Proveedor()
     {//es un solo proveedor por documento
         //por lo tanto aqui busco el nombre proveedor para ubicar 
         //el JCombo de entradas en ese proveedor
         try
         {
                consulta= conex.prepareStatement("select nombre from proveedores where rif_proveedor=?");
                consulta.setString(1, cod_proveedor);
                ejecutar=consulta.executeQuery();
                if(ejecutar.next())
                {
                nombre_proveedor=(ejecutar.getString("nombre"));
                }//if   
         }
         catch(SQLException e)
         {
             
         }
         
     }
    
    public List<Date> getFecha()
    {
        return fecha;
    }
    public List<Integer> getCantidadArticulos()
    {
        return articulos;
    }
    public List<String> getDocumento()
    {
        return documento;
    }
    public List<Float> getValorOperacion()
    {
        return valor;
    }
    public List<String> getConcepto()
    {
        return concepto;
    }
    
   public int getResultado()
   {
       if(fecha.isEmpty())
       {
           resultado=0;
       }
       else
       {
           resultado=1;//verifico si logro leer entradas ya que al estar en una seccion nueva pueden no haber entradas al momento de consultar
       }
       return resultado;
   }
   public void setSeccion(int recibido)
   {
       seccion=recibido;
   }
   
}//clase
