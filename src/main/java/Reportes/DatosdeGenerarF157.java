
package Reportes;

import BaseDatos.ConexionConsultarDecimales;
import BaseDatos.ConexionReporteF157;
import BaseDatos.ConexionReporteSalidas;
import BaseDatos.ConexionVerSeccionActiva;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;



public class DatosdeGenerarF157 implements JRDataSource{
        private int index;
         List<Integer> grupo=new ArrayList<>();
        List<Integer> codigoCargos=new ArrayList<>();
        
        List<Integer> cargosFirmantes=new ArrayList<>();
        List<String> nombresFirmantes=new ArrayList<>();
        List<String> apellidosFirmantes=new ArrayList<>();
        List<String> cedulaFirmantes=new ArrayList<>();
        List<String> descripcionConcepto=new ArrayList<>();
        List<String> descripcionCargos=new ArrayList<>();
        List<String> descripcionUnidad=new ArrayList<>();
        List<Integer> desde=new ArrayList<>();
        List<Integer> codigoConcepto=new ArrayList<>();
        List<Integer> hasta=new ArrayList<>();
        List<Double> ingresosBolivares=new ArrayList<>();
        List<Double> egresosBolivares=new ArrayList<>();
        String nombreSeccion;
        int codigoSeccion;
     
        Date fechaDocumento;
        String documento;
        int decimalesPrecioUnitario;
        int decimalesCalculoTotal;
       
        Double totalIngresos=0.0;
        Double totalEgresos=0.0;
        Double existenciaAnterior=0.0;
        Double existenciaFinal=0.0;
        ConexionReporteF157 reporte=new ConexionReporteF157();
        ConexionConsultarDecimales decimales=new ConexionConsultarDecimales();
        ConexionVerSeccionActiva seccionActiva=new ConexionVerSeccionActiva();
        
    public DatosdeGenerarF157(){
        reporte.consultas();
        index=-1;
        grupo=reporte.getGrupo();
        fechaDocumento=reporte.getFecha();
        codigoConcepto=reporte.getCodigosConceptos();
        descripcionConcepto=reporte.getDescripcionConcepto();
        seccionActiva.consulta();
        codigoSeccion=seccionActiva.codigo();
        decimales.setSeccion(codigoSeccion);
        decimales.consulta();
        decimalesPrecioUnitario=decimales.getDecimalCampo();
        decimalesCalculoTotal=decimales.getDecimalTotal();
        desde=reporte.getDesde();
        hasta=reporte.getHasta();
        ingresosBolivares=reporte.getIngresosBsMes();
        egresosBolivares=reporte.getEgresosBsMes();
        existenciaAnterior=reporte.getExistenciasAnteriores();
        calculosTotales();
    }
       
    @Override
    public boolean next() throws JRException {
        index++;
        return(index<codigoConcepto.size());
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
       
        Object valor=null;
        String campo=jrf.getName();
        switch(campo)
        {
            case "Codigos" : valor=codigoConcepto.get(index).toString();
            break;
            case "Descripcion" : valor=descripcionConcepto.get(index);
            break;
            case "Desde" : valor=desde.get(index);
            break;
            case "Hasta" : valor=hasta.get(index);
            break;
            case "IngresoBolivares": valor=ingresosBolivares.get(index);
            break;
            case "EgresoBolivares" : valor=egresosBolivares.get(index);
            break;
            case "IngresosTotal" : valor=totalIngresos;
            break;
           case "EgresosTotal" : valor=totalEgresos;
            break;
            case "ExistenciaAnterior":valor=existenciaAnterior;
            break;
            case "ExistenciaFinal": valor=existenciaFinal;
            break;
                                               
        }
       
        return valor;
        
    }
    
     
    public static JRDataSource getDataSource(){
        return new DatosdeGenerarF157();
    }
    /*
    private String decimalesPrecioUnitario(int index){
        String precioUnitarioFinal;
        String mascaraPrecioUnitario="#.";//para la mascara
               
            
            for(int i=0; i<decimalesPrecioUnitario; i++)
            {
                mascaraPrecioUnitario=mascaraPrecioUnitario+("0");
                
            }
           DecimalFormat formatoPrecioUnitario=new DecimalFormat(mascaraPrecioUnitario);
            precioUnitarioFinal=(formatoPrecioUnitario.format(precioUnitario.get(index)).replace(',','.'));
        
        return precioUnitarioFinal;
    }
    private String decimalesCalculoTotal(int index){
        String calculoTotalFinal;
        String mascaraCalculoTotal="#.";//para la mascara
        Double temporal;
        
            temporal=precioUnitario.get(index)*cantidad.get(index);
            for(int i=0; i<decimalesCalculoTotal; i++)
            {
                mascaraCalculoTotal=mascaraCalculoTotal+("0");
                
            }
            DecimalFormat formatoPrecioUnitario=new DecimalFormat(mascaraCalculoTotal);
            calculoTotalFinal=(formatoPrecioUnitario.format(temporal).replace(',','.'));
        
        return calculoTotalFinal;
    }
    */
    private void calculosTotales() {
         for(int i=0; i<codigoConcepto.size(); i++)
            {
                totalIngresos+=ingresosBolivares.get(i);
                totalEgresos+=egresosBolivares.get(i);
                
            }
         existenciaFinal=(existenciaAnterior+totalIngresos)-totalEgresos;
         
    }
            
}
