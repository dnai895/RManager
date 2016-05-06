/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDDMapper;

import Entidades.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Dani
 */
public class ProductoMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Producto p = new Producto();
        p.setIdRestaurante(rs.getInt("idRestaurante"));
        p.setIdProducto(rs.getInt("idProducto"));
        p.setNombre(rs.getString("nombreProducto"));
        p.setDescripcion(rs.getString("descripcion"));
        p.setIdTipoProducto(rs.getInt("idTipoProducto"));
        p.setTipoProducto(rs.getString("nombreTipoProducto"));
        return p;
    }
    
}
