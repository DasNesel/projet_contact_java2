package View;
import java.io.IOException;

import contact.App;
import javafx.application.Platform;

public class MainLayoutController {

	public void closeApplication() {
		Platform.exit();
	}
	
	public void gotoHome() throws IOException {
		App.showView("HomeScreen");
	}
	
	public void gotoContact() throws IOException {
		App.showView("ListAllContact");
	}
}
