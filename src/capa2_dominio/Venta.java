
package capa2_dominio;

import java.sql.Date;

/**
 *
 * @author SANDRO
 */
public class Venta {
    private int idVenta;
    private double montoVenta;
    private Date fechaVenta;
    
    public Venta(int idVenta, double montoVenta, Date fechaVenta){
        this.idVenta = idVenta;
        this.montoVenta = montoVenta;
        this.fechaVenta = fechaVenta;
    }

    public Venta(double montoVenta, Date fechaVenta) {
        this.montoVenta = montoVenta;
        this.fechaVenta = fechaVenta;
    }

    public Venta(double montoVenta) {
        this.montoVenta = montoVenta;
    }
    
    
    
    public int getIdVenta(){
        return idVenta;
    }
    
    public void setIdVenta(int idVenta){
        this.idVenta = idVenta;
    }

    public double getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(double montoVenta) {
        this.montoVenta = montoVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    
}
