package View;

import javafx.fxml.FXML;
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
	TextField birthday;
	
	@FXML
	TextField mail;
	
	@FXML
	TextField website;
	
	@FXML
	TextField adress;
	
	@FXML
	private void handleSaveButton() {
	
		
	}
	
	@FXML
	private void handleDeleteButton() {
		/*int selectedIndex = this.questionsTable.getSelectionModel().getSelectedIndex();
	    if (selectedIndex >= 0) {
	        questionsTable.getItems().remove(selectedIndex);
	        resetView();
	    }*/
	}
}
