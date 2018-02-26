package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainController {
	static Connection con = null;
	static Statement statement;

	public static void createTable() throws SQLException {

		try {
			String sql = "CREATE TABLE Patient_Record " + "(PID INTEGER not NULL AUTO_INCREMENT, "
					+ " Patient_Name VARCHAR(255), " + " Address VARCHAR(255), " + " Age INTEGER, "
					+ " Disease VARCHAR(255), " + " Doctor_Name VARCHAR(255), " + "Admit_Date Date, "
					+ "Discharge_Date Date, " + " PRIMARY KEY ( PID ))";

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patients_database", "root", "root");
			statement = con.createStatement();
			statement.executeUpdate(sql);
			System.out.println("table created");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// When called this method sets stage to a new scene
	public void addRecord(ActionEvent event) throws IOException {
		try {
			Parent formView = FXMLLoader.load(getClass().getResource("PatientForm.fxml"));
			Scene formViewScene = new Scene(formView);
			Stage window = ((Stage) ((Node) event.getSource()).getScene().getWindow());
			window.setScene(formViewScene);
			window.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewData(ActionEvent event) {
		try {
			Parent detailView = FXMLLoader.load(getClass().getResource("DetailsPage.fxml"));
			Scene detailViewScene = new Scene(detailView);
			Stage window1 = ((Stage) ((Node) event.getSource()).getScene().getWindow());
			window1.setScene(detailViewScene);
			window1.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateRecord(ActionEvent event) throws IOException {
		try {
			Parent editView = FXMLLoader.load(getClass().getResource("UpdateDelete.fxml"));
			Scene editViewScene = new Scene(editView);
			Stage window = ((Stage) ((Node) event.getSource()).getScene().getWindow());
			window.setScene(editViewScene);
			window.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
