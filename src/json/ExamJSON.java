package json;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

/**
 * The persistent class for the exams database table.
 * 
 */
@XmlRootElement
public class ExamJSON implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idexams;

	@XmlElement
	private String drafting;
	@XmlElement
	private String level;
	@XmlElement
	private int numExams;
	@XmlElement
	private double resultExams;
	@XmlElement
	private String typeExam;
	@XmlElement
	private String voiceFileName;



	public ExamJSON() {
	}
	
	public ExamJSON(String level,int numExams,double resultExams,String typeExam,String voiceFileName,String drafting) {
		this.drafting=drafting;
		this.level=level;
		this.numExams=numExams;
		this.resultExams=resultExams;
		this.typeExam=typeExam;
		this.voiceFileName=voiceFileName;
	}
	

	public int getIdexams() {
		return this.idexams;
	}

	public void setIdexams(int idexams) {
		this.idexams = idexams;
	}

	public String getDrafting() {
		return this.drafting;
	}

	public void setDrafting(String drafting) {
		this.drafting = drafting;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getNumExams() {
		return this.numExams;
	}

	public void setNumExams(int numExams) {
		this.numExams = numExams;
	}

	public double getResultExams() {
		return this.resultExams;
	}

	public void setResultExams(double resultExams) {
		this.resultExams = resultExams;
	}

	public String getTypeExam() {
		return this.typeExam;
	}

	public void setTypeExam(String typeExam) {
		this.typeExam = typeExam;
	}

	public String getVoiceFileName() {
		return this.voiceFileName;
	}

	public void setVoiceFileName(String voiceFileName) {
		this.voiceFileName = voiceFileName;
	}



}