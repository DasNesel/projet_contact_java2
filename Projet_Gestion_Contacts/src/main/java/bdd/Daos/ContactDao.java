package bdd.Daos;

import bdd.Entities.Contact;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContactDao {

    public List<Contact> listContacts() {
        /*
         * Function use to get the list of the contacts
         * Return : List<Contact> with all the contact in the database
         */
        List<Contact> list = new ArrayList<>();
        DataSource db = DataSourceFactory.getDataSource();
        try(Connection connection = db.getConnection()) { // connection to the database
            String sqlQuery = "SELECT * FROM contact"; // requete SQL
            try(PreparedStatement statement = connection.prepareStatement(sqlQuery)){
                try(ResultSet resultSet = statement.executeQuery()){ //Recupere le resultat de la requete SQL
                    while(resultSet.next()){
                        LocalDate birth = resultSet.getDate("birth_date").toLocalDate();
                        int id = resultSet.getInt("id");
                        String firstname = resultSet.getString("firstname");
                        String lastname = resultSet.getString("lastname");
                        String nickname = resultSet.getString("nickname");
                        String phoneFix = resultSet.getString("phone_number_fix");
                        String phoneMobil = resultSet.getString("phone_number_mobil");
                        String mail = resultSet.getString("email_address");
                        String address = resultSet.getString("address");
                        String website = resultSet.getString("website_address");
                        Contact contact = new Contact(id, firstname, lastname, nickname, phoneFix, phoneMobil, birth, mail, website, address);
                        list.add(contact);
                    }
                    resultSet.close();
                }
                statement.close();
            }
            connection.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public void addContact(Contact contact) {
        /*
         * Function that permit to add a contact to the database
         */
        DataSource db = DataSourceFactory.getDataSource();
        try (Connection connection = db.getConnection()) {
            String sqlQuery = "INSERT INTO contact(lastname,firstname,nickname,phone_number_fix,phone_number_mobil,address,email_address,website_address,birth_date) " +
                    "VALUES(?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, contact.getLastname());
                statement.setString(2, contact.getFirstname());
                statement.setString(3, contact.getNickname());
                statement.setString(4, contact.getPhoneFix());
                statement.setString(5, contact.getPhoneMobil());
                statement.setString(6, contact.getAdress());
                statement.setString(7, contact.getMail());
                statement.setString(8, contact.getWebsite());
                statement.setDate(9, java.sql.Date.valueOf(contact.getBirthday()));

                statement.executeUpdate();
                statement.close();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Contact> getContactsByLastname(String searchName) {
        /*
         * Function use to get the list of the contacts
         * Return : List<Contact> with all the contact in the database
         */
        List<Contact> list = new ArrayList<>();
        DataSource db = DataSourceFactory.getDataSource();
        try(Connection connection = db.getConnection()) { // connection to the database
            String sqlQuery = "SELECT * FROM contact WHERE lastname = ? "; // requete SQL
            try(PreparedStatement statement = connection.prepareStatement(sqlQuery)){
                statement.setString(1, searchName.toUpperCase());
                try(ResultSet resultSet = statement.executeQuery()){ //Recupere le resultat de la requete SQL
                    while(resultSet.next()){
                        LocalDate birth = resultSet.getDate("birth_date").toLocalDate();
                        int id = resultSet.getInt("id");
                        String firstname = resultSet.getString("firstname");
                        String lastname = resultSet.getString("lastname");
                        String nickname = resultSet.getString("nickname");
                        String phoneFix = resultSet.getString("phone_number_fix");
                        String phoneMobil = resultSet.getString("phone_number_mobil");
                        String mail = resultSet.getString("email_address");
                        String address = resultSet.getString("address");
                        String website = resultSet.getString("website_address");
                        Contact contact = new Contact(id, firstname, lastname, nickname, phoneFix, phoneMobil, birth, mail, website, address);
                        list.add(contact);
                    }
                    resultSet.close();
                }
                statement.close();
            }
            connection.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

}
