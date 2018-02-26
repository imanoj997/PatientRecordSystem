package application;

import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class InsertPatient {

	@FXML
	private TextField Patient_Name1;
	@FXML
	private TextField Address1;
	@FXML
	private TextField Age1;
	@FXML
	private TextField Disease1;
	@FXML
	private TextField Doctor_Name1;
	@FXML
	private DatePicker Admit_Date1;
	@FXML
	private DatePicker Discharge_Date1;

	public void submitform(ActionEvent event) {
		try {

			String Patient_Name = Patient_Name1.getText();
			String Address = Address1.getText();
			String textAge = Age1.getText();
			int Age = Integer.parseInt(textAge);
			String Disease = Disease1.getText();
			String Doctor_Name = Doctor_Name1.getText();
			LocalDate txtAdmit_Date = Admit_Date1.getValue();
			LocalDate txtDischarge_DateL = Discharge_Date1.getValue();
			String Admit_Date = txtAdmit_Date.toString();
			String Discharge_Date = txtDischarge_DateL.toString();

			Patients patients = new Patients();
			patients.setPatient_Name(Patient_Name);
			patients.setAddress(Address);
			patients.setAge(Age);
			patients.setDisease(Disease);
			patients.setDoctor_Name(Doctor_Name);
			patients.setAdmit_Date(Admit_Date);
			patients.setDischarge_Date(Discharge_Date);

			int state = DBInfo.save(patients);

			if (state > 0) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Data Insert");
				alert.setHeaderText("Information Dialog");
				alert.setContentText("Record saved successfully!");

				alert.showAndWait();

				// System.out.println(" Record saved successfully! ");

			} else {

				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Data Insert");
				alert.setHeaderText("ERROR Dialog");
				alert.setContentText("Sorry! unable to save record");

				alert.showAndWait();

				// System.out.println("Sorry! unable to save record");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void retunHomeScreen(ActionEvent event) {
		try {
			Parent homeView3 = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
			Scene homeViewScene = new Scene(homeView3);
			Stage window1 = ((Stage) ((Node) event.getSource()).getScene().getWindow());
			window1.setScene(homeViewScene);
			window1.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
