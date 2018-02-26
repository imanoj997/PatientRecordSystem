package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class LoginController {

	@FXML TextField txtuserName;
	@FXML PasswordField txtpassword;
	
	static final String USERNAME = "admin";
	static final String PASSWORD = "admin";
	
	public void login(ActionEvent event) {
		
		if(txtuserName.getText().equals("admin") && txtpassword.getText().equals("pass")){
			try {
				Parent mainView = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
				Scene mainViewScene = new Scene(mainView);
				Stage window = ((Stage) ((Node) event.getSource()).getScene().getWindow());
				window.setScene(mainViewScene);
				window.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Login");
			alert.setHeaderText("Login Eroor");
			alert.setContentText("Invalid Username or Password" + "\n" + "try again!!!");
			alert.showAndWait();

		}
	}
	
}
