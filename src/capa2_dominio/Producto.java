
package capa2_dominio;

import java.io.File;

/**
 *
 * @author SANDRO
 */
public class Producto {
   private String idProducto;
   private String nombreProducto;
   private String descripcionProducto;
   private double stockProducto;
   private File fotoProducto;
   private String unidadProducto;
   private double precioCompraProducto;
   private double precioVentaProducto;
   private double existenciasProducto;
   private int idCategoriaProducto;
   private int idProveedor;

    public Producto(String idProducto, String nombreProducto, String descripcionProducto, double stockProducto, File fotoProducto, String unidadProducto, double precioCompraProducto, double precioVentaProducto, double existenciasProducto, int idCategoriaProducto,int idProveedor) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.stockProducto = stockProducto;
        this.fotoProducto = fotoProducto;
        this.unidadProducto = unidadProducto;
        this.precioCompraProducto = precioCompraProducto;
        this.precioVentaProducto = precioVentaProducto;
        this.existenciasProducto = existenciasProducto;
        this.idCategoriaProducto = idCategoriaProducto;
        this.idProveedor = idProveedor;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public double getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(double stockProducto) {
        this.stockProducto = stockProducto;
    }

    public File getFotoProducto() {
        return fotoProducto;
    }

    public void setFotoProducto(File fotoProducto) {
        this.fotoProducto = fotoProducto;
    }

    public String getUnidadProducto() {
        return unidadProducto;
    }

    public void setUnidadProducto(String unidadProducto) {
        this.unidadProducto = unidadProducto;
    }

    public double getPrecioCompraProducto() {
        return precioCompraProducto;
    }

    public void setPrecioCompraProducto(double precioCompraProducto) {
        this.precioCompraProducto = precioCompraProducto;
    }

    public double getPrecioVentaProducto() {
        return precioVentaProducto;
    }

    public void setPrecioVentaProducto(double precioVentaProducto) {
        this.precioVentaProducto = precioVentaProducto;
    }

    public double getExistenciasProducto() {
        return existenciasProducto;
    }

    public void setExistenciasProducto(double existenciasProducto) {
        this.existenciasProducto = existenciasProducto;
    }

    public int getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(int idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    public String toString(){
        return this.nombreProducto;
    }
}
