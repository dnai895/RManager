/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Entidades.Restaurante;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import utilidades.General;

/**
 *
 * @author Dani
 */
@Component
public class GestorUsuarios {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public boolean checkDataUsuario(Restaurante restaurante) {
        boolean resultado = true;
        if(!restaurante.getPassword().equals(restaurante.getCfpassword())) {
            resultado = false;
        }
        return resultado;
    }
    
    public void registraUsuario(Restaurante restaurante) {
        Calendar cal = new GregorianCalendar();
        String fecha = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH) + 1)+"-"+cal.get(Calendar.DAY_OF_MONTH);
        try {
            String query = "INSERT INTO restaurante (nombre, direccion, telefono, username, passwd, web, email, fecha) "
                            + "VALUES (?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(query, new Object[]{restaurante.getNombre(), restaurante.getDireccion(), restaurante.getTelefono(),
            restaurante.getUsername(), restaurante.getPassword(), restaurante.getWeb(), restaurante.getEmail(), fecha});
        } catch(Exception e) {
            General.log("GestorUsuarios", "ERROR en registraUsuario: "+e.getMessage());
        }
    }
}
