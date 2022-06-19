package com.lab.services;

import java.util.Random;

import com.lab.model.Employee;

public class CredentialsService {
	
	private static final int PASSWORD_LENGTH = 8;
	
	public String generateRandomPassword() {
		final StringBuilder sb = new StringBuilder();
		
		final Random rm = new Random();
		
		int first = (int) '%'; // 37
		int last = (int) '|'; // 124 
		
		for (int i = 0; i < PASSWORD_LENGTH; i++) {
			
			int random = rm.nextInt(last - first); // 87
			char randomChar = (char) (first + random); 
			sb.append(randomChar);
		}
		
		return sb.toString();
	}
	
	public String generateEmailAddress(Employee employee, String departmentName) {
		return String.format("%s%s@%s.company.com", employee.getFirstName(), employee.getLastName(), departmentName);
	}
	
	public void showCredentials(Employee employee, String emailAddress, String randomPassword) {
		System.out.printf("\nDear %s, your credentials are as follows\n"
				+ "Email: %s\n"
				+ "Password: %s", employee.getFirstName(), emailAddress, randomPassword);
	} 
}