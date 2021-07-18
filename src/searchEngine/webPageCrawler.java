package searchEngine;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;

public class webPageCrawler {
	
	public void Crawler()
	{
		String urls[] = new String[] 
				{"https://www.nutrition.gov/recipes/summer-squash-kabobs",
						"https://www.usda.gov/topics/food-and-nutrition",
						"https://www.nationalnutrition.ca/"};
		
		String urlName[] = new String[] {"Summer-Squash","U.S. Dept of Agriculture","Food Guide Canada"};
		
		for (int i = 0; i < urls.length; i++) {
			// System.out.println(webPages[i]);
			htmlToTextConvertor(urls[i], urlName[i]);
		}
	}
	
	private static void htmlToTextConvertor(String webPage, String webPageName) {
		// TODO Auto-generated method stub
		org.jsoup.nodes.Document doc;
		try {
			//doc = Jsoup.parse(webPage, "UTF-8");
			doc = Jsoup.connect(webPage).get();
			String text = doc.text();
			//System.out.println(text);
			PrintWriter out = new PrintWriter("convertedWebPages\\"+webPageName+".txt");
			out.println(text);
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
