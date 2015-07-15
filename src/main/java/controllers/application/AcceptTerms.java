package controllers.application;

import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.beans.PersonBasicInformation;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.HandlerExceptionUtil;
import model.util.PersonBasicInformationUtil;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class AcceptTerms extends BaseController {
    
    private static final Logger logger = Logger.getLogger(AcceptTerms.class);
    
    @Autowired
    private MessageSource messageSource;
    
    //==========================================================================
    @RequestMapping(value = {"/acceptTerms", "acceptTerms"})
    public ModelAndView closeSession(HttpSession session, HttpServletResponse response, Model model, Locale locale) {
        
        ModelAndView mav = getModelAndViewJson();
        PersonBasicInformation personBasicInformation = null;
        String json;
        HashMap parameters;
        JSONObject jsono;
        boolean flag;
        String uri;
        
        try {
            
            setHeaderNoChache(response);
            
            personBasicInformation = PersonBasicInformationUtil.getPersonBasicInformation(session);
            
            parameters = new HashMap<>();
            parameters.put("id", personBasicInformation.getId());
            
            if(personBasicInformation.isIsAffiliate()){
                uri = Constants.URI_AFFILIATE_ACCEPT_TERMS;
            }else{
                uri = Constants.URI_COMPANY_ACCEPT_TERMS;
            }
            
            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    uri);
            jsono = new JSONObject(json);
            
            flag = (boolean) jsono.get("accept");
            
            if(flag == true){
                session.setAttribute("approved", 1);
            }
            
            mav.addObject("json", jsono);
            
        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }
        
        return mav;
        
    }
    
}
