package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the mobiles database table.
 * 
 */
@Entity
@Table(name="mobiles")
@NamedQueries({
	@NamedQuery(name="Mobile.findAll", query="SELECT m FROM Mobile m"),
	@NamedQuery(name="Mobile.findByMAC", query="SELECT c FROM Mobile c WHERE c.mobilesMAC = :mobilesMAC")
})
public class Mobile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmobiles;

	private String mobilesMAC;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="mobile",cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<User> users;

	public Mobile() {
	}

	public int getIdmobiles() {
		return this.idmobiles;
	}

	public void setIdmobiles(int idmobiles) {
		this.idmobiles = idmobiles;
	}

	public String getMobilesMAC() {
		return this.mobilesMAC;
	}

	public void setMobilesMAC(String mobilesMAC) {
		this.mobilesMAC = mobilesMAC;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setMobile(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setMobile(null);

		return user;
	}

}