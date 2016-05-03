/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BBDDMapper;

import Entidades.Restaurante;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Dani
 */
public class RestauranteMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Restaurante rest = new Restaurante();
        rest.setIdRestaurante(rs.getInt("idRestaurante"));
        rest.setNombre(rs.getString("nombre"));
        rest.setEmail(rs.getString("email"));
        rest.setDireccion(rs.getString("direccion"));
        rest.setTelefono(rs.getString("telefono"));
        rest.setLatitud(rs.getString("latitud"));
        rest.setLongitud(rs.getString("longitud"));
        rest.setUsername(rs.getString("username"));
        rest.setWeb(rs.getString("web"));
        
        return rest;
    }
    
}
