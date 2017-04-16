package com.michjony.basic.util.annotation;


import java.util.List;

public class UserUtils {

	@MyUserCase(id = 1,description="this is validatePassword")
	public boolean validatePassword(String password){
		return password.matches("\\w*\\d\\w*");
	}
	
	@MyUserCase(id = 2)	
	public String encryptPassword(String password){
		return new StringBuilder(password.toLowerCase()).reverse().toString();
	}
	
	
	@MyUserCase(id = 3,description="not use previously password")
	public boolean checkForNewPassword(List<String> prepassword ,String password){
		   return 0L == prepassword.stream().filter(pw -> pw.equals(password)).count();
	}
	
	
	@MyUserCase(id = 4,description="not use previously password")
	public boolean checkForNewPw(List<String> prepassword ,String password){
		return prepassword.contains(password);
	}
	
	
}

