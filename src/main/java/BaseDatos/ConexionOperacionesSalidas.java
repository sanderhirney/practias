
package BaseDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import javax.swing.JOptionPane;
public class ConexionOperacionesSalidas {
    Connection conex;
    PreparedStatement consulta;
    Conexion conectar= new Conexion();
    ResultSet ejecutar;
    int existencia_unidad;
    List<Integer> codigos_salida = new ArrayList<>();
    int codigo;
    List<Integer> codigo_recibido=new ArrayList<>();
    List<Double> precioLista= new ArrayList<>();
    Double preciounidad;
    List<Double> existencia=new ArrayList<>();
    String codigo_nuevo;
    String documento_nuevo;
    List<Double> costo_nuevo= new ArrayList<>();
    Date fecha_nuevo;
    List<Double> existencias_nuevo= new ArrayList<>();
    int resultado_operaciones;
    String documento;
    Date fecha;
     public void precios()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
       
        consulta= conex.prepareStatement("select costo from costos where codigo_articulo=? order by clave desc limit 1 ");
        consulta.setInt(1, codigo);
        ejecutar=consulta.executeQuery();
       
        if(ejecutar.next())
        {
        preciounidad=(ejecutar.getDouble("costo"));
        }
                
         if(precioLista.size()>0)
        {
            resultado_operaciones=1;
        }
        if(precioLista.size()<=0)
        {
            resultado_operaciones=1;
        }
        conectar.Cerrar();
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo realizar las Operaciones.\n Ventana Operaciones Precios \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
     
      public void existencias()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        for(int i=0; i<codigos_salida.size(); i++)
        {
        consulta= conex.prepareStatement("select existencias from existencias where codigo=? order by id desc limit 1 ");
        consulta.setInt(1, codigos_salida.get(i));
        ejecutar=consulta.executeQuery();
        
        
        if(ejecutar.next())
        {
        existencia.add(ejecutar.getDouble("existencias"));
        }//if
        }//for
      
        if(existencia.size()>0)
        {
            resultado_operaciones=1;
        }
        if(existencia.size()<=0)
        {
            resultado_operaciones=0;
        }
        conectar.Cerrar();
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion las operaciones.\n Ventana Existencias \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
      
      public void existenciasUnidad()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        
        consulta= conex.prepareStatement("select existencias from existencias where codigo=? order by id desc limit 1 ");
        consulta.setInt(1, codigo);
        ejecutar=consulta.executeQuery();
        
        if(ejecutar.next())
        {
        existencia_unidad=(ejecutar.getInt("existencias"));
        }
       
        if(existencia_unidad!=0)
        {
            resultado_operaciones=1;
        }
        if(existencia_unidad!=0)
        {
            resultado_operaciones=1;
        }
        conectar.Cerrar();
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion las operaciones.\n Ventana Existencias \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
      public void Actualizarexistencias()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
        for(int i=0; i<codigo_recibido.size(); i++)
        {
        consulta= conex.prepareStatement("update existencias set existencias=?, fecha=?, numero_dco=? where codigo=?");
        consulta.setDouble(1, existencias_nuevo.get(i));
        consulta.setDate(2, fecha);
        consulta.setString(3, documento);
        consulta.setInt(4, codigo_recibido.get(i));
        
        
        resultado_operaciones=consulta.executeUpdate();
        }
        conectar.Cerrar();
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de las operaciones.\n Ventana Actualizar Existencias \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
      
      public void ActualizarCostos()
    {
          try
    {
        conectar.Conectar();
        conex= conectar.getConexion();
             for(int i=0; i<codigo_recibido.size(); i++)
             {
                  consulta= conex.prepareStatement("update costos set costo=?, estado=1, numero_documento=?, fecha_precio=? where codigo_articulo=?");
                  consulta.setDouble(1, costo_nuevo.get((i)));
                  consulta.setString(2, documento);
                  consulta.setDate(3, fecha);
                  consulta.setInt(4, codigo_recibido.get(i));
                  resultado_operaciones=consulta.executeUpdate();
              }
             
         conectar.Cerrar();
    }//consulta
           catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "No se pudo recuperar informacion de las operaciones.\n Ventana Ver Actualizar Costos \n Contacte al Desarrollador \n "+ex ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
    }
    }//consulta
      
     
    
    
      public void setCodigoActualizar(List<Integer> recibido)
      {
          codigo_recibido=recibido;
      }
      public void setCodigoConsulta(int recibido)
      {
          codigo=recibido;
      }
      public void setCodigoConsultaSalida(List<Integer> recibido)//para ya realizar la operacion de resta
      {
          codigos_salida=recibido;
      }
    public List<Double> obtenerPrecioLista()
    {
        return precioLista;
    }
    public Double obtenerPrecioUnidad()
    {
        return preciounidad;
    }
    public List<Double> obtenerExistencia()
    {
        return existencia;
    }
    public Integer existenciaUnidad()
    {
        return existencia_unidad;
    }
    public void setDocumento(String recibido)
    {
        documento=recibido;
    }
    public void setFecha(Date recibido)
    {
        fecha=recibido;
    }
    public int getResultadoOperacion()
    {
        return resultado_operaciones;
    }
    
    public void setCodigoNuevo(String nuevo)
    {
        codigo_nuevo=nuevo;
    }
    
    public void setCostoNuevo(List<Double> nuevo)
    {
        costo_nuevo=nuevo;
    }
    public void setExistenciaNuevo(List<Double> nuevo)
    {
        existencias_nuevo=nuevo;
    }
    
    public void setFechanueva(Date nuevo)
    {
        fecha_nuevo=nuevo;
    }
    public void setDocumentoNuevo(String nuevo)
    {
        documento_nuevo=nuevo;
    }
   
}//clase
