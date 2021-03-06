package bdd.Daos;

import bdd.Entities.Contact;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                        int id = resultSet.getInt("genre_id");
                        String firstname = resultSet.getString("firstname");
                        String lastname = resultSet.getString("lastname");
                        String nickname = resultSet.getString("nickname");
                        String phoneFix = resultSet.getString("phone_number_fix");
                        String phoneMobil = resultSet.getString("phone_number_mobil");
                        String mail = resultSet.getString("email_address");
                        String address = resultSet.getString("address");
                        String website = resultSet.getString("website");
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
