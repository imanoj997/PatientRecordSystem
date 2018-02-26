package application;

public class Patients {

	private int PID;
	private String Patient_Name;
	private String Address;
	private int Age;
	private String Disease;
	private String Doctor_Name;
	private String Admit_Date;
	private String Discharge_Date;
	
	public  Patients(int PID, String Patient_Name, String Address , int Age, String Disease, String Doctor_Name, String Admit_Date, String Discharge_Date) {
		super();
		this.PID = PID;
		this.Patient_Name=Patient_Name;
		this.Address=Address;
		this.Age=Age;
		this.Disease=Disease;
		this.Doctor_Name=Doctor_Name;
		this.Admit_Date=Admit_Date;
		this.Discharge_Date=Discharge_Date;
	}
	public Patients() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the PID
	 */
	public int getPid() {
		return PID;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(int PID) {
		this.PID = PID;
	}
	/**
	 * @return the patient_Name
	 */
	public String getPatient_Name() {
		return Patient_Name;
	}
	/**
	 * @param patient_Name the patient_Name to set
	 */
	public void setPatient_Name(String patient_Name) {
		Patient_Name = patient_Name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		Address = address;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return Age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		Age = age;
	}
	/**
	 * @return the disease
	 */
	public String getDisease() {
		return Disease;
	}
	/**
	 * @param disease the disease to set
	 */
	public void setDisease(String disease) {
		Disease = disease;
	}
	/**
	 * @return the doctor_Name
	 */
	public String getDoctor_Name() {
		return Doctor_Name;
	}
	/**
	 * @param doctor_Name the doctor_Name to set
	 */
	public void setDoctor_Name(String doctor_Name) {
		Doctor_Name = doctor_Name;
	}
	/**
	 * @return the admit_Date
	 */
	public String getAdmit_Date() {
		return Admit_Date;
	}
	/**
	 * @param admit_Date the admit_Date to set
	 */
	public void setAdmit_Date(String admit_Date) {
		Admit_Date = admit_Date;
	}
	/**
	 * @return the discharge_Date
	 */
	public String getDischarge_Date() {
		return Discharge_Date;
	}
	/**
	 * @param discharge_Date the discharge_Date to set
	 */
	public void setDischarge_Date(String discharge_Date) {
		Discharge_Date = discharge_Date;
	}
	

	
	
	
}

