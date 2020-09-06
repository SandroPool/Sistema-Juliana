package capa1_presentacion;

import capa2_dominio.DetalleVenta;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import capa2_dominio.Producto;
import capa2_dominio.Venta;
import capa3_persistencia.BaseDatos;
import com.sun.glass.events.KeyEvent;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
/**
 *
 * @author SANDRO
 */
public class VentasFrame extends javax.swing.JInternalFrame {
    DefaultTableModel modeloTablaProductos = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    DefaultListModel<Producto> modeloListaProductos = new DefaultListModel<Producto>();
    BaseDatos baseDatos = new BaseDatos();
    Producto producto;
    
    /**
     * Creates new form Ventas
     */
    public VentasFrame() {
        cargarColumnasTabla();
        initComponents();
        cargarListenerModeloTabla();
    }
    
    
    private void cargarColumnasTabla(){
        modeloTablaProductos.addColumn("Clave");
        modeloTablaProductos.addColumn("Nombre");
        modeloTablaProductos.addColumn("Precio Venta");
        modeloTablaProductos.addColumn("Cantidad");
        modeloTablaProductos.addColumn("Importe");
    }

    private void cargarListenerModeloTabla(){
        modeloTablaProductos.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int numeroFilas = modeloTablaProductos.getRowCount();
                double suma = 0;
                for(int i=0; i<numeroFilas; i++){
                    String importe = (String) modeloTablaProductos.getValueAt(i, 4);
                    suma += Double.parseDouble(importe);
                }
                lblSuma.setText(String.valueOf(suma));
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentasProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        campoBuscarProducto = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblSuma = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonRealizarVenta = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        campoPagoCon = new javax.swing.JTextField();
        botonQuitarProducto = new javax.swing.JButton();
        botonCancelarVenta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaBusquedaProductos = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        lblImagenProducto = new javax.swing.JLabel();
        botonCorteDia = new javax.swing.JButton();

        setTitle("Ventas");
        setMinimumSize(new java.awt.Dimension(700, 544));

        tablaVentasProductos.setModel(modeloTablaProductos);
        tablaVentasProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaVentasProductosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaVentasProductos);

        jLabel1.setFont(new java.awt.Font("Forte", 1, 24)); // NOI18N
        jLabel1.setText("Buscar Producto");

