package json;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the mobiles database table.
 * 
 */


	
@XmlRootElement
public class MobileJSON implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int idmobiles;

	@XmlElement
	private String mobilesMAC;
	//@XmlElement
	//private UsersJSON usersJSON;
	@XmlElement
	private List<UserJSON> users;
	

	public MobileJSON() {
	}
	/*
	public MobileJSON(String mobilesMAC,UsersJSON usersJSON) {
		this.mobilesMAC=mobilesMAC;
		this.usersJSON=usersJSON;
	}
	*/
	public MobileJSON(String mobilesMAC,List<UserJSON> users) {
		this.mobilesMAC=mobilesMAC;
		this.users=users;
	}


	public void setMobilesMAC(String mobilesMAC) {
		this.mobilesMAC = mobilesMAC;
	}
	/*
	public UsersJSON getUsersJSON(){
		return this.usersJSON;
	}
	
	public void setUsersJSON(UsersJSON usersJSON){
		this.usersJSON=usersJSON;
	}
	*/
	public List<UserJSON> getUsers() {
		return this.users;
	}

	public void setUsers(List<UserJSON> users) {
		this.users = users;
	}

	public UserJSON addUser(UserJSON user) {
		getUsers().add(user);

		return user;
	}

	public UserJSON removeUser(UserJSON user) {
		getUsers().remove(user);
		return user;
	}

	

}