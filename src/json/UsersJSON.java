package json;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@XmlRootElement
public class UsersJSON implements Serializable {
	private static final long serialVersionUID = 1L;



	//bi-directional many-to-one association to Exam
	@XmlElement
	private List<UserJSON> users;



	public UsersJSON() {
	}

	

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