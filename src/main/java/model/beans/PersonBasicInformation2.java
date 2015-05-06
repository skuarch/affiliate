package model.beans;

import java.io.Serializable;

/**
 * basic version of Freelancer.
 *
 * @author skuarch
 */
public class PersonBasicInformation2 implements Serializable {

    private long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String lastLogin;
    private String gender;
    private String type;
    private String registrationDate;
    private long personId;
    private boolean isPartner;
    private boolean isAffiliate;

    public PersonBasicInformation2() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public boolean isIsPartner() {
        return isPartner;
    }

    public void setIsPartner(boolean isPartner) {
        this.isPartner = isPartner;
    }

    public boolean isIsAffiliate() {
        return isAffiliate;
    }

    public void setIsAffiliate(boolean isAffiliate) {
        this.isAffiliate = isAffiliate;
    }

    
}
