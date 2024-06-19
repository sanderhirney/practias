
package Reportes;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;


public class ModeloF4 {
    
 
    public void ejecutar()
    {
      // Se crea el libro
        HSSFWorkbook libro = new HSSFWorkbook();

        // Se crea una hoja dentro del libro
        HSSFSheet hoja = libro.createSheet();

        // Se crea una fila dentro de la hoja
      hoja.addMergedRegion(new CellRangeAddress(0,0,0,4));//fusionar celdas FORMATO FILA, FILA, COLUMNA, COLUMNA
       HSSFRow fila = hoja.createRow(3);
       HSSFCell celdaA = fila.createCell(0);
       celdaA.setCellValue("MINISTERIO DEL PODER POPULAR PARA LA SALUD");
       HSSFCell celdaA1 = fila.createCell(10);
       celdaA1.setCellValue("HOSPITAL GENERAL TIPO II  DR SAMUEL DARIO MALDONADO");
       HSSFRow fila1 = hoja.createRow(5);
       HSSFCell celdaA2=fila1.createCell(0);
       celdaA2.setCellValue("CODIGOS GRUPOS");
        HSSFRow fila2 = hoja.createRow(8);
for(int i=0; i<20; i++)
{
      
      
      for(int j=3; j<20; j++)
      {
           // Se crea una celda dentro de la fila
      HSSFCell celdaB = fila2.createCell(j);
         celdaB.setCellValue(j);
      }
}
       
     

        // Se crea el contenido de la celda y se mete en ella.
        HSSFRichTextString texto = new HSSFRichTextString("MODELO F4");
       

        // Se salva el libro.
        try {
            FileOutputStream elFichero = new FileOutputStream("modelof4.xls");
            libro.write(elFichero);
            elFichero.close();
            
             try {

            File archivoExcel = new File ("modelof4.xls");
            Desktop.getDesktop().open(archivoExcel);

     }
             catch (IOException ex) 
     {

            JOptionPane.showMessageDialog(null, "Error no se ha conseguido el archivo. \n Motivo: "+ex, "Error grave", JOptionPane.ERROR_MESSAGE);

     }
        } 
    catch (Exception e) 
{
            JOptionPane.showMessageDialog(null, "Error no se ha podido crear el archivo. \n Motivo: "+e, "Error grave", JOptionPane.ERROR_MESSAGE);
        }//catch
     }
}
    
