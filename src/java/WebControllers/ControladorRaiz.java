/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebControllers;

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
@RequestMapping("/*")
public class ControladorRaiz extends ControladorFuncionesComunes {
        
    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView index( HttpServletRequest request ) {
        ModelAndView result = new ModelAndView("paginas/landing");        
    /*    ModelAndView result = new ModelAndView("index");
        restaurante.setIdRestaurante(1);
        restaurante.setNombre("JFD");
        result.addObject("holaMundo", "Hola mundo, si señor");*/
        return result;
    } 
    
    @RequestMapping(value="landing", method=RequestMethod.GET)
    public ModelAndView landing( HttpServletRequest request ) {
        ModelAndView result = new ModelAndView("paginas/landing");
        return result;
    } 
    
}

//        try {
//            List<Int_String> list = jdbcTemplate.query("SELECT idRestaurante, nombre FROM RESTAURANTE", new Int_StringMapper(), new Object[]{});
//            for (Int_String col : list) {
//                System.out.println("- ("+col.getValor()+") "+col.getTexto());
//            }
//        } catch(Exception e) {
//            System.out.println("ERROR en index: "+e.getMessage());
//        }