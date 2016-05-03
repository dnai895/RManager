/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebControllers;

import Entidades.Restaurante;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dani
 */
@Controller
@RequestMapping("/usuarios/*")
public class WebControllerUsuarios extends ControladorFuncionesComunes {
    
    @RequestMapping(value="registro", method=RequestMethod.GET)
    public ModelAndView viewRegistro( HttpServletRequest request ) {
        ModelAndView result = new ModelAndView("registro");
        cargaContenidoComun(request, result);

        return result;
    } 
    
    @RequestMapping(value="registro", method=RequestMethod.POST)
    public ModelAndView serviceRegistro( HttpServletRequest request ) {
        ModelAndView result = new ModelAndView("registro");
        cargaContenidoComun(request, result);
        
        String nombre       = getParametroString("nombre", request);
        String direccion    = getParametroString("direccion", request);
        String telefono     = getParametroString("telefono", request);
        String email        = getParametroString("email", request);
        String username     = getParametroString("username", request);
        String web          = getParametroString("web", request);
        String password     = getParametroString("password", request);
        String cfpassword   = getParametroString("cfpassword", request);
        
        Restaurante restaurante = new Restaurante();
        restaurante.setNombre(nombre);
        restaurante.setDireccion(direccion);
        restaurante.setTelefono(telefono);
        restaurante.setUsername(username);
        restaurante.setWeb(web);
        restaurante.setEmail(email);
        restaurante.setPassword(password);
        restaurante.setCfpassword(cfpassword);
        
        if(gUsuarios.checkDataUsuario(restaurante)) {
            gUsuarios.registraUsuario(restaurante);
        }
        
        return result;
    } 
}
