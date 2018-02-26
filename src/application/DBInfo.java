package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class DBInfo {

	public static Connection getConnection() {
		Connection con = null;

		try {
			String url = "jdbc:mysql://localhost:3306/patients_database";
			con = DriverManager.getConnection(url, "root", "root");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}

	public static int save(Patients patients) {

		int st = 0;

		String sql = "insert into Patient_Record(Patient_Name,Address,Age,Disease,Doctor_Name,Admit_Date,Discharge_Date)values (?,?,?,?,?,?,?)";
		Connection con = DBInfo.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, patients.getPatient_Name());
			ps.setString(2, patients.getAddress());
			ps.setInt(3, patients.getAge());
			ps.setString(4, patients.getDisease());
			ps.setString(5, patients.getDoctor_Name());
			ps.setString(6, patients.getAdmit_Date());
			ps.setString(7, patients.getDischarge_Date());
			st = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return st;
	}

	public static int updatePatient(Patients patients) {

		int st = 0;

		String sql = "update Patient_Record set Patient_Name=?, Address=?, Age=?, Disease=?, Doctor_Name=?, Admit_Date=?, Discharge_Date=? where PID=?";
		Connection con = DBInfo.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, patients.getPatient_Name());
			ps.setString(2, patients.getAddress());
			ps.setInt(3, patients.getAge());
			ps.setString(4, patients.getDisease());
			ps.setString(5, patients.getDoctor_Name());
			ps.setString(6, patients.getAdmit_Date());
			ps.setString(7, patients.getDischarge_Date());
			ps.setInt(8, patients.getPid());
			st = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return st;
	}

	public static int deletePatient(int PID) {

		int state = 0;

		try {
			String sql = "DELETE FROM Patient_Record WHERE PID=?";
			Connection con = DBInfo.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

			ps.setInt(1, PID);

			state = ps.executeUpdate();

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return state;

	}

	public static Patients getPatientByID(int PID) {
		Patients patients = new Patients();

		try {
			String sql = "select * from Patient_Record where PID=?";
			Connection con = DBInfo.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

			ps.setInt(1, PID);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				patients.setPid(rs.getInt(1));
				patients.setPatient_Name(rs.getString(2));
				patients.setAddress(rs.getString(3));
				patients.setAge(rs.getInt(4));
				patients.setDisease(rs.getString(5));
				patients.setDoctor_Name(rs.getString(6));
				patients.setAdmit_Date(rs.getString(7));
				patients.setDischarge_Date(rs.getString(8));

			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patients;

	}

	public static List<Patients> getPatient() {
		List<Patients> list = new ArrayList<>();

		try {
			String sql = "select * from Patient_Record";
			Connection con = DBInfo.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Patients patients = new Patients();
				patients.setPid(rs.getInt(1));
				patients.setPatient_Name(rs.getString(2));
				patients.setAddress(rs.getString(3));
				patients.setAge(rs.getInt(4));
				patients.setDisease(rs.getString(5));
				patients.setDoctor_Name(rs.getString(6));
				patients.setAdmit_Date(rs.getString(7));
				patients.setDischarge_Date(rs.getString(8));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

}
