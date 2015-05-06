package model.util;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import model.beans.PersonBasicInformation;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 *
 * @author skuarch
 */
public class PersonBasicInformationUtil {

    //==========================================================================
    private PersonBasicInformationUtil() {
    }

    //==========================================================================
    public static void resetPersonBasicInformationSession(HttpSession session, PersonBasicInformation personBasicInformation) {

        try {
            if (session != null) {

                Object object = session.getAttribute("personBasicInformation");

                if (object != null) {
                    session.removeAttribute("personBasicInformation");
                    object = null;
                    session.setAttribute("personBasicInformation", personBasicInformation);
                }

            }
        } catch (Exception e) {
            throw e;
        }

    }

    //==========================================================================
    public static HashMap<String, Object> createHashMapFreelancer(PersonBasicInformation freelancer) {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags
            hm.put("id", freelancer.getId());
            hm.put("person.email", StringEscapeUtils.escapeHtml4(String.valueOf(freelancer.getEmail())));
            hm.put("person.name", StringEscapeUtils.escapeHtml4(String.valueOf(freelancer.getName())));
            hm.put("person.lastName", StringEscapeUtils.escapeHtml4(String.valueOf(freelancer.getLastName())));
            hm.put("person.phone", StringEscapeUtils.escapeHtml4(String.valueOf(freelancer.getPhone())));
            hm.put("person.gender.id", freelancer.getGender());
            hm.put("address.all", StringEscapeUtils.escapeHtml4(String.valueOf(freelancer.getAddressAll())));
            hm.put("address.zipCode", freelancer.getZipCode());
            hm.put("address.country", StringEscapeUtils.escapeHtml4(String.valueOf(freelancer.getCountry())));
            hm.put("address.city", StringEscapeUtils.escapeHtml4(String.valueOf(freelancer.getCity())));
            hm.put("address.state", StringEscapeUtils.escapeHtml4(String.valueOf(freelancer.getState())));

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }
    
    //==========================================================================
    public static HashMap<String, Object> createHashMapFreelancerUpdatePassword(String currentPassword, String newPassword, String newPassword2, long personId) {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags            
            hm.put("currentPassword", StringEscapeUtils.escapeHtml4(currentPassword));
            hm.put("newPassword", StringEscapeUtils.escapeHtml4(newPassword));
            hm.put("newPassword2", StringEscapeUtils.escapeHtml4(newPassword2));
            hm.put("id", personId);

        } catch (Exception e) {
            throw e;
        }
        
        return hm;

    }
    
    //==========================================================================
    public static HashMap<String, Object> createHashMapGetAffiliatesbyCreator(long freelancerId) {

        HashMap hm = new HashMap();

        try {
            
            hm.put("creatorId", freelancerId);
            hm.put("other", "other");

        } catch (Exception e) {
            throw e;
        }
        
        return hm;

    }

    //==========================================================================
    public static PersonBasicInformation getPersonBasicInformation(HttpSession session) {
        PersonBasicInformation personBasicInformation = null;
        if (session != null) {
            personBasicInformation = (PersonBasicInformation) session.getAttribute("personBasicInformation");
        } else {
            throw new IllegalStateException("session is null");
        }
        return personBasicInformation;
    }

}
