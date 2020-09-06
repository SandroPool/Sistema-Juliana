
package capa3_persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


import capa2_dominio.*;
import java.io.File;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author SANDRO
 */
public class BaseDatos {
    Connection connexion = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Statement statement = null;
    
    public BaseDatos(){
        try{
            Class.forName("org.postgresql.Driver");
            
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    
    public void insertarProducto(Producto producto){ 
        try {
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_sistema", "postgres", "password");
            File fileFoto = producto.getFotoProducto();
            FileInputStream filefoto = new FileInputStream(fileFoto);
            
            String sql = "INSERT INTO cat_productos (id_producto,nombre_producto,descripcion_producto,stock_producto,foto_producto,"
                + "unidad_producto,precio_compra_producto,precio_venta_producto,existencias_producto,id_categoria_producto,id_proveedor)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            
            ps = connexion.prepareStatement(sql);
            ps.setString(1, producto.getIdProducto());
            ps.setString(2, producto.getNombreProducto());
            ps.setString(3, producto.getDescripcionProducto());
            ps.setDouble(4, producto.getStockProducto());
            long sizeFoto = producto.getFotoProducto().length();
            ps.setBinaryStream(5, filefoto, (int)sizeFoto);
            ps.setString(6, producto.getUnidadProducto());
            ps.setDouble(7, producto.getPrecioCompraProducto());
            ps.setDouble(8, producto.getPrecioVentaProducto());
            ps.setDouble(9, producto.getExistenciasProducto());
            ps.setInt(10, producto.getIdCategoriaProducto());
            ps.setInt(11, producto.getIdProveedor());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }finally{
            try {
                
                connexion.close();
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    
    public void borrarProducto(Producto producto){
        try {
            connexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/db_sistema", "postgres", "password");
            String sql = "DELETE FROM cat_productos WHERE id_producto = ?";
            ps = connexion.prepareStatement(sql);
            ps.setString(1, producto.getIdProducto());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                connexion.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public void actualizarProductoExistencia(Producto producto, double cantidad){
        try {
            connexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/db_sistema", "postgres", "password");
            String sql = "UPDATE cat_productos SET existencias_producto = ? WHERE id_producto = ?";
            ps = connexion.prepareStatement(sql);
            ps.setDouble(1, cantidad);
            ps.setString(2, producto.getIdProducto());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                connexion.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void actualizarProducto(Producto producto, boolean cambiarFoto){
        try {
            connexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/db_sistema", "postgres", "password");
            
            if(cambiarFoto == true){
                File fileFoto = producto.getFotoProducto();
                FileInputStream inputStream = new FileInputStream(fileFoto);
                String sql = "UPDATE cat_productos SET descripcion_producto = ?, stock_producto = ?, foto_producto = ?,"
                        +" unidad_producto = ?, precio_compra_producto=?,precio_venta_producto=?,"
                        +" id_categoria_producto=?, id_proveedor=?"
                        + " WHERE id_producto = ?";
                ps = connexion.prepareStatement(sql);
                
                ps.setString(1, producto.getDescripcionProducto());
                ps.setDouble(2, producto.getStockProducto());
                long tamanoFoto = fileFoto.length();
                ps.setBinaryStream(3, inputStream, tamanoFoto);
                ps.setString(4, producto.getUnidadProducto());
                ps.setDouble(5, producto.getPrecioCompraProducto());
                ps.setDouble(6, producto.getPrecioVentaProducto());
                ps.setInt(7, producto.getIdCategoriaProducto());
                ps.setInt(8, producto.getIdProveedor());
                ps.setString(9, producto.getIdProducto());
                
            }else{
                String sql = "UPDATE cat_productos SET descripcion_producto = ?, stock_producto = ?,"
                        +" unidad_producto = ?, precio_compra_producto=?,precio_venta_producto=?,"
                        +" id_categoria_producto=?, id_proveedor=?"
                        + " WHERE id_producto = ?";
                ps = connexion.prepareStatement(sql);
                
                ps.setString(1, producto.getDescripcionProducto());
                ps.setDouble(2, producto.getStockProducto());
                ps.setString(3, producto.getUnidadProducto());
                ps.setDouble(4, producto.getPrecioCompraProducto());
                ps.setDouble(5, producto.getPrecioVentaProducto());
                ps.setInt(6, producto.getIdCategoriaProducto());
                ps.setInt(7, producto.getIdProveedor());
                ps.setString(8, producto.getIdProducto());
            }
            ps.executeUpdate();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }catch(FileNotFoundException exception){
            exception.printStackTrace();
        }finally{
            try {
                connexion.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public InputStream buscarFoto(Producto producto){
        InputStream streamFoto  = null;
        try {
            connexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/db_sistema", "postgres", "password");
            String sql = "SELECT foto_producto FROM cat_productos WHERE id_producto = ?";
            ps = connexion.prepareStatement(sql);
            ps.setString(1, producto.getIdProducto());
            
            rs  = ps.executeQuery();
            while(rs.next()){
               streamFoto = rs.getBinaryStream("foto_producto");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                connexion.close();
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return streamFoto;
    }
    
    public ArrayList<Venta> cantidadVentas(){
        ArrayList<Venta> listaVentas = new ArrayList<Venta>();
        try {
            
            connexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/db_sistema", "postgres", "password");
            String sql = "SELECT COUNT(monto_venta) as cantidad_venta FROM ventas ";
            ps = connexion.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                double cantidadVenta = rs.getDouble("cantidad_venta");
                
                Venta venta = new Venta(cantidadVenta);
                listaVentas.add(venta);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                connexion.close();;
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return listaVentas;
    }
    
    public ArrayList<Venta> montoTotalVenta(){
        ArrayList<Venta> listaMontoTotal = new ArrayList<Venta>();
        
        try {
            connexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/db_sistema", "postgres", "password");
            String sql = "select SUM(v.monto_venta) as TotalVendido from ventas v";
            ps = connexion.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                double montoTotalVenta = rs.getDouble("TotalVendido");
                
                Venta venta = new Venta(montoTotalVenta);
                listaMontoTotal.add(venta);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                connexion.close();
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaMontoTotal;
    }
    
    public void insertCategoria(Categoria categoria){
        try {
            connexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/db_sistema", "postgres", "password");
            String sql = "INSERT INTO cat_categorias (nombre_categoria_prod,descripcion_categoria_prod) VALUES (?,?)";
            ps = connexion.prepareStatement(sql);
            ps.setString(1, categoria.getNombreCategoriaProducto());
            ps.setString(2, categoria.getDescripcionCategoriaProducto());
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
            ps.close();
            connexion.close();                
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    public void insertarProveedor(Proveedor proveedor){
        try {
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_sistema", "postgres", "password");
            String sql = "INSERT INTO cat_proveedores (nombre_proveedor,direccion_proveedor,telefono_proveedor,email_proveedor,contacto_proveedor)\n" 
                        +"VALUES(?,?,?,?,?)";
            ps = connexion.prepareStatement(sql);
            ps.setString(1, proveedor.getNombreProveedor());
            ps.setString(2, proveedor.getDireccionProveedor());
            ps.setString(3, proveedor.getTelefonoProveedor());
            ps.setString(4, proveedor.getEmailProveedor());
            ps.setString(5, proveedor.getContactoProveedor());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                connexion.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public Long insertarVenta(Venta venta){
        Long lastVal = 0l;
        try {
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_sistema", "postgres", "password");
            String sql = "INSERT INTO ventas (monto_venta,fecha_venta) VALUES (?,?)";
            ps = connexion.prepareStatement(sql);
            ps.setDouble(1, venta.getMontoVenta());
            ps.setDate(2, venta.getFechaVenta());
            ps.executeUpdate();
            ps.close();
            
            ps = this.connexion.prepareStatement("SELECT lastval()");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                lastVal = rs.getLong("lastval");
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                connexion.close();
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lastVal;
    }
    
    public void insertarDetalleVenta(DetalleVenta detalleVenta){
        try {
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_sistema", "postgres", "password");
            String sql = new String("INSERT INTO detalle_venta (id_venta,id_producto,catidad_vendida)VALUES(?,?,?)");
            ps = connexion.prepareStatement(sql);
            ps.setLong(1, detalleVenta.getIdVenta());
            ps.setString(2, detalleVenta.getIdProducto());
            ps.setDouble(3, detalleVenta.getCatidadVendida());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                connexion.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public ArrayList<Producto> obtenerProducto(){
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
         try {
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_sistema", "postgres", "password");
            String sql = new String("SELECT * FROM cat_productos ORDER BY nombre_producto");
            ps = connexion.prepareStatement(sql);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                String idProducto = rs.getString("id_producto");
                String nombre = rs.getString("nombre_producto");
                String descripcion = rs.getString("descripcion_producto");
                double stock = rs.getDouble("stock_producto");
                String unidad = rs.getString("unidad_producto");
                double precioCompra = rs.getDouble("precio_compra_producto");
                double precioVenta = rs.getDouble("precio_venta_producto");
                double existencia = rs.getDouble("existencias_producto");
                int idCategoria = rs.getInt("id_categoria_producto");
                int idProveedor = rs.getInt("id_proveedor");
                
                Producto producto = new Producto(idProducto, nombre, descripcion, stock, null, unidad, precioCompra, precioVenta, existencia, idCategoria, idProveedor);
                listaProductos.add(producto);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                connexion.close();
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         return listaProductos;
    }
    
    public ArrayList<Producto> obtenerProductosPorCriterio(String criterio){
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        
        try {
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_sistema", "postgres", "password");
            String sql = "SELECT* FROM cat_productos WHERE id_producto ILIKE '"+criterio+"%' OR nombre_producto ILIKE '%"+criterio+"%' ORDER BY nombre_producto";
            ps = connexion.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                String idProducto = rs.getString("id_producto");
                String nombre = rs.getString("nombre_producto");
                String descripcion = rs.getString("descripcion_producto");
                double stock = rs.getDouble("stock_producto");
                String unidad = rs.getString("unidad_producto");
                double precioCompra = rs.getDouble("precio_compra_producto");
                double precioVenta = rs.getDouble("precio_venta_producto");
                double existencia = rs.getDouble("existencias_producto");
                int idCategoria = rs.getInt("id_categoria_producto");
                int idProveedor = rs.getInt("id_proveedor");
                Producto producto = new Producto(idProducto, nombre, descripcion, stock, null, unidad, precioCompra, precioVenta, existencia, idCategoria, idProveedor);
                listaProductos.add(producto);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                connexion.close();
                 ps.close();
                 rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return listaProductos;
    }
    
    public ArrayList<Categoria> obtenerCategoria(){
        ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
        try {
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_sistema", "postgres", "password");
            String sql = new String("SELECT * FROM cat_categorias");
            ps = connexion.prepareStatement(sql);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                int idCategoria = rs.getInt("id_categoria_prod");
                String nombreCategoria = rs.getString("nombre_categoria_prod");
                String descripcionCategoria = rs.getString("descripcion_categoria_prod");
                
                Categoria categoria = new Categoria(idCategoria, nombreCategoria, descripcionCategoria);
                listaCategorias.add(categoria);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                connexion.close();
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return listaCategorias;
    }
    
    public ArrayList<Proveedor> obtenerProveedor(){
        ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
        try{
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_sistema", "postgres", "password");
            String sql = "SELECT * FROM cat_proveedores";
            ps = connexion.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int idProveedor = rs.getInt("id_proveedor");
                String nombreProveedor = rs.getString("nombre_proveedor");
                String direccionProveedor = rs.getString("direccion_proveedor");
                String telefonoProveedor = rs.getString("telefono_proveedor");
                String emailProveedor = rs.getString("email_proveedor");
                String contactoProveedor = rs.getString("contacto_proveedor");
                
                Proveedor proveedor = new Proveedor(idProveedor, nombreProveedor, direccionProveedor, telefonoProveedor, emailProveedor, contactoProveedor);
                
                listaProveedores.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                connexion.close();
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaProveedores;
    }
    
    public ArrayList<Venta> obtenerVenta(){
        ArrayList<Venta> listaVentas = new ArrayList<Venta>();
        
        try {
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_sistema", "postgres", "password");
            String sql = "SELECT * FROM ventas";
            ps = connexion.prepareStatement(sql);
            
            rs=ps.executeQuery();
            
            while (rs.next()) {                
                int idVenta = rs.getInt("id_venta");
                double montoVenta = rs.getDouble("monto_venta");
                Date fechaVenta = rs.getDate("fecha_venta");
                
                Venta venta = new Venta(idVenta, montoVenta, fechaVenta);
                listaVentas.add(venta);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }finally{
            try {
                connexion.close();
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return listaVentas;
    }
    
    public ArrayList<DetalleVenta> obtenerDetalledeVenta(){
        ArrayList<DetalleVenta> listaDetalleVentas = new ArrayList<DetalleVenta>();
        
        try {
            connexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/db_sistema", "postgres", "password");
            String sql = "SELECT * FROM detalle_venta";
            ps = connexion.prepareCall(sql);
            
            rs = ps.executeQuery();
            while (rs.next()) { 
                int idDetalleVenta = rs.getInt("id_detalle_venta");
                Long idVenta = rs.getLong("id_venta");
                String idProducto = rs.getString("id_producto");
                double catidadVendida = rs.getDouble("catidad_vendida");
                
                DetalleVenta detalleVenta = new DetalleVenta(idDetalleVenta,idVenta,idProducto,catidadVendida);
                
                listaDetalleVentas.add(detalleVenta);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                connexion.close();
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }        
        
        return listaDetalleVentas;
    }
    
   /* public static void main(String[] args) {
        ArrayList<Venta> listVentas = new ArrayList<Venta>();
        BaseDatos baseDatos = new BaseDatos();
        listVentas = baseDatos.totalVentas();
        listVentas.forEach(vental->{
            System.out.println(Math.round(vental.getMontoVenta()));
        });
    }*/
    
}

