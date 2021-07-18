package searchEngine;

import java.util.Scanner;

/**
*  Search Engine Start 
*  Conversion of html to text 
*  Storage of converted text file to local
*/

public class SearchEngineMain {

	public static void main(String[] args) {
	
		/*Web page crawling and conversion to html */
		webPageCrawler web = new webPageCrawler();
		web.Crawler();
		
		/*Conversion finished from html to text*/
		
		/* User Interaction start */

		Scanner userInput = new Scanner(System.in);  
	    System.out.println("Please enter the text to be searched: ");

	    String userName = userInput.nextLine();  // Read user input
		
		/* Switch Case */
		
		/* Features */
	}
}
