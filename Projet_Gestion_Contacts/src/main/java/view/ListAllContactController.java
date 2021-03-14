package View;

import bdd.Entities.Contact;
import java.util.ArrayList;
import java.util.List;

import bdd.Daos.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class ListAllContactController 
implements Callback<TableColumn.CellDataFeatures<Contact, String>, ObservableValue<String>> {

@Override
public ObservableValue<String> call(CellDataFeatures<Contact, String> cellData) {
	return new SimpleStringProperty(cellData.getValue().getFirstname());
}

	@FXML 
	TableView <Contact> listeContact;
	
	private void afficheContact()
	{
		List<Contact> contacts = new ArrayList<>();	
		ContactDao contactdao= new ContactDao();
		contacts = contactdao.listContacts();
	
	}
	

	
}
