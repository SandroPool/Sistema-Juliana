
package capa2_dominio;

/**
 *
 * @author SANDRO
 */
public class DetalleVenta {
    
    private int idDetalleVenta;
    private Long idVenta;
    private String idProducto;
    private double catidadVendida;

    public DetalleVenta(int idDetalleVenta, Long idVenta, String idProducto, double catidadVendida) {
        this.idDetalleVenta = idDetalleVenta;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.catidadVendida = catidadVendida;
    }

    public DetalleVenta(Long idVenta, String idProducto, double catidadVendida) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.catidadVendida = catidadVendida;
    }
    

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public double getCatidadVendida() {
        return catidadVendida;
    }

    public void setCatidadVendida(double catidadVendida) {
        this.catidadVendida = catidadVendida;
    }
    
    
}
