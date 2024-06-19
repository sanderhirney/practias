
package BaseDatos;
//clase para consultar grupos y articulos de reportes que se filtran por la seccion
// en la que se esta trabajando en la sesion
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class ConexionReporteGruposArtf4 {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    int resultado;
    int mes_consulta_inicio;
    int mes_consulta_fin;
    int mes_consulta;
    int anio_consulta;
    List<String> codigo_subgrupo= new ArrayList<>();
    List<String> descripcion=new ArrayList<>();
    List<Integer> codigo_grupo=new ArrayList<>();
    List<Integer> codigo_articulos=new ArrayList<>();
    List<Float> suma_entradas_anterior= new ArrayList<>();//existencia anterior
    List<Float> suma_salidas_anterior=new ArrayList<>();//existencia anterior
    List<Float> suma_entradas_actual= new ArrayList<>();//mes actual
    List<Float> suma_salidas_actual=new ArrayList<>();//mes actual
    List<Float> existencia_anteriores=new ArrayList<>();
    List<Float> existencia_fin_mes= new ArrayList<>();
    int codigo_seccion;
    public void consulta()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        consulta= conex.prepareStatement("select codigo_grupo, codigo_sub, descripcion from grupos");
        ejecutar=consulta.executeQuery();
        while( ejecutar.next())
        {
               codigo_subgrupo.add(ejecutar.getString("codigo_sub"));
               codigo_grupo.add(ejecutar.getInt("codigo_grupo"));
               descripcion.add(ejecutar.getString("descripcion"));
              
        }//if
      
       
    }//consulta
           catch(SQLException ex)
    {
        
        JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de Reporte de Grupos.\n Ventana Crear Reporte Grupos \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
         catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, "Error general.\n Ventana Crear Reporte- Consulta Grupos  \n Contacte al Desarrollador \n "+e ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);  
    }
    }//consulta
    
    public void consulta_articulos()
    {
       
         try
    {
        conectar.Conectar();
        conex=conectar.getConexion();
       
        for(int i=0; i<codigo_grupo.size(); i++)
        {
            
        consulta=conex.prepareStatement("select codigo from articulos where id_grupo=? and id_subgrupo=?");//fin de conuslta
        consulta.setInt(1, codigo_grupo.get(i));
        consulta.setString(2, codigo_subgrupo.get(i));
        ejecutar=consulta.executeQuery();
        
        
        while( ejecutar.next())
        {
               codigo_articulos.add(ejecutar.getInt("codigo"));
        }//if
      
        }
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de Reporte de Grupos.\n Ventana Crear Reporte Grupos \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
         catch(Exception e)
         {
           JOptionPane.showMessageDialog(null, "Error general.\n Ventana Crear Reporte - Consulta Articulos  \n Contacte al Desarrollador \n "+e ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);  
         }
    }//consulta
    
    public void suma_articulos_anterior()
    {
       
         try
    {
        
        conectar.Conectar();
        conex=conectar.getConexion();
        for(int i=0; i<codigo_grupo.size(); i++)
        {
       
            consulta=conex.prepareStatement(
            "SELect SUM(valor_entrada) as entradas, SUM(valor_salida) as salidas from historiales \n" +
            "inner join articulos \n" +
            "on \n" +
            "articulos.codigo = historiales.cod_articulo\n" +
            "where \n" +
            "extract(month from fecha)>=?\n" +
            "and\n" +
            "extract (month from fecha)<=?\n" +
            "and \n" +
            "extract (year from fecha)=?\n" +
            "and \n" +
            "id_grupo=? \n"+
            "and \n"+
            "id_subgrupo=?\n"+
            "and \n"+
            "seccion=?"
            
            );//fin de constulta
        consulta.setInt(1, mes_consulta_inicio);
        consulta.setInt(2, mes_consulta_fin);
        consulta.setInt(3, anio_consulta);
        consulta.setInt(4, codigo_grupo.get(i));
        consulta.setString(5, codigo_subgrupo.get(i));
        consulta.setInt(6, codigo_seccion);
        ejecutar=consulta.executeQuery();
               
        while( ejecutar.next())
        {
               suma_entradas_anterior.add((ejecutar.getFloat("entradas")));
               suma_salidas_anterior.add((ejecutar.getFloat("salidas")));
               
        }//if
      
        }//for
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de Reporte de Grupos.\n Ventana Crear Reporte Grupos \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
         catch(Exception e)
         {
           JOptionPane.showMessageDialog(null, "Error general.\n Ventana Crear Reporte Grupos Operaciones Suma articulos  \n Contacte al Desarrollador \n "+e ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);  
         }
    }//consulta
    
    //consulta 
    public void consumidos_mes()
    {//mes_consulta_fin es el mes de la consulta
    try
    {
             
        conectar.Conectar();
        conex=conectar.getConexion();
        for(int i=0; i<codigo_grupo.size(); i++)
        {
      
            consulta=conex.prepareStatement(
            "SELect SUM(valor_entrada) as entradas, SUM(valor_salida) as salidas from historiales \n" +
            "inner join articulos \n" +
            "on \n" +
            "articulos.codigo = historiales.cod_articulo\n" +
            "where \n" +
            "extract(month from fecha)=?\n" +
            "and\n" +
            "extract (year from fecha)=?\n" +
            "and \n" +
            "id_grupo=?\n"+
            "and \n"+
            "id_subgrupo=?\n"+
            "and \n"+
            "seccion=?"
            
            );//fin de constulta
        consulta.setInt(1, mes_consulta);
        consulta.setInt(2, anio_consulta);
        consulta.setInt(3, codigo_grupo.get(i));
        consulta.setString(4, codigo_subgrupo.get(i));
        consulta.setInt(5, codigo_seccion);
        ejecutar=consulta.executeQuery();
        
        while( ejecutar.next())
        {
               suma_entradas_actual.add((ejecutar.getFloat("entradas")));
               suma_salidas_actual.add((ejecutar.getFloat("salidas")));
               
        }//if
        
        }//for
         
    }//try
    catch(SQLException ex1)
    {
        JOptionPane.showMessageDialog(null, "No se pudo procesar la operacion de Reporte de Grupos.\n Ventana Crear Reporte Grupos \n Contacte al Desarrollador \n "+ex1,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//public
    public int respuesta()
    {
        return resultado;
    }
    public List<String> subgrupo()
    {
        return codigo_subgrupo;
    }
    public List<Integer> grupo()
    {
        return codigo_grupo;
    }
    public List<String> descripcion()
    {
        return descripcion;
    }
    
    public List<Float> suma_entrada_anterior()
    {
        return suma_entradas_anterior;
    }
    public List<Float> suma_salida_anterior()
    {
        return suma_salidas_anterior;
    }
    public List<Float> suma_entrada_actual()
    {
        return suma_entradas_actual;
    }
    public List<Float> suma_salida_actual()
    {
        return suma_salidas_actual;
    }
    
    public List<Float> existencias_anteriores()
    {
        return existencia_anteriores;
    }
    public List<Float> existencias_finMes()
    {
        return existencia_fin_mes;
    }
    
   public void setMesInicio(int mesinicio)
   {
       mes_consulta_inicio=mesinicio;
   }
   public void setMesFin(int mesfin)
   {
       mes_consulta_fin=mesfin;
   }
   public void setAnio(int anio)
   {
       anio_consulta=anio;
   }
   public void setMesConsulta(int recibido)
   {
       mes_consulta=recibido;
   }
   public void setSeccion(int recibido)
   {
       codigo_seccion=recibido;
   }
   
}//clase
