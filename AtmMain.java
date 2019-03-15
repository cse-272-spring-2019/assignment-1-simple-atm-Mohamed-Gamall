import javafx.application.Application;
import javafx.stage.Stage;

public class AtmMain extends Application {

	public static void main(String[] args) {	
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ATM Machine");
		GUI gui=new GUI(primaryStage);
		GUI2 gui2=new GUI2(primaryStage);
		
		gui.prepareScene();
		gui2.prepareScene();
		
		gui.setgui2(gui2);
		gui2.setgui(gui);
		
		primaryStage.setScene(gui.getScene());
		primaryStage.show();
		
	}
	
}

