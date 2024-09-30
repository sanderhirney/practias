
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



public class ReporteEntrada {
    
    public void llamarReporte(){
        
        
        
      
       
        try {
             InputStream report = ReporteEntrada.class.getResourceAsStream("/Entradas.jasper");
            //URL url=(this.getClass().getResource("/Entradas.jasper"));
            //File fichero=new File(url.getFile());
            JasperReport reporte = (JasperReport) JRLoader.loadObject(report);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, DatosdeGenerarEntrada.getDataSource());
            JasperViewer view = new JasperViewer(jprint, false);
            view.setTitle("Entrada");
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setAlwaysOnTop(true);
          
            view.setVisible(true);
             } catch (JRException ex) {
            Logger.getLogger(ReporteEntrada.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Se ha producido un error al cargar el reporte" + "\n" + ex , "Error", JOptionPane.ERROR_MESSAGE);
             ex.printStackTrace();
             }
        
    }
   
        
    
}
