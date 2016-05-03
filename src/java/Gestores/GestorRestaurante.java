/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import BBDDMapper.RestauranteMapper;
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
    
}
