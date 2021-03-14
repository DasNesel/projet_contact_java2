package contact;


import java.io.IOException;

//import org.kordamp.bootstrapfx.BootstrapFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

	private static Scene scene;

	// Lets add the main layout of our application as a static member, shall we ?
	// This will help us avoiding dodgy explicit casts
	private static BorderPane mainlayout;

	@Override
	public void start(Stage stage) throws IOException {
		// Nothing new here
		stage.setTitle("Le meilleur gestionnaire de contact de l'univers");
		// Load the main layout from file
		mainlayout = loadFXML("MainLayout");
		// Back to normal, except we use our newly defined member. Seems cumbersome, but
		// it will make sense in two seconds
		scene = new Scene(mainlayout, 640, 480);
		stage.setScene(scene);
		// This is a sample about how to customize your application using BootstrapFX.
		// here I apply the bootstrapFX CSS to my root node (MainLayout). I can then
		// apply some styles to the components (see for example the launch button in
		// HomeScreen.fxml)
		// Note that I can still use another CSS if I want (for example, the
		// QuizOverview uses another css, which is located in the project (quiz.css) and
		// applies to every element class.
	//	scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
		stage.show();
		// This is also new for this PW : you have to call the default view you want to
		// see when the application launches
		App.showView("HomeScreen");
	}

	// this is not used anymore, you can (should) get rid of it. There is other now
	// useless code in this class, can you spot it ?
	public static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	// Here is the real game changer: let's change Parent with something more, let's
	// say, generic. We can do this as fxmlLoader.load() specifically returns a
	// generic object.
	// Doing this allows us to call loadFXML to populate whatever object type we
	// think relevant, not only Parent objects (here, we also are looking for Nodes
	// ones indeed)
	private static <T> T loadFXML(String fxml) throws IOException {
		// As we will use this method a lot, and we have all our view in a specific
		// package, let's put it there to save some typing :)
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/View/" + fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void main(String[] args) {
		launch();
	}

	/**
	 * @param rootElement updates the center of our layout with the @rootElement
	 *                    passed in parameter
	 */
	public static void showView(String rootElement) {
		try {
			// We can only set the center of a borderPane, not a Parent, so we rely on
			// either an explicit cast or our better generics implementation to convert our
			// scene and modify it.
			mainlayout.setCenter(loadFXML(rootElement));
		} catch (IOException e) {
			// Chances are that the file is not found. Nothing we can do, really, but as
			// IOException is checked, it would require us to add nasty support all over our
			// code
			// Instead, a better practice is to convert this checked exception into an
			// unchecked exception, and let it bubble up to the main thread, killing the
			// JVM. We could also close the app, but it would be dangerous, as some
			// resources could be opened somewhere and not correctly closed...
			// BEWARE ! you should ALWAYS keep the stacktrace complete. using the original
			// exception as an argument allows that !
			throw new IllegalArgumentException(e);
		}
	}
}
