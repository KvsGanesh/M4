import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validate {

	public static boolean ValidateName(String name){
		if(Pattern.matches("[a-zA-Z]{5,15}",name)){
			return true;
		}
		else{
			System.out.println("The user name should be between 5 to 15 characters");
			return false;
		}
		
	}
	
	
	
	public static boolean ValidateNo(String phoneno){
		if(phoneno.length()==10){
		return true;
		}
		else{
			System.out.println("The Phone number should be between 10 digits");
			return false;
		}
	}
	
	 public static boolean Validatemail(String email)
	    {
		 Pattern emailNamePtrn = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		 Matcher mtch = emailNamePtrn.matcher(email);

		 if(mtch.matches()){
	            return true;
	        }
	        else
	        {
	        	System.out.println("Enter a valid email");
	        	System.out.println(email);
	        	return false;
	        }
	    }
}
