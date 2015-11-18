package business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Feature;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import json.ExamJSON;
import json.ExamsJSON;
import json.MobileJSON;
import json.MobilesJSON;
import json.UserJSON;
import json.UsersJSON;
import model.Exam;
import model.Mobile;
import model.User;


@Singleton//Anotación de EJB compatible con Web Service
@Path("/prueba")
public class RestServices {
	@Context
    private javax.servlet.http.HttpServletRequest hsr;
	
	@PersistenceContext 
	EntityManager em;
	 
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.TEXT_PLAIN)//indicamos que produce un codigo de texto plano
	@Path("/test")
	public boolean testOnline() {	
		System.out.println("Test ok IP:"+hsr.getRemoteAddr());
		//List<Mobile> mobileList=(List<Mobile>)em.createNamedQuery("Mobile.findAll");
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.TEXT_PLAIN)//indicamos que produce un codigo de texto plano
	@Path("/test3")
	public boolean testOnline3() {	
		System.out.println("Test ok IP:"+hsr.getRemoteAddr());
		List<Mobile> mobileList=(List<Mobile>)em.createNamedQuery("Mobile.findAll").getResultList();
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.TEXT_PLAIN)//indicamos que produce un codigo de texto plano
	@Path("/test4")
	public boolean testOnline4() {	
		System.out.println("Test ok IP:"+hsr.getRemoteAddr());
		List<Mobile> mobileList=(List<Mobile>)em.createNamedQuery("Mobile.findAll").getResultList();
		
		for(int con=0;con<mobileList.size();con++){
			System.out.println("ID:"+mobileList.get(con).getIdmobiles()+" mac:"+mobileList.get(con).getMobilesMAC());
			em.remove(mobileList.get(con));
		}
		
		
		return true;
	}
	
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.TEXT_PLAIN)//indicamos que produce un codigo de texto plano
	@Path("/test2")
	public boolean testOnline2() {	
		System.out.println("Test ok IP:"+hsr.getRemoteAddr());
		
		
		
		Mobile mobile=new Mobile();
		Date date=new Date();
		mobile.setMobilesMAC("saasfasfasfafdsaf"+date.toString());
		
		User user=new User();
		user.setName("csdafsdafgasd");
		user.setPass("123444323");
		
		if(mobile.getUsers()==null){
			mobile.setUsers(new ArrayList<User>());
			System.out.println("hola");
		}
		if(user.getExams()==null){
			user.setExams(new ArrayList<Exam>());
			System.out.println("hola2");
		}
		/*
		for(int con2=0;con2<5;con2++){
			Exam exam=new Exam();
			exam.setDrafting("fd");
			exam.setIdexams(7687);
			exam.setLevel("sasadfsda"+date.toString());
			user.addExam(exam);
		}
		*/
		mobile.addUser(user);
		
		em.persist(mobile);//you need this, as there is no cascading from Product to Feature.
		//em.getTransaction().commit();//if you work with a resource-local persistence unit. Otherwise if JTA: commit the transaction the JTA-specific way (if that was not already done by the container)
		
		List<Mobile> mobileList=(List<Mobile>)em.createNamedQuery("Mobile.findAll").getResultList();
		for(int con=0;con<mobileList.size();con++){
			System.out.println("ID:"+mobileList.get(con).getIdmobiles()+" mac:"+mobileList.get(con).getMobilesMAC());
		}
		
		return true;
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.TEXT_PLAIN)//indicamos que produce un codigo de texto plano
	@Path("/newUser")
	public boolean newUser() {	
		System.out.println("Test ok IP:"+hsr.getRemoteAddr());

		User user=new User();
		Date date=new Date();
		String name="csdafsdafgasd"+date.toString();
		user.setName(name);
		user.setPass("123444323");
		
		
		
		
		List<Exam> exams=new ArrayList<Exam>();
		for(int con=0;con<10;con++){
			Exam exam=new Exam();
			exam.setDrafting("asdvgsdvsdfgvasdgsdgasdfgasdgsadgsdgsdfagfdavfdfdfgvbf"+con);
			exam.setLevel("A2");
			exam.setNumExams(con);
			exam.setTypeExam("sdsdddsfgasdg");
			exams.add(exam);
		}
		user.setExams(exams);
		em.persist(user);
		//em.getTransaction().begin();
		//em.persist(user);//you need this, as there is no cascading from Product to Feature.
		//em.getTransaction().commit();
		//em.getTransaction().commit();//if you work with a resource-local persistence unit. Otherwise if JTA: commit the transaction the JTA-specific way (if that was not already done by the container)
		/*
		List<User> userList=(List<User>)em.createNamedQuery("User.findAll").getResultList();
		for(int con=0;con<userList.size();con++){
			System.out.println("asd"+con);
			System.out.println("name:"+userList.get(con).getName()+" pass:"+userList.get(con).getPass());
			if(userList.get(con).getName()==name){
				if(userList.get(con).getExams()==null){
					userList.get(con).setExams(new ArrayList<Exam>());
				}
				for(int con1=0;con1<10;con1++){
					Exam exam=new Exam();
					exam.setDrafting("asdvgsdvsdfgvasdgsdgasdfgasdgsadgsdgsdfagfdavfdfdfgvbf"+con1);
					exam.setLevel("A2");
					exam.setNumExams(con1);
					exam.setTypeExam("sdsdddsfgasdg");
					
					userList.get(con).addExam(exam);
				}
			}
			
		}
		*/
		return true;
	}
	
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllExams")	
	public List<ExamJSON> getAllExams() {
		System.out.println("requestLessons: "+hsr.getRemoteAddr());
		
		
		
		List<Exam> examsList=(List<Exam>)em.createNamedQuery("Exam.findAll").getResultList();//Consultar la lista de todas las lecciones
			
		return convertExams(examsList);

	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllUsers")	
	public List<UserJSON> getAllUsers() {
		System.out.println("requestLessons: "+hsr.getRemoteAddr());
		
		List<User> usersList=(List<User>)em.createNamedQuery("User.findAll").getResultList();//Consultar la lista de todas las lecciones

		return convertUsers(usersList);
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllMobiles")	
	public List<MobileJSON> getAllMobiles() {
		System.out.println("requestLessons: "+hsr.getRemoteAddr());
		
		List<Mobile> mobilesList=(List<Mobile>)em.createNamedQuery("Mobile.findAll").getResultList();//Consultar la lista de todas las lecciones

		return convertMobile(mobilesList);
	}
	
	/*
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllExams")	
	public ExamsJSON getAllExams() {
		System.out.println("requestLessons: "+hsr.getRemoteAddr());
		
		
		
		List<Exam> examsList=(List<Exam>)em.createNamedQuery("Exam.findAll").getResultList();//Consultar la lista de todas las lecciones
			
		return convertExams(examsList);

	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllUsers")	
	public UsersJSON getAllUsers() {
		System.out.println("requestLessons: "+hsr.getRemoteAddr());
		
		List<User> usersList=(List<User>)em.createNamedQuery("User.findAll").getResultList();//Consultar la lista de todas las lecciones

		return convertUsers(usersList);
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllMobiles")	
	public MobilesJSON getAllMobiles() {
		System.out.println("requestLessons: "+hsr.getRemoteAddr());
		
		List<Mobile> mobilesList=(List<Mobile>)em.createNamedQuery("Mobile.findAll").getResultList();//Consultar la lista de todas las lecciones

		return convertMobile(mobilesList);
	}
	*/
	
	
	
	private List<ExamJSON> convertExams(List<Exam> examsList){
		if(examsList==null){
			System.out.println("No se puede pasar un argunmento null en ConvertExams");
			return null;
		}
		ExamsJSON examsJSON=new ExamsJSON();
		List<ExamJSON> examJSONList=new ArrayList<ExamJSON>();
		for(int i=0;i<examsList.size();i++){//Para cada lección de la lista
			Exam l=examsList.get(i);
			ExamJSON lJSON=new ExamJSON(l.getLevel(),l.getNumExams(),l.getResultExams(),l.getTypeExam(),l.getVoiceFileName(),l.getDrafting());//Crear objeto LessonJSON, copiando lessonCode y title
			examJSONList.add(lJSON);//Añadir objeto LessonJSON creado a la lista lessonJSONList
		}
		examsJSON.setExams(examJSONList);//Meter la lista lessonJSONList en el objeto lessonsJSON

		return examJSONList;
	}
	
	
	
	private List<UserJSON> convertUsers(List<User> usersList){
		
		List<UserJSON> userJSONList=new ArrayList<UserJSON>();
		UsersJSON usersJSON=new UsersJSON();
		for(int i=0;i<usersList.size();i++){//Para cada lección de la lista
			User l=usersList.get(i);
			UserJSON lJSON=new UserJSON(l.getName(),l.getPass(),convertExams(l.getExams()));//Crear objeto LessonJSON, copiando lessonCode y title
			userJSONList.add(lJSON);//Añadir objeto LessonJSON creado a la lista lessonJSONList
		}
		usersJSON.setUsers(userJSONList);//Meter la lista lessonJSONList en el objeto lessonsJSON

		return userJSONList;
		
	}
	
	private List<MobileJSON> convertMobile(List<Mobile> mobilesList){
		
		List<MobileJSON> mobileJSONList=new ArrayList<MobileJSON>();
		MobilesJSON mobilesJSON=new MobilesJSON();
		for(int i=0;i<mobilesList.size();i++){//Para cada lección de la lista
			Mobile l=mobilesList.get(i);
			MobileJSON lJSON=new MobileJSON(l.getMobilesMAC(),convertUsers(l.getUsers()));//Crear objeto LessonJSON, copiando lessonCode y title
			mobileJSONList.add(lJSON);//Añadir objeto LessonJSON creado a la lista lessonJSONList
		}
		mobilesJSON.setUsers(mobileJSONList);//Meter la lista lessonJSONList en el objeto lessonsJSON

		return mobileJSONList;
		
	}
	
	/*
	private ExamsJSON convertExams(List<Exam> examsList){
		if(examsList==null){
			System.out.println("No se puede pasar un argunmento null en ConvertExams");
			return null;
		}
		ExamsJSON examsJSON=new ExamsJSON();
		List<ExamJSON> examJSONList=new ArrayList<ExamJSON>();
		for(int i=0;i<examsList.size();i++){//Para cada lección de la lista
			Exam l=examsList.get(i);
			ExamJSON lJSON=new ExamJSON(l.getLevel(),l.getNumExams(),l.getResultExams(),l.getTypeExam(),l.getVoiceFileName(),l.getDrafting());//Crear objeto LessonJSON, copiando lessonCode y title
			examJSONList.add(lJSON);//Añadir objeto LessonJSON creado a la lista lessonJSONList
		}
		examsJSON.setExams(examJSONList);//Meter la lista lessonJSONList en el objeto lessonsJSON

		return examsJSON;
	}
	
	
	
	private UsersJSON convertUsers(List<User> usersList){
		
		List<UserJSON> userJSONList=new ArrayList<UserJSON>();
		UsersJSON usersJSON=new UsersJSON();
		for(int i=0;i<usersList.size();i++){//Para cada lección de la lista
			User l=usersList.get(i);
			UserJSON lJSON=new UserJSON(l.getName(),l.getPass(),convertExams(l.getExams()));//Crear objeto LessonJSON, copiando lessonCode y title
			userJSONList.add(lJSON);//Añadir objeto LessonJSON creado a la lista lessonJSONList
		}
		usersJSON.setUsers(userJSONList);//Meter la lista lessonJSONList en el objeto lessonsJSON

		return usersJSON;
		
	}
	
	private MobilesJSON convertMobile(List<Mobile> mobilesList){
		
		List<MobileJSON> mobileJSONList=new ArrayList<MobileJSON>();
		MobilesJSON mobilesJSON=new MobilesJSON();
		for(int i=0;i<mobilesList.size();i++){//Para cada lección de la lista
			Mobile l=mobilesList.get(i);
			MobileJSON lJSON=new MobileJSON(l.getMobilesMAC(),convertUsers(l.getUsers()));//Crear objeto LessonJSON, copiando lessonCode y title
			mobileJSONList.add(lJSON);//Añadir objeto LessonJSON creado a la lista lessonJSONList
		}
		mobilesJSON.setUsers(mobileJSONList);//Meter la lista lessonJSONList en el objeto lessonsJSON

		return mobilesJSON;
		
	}
	*/
	
	
	
	
}
