package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

//import prsDto.*;
//import prcDbUtil.DbUtil;

public class PatientsDetailsController implements Initializable {

	//List<PatientDto> list = new ArrayList<>();

	@FXML
	TableView<Patients> table;
	@FXML
	private TableColumn<Patients, Integer> pidcol;
	@FXML
	private TableColumn<Patients, String> patientNamecol;
	@FXML
	private TableColumn<Patients, String> addresscol;
	@FXML
	private TableColumn<Patients, Integer> agecol;
	@FXML
	private TableColumn<Patients, String> diseasecol;
	@FXML
	private TableColumn<Patients, String> doctorNamecol;
	@FXML
	private TableColumn<Patients, String> admitDatecol;
	@FXML
	private TableColumn<Patients, String> dischargeDatecol;

	private ObservableList<Patients> tableData = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {
			String sql = "select * from patient_record";
			Connection con = DBInfo.getConnection();
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tableData.add(new Patients(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
			}
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pidcol.setCellValueFactory(new PropertyValueFactory<Patients, Integer>("pid"));
		patientNamecol.setCellValueFactory(new PropertyValueFactory<Patients, String>("Patient_Name"));
		addresscol.setCellValueFactory(new PropertyValueFactory<Patients, String>("Address"));
		agecol.setCellValueFactory(new PropertyValueFactory<Patients, Integer>("Age"));
		diseasecol.setCellValueFactory(new PropertyValueFactory<Patients, String>("Disease"));
		doctorNamecol.setCellValueFactory(new PropertyValueFactory<Patients, String>("Doctor_Name"));
		admitDatecol.setCellValueFactory(new PropertyValueFactory<Patients, String>("Admit_Date"));
		dischargeDatecol.setCellValueFactory(new PropertyValueFactory<Patients, String>("Discharge_Date"));
		table.setItems(tableData);
	}
	
	public void retunHomeScreen(ActionEvent event) {
		try {
			Parent homeView1 = FXMLLoader.load(getClass().getResource("FirstPage.fxml"));
			Scene homeViewScene = new Scene(homeView1);
			Stage window1 = ((Stage) ((Node) event.getSource()).getScene().getWindow());
			window1.setScene(homeViewScene);
			window1.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
