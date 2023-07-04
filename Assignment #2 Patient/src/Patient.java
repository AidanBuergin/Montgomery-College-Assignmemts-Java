/*
 * Class: CMSC203 
 * Instructor: Eivazi
 * Description: Patient is where the blueprint for pateints will be stored..
 * Due: 07/03/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Aidan Buergin_________
*/

public class Patient {
	
	String fullName;
	String addy;
	String city;
	String state;
	String zip;
	String phone;
	String econtact;
	
/**
 * @description constructs new instances of Patient class
 * @param fullName
 * @param addy
 * @param city
 * @param state
 * @param zip
 * @param phone
 * @param econtact
 */
	
	public Patient(String fullName, String addy, String city, String state, String zip, String phone, String econtact) {
		this.fullName = fullName;
		this.addy = addy;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.econtact = econtact;
	}
	
	/**
	 * @description getter for full patient name.
	 * @return fullName
	 */
	
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * @description setter for patient's full name.
	 * @param fullName
	 */
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/**
	 * @description getter for patient address.
	 * @return addy
	 */
	
	public String getAddy() {
		return addy;
	}
	
	/**
	 * @description setter for patient's address.
	 * @param addy
	 */
	
	public void setAddy(String addy) {
		this.addy = addy;
	}
	
	/**
	 * @description getter for city of patient's residence.
	 * @return city
	 */
	
	public String getCity() {
		return city;
	}
	
	/**
	 * @description setter for patients city of residence.
	 * @param city
	 */
	
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @description getter for patient's state of residence.
	 * @return state
	 */
	
	public String getState() {
		return state;
	}
	
	/**
	 * @description setter for the patient's state of residence.
	 * @param state
	 */
	
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * @description getter for patient's ZIP code.
	 * @return zip
	 */
	
	public String getZip() {
		return zip;
	}
	
	/**
	 * @description setter for patient's ZIP.
	 * @param zip
	 */
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	/**
	 * @description getter for phone number of patient.
	 * @return phone
	 */
	
	public String getPhone() {
		return phone;
	}
	
	/**
	 * @description setter for phone number.
	 * @param phone
	 */
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * @description getter for emergency contact.
	 * @return econtact
	 */
	
	public String getEcontact() {
		return econtact;
	}
	
	/**
	 * @description setter for emergency contact.
	 * @param econtact
	 */
	
	public void setEcontact(String econtact) {
		this.econtact = econtact;
	}
	
	/**
	 * @return returns patient information.
	 */

	@Override
	public String toString() {
		return "Patient name: " + fullName + "\nAddress: " + addy + "\nCity: " + city + "\nState: " + state + "\nZIP: "
				+ zip + "\nPhone: " + phone + "\nEmergency Contact: " + econtact;
	}
	
	
	
	

}
