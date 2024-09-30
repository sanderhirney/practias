
package Reportes;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;



public class ReporteSalida {
    
    public void llamarReporte(){
        
         
        
      
       
        try {
             InputStream report = ReporteSalida.class.getResourceAsStream("/Salidas.jasper");
            //URL url=(this.getClass().getResource("/Salidas.jasper"));
            //File fichero=new File(url.getFile());
            JasperReport reporte = (JasperReport) JRLoader.loadObject(report);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, DatosdeGenerarSalida.getDataSource());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setAlwaysOnTop(true);
            view.setVisible(true);
             } catch (JRException ex) {
            Logger.getLogger(ReporteSalida.class.getName()).log(Level.SEVERE, "Mensaje de log", ex);
            JOptionPane.showMessageDialog(null, "Se ha producido un error al cargar el reporte" + "\n" + ex , "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            }
       
        
        }
  
           
  
           
        
    
}
