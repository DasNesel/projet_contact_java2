package bdd.Entities;

import java.time.LocalDate;
import java.util.Date;

public class Contact {

    private Integer id;
    private String firstname;
    private String lastname;
    private String nickname;
    private String phoneFix;
    private String phoneMobil;
    //private String fax;
    private LocalDate birthday;
    private String mail;
    //private String society;
    //private String postCode;
    //private String region;
    private String website;
    private String adress;
    private String city;
    private String country;
    //private String streetName;
    //private Integer streetNumber;
    //private String gender;
    //private String streetType;

    //CONSTRUCTOR

    public Contact(Integer id, String firstname, String lastname, String nickname, String phoneFix, String phoneMobil, LocalDate birthday, String mail, String website, String adress, String city, String country) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.phoneFix = phoneFix;
        this.phoneMobil = phoneMobil;
        this.birthday = birthday;
        this.mail = mail;
        this.website = website;
        this.adress = adress;
        this.city = city;
        this.country = country;
    }



    /*public Contact(Integer id, String name, String surname, String nickname, String phoneFix, String phoneMobil, String fax, Date birthday, String mail, String society, String city, String postCode, String country, String region, String website, String streetName, Integer streetNumber, String gender, String streetType) {
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
    }*/


    //GETTERS

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getMail() {
        return mail;
    }

    public String getWebsite() {
        return website;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
//SETTERS


    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
