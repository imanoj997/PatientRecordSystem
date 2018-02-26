package application;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;

public class UpdateAndDelete {

	@FXML
	TextField idPatient;
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

	public void getPatientByID(ActionEvent event) throws IOException, ParseException {

		String patientid = idPatient.getText();
		int PID = Integer.parseInt(patientid);

		Patients patients = DBInfo.getPatientByID(PID);

		Patient_Name1.setText(patients.getPatient_Name());
		Address1.setText(patients.getAddress());
		Age1.setText(String.valueOf(patients.getAge()));
		Disease1.setText(patients.getDisease());
		Doctor_Name1.setText(patients.getDoctor_Name());
		Admit_Date1.setPromptText(patients.getAdmit_Date());
		Discharge_Date1.setPromptText(patients.getDischarge_Date());

	}

	public void updatePatient(ActionEvent event) {

		String patientid = idPatient.getText();
		int PID = Integer.parseInt(patientid);

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
		patients.setPid(PID);
		patients.setPatient_Name(Patient_Name);
		patients.setAddress(Address);
		patients.setAge(Age);
		patients.setDisease(Disease);
		patients.setDoctor_Name(Doctor_Name);
		patients.setAdmit_Date(Admit_Date);
		patients.setDischarge_Date(Discharge_Date);

		int st = DBInfo.updatePatient(patients);
		if (st > 0) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Data update");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record updated successfully!");

			alert.showAndWait();

			// System.out.println(" Record saved successfully! ");
		} else {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Data update");
			alert.setHeaderText("ERROR Dialog");
			alert.setContentText("Sorry! unable to update record");

			alert.showAndWait();

			// System.out.println("Sorry! unable to update record");
		}
	}

	public void deletePatient(ActionEvent event) {
		String patientid = idPatient.getText();
		int PID = Integer.parseInt(patientid);

		int state = DBInfo.deletePatient(PID);

		if (state > 0) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Data delete");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record deleted successfully!");

			alert.showAndWait();

			// System.out.println(" Record deleted successfully! ");
		} else {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Data update");
			alert.setHeaderText("ERROR Dialog");
			alert.setContentText("Sorry! unable to delete record");

			alert.showAndWait();

			// System.out.println("Sorry! unable to update record");
		}
	}
	
	public void retunHomeScreen(ActionEvent event) {
		try {
			Parent homeView2 = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
			Scene homeViewScene = new Scene(homeView2);
			Stage window1 = ((Stage) ((Node) event.getSource()).getScene().getWindow());
			window1.setScene(homeViewScene);
			window1.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
