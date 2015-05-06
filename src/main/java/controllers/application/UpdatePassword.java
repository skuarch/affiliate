package controllers.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class UpdatePassword extends BaseController {
    
    //==========================================================================
    @RequestMapping(value = {"/updatePassword", "updatePassword"})
     public ModelAndView updatePassword(){
     
         ModelAndView mav = new ModelAndView("application/updatePassword");
         return mav;
         
     }
    
}
