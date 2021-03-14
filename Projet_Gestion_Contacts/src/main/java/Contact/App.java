package Contact;

import java.io.IOException;

//import org.kordamp.bootstrapfx.BootstrapFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
	private static BorderPane mainlayout;

    @Override
    public void start(Stage stage) throws IOException {
		stage.setTitle("Contact Project");
		mainlayout = loadFXML("MainLayout");
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
        App.showView("HomeScreen");
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

	private static <T> T loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/isen/quiz/view/" + fxml + ".fxml"));
		return fxmlLoader.load();
	}

    public static void main(String[] args) {
        launch();
    }
    
	public static void showView(String rootElement) {
		try {
			
			mainlayout.setCenter(loadFXML(rootElement));
		} catch (IOException e) {
			
			throw new IllegalArgumentException(e);
		}
	}

}