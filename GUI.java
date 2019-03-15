import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI{
	Stage stage;
	Scene scene;
	CreditCard creditCards=new CreditCard();
	Transactions tranObj=new Transactions();
	GUI2 gui2;

	public GUI(Stage stage) {
		this.stage=stage;
	}
	public void prepareScene() {
		
		Label ccLabel=new Label("Enter credit card number you want to search for: ");
		TextField ccField=new TextField(); 
		Button submit=new Button("Submit");
		GridPane grid=new GridPane();
		grid.add(ccLabel,0,1);
		grid.add(ccField,0,2);
		grid.add(submit,0,3);
		
		submit.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent arg0) {
				String searchKey=ccField.getText();
				if(!searchKey.equals(creditCards.getNumber()))
				{
					Label errorLabel=new Label("Incorrect number, please try again!");
					grid.add(errorLabel, 0, 5);
				}
				else {
				String balance=creditCards.getBalance();
				tranObj.setCurrentBalance(balance);
				stage.setScene(gui2.getScene());
					}
			}
			
		});
		scene=new Scene(grid,600,400);
	}
	public Scene getScene()
	{
		return this.scene;
	}
	public void setgui2(GUI2 gui2)
	{
		this.gui2=gui2;
	}
}
