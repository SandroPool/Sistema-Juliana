/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa1_presentacion;

import capa2_dominio.Categoria;
import capa2_dominio.Producto;
import capa2_dominio.Proveedor;
import capa3_persistencia.BaseDatos;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author SANDRO
 */
public class ProductoFrame extends javax.swing.JDialog {
    DefaultComboBoxModel<Categoria> modeloCategorias;
    DefaultComboBoxModel<Proveedor> modeloProveedores;
    BaseDatos baseDatos;
    boolean estaActualizando;
    String informacion = "";
    
    /**
     * Creates new form ProveedoresFrame
     */
    public ProductoFrame(java.awt.Frame parent, boolean modal, Producto producto, ImageIcon imageIcon, String titulo,boolean actualizando) {
        super(parent, modal);
        modeloCategorias = new DefaultComboBoxModel<Categoria>();
        modeloProveedores = new DefaultComboBoxModel<Proveedor>();
        baseDatos = new BaseDatos();
        cargarModeloCategoria();
        cargarModeloProveedor();
        initComponents();
        this.estaActualizando = actualizando;
        this.setTitle(titulo);
        if(producto != null){
            cargarProductos(producto, imageIcon);
        }
    }
    
    private void cargarProductos(Producto producto, ImageIcon imageIcon){
        Image imageProd = imageIcon.getImage();
        int ancho = lblArticuloImagen.getWidth();
        int alto = lblArticuloImagen.getHeight();
            
        Image imgRedimensionada = imageProd.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
            
        ImageIcon iconRedimensionado = new ImageIcon(imgRedimensionada);
        
        
        lblArticuloImagen.setIcon(iconRedimensionado);
        String clave = producto.getIdProducto();
        String nombre = producto.getNombreProducto();
        String descripcion = producto.getDescripcionProducto();
        double stock = producto.getStockProducto();
        String unidad = producto.getUnidadProducto();
        double precioCompra = producto.getPrecioCompraProducto();
        double precioVenta = producto.getPrecioVentaProducto();
        
        campoClave.setText(clave);
        campoNombre.setText(nombre);
        campoDescripcion.setText(descripcion);
        campoStockRequerido.setText(String.valueOf(stock));
        comboUnidad.setSelectedItem(unidad);
        campoPrecioCompra.setText(String.valueOf(precioCompra));
        campoPrecioVenta.setText(String.valueOf(precioVenta));
        
        campoClave.setEnabled(false);
        campoNombre.setEnabled(false);
    }
    
    private void cargarModeloCategoria(){
        ArrayList<Categoria> listaCategorias;
        listaCategorias = baseDatos.obtenerCategoria();
        listaCategorias.forEach(categoria->{
            modeloCategorias.addElement(categoria);
        });
    }
    private void cargarModeloProveedor(){
        ArrayList<Proveedor> listaProveedores;
        listaProveedores=baseDatos.obtenerProveedor();
        listaProveedores.forEach(proveedor->{
            modeloProveedores.addElement(proveedor);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoClave = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        campoStockRequerido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboUnidad = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        campoPrecioCompra = new javax.swing.JTextField();
        campoPrecioVenta = new javax.swing.JTextField();
        botonCancelar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblArticuloImagen = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboProveedor = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Product");
        setLocation(new java.awt.Point(250, 10));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Clave:");

        campoClave.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Descripcion");

        campoDescripcion.setColumns(20);
        campoDescripcion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        campoDescripcion.setLineWrap(true);
        campoDescripcion.setRows(5);
        campoDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoDescripcionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(campoDescripcion);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Stock Requerido");

        campoStockRequerido.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        campoStockRequerido.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Categoria");

        comboCategoria.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comboCategoria.setModel(modeloCategorias);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Unidad de Medida:");

        comboUnidad.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comboUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilogramo", "Ciento", "Pieza", "Litro", "Unidad", "Ciento", "Caja" }));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Precio de Compra");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Precio de Venta");

        campoPrecioCompra.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        campoPrecioCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        campoPrecioVenta.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        campoPrecioVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        botonCancelar.setBackground(new java.awt.Color(241, 81, 86));
        botonCancelar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonGuardar.setBackground(new java.awt.Color(0, 159, 253));
        botonGuardar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        botonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 14, 11));

        lblArticuloImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblArticuloImagenMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblArticuloImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblArticuloImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Proveedor");

        comboProveedor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comboProveedor.setModel(modeloProveedores);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Nombre:");

