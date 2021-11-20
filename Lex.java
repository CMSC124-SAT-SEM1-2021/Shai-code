/* Medina Shaina Bess
   San Juan Jan Catherine
   CMSC 124
   ME1
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lex {

	static int length = 0;
	static char charAdd[] = new char[10];
	static String prevcharClass = "";
	
	public static void main(String[] args) throws FileNotFoundException {  
		String lineFile = null;
		
		//opens file
		File file = new File("C:\\Users\\DELL\\Documents\\test.txt");
		Scanner scan  = new Scanner(file);
		
		//gets the the text per line
		while(scan.hasNextLine()) {
			
		lineFile = scan.nextLine();
		String trimmedLine = lineFile.trim();
		
			if (trimmedLine.length() != 0 ) {
			System.out.println("------------------------------------------------------"+lineFile.length());
			String removedSpaces = lineFile.replaceAll("\\s+", " ");
			System.out.println("Input: " +removedSpaces);
			System.out.println("------------------------------------------------------"+removedSpaces.length());
			getChar(lineFile);
			}
		}
		lineFile = "eof";
		System.out.println(lineFile);
	}
	
	
	static void getChar(String s) {
		String thisString = s;
		String charClass = "UNKNOWN";
			char[] charsFromString = thisString.toCharArray();
			
			for (int i = 0; i < charsFromString.length; i++) {
		    	
				
				if (Character.isLetter(charsFromString[i]) || Character.isWhitespace(charsFromString[i])) {
						 charClass = "LETTER";
						 char put = charsFromString[i];
						 addChar(put, charClass);
					}
				else if (Character.isDigit(charsFromString[i]) || Character.isWhitespace(charsFromString[i])) {
						char put = charsFromString[i];
						charClass = "DIGIT";
						addChar(put, charClass);
					}
						
						
				else {
						char put = '\f';
						charClass = "UNKNOWN";
						addChar(put, charClass);	
						System.out.print("Lexeme is: " + charsFromString[i] + "         token is: ");
						lookup(charsFromString[i]);
					}
				}
			
			char put = '\f';
			addChar(put, charClass);
		}
	
	static void addChar(char s, String c) {
		
		if (length < 10) {
			if (Character.isWhitespace(s)) {
				if (length != 0) 
					printlex();
					clearlex();		
			}
			else if(prevcharClass == "DIGIT" && c == "LETTER"){
				printlex();
				clearlex();
				charAdd[length] = s;
				length++;
			}
			else {
			charAdd[length] = s;
			length++;}
			}
		
		else if (length == 10) {
			System.out.println("error too big");
			length++;
		}
		if (Character.isWhitespace(s)) {
			if (length != 0) {
				printlex();
				clearlex();
				}
		}

		prevcharClass = c;		
	}

		
	
	//clears the array
	static void clearlex() {
		for (int i = 0; i < charAdd.length; i++) {
			charAdd[i] = 0;
		}
		length = 0;
	}
	//converts the charAdd into string
	static void printlex() {
		String charConvert = String.valueOf(charAdd);
		System.out.print("Lexeme is: " + charConvert + "token is: ");
		lookup2(charConvert);
            
	}
	
	//lookup for string chars
	static void lookup2(String s) {
		String token = "";

		if(Character.isLetter(s.charAt(0))){
			token = "IDENTIFIER";
		}
		else{
			token = "INT_LITERAL";
		}

		System.out.print(token);
		System.out.println();
	}
	//lookup for unknown chars
	static void lookup(char s) {
		String token = "";

		if(s=='+'){
			token = "PLUS_OP";
		}
		else if(s=='-'){
			token = "SUB_OP";
		}
		else if(s=='*'){
			token = "MULTI_OP";
		}
		else if(s=='/'){
			token = "DIV_OP";
		}
		else if(s=='('){
			token = "L_PAREN";
		}
		else if(s==')'){
			token = "R_PAREN";
		}
		else if(s=='='){
			token = "ASSIGN_OP";
		}
		else {
			token = "EOF";
		}

		System.out.print(token);
		System.out.println();
	}
}
	
	
