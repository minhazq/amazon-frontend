package mq.amazon_frontend.framework.persistance;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accountprofile")
public class AccountProfile {

	@Id
	private int id;
	
	private String user_name;
	private String user_password;
	private String user_fullname;
	private String user_addressline_1;
	private String user_city;
	private String user_state;
	private String user_country;
	private String user_phonenumber;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_fullname() {
		return user_fullname;
	}
	public void setUser_fullname(String user_fullname) {
		this.user_fullname = user_fullname;
	}
	public String getUser_addressline_1() {
		return user_addressline_1;
	}
	public void setUser_addressline_1(String user_addressline_1) {
		this.user_addressline_1 = user_addressline_1;
	}
	public String getUser_city() {
		return user_city;
	}
	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}
	public String getUser_state() {
		return user_state;
	}
	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}
	public String getUser_country() {
		return user_country;
	}
	public void setUser_country(String user_country) {
		this.user_country = user_country;
	}
	public String getUser_phonenumber() {
		return user_phonenumber;
	}
	public void setUser_phonenumber(String user_phonenumber) {
		this.user_phonenumber = user_phonenumber;
	}
	

	

	
}
