package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Member {
	
//	int no;
//	String id, pw, name, gender, phone, address ;
	
	private SimpleIntegerProperty no;
	private SimpleStringProperty id;
	private SimpleStringProperty pw;
	private SimpleStringProperty name;
	private SimpleStringProperty gender;
	private SimpleStringProperty phone;
	private SimpleStringProperty address;
	
//	public Member() {
//		this(0, null, null, null, null, null, null);
//	}
	
	public int getNo() {
		return no.get();
	}
	public void setNo(Integer no) {
		this.no = new SimpleIntegerProperty(no);
	}
	public IntegerProperty noProperty() {
		return no;
	}
	
	public String getId() {
		return id.get();
	}
	public void setId(String id) {
		this.id = new SimpleStringProperty(id);;
	}
	public StringProperty idProperty() {
		return id;
	}
	
	public String getPw() {
		return pw.get();
	}
	public void setPw(String pw) {
		this.pw = new SimpleStringProperty(pw);;
	}
	public StringProperty pwProperty() {
		return pw;
	}
	
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}
	public StringProperty nameProperty() {
		return name;
	}
	
	public String getGender() {
		return gender.get();
	}
	public void setGender(String gender) {
		this.gender = new SimpleStringProperty(gender);
	}
	public StringProperty genderProperty() {
		return gender;
	}
	
	public String getPhone() {
		return phone.get();
	}
	public void setPhone(String phone) {
		this.phone = new SimpleStringProperty(phone);
	}
	public StringProperty phoneProperty() {
		return phone;
	}
	
	public String getAddress() {
		return address.get();
	}
	public void setAddress(String address) {
		this.address = new SimpleStringProperty(address);
	}
	public StringProperty addressProperty() {
		return address;
	}
	//=========================================================================================================
	public Member(int no, String id, String pw, String name, String gender, String phone, String address) {
		super();
		this.no = new SimpleIntegerProperty(no);
		this.id = new SimpleStringProperty(id);
		this.pw = new SimpleStringProperty(pw);
		this.name = new SimpleStringProperty(name);
		this.gender = new SimpleStringProperty(gender);
		this.phone = new SimpleStringProperty(phone);
		this.address = new SimpleStringProperty(address);
	}
//	public int getNo() {
//		return no;
//	}
//	public void setNo(int no) {
//		this.no = no;
//	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getPw() {
//		return pw;
//	}
//	public void setPassword(String pw) {
//		this.pw = pw;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getGender() {
//		return gender;
//	}
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
	

}
