package controllers.application;

import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class Welcome extends BaseController {
    
    private static final Logger logger = Logger.getLogger(Welcome.class);
    
    @Autowired
    private HttpSession session;
    
    //==========================================================================
    @RequestMapping(value = {"/","/welcome","welcome"})
    public ModelAndView welcome(){
    
        ModelAndView mav = null;
        byte approved;
        
        try {
            
            mav = new ModelAndView("application/welcome");
            approved = (byte) session.getAttribute("approved");
            mav.addObject("approved", approved);
            
        } catch (Exception e) {
            logger.error("Welcome.welcome", e);
        }
        
        return mav;
    
    }
    
}