        campoBuscarProducto.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        campoBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarProductoKeyReleased(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblSuma.setFont(new java.awt.Font("Book Antiqua", 1, 56)); // NOI18N
        lblSuma.setText("0.00");

        jLabel3.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        jLabel3.setText("Venta Total");

        botonRealizarVenta.setBackground(new java.awt.Color(51, 153, 255));
        botonRealizarVenta.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        botonRealizarVenta.setForeground(new java.awt.Color(255, 255, 255));
        botonRealizarVenta.setText("Realizar Venta");
        botonRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRealizarVentaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("Pagó Con S/.");

        campoPagoCon.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        campoPagoCon.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 79, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(70, 70, 70))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(lblSuma))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel3))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoPagoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRealizarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lblSuma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(campoPagoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonRealizarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        botonQuitarProducto.setBackground(new java.awt.Color(14, 173, 105));
        botonQuitarProducto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonQuitarProducto.setForeground(new java.awt.Color(255, 255, 255));
        botonQuitarProducto.setText("Quitar Producto");
        ImageIcon iconQuitar = new ImageIcon("img/quitar.png");

        botonQuitarProducto.setIcon(iconQuitar);

        botonQuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarProductoActionPerformed(evt);
            }
        });

        botonCancelarVenta.setBackground(new java.awt.Color(241, 81, 86));
        botonCancelarVenta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonCancelarVenta.setForeground(new java.awt.Color(255, 255, 255));
        botonCancelarVenta.setText("Cancelar Venta");
        ImageIcon iconCancelar = new ImageIcon("img/cancelar.png");
        botonCancelarVenta.setIcon(iconCancelar);
        botonCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarVentaActionPerformed(evt);
            }
        });

        listaBusquedaProductos.setModel(modeloListaProductos);
        listaBusquedaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listaBusquedaProductosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(listaBusquedaProductos);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagenProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagenProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        botonCorteDia.setBackground(new java.awt.Color(255, 102, 102));
        botonCorteDia.setFont(new java.awt.Font("Engravers MT", 1, 12)); // NOI18N
        botonCorteDia.setForeground(new java.awt.Color(255, 255, 255));
        botonCorteDia.setText("Corte del Día");
        ImageIcon iconVentas = new ImageIcon("img/ventas.png");
        botonCorteDia.setIcon(iconVentas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(botonQuitarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(botonCancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoBuscarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                            .addComponent(botonCorteDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(176, 176, 176))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonCorteDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(campoBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonQuitarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonCancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarProductoKeyReleased
       modeloListaProductos.clear();
       String cadenaBusqueda = campoBuscarProducto.getText();
       if(cadenaBusqueda.isEmpty()){
           modeloListaProductos.clear();
       }else{
       ArrayList<Producto> listaProductos = new ArrayList<Producto>();
       
       listaProductos = baseDatos.obtenerProductosPorCriterio(cadenaBusqueda);
       
       listaProductos.forEach(producto->{
           modeloListaProductos.addElement(producto);
       });
      }
    }//GEN-LAST:event_campoBuscarProductoKeyReleased

    private void listaBusquedaProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaBusquedaProductosMousePressed
        JList list = (JList)evt.getSource();
        if(evt.getClickCount() == 2){
            list.locationToIndex(evt.getPoint());
            Producto producto = (Producto)list.getSelectedValue();
            agregarProductoVenta(producto);
            desplegarFoto(producto);
        }
        
    }//GEN-LAST:event_listaBusquedaProductosMousePressed

    private void tablaVentasProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaVentasProductosKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_F2){
            int filaSeleccionada = tablaVentasProductos.getSelectedRow();
            String cantida = JOptionPane.showInputDialog("Modificar Cantidad");
            String precioVenta = (String) tablaVentasProductos.getValueAt(filaSeleccionada, 2);
            double importe = Double.parseDouble(cantida) * Double.parseDouble(precioVenta);
            String importeString = String.valueOf(importe);
            modeloTablaProductos.setValueAt(cantida, filaSeleccionada, 3);
            modeloTablaProductos.setValueAt(importeString, filaSeleccionada, 4);
        }
    }//GEN-LAST:event_tablaVentasProductosKeyReleased

      private void desplegarFoto(Producto producto){
        ImageIcon imageProducto = null;
        
        try {
            InputStream inputStream = baseDatos.buscarFoto(producto);
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            imageProducto = new ImageIcon(bufferedImage);
            Image imageProd = imageProducto.getImage();
            int ancho = lblImagenProducto.getWidth();
            int alto = lblImagenProducto.getHeight();
            
            Image imgRedimensionada = imageProd.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
            
            ImageIcon iconRedimensionado = new ImageIcon(imgRedimensionada);
            
            
            lblImagenProducto.setIcon(iconRedimensionado);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    private void botonQuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarProductoActionPerformed
        int filaSeleccionada = tablaVentasProductos.getSelectedRow();
        int cantidaFilas = modeloTablaProductos.getRowCount();
        if(cantidaFilas > 0){
            int  opcion = JOptionPane.showConfirmDialog(this, "¿Esta seguro de quitar producto?");
            if(opcion == 0){
                modeloTablaProductos.removeRow(filaSeleccionada);
            }    
        }
    }//GEN-LAST:event_botonQuitarProductoActionPerformed

    private void botonCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarVentaActionPerformed
        int cantidadFilas = modeloTablaProductos.getRowCount();
        if(cantidadFilas > 0){
            int  opcion = JOptionPane.showConfirmDialog(this, "¿Esta seguro de cancelar venta?");
            if(opcion == 0){
                for(int i=cantidadFilas - 1; i>=0; i--){
                    modeloTablaProductos.removeRow(i);
                }    
            }
        }
    }//GEN-LAST:event_botonCancelarVentaActionPerformed

    private void botonRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRealizarVentaActionPerformed
        ArrayList<DetalleVenta> listaDetalleVenta = new ArrayList<DetalleVenta>();
        String sumaTexto = lblSuma.getText();
        double montoTotalVenta = Double.parseDouble(sumaTexto);
        
        String pagoCon = campoPagoCon.getText();
        double cambio = 0;
        
        if(!pagoCon.isEmpty()){
            double montoPagado = Double.parseDouble(pagoCon);
            cambio = montoPagado - montoTotalVenta;
        }
        
        Calendar calendarioLocal = Calendar.getInstance();
        java.util.Date fechaActual = calendarioLocal.getTime();
        long fechaMilisegundos = fechaActual.getTime();
        java.sql.Date fecha = new Date(fechaMilisegundos);
        
        Venta venta = new Venta(montoTotalVenta,fecha);
        Long idVenta = baseDatos.insertarVenta(venta);
        
        int numeroFilas = modeloTablaProductos.getRowCount();
        
        for (int i = 0; i < numeroFilas; i++) {
            String idProducto = (String)modeloTablaProductos.getValueAt(i, 0);
            String cantidadTexto = (String)modeloTablaProductos.getValueAt(i, 3);
            double cantidad = Double.parseDouble(cantidadTexto);
            DetalleVenta detalleVenta = new DetalleVenta(idVenta, idProducto, cantidad);
            baseDatos.insertarDetalleVenta(detalleVenta);
            listaDetalleVenta.add(detalleVenta);
        }
        
        for(int i=numeroFilas - 1; i>=0; i--){
                    modeloTablaProductos.removeRow(i);
        }    
        lblSuma.setText("0.0");
        
        if(!pagoCon.isEmpty()){
            JOptionPane.showMessageDialog(this, "<html> <h1 style='font-size:3em; color:#3a87fa;'>"+cambio+"</h1> </html>", "Ustede debe dar este cambio", 1);
            campoPagoCon.setText("");
        }
    }//GEN-LAST:event_botonRealizarVentaActionPerformed
    
    public void agregarProductoVenta(Producto producto){
        String clave = producto.getIdProducto();
        String nombre = producto.getNombreProducto();
        String precioVenta = String.valueOf(producto.getPrecioVentaProducto());
        String importe = String.valueOf(producto.getPrecioVentaProducto());
        
        String datosProducto[] = {clave,nombre,precioVenta,"1",importe};
        
        modeloTablaProductos.addRow(datosProducto);
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelarVenta;
    private javax.swing.JButton botonCorteDia;
    private javax.swing.JButton botonQuitarProducto;
    private javax.swing.JButton botonRealizarVenta;
    private javax.swing.JTextField campoBuscarProducto;
    private javax.swing.JTextField campoPagoCon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImagenProducto;
    private javax.swing.JLabel lblSuma;
    private javax.swing.JList<Producto> listaBusquedaProductos;
    private javax.swing.JTable tablaVentasProductos;
    // End of variables declaration//GEN-END:variables
}
