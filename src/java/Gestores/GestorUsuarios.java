/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import BBDDMapper.Int_StringMapper;
import Entidades.Int_String;
import Entidades.Restaurante;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class GestorUsuarios {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private GestorHash gHash;
    
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
            restaurante.getUsername(), gHash.md5(restaurante.getPassword()), restaurante.getWeb(), restaurante.getEmail(), fecha});
        } catch(Exception e) {
            General.log("GestorUsuarios", "ERROR en registraUsuario: "+e.getMessage());
        }
    }
    
    public boolean login(String username, String password) {
        boolean logado = false;
        List<Int_String> lista = null;
        try {
            String query = "SELECT idRestaurante, username "
                    + "FROM restaurante "
                    + "WHERE username = ? AND passwd = ? "
                    + "LIMIT 1";
            lista = jdbcTemplate.query(query, new Int_StringMapper(), new Object[]{username, gHash.md5(password)});
            if(lista != null && lista.size() == 1 &&lista.get(0) != null) {
                if(username.equals(lista.get(0).getTexto())) {
                    logado = true;
                }
            }
        } catch(Exception e) {
            General.log("GestorUsuarios", "ERROR en login: "+e.getMessage());
        }
        return logado;
    }
}
