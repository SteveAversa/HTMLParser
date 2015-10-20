import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JEditorPane;
import javax.swing.JFrame;


public class HTMLContent extends JFrame{

	public static void main(String args[]) throws IOException{ 
		new HTMLContent().start();
		}

void start() throws IOException { 
	FileReader reader = new FileReader("C:/Users/Steve Aversa/workspace/HTMLParser/Plantation.html");
	StringBuilder sb = new StringBuilder();
	BufferedReader br = new BufferedReader(reader);
	FileWriter fWriter = new FileWriter("fileName.html");
	BufferedWriter writer = new BufferedWriter(fWriter);
	String line;
	
	while ( (line=br.readLine()) != null) {
		  sb.append(line);

		}

	String text = sb.toString();
	String lastLink = "";
	
	String regex = "<a (.*?) \"|<a href=\"(.*?)\"|<a style=\"(.*?) \"";
	Pattern pattern =  Pattern.compile(regex);
	Matcher  matcher = pattern.matcher(text);

	while(matcher.find()){
	String imageLink =  matcher.group();
	System.out.println(imageLink);
	if (imageLink != lastLink){
		text = text.replace(imageLink,"<input type=\"text\" name=\"inBox\">"+imageLink);
	}
	lastLink = imageLink;
	}
	
	writer.append(text);
	regex = "</body\>";
	pattern =  Pattern.compile(regex);
	matcher = pattern.matcher(text);
	String imageLink =  matcher.group();
	text = text.replace(imageLink,imageLink+"<button type=\"button\">Click Me!</button>");
	writer.close();
}



}



