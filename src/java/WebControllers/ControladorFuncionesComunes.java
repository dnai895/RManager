/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebControllers;

import Entidades.Restaurante;
import Gestores.GestorUsuarios;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;
import utilidades.Constantes;

/**
 *
 * @author Dani
 */
public class ControladorFuncionesComunes {
    
    @Autowired
    protected JdbcTemplate jdbcTemplate;
    
    @Autowired
    protected Restaurante restaurante;
    
    @Autowired
    protected GestorUsuarios gUsuarios;
    
    public void cargaContenidoComun(HttpServletRequest request, ModelAndView view) {
        view.addObject("contextpath", Constantes.CONTEXTPATH);
    }
    
    public String getParametroString(String parametro, HttpServletRequest request) {
        String param = "";
        if(request.getParameter(parametro) != null && !request.getParameter(parametro).isEmpty()) {
            param = request.getParameter(parametro);
        }
        return param;
    }
    
    public int getParametroInt(String parametro, HttpServletRequest request) {
        int param = 0;
        if(request.getParameter(parametro) != null && !request.getParameter(parametro).isEmpty()) {
            try {
                param = Integer.parseInt(request.getParameter(parametro));
            } catch (NumberFormatException e) {
                
            }
        }
        return param;
    }
}
