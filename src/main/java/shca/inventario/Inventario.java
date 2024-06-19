package inventario;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.JOptionPane;

public class Inventario {
private final static Logger Log = Logger.getLogger("Inventario");
    public static void main(String[] args) {
        
        
        try
        { 
         SimpleFormatter Formato = new SimpleFormatter();
        Handler consolaErrores=new ConsoleHandler();
        Handler archivo=new FileHandler("log.txt");
        consolaErrores.setLevel(Level.ALL);
        archivo.setLevel(Level.ALL);
       
        archivo.setFormatter(Formato);
        Log.addHandler(consolaErrores);
        Log.addHandler(archivo);
        Ventana_Principal ventana = new Ventana_Principal();
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setVisible(true);
        Log.log(Level.ALL, "Bitacora: ");
        Log.log(Level.INFO, "Ingreso Satisfactorio");
        consolaErrores.close();
        archivo.close();
        
          
            
        }catch(IOException | SecurityException e)
        {
           JOptionPane.showMessageDialog(null, "Se ha producido un error al cargar los archvios de arranque" + "\n Verifique que los archivos de LOG y del sistema esten ubicados apropiadamente" + e, "Error", JOptionPane.ERROR_MESSAGE);
            
        }

        
        
        

    }//main

}//clase
