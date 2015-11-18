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
public class MobilesJSON implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlElement
	private List<MobileJSON> mobileJSON;

	
	public MobilesJSON() {
	}

	
	public List<MobileJSON> getUsers() {
		return this.mobileJSON;
	}

	public void setUsers(List<MobileJSON> mobileJSON) {
		this.mobileJSON = mobileJSON;
	}

	

}