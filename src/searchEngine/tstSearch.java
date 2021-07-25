package searchEngine;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Searching a word in all the converted text files from html
 * 1. Searching for a complete word
 * 2. Searching for a word with given prefix  
 * @author SAIKRISHNA
 *
 */

public class tstSearch {
	
	 private static boolean verificationkeysThatMatch(TrieST<Integer> st, String word) {
		 Boolean bool=false;
		 for (String s : st.keysThatMatch(word))
		 {
				StdOut.println(s);
				bool = true;
		 }
		return bool;
	 }
	 
	 private static boolean verificationkeysWithPrefix(TrieST<Integer> st, String word) {
		 Boolean bool=false;
		 for (String s : st.keysWithPrefix(word))
		 {
				StdOut.println(s);
				bool = true;
		 }
		 return bool;
	 }
	
	public static void tstSearching(String myWord, int choice)  throws IOException {
		  
		File myFolder = new File("E:\\Advance computing concepts\\Project\\SearchEngine-main\\SearchEngine-main\\convertedWebpages");
		File[] files = myFolder.listFiles();
		
		for (File file : files) {

			Document doc = Jsoup.parse(file, "UTF-8");
			String text = doc.text();
			
			String[] obj = text.split(" ");
			
			TrieST<Integer> st = new TrieST<Integer>();
			
			for (int i = 0; i < obj.length; i++) {
				st.put(obj[i], i);
			}
			System.out.println("====================================================");
			switch (choice) {
			case 1 :
				System.out.println("Exact word");
				System.out.println(file.getName());
				if(!verificationkeysThatMatch(st, myWord))
					System.out.println("Unable to find the word you are searcing for in "+ file.getName());
				break;
				
				
			case 2 :
				System.out.println("Prefix serch");
				System.out.println(file.getName());
				if(!verificationkeysWithPrefix(st, myWord) == true)
					System.out.println("Unable to find the word you are searcing for in "+ file.getName());
				break;
			
			default:
				System.out.println("Enter a correct choice!! ");
			}
		}
	}		
}