package interceptors;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.logic.Approved;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
public class PrivacyPolitics implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(PrivacyPolitics.class);

    //==========================================================================
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        return true;
    }

    //==========================================================================
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView mav) throws Exception {

        try {

            if (mav == null) {
                mav = new ModelAndView("application/systemWelcome");
            }
            
            String url = request.getRequestURL().toString();
            HashMap<String, String> urls = Approved.getUrls();
            String baseName = FilenameUtils.getBaseName(url);
            
            if (baseName.equalsIgnoreCase("")) {
                return;
            }

            if (urls.containsKey(baseName)) {
                return;
            }
            
            Integer approved = (Integer) request.getSession().getAttribute("approved");
            
            if (approved == 0) {
                mav.setViewName("application/acceptPrivacyPolitic");             
            }

        } catch (Exception e) {
            logger.error("PrivacyPoliticsInterceptor", e);
        }

    }

    //==========================================================================
    @Override
    public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn) throws Exception {
        //System.out.println("afterCompletation");
    }

} // end class
