package View;

import contact.App;
import bdd.Daos.*;
import bdd.Entities.*;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ContactController {
	@FXML
	AnchorPane formPane;

	@FXML
	TextField firstName;

	@FXML
	TextField lastName;

	@FXML
	TextField nickName;
	
	@FXML
	TextField phoneFix;
	
	@FXML
	TextField mobilePhone;
	
	@FXML 
	DatePicker birthDay;
	
	@FXML
	TextField mail;
	
	@FXML
	TextField website;
	
	@FXML
	TextField adress;
	
	@FXML
	TextField city;
	
	@FXML
	TextField country;
	@FXML
	private void handleSaveButton() {
		Contact contact = new Contact(null,firstName.getText(),lastName.getText(),nickName.getText(),phoneFix.getText(),mobilePhone.getText(),birthDay.getValue(),mail.getText(),website.getText(),adress.getText(),city.getText(),country.getText());
		ContactDao contactdao= new ContactDao();
		contactdao.addContact(contact);
		
		App.showView("HomeScreen");
	}
	
	@FXML
	private void handleCancelButton() {
		App.showView("HomeScreen");
	}
}
