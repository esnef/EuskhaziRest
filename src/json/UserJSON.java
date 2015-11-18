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
public class UserJSON implements Serializable {
	private static final long serialVersionUID = 1L;


	private int idusers;
	@XmlElement
	private String name;
	@XmlElement
	private String pass;
	//@XmlElement
	//private ExamsJSON examsJSON;

	@XmlElement(name="exams")
	private List<ExamJSON> examJSONList;

	public UserJSON() {
	}
	/*
	public UserJSON(String name,String pass,ExamsJSON examsJSON) {
		this.name=name;
		this.pass=pass;
		this.examsJSON=examsJSON;
	}
	*/
	public UserJSON(String name,String pass,List<ExamJSON> examJSONList) {
		this.name=name;
		this.pass=pass;
		this.examJSONList=examJSONList;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	/*
	public ExamsJSON getExamsJSON(){
		return this.examsJSON;
	}
	
	public void setExamsJSON(ExamsJSON examsJSON){
		this.examsJSON=examsJSON;
	}
	*/
	

}