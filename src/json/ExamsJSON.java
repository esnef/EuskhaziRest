package json;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;


/**
 * The persistent class for the exams database table.
 * 
 */
@XmlRootElement
public class ExamsJSON implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlElement(name="exams")
	private List<ExamJSON> examJSON;


	public ExamsJSON() {
	}
	
	public List<ExamJSON> getExams() {
		return this.examJSON;
	}

	public void setExams(List<ExamJSON> exams) {
		this.examJSON = exams;
	}
	
	public void addExams(ExamJSON exam) {
		this.examJSON.add(exam);
	}


}