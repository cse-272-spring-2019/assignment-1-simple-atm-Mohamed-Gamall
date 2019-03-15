import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI2 {
	Stage stage;
	Scene scene;
	CreditCard creditCards = new CreditCard();
	Transactions tranObj = new Transactions();
	GUI gui;

	public GUI2(Stage stage) {
		this.stage = stage;
		tranObj.initArray();
	}

	public void prepareScene() {
		Label activity = new Label("Choose Activity");
		Button balanceInquiry = new Button("Balance inquiry");
		Button deposit = new Button("Deposit");
		TextField depositTextField = new TextField();
		Button withdraw = new Button("Withdraw");
		TextField withdrawTextField = new TextField();
		Button previous = new Button("Previous");
		Button next = new Button("Next");
		Label result = new Label();
		Label error = new Label();
		Button back=new Button("Insert new credit card");
		GridPane grid = new GridPane();
		grid.add(activity, 0, 0);
		grid.add(balanceInquiry, 0, 1);
		grid.add(deposit, 0, 2);
		grid.add(depositTextField, 2, 2);
		grid.add(withdraw, 0, 3);
		grid.add(withdrawTextField, 2, 3);
		grid.add(previous, 0, 4);
		grid.add(next, 0, 5);
		grid.add(result, 0, 6);
		grid.add(error, 0, 7);
		grid.add(back, 0, 8);
		balanceInquiry.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String balance = creditCards.getBalance();
				tranObj.setCurrentBalance(balance);
				result.setText("Current balance =" + tranObj.getCurrentBalance2());

			}

		});

		deposit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String balance = creditCards.getBalance();
				tranObj.setCurrentBalance(balance);
				String amount = depositTextField.getText();
				if (Integer.parseInt(amount) < 0)
					error.setText("Cannot use negative number");
				else {
					tranObj.deposit(amount);
					result.setText("New balance = " + tranObj.getCurrentBalance());
					error.setText(null);
					creditCards.setBalance(tranObj.getCurrentBalance());
				}
			}

		});
		withdraw.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String balance = creditCards.getBalance();
				tranObj.setCurrentBalance(balance);
				String amount = withdrawTextField.getText();
				if (Integer.parseInt(amount) < 0)
					error.setText("Cannot use negative number");
				else {
					tranObj.withdraw(amount);
					if (Integer.parseInt(tranObj.getCurrentBalance()) < 0)
						error.setText("Cannot withdraw more than current balance");
					else {
						result.setText("New balance = " + tranObj.getCurrentBalance());
						creditCards.setBalance(tranObj.getCurrentBalance());
					}
				}
			}

		});
		previous.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String balance = creditCards.getBalance();
				tranObj.setCurrentBalance(balance);
				String previous = tranObj.prev();
				result.setText("Previous transaction is: " + previous);

			}

		});
		next.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String next = tranObj.next();
				result.setText("Next transaction is: " + next);

			}

		});
		back.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				stage.setScene(gui.getScene());

			}
		});

		scene = new Scene(grid, 600, 400);
	}

	public Scene getScene() {
		return this.scene;
	}

	public void setgui(GUI gui) {
		this.gui = gui;
	}
}
