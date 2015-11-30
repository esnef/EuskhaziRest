package model;

import java.io.Serializable;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import json.UserJSON;


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
	//@GeneratedValue(strategy=GenerationType.AUTO, generator="purchase_seq")
	//@SequenceGenerator(name="purchase_seq", sequenceName="PURCHASE_SEQ")
	private int idmobiles;

	private String mobilesMAC;

	//bi-directional many-to-one association to User
	//@Cascade(CascadeType.PERSIST)
	//@OneToMany(mappedBy="mobile",cascade = {CascadeType.PERSIST})
	//@OneToMany(mappedBy="mobile",cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@OneToMany(mappedBy="mobile", cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE} )
	private List<User> users;

	public Mobile() {
	}
	public Mobile(String mobilesMAC,List<User> users) {
		this.mobilesMAC=mobilesMAC;
		this.users=users;
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