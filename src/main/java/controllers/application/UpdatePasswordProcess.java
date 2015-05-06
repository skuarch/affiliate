package controllers.application;

import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.beans.PersonBasicInformation;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.PersonBasicInformationUtil;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch
 */
@Controller
public class UpdatePasswordProcess extends BaseController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;
    private static final Logger logger = Logger.getLogger(UpdatePasswordProcess.class);

    //==========================================================================
    @RequestMapping(value = {"/updatePasswordProcess", "updatePasswordProcess"}, method = RequestMethod.POST)
    public ModelAndView updatePassword(@RequestParam String currentPassword, @RequestParam String newPassword, @RequestParam String newPassword2, HttpServletResponse response, Locale locale) {

        ModelAndView mav = new ModelAndView("application/json");
        HashMap<String, Object> parameters = null;
        String json = null;
        JSONObject jsono = null;
        PersonBasicInformation personBasicInformation = null;
        String uri;

        try {

            setHeaderNoChache(response);

            personBasicInformation = PersonBasicInformationUtil.getPersonBasicInformation(session);
            parameters = PersonBasicInformationUtil.createHashMapFreelancerUpdatePassword(currentPassword,
                    newPassword,
                    newPassword2,
                    personBasicInformation.getId());

            if (personBasicInformation.getPersonType() == Constants.PERSON_TYPE_AFFILIATE) {
                //change password to affiliate
                uri = Constants.URI_AFFILIATE_UPDATE_PASSWORD;
            } else {
                //change password to partner
                uri = Constants.URI_PARTNER_UPDATE_PASSWORD;
            }

            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    uri);
            jsono = new JSONObject(json);
            mav.addObject("json", jsono);

        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }

        return mav;
    }

}
