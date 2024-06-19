
package Reportes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Crear_Libro {
    int hojas=0;
    
    public void crear(){
    
    
    try(FileInputStream archivoBase=new FileInputStream("entradasBase.xls"))
        
    {
        
        try (HSSFWorkbook libroBase=new HSSFWorkbook(archivoBase))         

        {
             
               
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo base a cargar"+"\n"+e, "Error grave", JOptionPane.ERROR_MESSAGE);
        }
    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo base en el cual escribir la informacion"+"\n"+e, "Error grave", JOptionPane.ERROR_MESSAGE);
    
    }
    
    
    }//funcion crear
    
    public void setCantidadHojas(int hojas){
        this.hojas=hojas;
    }
}
