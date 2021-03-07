package bdd.Daos;

import bdd.Entities.Contact;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.Assert.*;

public class ContactDaoTest {

    private ContactDao contactDao = new ContactDao();

    @Before
    public void initDatabase() throws Exception {
        Connection connection = DataSourceFactory.getDataSource().getConnection();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS contact(" +
                        "    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, \n" +
                        "    lastname VARCHAR(45) NOT NULL,  \n" +
                        "    firstname VARCHAR(45) NOT NULL,\n" +
                        "    nickname VARCHAR(45) NOT NULL,\n" +
                        "    phone_number_fix VARCHAR(15) NULL,\n" +
                        "    phone_number_mobil VARCHAR(15) NULL,\n" +
                        "    address VARCHAR(200) NULL,\n" +
                        "    email_address VARCHAR(150) NULL,\n" +
                        "    website_address VARCHAR(200) NULL,\n" +
                        "    birth_date DATE NULL);");
        stmt.executeUpdate("DELETE FROM contact");
        stmt.executeUpdate("INSERT INTO contact(id,lastname,firstname,nickname,phone_number_fix,phone_number_mobil,address,email_address,website_address,birth_date) VALUES (1,'LICETTE', 'Matthieu', 'Math', null,'0602053033','Rue des lilas,59000 LILLE','matthieu.licette@junia.com', null, '1996-08-06 12:00:00.000')");
        stmt.executeUpdate("INSERT INTO contact(id,lastname,firstname,nickname,phone_number_fix,phone_number_mobil,address,email_address,website_address,birth_date) VALUES (2,'LICETTE', 'Camille', 'caca', null,'0655772137','Rue des lilas,59000 LILLE','camille.licette@hei.yncrea.fr', null, '1998-10-16 12:00:00.000')");
        stmt.close();
        connection.close();
    }

    @Test
    public void shouldListContacts() {
        // WHEN
        List<Contact> contacts = contactDao.listContacts();
        // THEN
        assertThat(contacts).hasSize(2);
        assertThat(contacts).extracting("id", "lastname", "firstname", "nickname", "phoneFix", "phoneMobil", "adress", "mail", "website", "birthday").containsOnly(
                tuple(1, "LICETTE","Matthieu","Math", null,"0602053033","Rue des lilas,59000 LILLE","matthieu.licette@junia.com", null, LocalDate.of(1996, 8, 6)),
                tuple(2, "LICETTE","Camille","caca", null,"0655772137","Rue des lilas,59000 LILLE","camille.licette@hei.yncrea.fr", null, LocalDate.of(1998, 10, 16))
        );
    }

    @Test
    public void shouldAddContact() throws Exception {
        // WHEN
        Contact contact = new Contact(null, "SNOW", "John", "le batard", "0105112233", null, LocalDate.of(1852, 10, 3), null, null,"Winterfell appartement 240, Westeros");
        contactDao.addContact(contact);

        // THEN
        Connection connection = DataSourceFactory.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSetFilm = statement.executeQuery("SELECT * FROM contact WHERE firstname='SNOW'");


        assertThat(resultSetFilm.next()).isTrue();
        assertThat(resultSetFilm.getInt("id")).isNotNull();
        assertThat(resultSetFilm.getString("firstname")).isEqualTo("SNOW");
        assertThat(resultSetFilm.getString("lastname")).isEqualTo("John");
        assertThat(resultSetFilm.getString("nickname")).isEqualTo("le batard");
        assertThat(resultSetFilm.getString("phone_number_fix")).isEqualTo("0105112233");
        assertThat(resultSetFilm.getString("address")).isEqualTo("Winterfell appartement 240, Westeros");
        assertThat(resultSetFilm.getString("phone_number_mobil")).isNull();
        assertThat(resultSetFilm.getString("email_address")).isNull();
        assertThat(resultSetFilm.getString("website_address")).isNull();
        assertThat(resultSetFilm.getDate("birth_date")).isEqualTo(java.sql.Date.valueOf((LocalDate.of(1852, 10, 3))));
        assertThat(resultSetFilm.next()).isFalse();

        resultSetFilm.close();
        statement.close();
        connection.close();
    }

