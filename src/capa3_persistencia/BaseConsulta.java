
package capa3_persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import capa2_dominio.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author SANDRO
 */
public class BaseConsulta {
    Connection connexion = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public BaseConsulta(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        } 
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
}
