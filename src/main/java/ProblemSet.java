/**

        * File: Problem Set Unit 3

        * Author: Peter

        * Date Created: March 29, 2026

        * Date Last Modified: April 4, 2026

        */

import java.util.Scanner; 
public class ProblemSet {
public static void main(String args[]) {

	Scanner scanner = new Scanner(System.in); 

	// input
	System.out.print("Input your email: "); 
	String email = scanner.nextLine(); 

	String status = "Valid";
	String reason = "";

	// checking if there is one @ symbol 

	int firstsymbol = email.indexOf("@"); 
	int secondsymbol = email.lastIndexOf("@");

	if (firstsymbol == -1){ 
		status = "Invalid";
		reason = "Missing @";
} 	
	else if (firstsymbol != secondsymbol){
		status = "Invalid";
		reason = "Multiple @";
	}
	
	// checking if it starts/ends with a dot 

if (status.equals("Valid") && (email.startsWith(".") || email.endsWith("."))) { 
	status = "Invalid";
	reason = "Starts or ends with dot";
} 
//checks if email contains a space 

if (status.equals("Valid") && email.contains(" ")) { 
	status = "Invalid";
	reason = "Contains spaces";
}
	// checks parts seperatly 
	String firstPart = "";
	String secondPart = "";

	if (status.equals("Valid")) {
		firstPart = email.substring(0, firstsymbol);
		secondPart = email.substring(firstsymbol + 1);
	}
	

// checks if the email has 1-64 character before @ 
if (status.equals("Valid")){
	if (firstPart.length() < 1) {
		status = "Invalid";
		reason = "Local part too short";
	}
		else if (firstPart.length() > 64) {
			status = "Invalid";
			reason = "Local part is too long";
		}
	}
	// Exception B
	// note: I didn't know any other way other than a huge if statement ~ i think i included all possible invalids
	if (status.equals("Valid")){
		if (firstPart.contains("$") || firstPart.contains("#") || firstPart.contains("%")){
			status = "Invalid";
			reason = "Invalid character in local part";
		}

			if (status.equals("Valid") && 
				(firstPart.contains("!") || firstPart.contains("&") || firstPart.contains("*"))){

				status = "Invalid";
				reason = "Invalid character in local part";
			}

				if (status.equals("Valid") && 
				(firstPart.contains("(") || firstPart.contains(")") || firstPart.contains("="))){
					status = "Invalid";
					reason = "Invalid character in local part";
				}
			if (status.equals("Valid") && 
				(firstPart.contains("?") || firstPart.contains("/") || firstPart.contains("\\"))){
					status = "Invalid";
					reason = "Invalid character in local part";
					}
		if (status.equals("Valid") && 
			(firstPart.contains(",") || firstPart.contains(";") || firstPart.contains(":"))){
				status = "Invalid";
				reason = "Invalid character in local part";
		}
	}
	// checks if there is one dot after the @ symbol 

int periodindex = secondPart.lastIndexOf("."); 
	if (status.equals("Valid") && periodindex == -1) {
		 status = "Invalid";
		 reason = "No dot in domain";
} 
// checks if there is a domain extension of 2-6 characters after the dot 
// also is Exception A
	if (status.equals("Valid")){

		String dotTest = secondPart.substring(periodindex + 1); 
		int domainlength = dotTest.length(); 

		if (domainlength < 2 || domainlength > 6) { 
			status = "Invalid";
			reason = "Invalid domain extension length";
} 
	}
// Exception C
boolean normalized = false;
String checker = secondPart.toLowerCase();
	if (status.equals("Valid") && checker.equals("gmail.com")){
		firstPart = firstPart.replace(".", "");
		normalized = true;
		reason = "Valid (Gmail normalized)";
	}

	// output

	if (status.equals("Valid")) {
		if (normalized == true) {
			System.out.println(reason);
		}
		else {
			System.out.println("Valid");
		}
	}
	else {
		System.out.println("Invalid" + ": " + reason);
	}
}
}
