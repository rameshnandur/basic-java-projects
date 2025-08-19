package quizProject.in;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



 class QuizQuestion{

	 private int id;
	 private String questionText;
	 private List<String> options;
	 private int Ans;
	 
	 
	 public QuizQuestion(int id, String questionText, List<String> options, int ans) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.options = options;
		Ans = ans;
	}
	 public int getId() {
		 return id;
	 }
	 public void setId(int id) {
		 this.id = id;
	 }
	 public String getQuestionText() {
		 return questionText;
	 }
	 public void setQuestionText(String questionText) {
		 this.questionText = questionText;
	 }
	 public List<String> getOptions() {
		 return options;
	 }
	 public void setOptions(List<String> options) {
		 this.options = options;
	 }
	 public int getAns() {
		 return Ans;
	 }
	 public void setAns(int ans) {
		 Ans = ans;
	 }
	 public boolean isCorrect(int s2) {
		// TODO Auto-generated method stub
		return s2 == Ans;
	 }
	 
	 
	
}
class QuizyService {
	ArrayList<QuizQuestion > al = new ArrayList<>();
	
	     public QuizyService() {
	    	 al.add(new QuizQuestion (123,"what is the full form ps",Arrays.asList("pocso","proto","police station","primary"),3));
	    	 al.add(new QuizQuestion (2, "Which language is used in Spring Boot?", Arrays.asList("C++", "Java", "Python", "Go"), 2));
	    	 al.add(new QuizQuestion (3,"what is the cheating",Arrays.asList("phoneCall","msgs","videoCall","meeting"),4));
	     }
	     
	    public void  EnbaleQuiz(){
	    	
	    	Scanner s = new Scanner (System.in);
	    	int score = 0;
	    	
	    	 System.out.println("Welcome to Quiz...");
	    	 for(QuizQuestion q: al) {
	    		 System.out.println(q.getQuestionText());
	    		 
	    		 List<String>  al1=q.getOptions() ;
	    		 
	    		 for (int i = 0;i<al1.size();i++) {
	    			  System.out.println((i+1)+". "+al1.get(i));
	    		 }
	    		 System.out.println("Enter you choice...");
	    		 int s2 = s.nextInt();
	    		 
	    		 if (q.isCorrect(s2)) {
	    			 System.out.println("correct Answer....");
	    			 score++;
	    		 }else {
	    			 System.out.println("Wrong Answer......");
	    		 }
	    	 } 
	    	 System.out.println("\n🎯 Quiz Finished! Your Score: " + score + "/" + al.size());
	    	
	    	
	    }
	
	
}

public class Quizy2 {

	public static void main(String[] args) {
		
		QuizyService qs  = new QuizyService();
		qs.EnbaleQuiz();

	}

}
