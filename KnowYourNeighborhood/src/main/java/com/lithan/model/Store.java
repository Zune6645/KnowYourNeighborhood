package com.lithan.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@EnableAutoConfiguration
public class Store {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int sid;
	public String sname;
	public String phone;
	public String location;
	
	@ManyToOne
	private Users user;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	} 

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Store [sid=" + sid + ", sname=" + sname + ", phone=" + phone + ", location=" + location + ", user="
				+ user + "]";
	}

	public Store(int sid, String sname, String phone, String location, Users user) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.phone = phone;
		this.location = location;
		this.user = user;
	}

	public Store() {
	}

	public Store(int sid, String sname, String phone, String location) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.phone = phone;
		this.location = location;
	}	
	
	public Store(String sname, String phone, String location) {
		super();
		this.sname = sname;
		this.phone = phone;
		this.location = location;
	}
}
