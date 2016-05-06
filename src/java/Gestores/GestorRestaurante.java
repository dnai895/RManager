/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import BBDDMapper.Int_StringMapper;
import BBDDMapper.ProductoMapper;
import BBDDMapper.RestauranteMapper;
import Entidades.Int_String;
import Entidades.Producto;
import Entidades.Restaurante;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import utilidades.General;

/**
 *
 * @author Dani
 */
@Component
public class GestorRestaurante {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public Restaurante getRestaurante(String username) {
        List<Restaurante> lrest = null;
        try {
            String query = "SELECT idRestaurante, nombre, direccion, telefono, latitud, longitud, "
                    + "username, web, email "
                    + "FROM restaurante "
                    + "WHERE username = ? "
                    + "LIMIT 1";
            lrest = jdbcTemplate.query(query, new RestauranteMapper(), new Object[]{username});
        } catch(Exception e) {
            General.log("GestorRestaurante", "ERROR en getRestaurante: "+e.getMessage());
        }
        if(lrest != null && lrest.size() > 0 && lrest.get(0) != null && lrest.get(0).getUsername().equals(username)) {
            return lrest.get(0);
        } else {
            return new Restaurante();
        }
    }
   
    public List<Producto> getProductos(int idRestaurante, int idTipoPlato) {
        List<Producto> lproductos = null;
        try {
            String query = "SELECT idRestaurante, idProducto, p.nombre as nombreProducto, precio, descripcion, tp.idTipoProducto,"
                    + "tp.nombre as nombreTipoProducto "
                    + "FROM PRODUCTO p "
                    + "LEFT JOIN TIPO_PRODUCTO tp ON tp.tipoProducto = p.tipoProducto "
                    + "WHERE idRestaurante = ? AND tp.idTipoProducto = ? AND visible = 1";
            lproductos = jdbcTemplate.query(query, new ProductoMapper(), new Object[]{idRestaurante, idTipoPlato});
        } catch(Exception e) {
            General.log("GestorRestaurante", "ERROR en getProductos: "+e.getMessage());
        } 
        return lproductos;
    }
    
    public Producto getProducto(int idProducto) {
        List<Producto> lproductos = null;
        try {
            String query = "SELECT idRestaurante, idProducto, p.nombre as nombreProducto, precio, descripcion, tp.idTipoProducto,"
                    + "tp.nombre as nombreTipoProducto "
                    + "FROM PRODUCTO p "
                    + "LEFT JOIN TIPO_PRODUCTO tp ON tp.tipoProducto = p.tipoProducto "
                    + "WHERE idProducto = ? AND visible = 1 "
                    + "LIMIT 1";
            lproductos = jdbcTemplate.query(query, new ProductoMapper(), new Object[]{idProducto});
        } catch(Exception e) {
            General.log("GestorRestaurante", "ERROR en getProducto: "+e.getMessage());
        } 
        if(lproductos != null && lproductos.size() > 0 && lproductos.get(0) != null) {
            return lproductos.get(0);
        } else {
            return new Producto();
        }
    }
    
    public List<Int_String> getTipoProductos() {
        List<Int_String> ltipoProductos = null;
        try {
            String query = "SELECT  tp.idTipoProducto,"
                    + "tp.nombre as nombreTipoProducto "
                    + "FROM TIPO_PRODUCTO tp ";
            ltipoProductos = jdbcTemplate.query(query, new Int_StringMapper(), new Object[]{});
        } catch(Exception e) {
            General.log("GestorRestaurante", "ERROR en getTipoProductos: "+e.getMessage());
        } 
        return ltipoProductos;
    }
    
    public void insertaProducto(Producto producto) {
        try {
            String query = "INSERT INTO PRODUCTO (idRestaurante, nombre, precio, descripcion, idTipoProducto) "
                            + "VALUES (?,?,?,?,?)";
            jdbcTemplate.update(query, new Object[]{producto.getIdRestaurante(), producto.getNombre(), producto.getPrecio(), 
                                                    producto.getDescripcion(), producto.getIdTipoProducto()});
        } catch(Exception e) {
            General.log("GestorUsuarios", "ERROR en registraUsuario: "+e.getMessage());
        }
    }
    
    public void modificaProducto(Producto producto) {
        try {
            String query = "UPDATE PRODUCTO SET nombre = ?, precio = ?, descripcion = ?, idTipoProducto = ? "
                    + "WHERE idProducto = ? ";
            jdbcTemplate.update(query, new Object[]{producto.getNombre(), producto.getPrecio(), 
                            producto.getDescripcion(), producto.getIdTipoProducto(), producto.getIdProducto()});
        } catch(Exception e) {
            General.log("GestorUsuarios", "ERROR en registraUsuario: "+e.getMessage());
        }
    }
    
    public void escondeProducto(int idProducto) {
        try {
            String query = "UPDATE PRODUCTO SET visible = 0 "
                    + "WHERE idProducto = ? ";
            jdbcTemplate.update(query, new Object[]{idProducto});
        } catch(Exception e) {
            General.log("GestorUsuarios", "ERROR en registraUsuario: "+e.getMessage());
        }
    }
}