        campoNombre.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(campoClave, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoNombre)))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoPrecioCompra, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(campoPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(campoStockRequerido))
                        .addGap(218, 218, 218))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(87, 87, 87)))
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(55, 55, 55))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(comboUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(comboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoStockRequerido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    File imgArticleFile;
    private void lblArticuloImagenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblArticuloImagenMousePressed
       JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Archivos de imagen jpg, gif o png", "jpg","gif","png");
        chooser.setFileFilter(filter);
        
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            int anchoImagen = lblArticuloImagen.getWidth();
            int altoImagen = lblArticuloImagen.getHeight();
            
            imgArticleFile = chooser.getSelectedFile();
            
            ImageIcon icono = new ImageIcon(imgArticleFile.getAbsolutePath());
            Image imagen = icono.getImage();
            Image imageRedimesionado = imagen.getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT);
            ImageIcon iconoRedimensionado = new ImageIcon(imageRedimesionado);
            lblArticuloImagen.setIcon(iconoRedimensionado);
        }
    }//GEN-LAST:event_lblArticuloImagenMousePressed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        try {
        String codigo = campoClave.getText();
        String nombre = campoNombre.getText();
        String descripcion = campoDescripcion.getText();
        double stock = Double.parseDouble(campoStockRequerido.getText());
        double preciCompra = Double.parseDouble(campoPrecioCompra.getText());
        double precioVenta = Double.parseDouble(campoPrecioVenta.getText());
        String unidadMedida = comboUnidad.getSelectedItem().toString();
        Categoria categoria = (Categoria)comboCategoria.getSelectedItem();
        Proveedor proveedor = (Proveedor)comboProveedor.getSelectedItem();
       
        if(estaActualizando){
            if(imgArticleFile == null){
                Producto producto = new Producto(codigo, nombre, descripcion, stock, null, unidadMedida, 
                preciCompra, precioVenta, 0.0, categoria.getIdCategoriaProducto(), proveedor.getIdProveedor());
                baseDatos.actualizarProducto(producto, false);   
            }else{
                Producto producto = new Producto(codigo, nombre, descripcion, stock, imgArticleFile, unidadMedida, 
                preciCompra, precioVenta, 0.0, categoria.getIdCategoriaProducto(), proveedor.getIdProveedor());
                baseDatos.actualizarProducto(producto, true);
            }
            JOptionPane.showMessageDialog(this, "Producto Actualizado");
            this.dispose();
            informacion = "1";
             
        if(imgArticleFile == null){
            JOptionPane.showMessageDialog(this,"No! ha elegido una fotografia de producto" ,"ERROR", JOptionPane.WARNING_MESSAGE);
        }else{
            
            Producto producto = new Producto(codigo, nombre, descripcion, stock, imgArticleFile, unidadMedida, 
                preciCompra, precioVenta, 0.0, categoria.getIdCategoriaProducto(), proveedor.getIdProveedor());
            baseDatos.insertarProducto(producto);
            JOptionPane.showMessageDialog(this, "Producto Guardado");
            this.dispose();
        }
      }else{
            
            if(imgArticleFile==null){
                JOptionPane.showMessageDialog(this, "No! ha elegido una fotografia de Producto", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else{
                Producto producto = new Producto(codigo, nombre, descripcion, stock, imgArticleFile, unidadMedida, 
                        preciCompra, precioVenta, 0.0, categoria.getIdCategoriaProducto(), proveedor.getIdProveedor());
                baseDatos.insertarProducto(producto);
                JOptionPane.showMessageDialog(this, "Se Ha Guardado el producto con exito");
                campoClave.setText("");
                campoNombre.setText("");
                campoDescripcion.setText("");
                campoStockRequerido.setText("");
                campoPrecioCompra.setText("");
                campoPrecioVenta.setText("");   
            }
        }
        }catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error Falta ingresar Stock o Precios", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void campoDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDescripcionKeyTyped
        if(campoDescripcion.getText().length() == 145){
            evt.consume();
        }
    }//GEN-LAST:event_campoDescripcionKeyTyped

    public String getInformacion(){
        return this.informacion;
    }
    
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
            java.util.logging.Logger.getLogger(ProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductoFrame dialog = new ProductoFrame(new javax.swing.JFrame(), true, null,null,"Actualizar Producto",true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JTextField campoClave;
    private javax.swing.JTextArea campoDescripcion;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecioCompra;
    private javax.swing.JTextField campoPrecioVenta;
    private javax.swing.JTextField campoStockRequerido;
    private javax.swing.JComboBox<Categoria> comboCategoria;
    private javax.swing.JComboBox<Proveedor> comboProveedor;
    private javax.swing.JComboBox<String> comboUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblArticuloImagen;
    // End of variables declaration//GEN-END:variables
}
