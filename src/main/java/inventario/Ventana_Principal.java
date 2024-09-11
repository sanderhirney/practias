package inventario;

import BaseDatos.ConexionEmpresas;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

       
public class Ventana_Principal extends javax.swing.JFrame {
   
    String nombre;//nombre tomado al iniciar el programa
    ConexionEmpresas consulta_empresas=new ConexionEmpresas();
    public Dimension resolucion;//variable para leer el ancho y alto de la ventana
 
  
      
    
    public Ventana_Principal() {
        this.getContentPane().setBackground(Color.WHITE);//color de fondo
        initComponents();
        resolucion=super.getToolkit().getScreenSize();
        this.setSize(resolucion);
        
        consulta_empresas.consulta();
        nombre=consulta_empresas.nombre_empresa();
       if(nombre==null)
        {
            JOptionPane.showMessageDialog(null, "No se pudo Obtener la informacion de la Seccion en cual trabajar.\n Ventana Principal \n Contacte al Desarrollador \n " ,  "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
           System.exit(0);
        }
        else
        {
       Etiq_titulo.setText(nombre);
        }
             
              
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Arbol = new javax.swing.JTree();
        Etiq_Seccion = new javax.swing.JLabel();
        Etiq_titulo = new javax.swing.JLabel();
        Boton_cambiar = new javax.swing.JButton();
        PanelLayout = new javax.swing.JPanel();
        botonSalir = new javax.swing.JButton();
        etiquetaVersion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Inventario");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Entradas");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Salidas");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Proveedores");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Crear");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Consultar");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Servicios");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Crear");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Consultar");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Articulos");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Crear");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Consultar");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Asignar");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Reportes");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Reportes");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Configuracion");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Firmantes");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Secciones");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Unidades");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Cargos");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Conceptos");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Grupos");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Decimales");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        Arbol.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        Arbol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ArbolMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Arbol);

        Etiq_Seccion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Etiq_Seccion.setText("SECCION:");

        Etiq_titulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        Boton_cambiar.setText("Cambiar");
        Boton_cambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_cambiarActionPerformed(evt);
            }
        });

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        PanelLayout.add(botonSalir);

        etiquetaVersion.setText("Ver1.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Etiq_Seccion, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Etiq_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Boton_cambiar)
                        .addGap(0, 61, Short.MAX_VALUE))
                    .addComponent(etiquetaVersion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(Etiq_Seccion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Etiq_titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(Boton_cambiar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaVersion)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
       
             int opcion= JOptionPane.showConfirmDialog(null," ¿Seguro desea Salir?. ¡No se conservara nada que no haya guardado!", "Confirmacion de Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        //opcion 0= Si, 1=No
         if (opcion==0)
         {
             System.exit(0);
         }//if
                 
    }//GEN-LAST:event_botonSalirActionPerformed

    private void ArbolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArbolMouseClicked
        // TODO add your handling code here:
       if (evt.getClickCount() == 2)
       {
        try
        {
          
       
          DefaultMutableTreeNode nodo = ((DefaultMutableTreeNode)Arbol.getLastSelectedPathComponent());     
          Object nodeInfo = nodo.getUserObject();
          
          if( ((nodo.getParent().toString()).equals("Inventario")) && ((nodeInfo.toString()).equals("Entradas")) )
          {
            
              //llamo primero a la ventana donde estan todas las entradas
              //y desde esta ventana el usuario decide si crea uno nuevo 
              //o modifica alguno seleccionado
              Consultar_Entradas entrada=new Consultar_Entradas(this, true);
              entrada.PrincipalFrame(this);
              entrada.setResizable(false);
              entrada.setLocationRelativeTo(null);
              entrada.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              entrada.setVisible(true);
              
              
             
          }
          if( ((nodo.getParent().toString()).equals("Inventario")) && ((nodeInfo.toString()).equals("Salidas")) )
          {
              Consultar_Salidas salida=new Consultar_Salidas(null, true);
              salida.PrincipalFrame(this);
              salida.setResizable(false);
              salida.setLocationRelativeTo(null);
              salida.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              salida.setVisible(true);
             
          }
         
          if( ((nodo.getParent().toString()).equals("Proveedores")) && ((nodeInfo.toString()).equals("Crear")) )
          {
              Crear_Proveedores crear_prov= new Crear_Proveedores(this, true);
              crear_prov.setResizable(false);
              crear_prov.setLocationRelativeTo(null);
              crear_prov.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              crear_prov.setVisible(true);
          }
          if( ((nodo.getParent().toString()).equals("Proveedores")) && ((nodeInfo.toString()).equals("Consultar")) )
          {
              Consultar_Proveedores consultar_prov= new Consultar_Proveedores(this, true);
              consultar_prov.setResizable(false);
              consultar_prov.setLocationRelativeTo(null);
              consultar_prov.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              consultar_prov.setVisible(true);
          }
          if( ((nodo.getParent().toString()).equals("Servicios")) && ((nodeInfo.toString()).equals("Crear")) )
          {
              Crear_Servicio crear_serv= new Crear_Servicio(this, true);
              crear_serv.setResizable(false);
              crear_serv.setLocationRelativeTo(null);
              crear_serv.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              crear_serv.setVisible(true);
          }
          if( ((nodo.getParent().toString()).equals("Servicios")) && ((nodeInfo.toString()).equals("Consultar")) )
          {
              Consultar_Servicio consultar_serv= new Consultar_Servicio(this, true);
              consultar_serv.setResizable(false);
              consultar_serv.setLocationRelativeTo(null);
              consultar_serv.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              consultar_serv.setVisible(true);
          }
          if( ((nodo.getParent().toString()).equals("Articulos")) && ((nodeInfo.toString()).equals("Crear")) )
          {
              Crear_Articulos crear_art= new Crear_Articulos(this, true);
              crear_art.setResizable(false);
              crear_art.setLocationRelativeTo(null);
              crear_art.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              crear_art.setVisible(true);
          }
          if( ((nodo.getParent().toString()).equals("Articulos")) && ((nodeInfo.toString()).equals("Consultar")) )
          {
              Consultar_Articulos consultar_serv= new Consultar_Articulos(this, true);
              consultar_serv.setResizable(false);
              consultar_serv.setLocationRelativeTo(null);
              consultar_serv.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              consultar_serv.setVisible(true);
          }
          if( ((nodo.getParent().toString()).equals("Articulos")) && ((nodeInfo.toString()).equals("Asignar")) )
          {
              Asignar_seccion_art asignar= new Asignar_seccion_art(this, true);
              asignar.setResizable(false);
              asignar.setLocationRelativeTo(null);
              asignar.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              asignar.setVisible(true);
          }
          if( ((nodo.getParent().toString()).equals("Almacenes")) && ((nodeInfo.toString()).equals("Crear")) )
          {
              Crear_Almacenes crear_almac= new Crear_Almacenes(this, true);
              crear_almac.setResizable(false);
              crear_almac.setLocationRelativeTo(null);
              crear_almac.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              crear_almac.setVisible(true);
          }
          if( ((nodo.getParent().toString()).equals("Almacenes")) && ((nodeInfo.toString()).equals("Consultar")) )
          {
              Consultar_Almacenes consultar_almac= new Consultar_Almacenes(this, true);
              consultar_almac.setResizable(false);
              consultar_almac.setLocationRelativeTo(null);
              consultar_almac.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              consultar_almac.setVisible(true);
          }
        
          if( ((nodo.getParent().toString()).equals("Reportes")) && ((nodeInfo.toString()).equals("Reportes")) )
          {
                       
             Reportes reportes= new Reportes(this, true);
              reportes.setResizable(false);
              reportes.setLocationRelativeTo(null);
              reportes.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              reportes.setVisible(true);
          }
          
          if( ((nodo.getParent().toString()).equals("Configuracion")) && ((nodeInfo.toString()).equals("Secciones")) )
          {
              Crear_Secciones secciones= new Crear_Secciones(this, true);
              secciones.setResizable(false);
              secciones.setLocationRelativeTo(null);
              secciones.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              secciones.setVisible(true);
          }
          if( ((nodo.getParent().toString()).equals("Configuracion")) && ((nodeInfo.toString()).equals("Unidades")) )
          {
              Crear_Unidades unidades= new Crear_Unidades(this, true);
              unidades.setResizable(false);
              unidades.setLocationRelativeTo(null);
              unidades.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              unidades.setVisible(true);
          }
          if( ((nodo.getParent().toString()).equals("Configuracion")) && ((nodeInfo.toString()).equals("Firmantes")) )
          {
              Crear_Firmantes firmas= new Crear_Firmantes(this, true);
              firmas.setResizable(false);
              firmas.setLocationRelativeTo(null);
              firmas.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              firmas.setVisible(true);
          }
          if( ((nodo.getParent().toString()).equals("Configuracion")) && ((nodeInfo.toString()).equals("Cargos")) )
          {
              Crear_Cargo cargos= new Crear_Cargo(this, true);
              cargos.setResizable(false);
              cargos.setLocationRelativeTo(null);
              cargos.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              cargos.setVisible(true);
          }
          if( ((nodo.getParent().toString()).equals("Configuracion")) && ((nodeInfo.toString()).equals("Conceptos")) )
          {
              Crear_Conceptos conceptos= new Crear_Conceptos(this, true);
              conceptos.setResizable(false);
              conceptos.setLocationRelativeTo(null);
              conceptos.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              conceptos.setVisible(true);
          }
          if( ((nodo.getParent().toString()).equals("Configuracion")) && ((nodeInfo.toString()).equals("Grupos")) )
          {
              Crear_Grupos grupos= new Crear_Grupos(this, true);
              grupos.setResizable(false);
              grupos.setLocationRelativeTo(null);
              grupos.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              grupos.setVisible(true);
          }
           if( ((nodo.getParent().toString()).equals("Configuracion")) && ((nodeInfo.toString()).equals("Decimales")) )
          {
              Crear_Decimal decimal= new Crear_Decimal(this, true);
              decimal.setResizable(false);
              decimal.setLocationRelativeTo(null);
              decimal.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
              decimal.setVisible(true);
          }
          
   
       }//evento try
        catch( Exception e )
        {
            JOptionPane.showMessageDialog(null, "Por favor de doble click solo a los nodos internos.\n Ventana Principal  \n " +e,  "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        }


    }//evento doble click
        
        
    }//GEN-LAST:event_ArbolMouseClicked

    private void Boton_cambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_cambiarActionPerformed
        // TODO add your handling code here:
        Ver_Secciones seccion= new Ver_Secciones(null, true);
         seccion.setResizable(false);
       seccion.setLocationRelativeTo(null);
       seccion.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
       seccion.setVisible(true);
       
       if(seccion.getEstado()==1)
       {
            consulta_empresas.consulta();
            nombre=consulta_empresas.nombre_empresa();
            Etiq_titulo.setText(nombre);
       }
        
    }//GEN-LAST:event_Boton_cambiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree Arbol;
    private javax.swing.JButton Boton_cambiar;
    private javax.swing.JLabel Etiq_Seccion;
    private javax.swing.JLabel Etiq_titulo;
    private javax.swing.JPanel PanelLayout;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel etiquetaVersion;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
