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
@RequestMapping("/restaurant/*")
public class WebControllerRestaurante {
    
    @RequestMapping(value="list", method=RequestMethod.GET)
    public ModelAndView index( HttpServletRequest request ) {
        ModelAndView result = new ModelAndView("index");
        result.addObject("holaMundo", "Hola mundo, si señor");
        return result;
    } 
    
    @RequestMapping(value="home", method=RequestMethod.GET)
    public ModelAndView home( HttpServletRequest request ) {
        ModelAndView result = new ModelAndView("paginas/home");
        
        return result;
    } 
}
