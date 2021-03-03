package bdd.Entities;

import java.security.PrivateKey;
import java.util.Date;

public class Contact {

    private Integer id;
    private String name;
    private String surname;
    private String nickname;
    private String phoneFix;
    private String phoneMobil;
    private String fax;
    private Date birthday;
    private String mail;
    private String society;
    private String city;
    private String postCode;
    private String country;
    private String region;
    private String website;
    private String streetName;
    private Integer streetNumber;
    private String gender;
    private String streetType;

    //CONSTRUCTOR

    public Contact(Integer id, String name, String surname, String nickname, String phoneFix, String phoneMobil, String fax, Date birthday, String mail, String society, String city, String postCode, String country, String region, String website, String streetName, Integer streetNumber, String gender, String streetType) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.phoneFix = phoneFix;
        this.phoneMobil = phoneMobil;
        this.fax = fax;
        this.birthday = birthday;
        this.mail = mail;
        this.society = society;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
        this.region = region;
        this.website = website;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.gender = gender;
        this.streetType = streetType;
    }


    //GETTERS

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPhoneFix() {
        return phoneFix;
    }

    public String getPhoneMobil() {
        return phoneMobil;
    }

    public String getFax() {
        return fax;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getMail() {
        return mail;
    }

    public String getSociety() {
        return society;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getWebsite() {
        return website;
    }

    public String getStreetName() {
        return streetName;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getStreetType() {
        return streetType;
    }

    //SETTERS


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPhoneFix(String phoneFix) {
        this.phoneFix = phoneFix;
    }

    public void setPhoneMobil(String phoneMobil) {
        this.phoneMobil = phoneMobil;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }
}
