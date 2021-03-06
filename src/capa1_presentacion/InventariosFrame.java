/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa1_presentacion;

import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

import capa2_dominio.Producto;
import capa3_persistencia.BaseDatos;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author SANDRO
 */
public class InventariosFrame extends javax.swing.JInternalFrame {
    DefaultTableModel modeloTabla = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    BaseDatos baseDatos = new BaseDatos();
    ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    Producto productoSeleccionado = null;
    /**
     * Creates new form Inventario
     */
    public InventariosFrame() {
        cargarColumnas();
        cargarModeloTabla();
        initComponents();
    }
    
    public void cargarColumnas(){
        modeloTabla.addColumn("Clave");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Unidad");
        modeloTabla.addColumn("Precio Compra");
        modeloTabla.addColumn("Precio Venta");
        modeloTabla.addColumn("Stock");
    }
    
    /* este metodo carga el modelo de inventarios de la tabla */
    private void cargarModeloTabla(){
        limpiarTabla();
        this.listaProductos = baseDatos.obtenerProducto();
        int numeroProductos = listaProductos.size();
        modeloTabla.setNumRows(numeroProductos);
        
        for(int i =0; i<numeroProductos; i++){
            Producto producto = listaProductos.get(i);
            String clave = producto.getIdProducto();
//            String nombre = producto.getNombreProducto();
            String unidad = producto.getUnidadProducto();
            Double precioCompra = producto.getPrecioCompraProducto();
            Double precioVenta = producto.getPrecioVentaProducto();
            Double stock = producto.getStockProducto();
            
            modeloTabla.setValueAt(clave, i, 0);
            modeloTabla.setValueAt(producto, i, 1);
            modeloTabla.setValueAt(unidad, i, 2);
            modeloTabla.setValueAt(precioCompra, i, 3);
            modeloTabla.setValueAt(precioVenta, i, 4);
            modeloTabla.setValueAt(stock, i, 5);
            
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

        botonNuevoArticulo = new javax.swing.JButton();
        botonNuevaCategoria = new javax.swing.JButton();
        botonNuevoProveedor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        botonModificarProducto = new javax.swing.JButton();
        botonBorrarProducto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        campoClave = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoStock = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoUnidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaDescripcion = new javax.swing.JTextArea();

        setTitle("Inventarios");
        setMinimumSize(new java.awt.Dimension(700, 544));

        botonNuevoArticulo.setToolTipText("Nuevo Producto");
        ImageIcon iconBtnNuevoProducto = new ImageIcon("img/nuevo_producto.png");

        botonNuevoArticulo.setIcon(iconBtnNuevoProducto);
        botonNuevoArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoArticuloActionPerformed(evt);
            }
        });

        botonNuevaCategoria.setToolTipText("Nueva Categoria");
        ImageIcon imageNuevaCategoria = new ImageIcon("img/nueva_categoria.png");

        botonNuevaCategoria.setIcon(imageNuevaCategoria);
        botonNuevaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevaCategoriaActionPerformed(evt);
            }
        });

        botonNuevoProveedor.setToolTipText("Nuevo Proveedor");
        ImageIcon iconProveedor = new ImageIcon("img/nuevo_proveedor.png");

        botonNuevoProveedor.setIcon(iconProveedor);
        botonNuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoProveedorActionPerformed(evt);
            }
        });

        tablaProductos.setModel(modeloTabla);
        tablaProductos.getSelectionModel().addListSelectionListener(
            new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent ev){
                    if(!ev.getValueIsAdjusting() && (tablaProductos.getSelectedRow()>=0)){
                        int filaSeleccionada = tablaProductos.getSelectedRow();
                        Producto producto = (Producto)modeloTabla.getValueAt(filaSeleccionada, 1);
                        campoClave.setText(producto.getIdProducto());
                        campoNombre.setText(producto.getNombreProducto());
                        String stock = String.valueOf(producto.getStockProducto());
                        campoStock.setText(stock);
                        areaDescripcion.setText(producto.getDescripcionProducto());
                        campoUnidad.setText(producto.getUnidadProducto());
                        productoSeleccionado = producto;
                        //despliegue la foto del producto
                        desplegarFoto(producto);
                    }
                }
            }
        );
        jScrollPane1.setViewportView(tablaProductos);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Buscar Producto");

        campoBuscar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
        });

        botonModificarProducto.setToolTipText("Editar");
        ImageIcon iconEditar = new ImageIcon("img/editar.png");

        botonModificarProducto.setIcon(iconEditar);
        botonModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarProductoActionPerformed(evt);
            }
        });

        botonBorrarProducto.setToolTipText("Borrar");
        ImageIcon iconEliminar = new ImageIcon("img/eliminar.png");
        botonBorrarProducto.setIcon(iconEliminar);
        botonBorrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarProductoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        lblImagen.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Clave");

        campoClave.setEditable(false);
        campoClave.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        campoClave.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Nombre");

        campoNombre.setEditable(false);
        campoNombre.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        campoNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Stock");

        campoStock.setEditable(false);
        campoStock.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        campoStock.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Unidad");

        campoUnidad.setEditable(false);
        campoUnidad.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        campoUnidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Descripción");

        areaDescripcion.setEditable(false);
        areaDescripcion.setBackground(new java.awt.Color(0, 51, 102));
        areaDescripcion.setColumns(20);
        areaDescripcion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        areaDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        areaDescripcion.setLineWrap(true);
        areaDescripcion.setRows(5);
        areaDescripcion.setWrapStyleWord(true);
        areaDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane2.setViewportView(areaDescripcion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonNuevoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(botonNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(botonNuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(botonBorrarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addGap(17, 17, 17)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoStock, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(44, 44, 44)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(218, 218, 218))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonNuevoProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(botonNuevaCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonNuevoArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(campoStock, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(campoUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonModificarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonBorrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonNuevoArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoArticuloActionPerformed
        ProductoFrame productoFrame = new ProductoFrame(null, true, null,null,"nuevo producto",false);
        productoFrame.setVisible(true);
        productoFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        productoFrame.setLocation(600,150);
        productoFrame.setAlwaysOnTop(true);
        
    }//GEN-LAST:event_botonNuevoArticuloActionPerformed

    private void botonNuevaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevaCategoriaActionPerformed
       CategoriaFrame categoriaFrame = new CategoriaFrame(null, true);
       categoriaFrame.setVisible(true);
       categoriaFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
       categoriaFrame.setLocation(600, 150);
       categoriaFrame.setAlwaysOnTop(true);
    }//GEN-LAST:event_botonNuevaCategoriaActionPerformed

    private void botonNuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoProveedorActionPerformed
        ProveedorFrame proveedorFrame = new ProveedorFrame(null, true);
        proveedorFrame.setVisible(true);
        proveedorFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        proveedorFrame.setLocation(600, 150);
        proveedorFrame.setAlwaysOnTop(true);
    }//GEN-LAST:event_botonNuevoProveedorActionPerformed

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
       limpiarTabla();
       String cadenaBusqueda = campoBuscar.getText();
       ArrayList<Producto> listaProductos = new ArrayList<Producto>();
       listaProductos= baseDatos.obtenerProductosPorCriterio(cadenaBusqueda);
       
       int numeroProductos = listaProductos.size();
       modeloTabla.setNumRows(numeroProductos);
       
       for(int i=0; i < numeroProductos; i++){
           Producto producto = listaProductos.get(i);
           String clave = producto.getIdProducto();
           String nombre = producto.getNombreProducto();
           String unidad = producto.getUnidadProducto();
           Double precioCompra = producto.getPrecioCompraProducto();
           Double precioVenta = producto.getPrecioVentaProducto();
           Double stock = producto.getStockProducto();
           
           modeloTabla.setValueAt(clave, i, 0);
           modeloTabla.setValueAt(producto, i, 1);
           modeloTabla.setValueAt(unidad, i, 2);
           modeloTabla.setValueAt(precioCompra, i, 3);
           modeloTabla.setValueAt(precioVenta, i, 4);
           modeloTabla.setValueAt(stock, i, 5);

       }
       
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void desplegarFoto(Producto producto){
        ImageIcon imageProducto = null;
        
        try {
            InputStream inputStream = baseDatos.buscarFoto(producto);
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            imageProducto = new ImageIcon(bufferedImage);
            
            Image imageProd = imageProducto.getImage();
            int ancho = lblImagen.getWidth();
            int alto = lblImagen.getHeight();
            
            Image imgRedimensionada = imageProd.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
            
            ImageIcon iconRedimensionado = new ImageIcon(imgRedimensionada);
            
            lblImagen.setIcon(iconRedimensionado);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    private void botonModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarProductoActionPerformed
        try {
            String nombreProducto = productoSeleccionado.getNombreProducto();
            ImageIcon imagenProducto = new  ImageIcon();
            ProductoFrame productoFrame  = null;
            int opcion = JOptionPane.showConfirmDialog(this, "¿Estas seguro de modifica el "+nombreProducto+" ?");
        
        if(opcion == 0){
            try {
                InputStream is = baseDatos.buscarFoto(productoSeleccionado);
                BufferedImage bi = ImageIO.read(is);
                imagenProducto = new ImageIcon(bi);
                
                
                productoFrame = new ProductoFrame(null, true, productoSeleccionado,imagenProducto,"Actualizar Producto",true);
                productoFrame.setVisible(true);
                if(productoFrame != null){
                    if(productoFrame.getInformacion() != ""){
                        cargarModeloTabla();
                    }
                }
            } catch (IOException ex) { 
                ex.printStackTrace();
            }
        }
        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Error Producto No seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
          
    }//GEN-LAST:event_botonModificarProductoActionPerformed

    private void botonBorrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarProductoActionPerformed
        if(tablaProductos.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Error Producto No seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
            int opcion = JOptionPane.showConfirmDialog(this, "ESTAS SEGURO DE BORRAR PRODUCTO");
        
            if(opcion == 0){
                modeloTabla.removeRow(tablaProductos.getSelectedRow());
                baseDatos.borrarProducto(productoSeleccionado);
            }
        }  
    }//GEN-LAST:event_botonBorrarProductoActionPerformed
    
    public void limpiarTabla(){
        int numeroFilas = modeloTabla.getRowCount();
        if(numeroFilas > 0){
            for (int i=numeroFilas -1; i >= 0 ; i--){
                modeloTabla.removeRow(i);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescripcion;
    private javax.swing.JButton botonBorrarProducto;
    private javax.swing.JButton botonModificarProducto;
    private javax.swing.JButton botonNuevaCategoria;
    private javax.swing.JButton botonNuevoArticulo;
    private javax.swing.JButton botonNuevoProveedor;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JTextField campoClave;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoStock;
    private javax.swing.JTextField campoUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
