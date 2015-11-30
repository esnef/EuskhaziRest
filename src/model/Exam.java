package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the exams database table.
 * 
 */
@Entity
@Table(name="exams")
@NamedQuery(name="Exam.findAll", query="SELECT e FROM Exam e")
public class Exam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idexams;

	@Lob
	private String drafting;

	private String level;

	private int numExams;

	private double resultExams;

	private String typeExam;

	private String voiceFileName;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="users_idusers")
	private User user;

	public Exam() {
	}
	public Exam(String level,int numExams,double resultExams,String typeExam,String voiceFileName,String drafting) {
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}