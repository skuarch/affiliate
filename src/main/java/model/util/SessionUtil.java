package model.util;

import javax.servlet.http.HttpSession;
import model.beans.PersonBasicInformation;
import model.beans.User;

/**
 *
 * @author skuarch
 */
public class SessionUtil {

    private static final String PERSON_BASIC_INFORMATION_BEAN = "personBasicInformation";

    //==========================================================================
    private SessionUtil() {
    }

    //==========================================================================
    public static boolean isValidSession(HttpSession session) {

        if (session == null) {
            throw new IllegalArgumentException("session is null");
        }

        Object object = null;
        boolean isValid = false;

        try {

            object = session.getAttribute(PERSON_BASIC_INFORMATION_BEAN);
            isValid = object != null;

        } catch (Exception e) {
            throw e;
        }

        return isValid;

    }

    //==========================================================================
    public static PersonBasicInformation getPersonBasicInformation(HttpSession session) {

        if (session == null) {
            throw new IllegalArgumentException("session is null");
        }

        PersonBasicInformation personBasicInformation = null;

        try {

            personBasicInformation = (PersonBasicInformation) session.getAttribute(PERSON_BASIC_INFORMATION_BEAN);

        } catch (Exception e) {
            throw e;
        }

        return personBasicInformation;

    }

    //==========================================================================
    public static String getStringParameter(HttpSession session, String attibute) {

        String parameter = "0";
        Object object = null;

        try {

            if (isValidSession(session)) {

                object = session.getAttribute(attibute);

                if (object != null) {
                    parameter = (String) session.getAttribute(attibute);
                }

            }

        } catch (Exception e) {
            throw e;
        }

        return parameter;

    }

    //==========================================================================
    public static short getShortParameter(HttpSession session, String attribute) throws Exception {

        short parameter = 0;
        Object object = null;

        try {

            if (isValidSession(session)) {

                object = session.getAttribute(attribute);

                if (object != null) {
                    parameter = Short.parseShort(object.toString());
                } else {
                    throw new Exception("attribute " + attribute + " doesn't exists");
                }

            }

        } catch (Exception e) {
            throw e;
        }

        return parameter;

    }

    //==========================================================================
    public static long getLongParameter(HttpSession session, String attribute) throws Exception {

        long parameter = 0;
        Object object = null;

        try {

            if (isValidSession(session)) {

                object = session.getAttribute(attribute);
                
                if (object != null) {                    
                    parameter = Long.parseLong(object.toString());
                } else {
                    throw new Exception("attribute " + attribute + " doesn't exists");
                }

            }

        } catch (Exception e) {
            throw e;
        }

        return parameter;

    }

    //==========================================================================
    public static void cleanAttributeSession(HttpSession session, String attibute) {
        session.removeAttribute(attibute);
    }

    //==========================================================================
    public static User getUser(HttpSession session) {

        if (session == null) {
            throw new IllegalArgumentException("session is null");
        }

        User user = null;

        try {

            user = (User) session.getAttribute("user");

        } catch (Exception e) {
            throw e;
        }

        return user;

    }
    
    //==========================================================================
    public static void setAttribute(HttpSession session, String name, String value){
        
        if (session == null) {
            throw new IllegalArgumentException("session is null");
        }
        
        if (name == null || name.length() < 1) {
            throw new IllegalArgumentException("name is null");
        }
        
        if (value == null || value.length() < 1) {
            throw new IllegalArgumentException("value is null");
        }
        
        try {
        
            session.setAttribute(name, value);
            
        } catch (Exception e) {
            throw e;
        }
        
    }

}
