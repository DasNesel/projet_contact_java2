package View;

import java.io.IOException;

import contact.App;
import javafx.fxml.FXML;

public class HomeScreenController {
	@FXML
	public void handleLaunchButton1() throws IOException {
		// Here we make use of our new method allowing us to change views inside the main Parent		
		App.showView("Contact");
	}
	
	@FXML
	public void handleLaunchButton2() throws IOException {
		// Here we make use of our new method allowing us to change views inside the main Parent		
		App.showView("ListAllContact");
	}
}