    @Test
    public void shouldGetContactsByLastname() {
        // WHEN
        List<Contact> contacts = contactDao.getContactsByLastname("Licette");
        // THEN
        assertThat(contacts).hasSize(2);
        assertThat(contacts).extracting("id", "lastname", "firstname", "nickname", "phoneFix", "phoneMobil", "adress", "mail", "website", "birthday").containsOnly(
                tuple(1, "LICETTE","Matthieu","Math", null,"0602053033","Rue des lilas,59000 LILLE","matthieu.licette@junia.com", null, LocalDate.of(1996, 8, 6)),
                tuple(2, "LICETTE","Camille","caca", null,"0655772137","Rue des lilas,59000 LILLE","camille.licette@hei.yncrea.fr", null, LocalDate.of(1998, 10, 16))
        );
    }

    @Test
    public void shouldGetContactsByFirstname() {
        // WHEN
        List<Contact> contacts = contactDao.getContactsByFirstname("Matthieu");
        // THEN
        assertThat(contacts).hasSize(1);
        assertThat(contacts).extracting("id", "lastname", "firstname", "nickname", "phoneFix", "phoneMobil", "adress", "mail", "website", "birthday").containsOnly(
                tuple(1, "LICETTE","Matthieu","Math", null,"0602053033","Rue des lilas,59000 LILLE","matthieu.licette@junia.com", null, LocalDate.of(1996, 8, 6))
        );
    }

    @Test
    public void shouldGetContactsByNickname() {
        // WHEN
        List<Contact> contacts = contactDao.getContactsByNickname("caca");
        // THEN
        assertThat(contacts).hasSize(1);
        assertThat(contacts).extracting("id", "lastname", "firstname", "nickname", "phoneFix", "phoneMobil", "adress", "mail", "website", "birthday").containsOnly(
                tuple(2, "LICETTE","Camille","caca", null,"0655772137","Rue des lilas,59000 LILLE","camille.licette@hei.yncrea.fr", null, LocalDate.of(1998, 10, 16))
        );
    }

    @Test
    public void shouldDeleteContact() throws Exception {
        // WHEN
        Contact contact = new Contact(1, "SNOW", "John", "le batard", "0105112233", null, LocalDate.of(1852, 10, 3), null, null,"Winterfell appartement 240, Westeros");
        contactDao.deleteContact(contact);

        // THEN
        Connection connection = DataSourceFactory.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSetFilm = statement.executeQuery("SELECT * FROM contact WHERE id=1");


        assertThat(resultSetFilm.next()).isFalse();

        resultSetFilm.close();
        statement.close();
        connection.close();
    }

    @Test
    public void shouldGetContactsByPhoneNumber() {
        // WHEN
        List<Contact> contacts = contactDao.getContactsByPhoneNumber("0655772137");
        // THEN
        assertThat(contacts).hasSize(1);
        assertThat(contacts).extracting("id", "lastname", "firstname", "nickname", "phoneFix", "phoneMobil", "adress", "mail", "website", "birthday").containsOnly(
                tuple(2, "LICETTE","Camille","caca", null,"0655772137","Rue des lilas,59000 LILLE","camille.licette@hei.yncrea.fr", null, LocalDate.of(1998, 10, 16))
        );
    }

    @Test
    public void shouldUpdateContact() throws Exception {
        // WHEN
        Contact contact = new Contact(1, "SNOW", "John", "le batard", "0105112233", null, LocalDate.of(1852, 10, 3), null, null,"Winterfell appartement 240, Westeros");
        contactDao.updateContact(contact);

        // THEN
        Connection connection = DataSourceFactory.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSetFilm = statement.executeQuery("SELECT * FROM contact WHERE firstname='SNOW'");


        assertThat(resultSetFilm.next()).isTrue();
        assertThat(resultSetFilm.getInt("id")).isNotNull();
        assertThat(resultSetFilm.getString("firstname")).isEqualTo("SNOW");
        assertThat(resultSetFilm.getString("lastname")).isEqualTo("John");
        assertThat(resultSetFilm.getString("nickname")).isEqualTo("le batard");
        assertThat(resultSetFilm.getString("phone_number_fix")).isEqualTo("0105112233");
        assertThat(resultSetFilm.getString("address")).isEqualTo("Winterfell appartement 240, Westeros");
        assertThat(resultSetFilm.getString("phone_number_mobil")).isNull();
        assertThat(resultSetFilm.getString("email_address")).isNull();
        assertThat(resultSetFilm.getString("website_address")).isNull();
        assertThat(resultSetFilm.getDate("birth_date")).isEqualTo(java.sql.Date.valueOf((LocalDate.of(1852, 10, 3))));
        assertThat(resultSetFilm.next()).isFalse();

        resultSetFilm.close();
        statement.close();
        connection.close();
    }
}