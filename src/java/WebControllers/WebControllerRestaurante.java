/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebControllers;

import Entidades.Int_String;
import Entidades.Producto;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import utilidades.Constantes;

/**
 *
 * @author Dani
 */
@Controller
@RequestMapping("/restaurante/*")
public class WebControllerRestaurante extends ControladorFuncionesComunes{
    
    @RequestMapping(value="home", method=RequestMethod.GET)
    public ModelAndView home( HttpServletRequest request ) {
        ModelAndView result = new ModelAndView("paginasRestaurante/home");
        cargaContenidoComun(request, result);
        return result;
    } 
    
    @RequestMapping(value="platos", method=RequestMethod.GET)
    public ModelAndView listadoPlatos( HttpServletRequest request ) {
        ModelAndView result = new ModelAndView("paginasRestaurante/listadoPlatos");
        cargaContenidoComun(request, result);
        if(restaurante.isLogado()) {
            List<Int_String> ltiposProducto = gRestaurante.getTipoProductos();
            List<Producto> lproductos = gRestaurante.getProductos(restaurante.getIdRestaurante(), Constantes.TIPO_PRODUCTO_COMIDA);
            result.addObject("lproductos", lproductos);
            result.addObject("ltiposProducto", ltiposProducto);
        }
        return result;
    } 
    
    @RequestMapping(value="plato", method=RequestMethod.GET)
    public ModelAndView viewPlato( HttpServletRequest request ) {
        ModelAndView result = new ModelAndView("paginasRestaurante/viewPlato");
        cargaContenidoComun(request, result);
        if(restaurante.isLogado()) {
            List<Int_String> ltiposProducto = gRestaurante.getTipoProductos();
            result.addObject("ltiposProducto", ltiposProducto);
        }
        return result;
    } 
    
    @RequestMapping(value="{idPlato}/plato", method=RequestMethod.GET)
    public ModelAndView editPlato(@PathVariable int idPlato, HttpServletRequest request ) {
        ModelAndView result = new ModelAndView("paginasRestaurante/viewPlato");
        cargaContenidoComun(request, result);
        if(restaurante.isLogado()) {
            List<Int_String> ltiposProducto = gRestaurante.getTipoProductos();
            Producto producto = gRestaurante.getProducto(idPlato);
            result.addObject("producto", producto);
            result.addObject("ltiposProducto", ltiposProducto);
        }
        return result;
    }
    
    @RequestMapping(value="{idPlato}/plato", method=RequestMethod.POST)
    public ModelAndView servicePlato(@PathVariable int idPlato, HttpServletRequest request ) {
        ModelAndView result = new ModelAndView("paginasRestaurante/viewPlato");
        cargaContenidoComun(request, result);
        
        if(restaurante.isLogado()) {
            int action = getParametroInt("action", request);
            switch(action) {
                case Constantes.INSERTAR_PRODUCTO:
                    Producto p1= getParametersProducto(request);
                    gRestaurante.insertaProducto(p1);
                    break;
                case Constantes.MODIFICAR_PRODUCTO:
                    Producto p2 = getParametersProducto(request);
                    gRestaurante.modificaProducto(p2);
                    break;
                case Constantes.ELIMINAR_PRODUCTO:
                    gRestaurante.escondeProducto(idPlato);
                    break;
            }
        }
        
        return result;
    }
    
    public Producto getParametersProducto(HttpServletRequest request) {
        Producto p = new Producto();
        p.setIdProducto(getParametroInt("idProducto", request));
        p.setNombre(getParametroString("nombre", request));
        p.setIdTipoProducto(getParametroInt("idTipoProducto", request));
        p.setPrecio(getParametroDouble("precio", request));
        p.setDescripcion(getParametroString("descripcion", request));
        return p;
    }
}
