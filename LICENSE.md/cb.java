package JTableNewTest;
import java.io.File;
import java.io.IOException;

import javax.print.Doc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.List;
import java.util.ArrayList;


public class HTMLParser{
  
    public static void main(String args[]) throws IOException {
    	List<Article> articleList = new ArrayList<>();
    	String HTMLSTring = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<title>JSoup Example</title>"
                + "</head>"
                + "<body>"
                + "data-price-value="
                + "</body>"
                + "</html>";
    	Document html = Jsoup.parse(HTMLSTring);
          // JSoup Example 2 - Reading HTML page from URL
        Document doc = Jsoup.connect("https://www.dns-shop.ru/product/eeaf580ea7e83330/55-139-sm--led-televizor-dexp-f55d7000k-seryj/").get();
        Elements divElements = doc.getElementsByAttributeValue("class","price_g");
        divElements.forEach(divElement -> {
        	Element spanElement = divElement.child(0);
        	String url = spanElement.removeClass();
        	String title = spanElement.child(0).text();
        	
        	articleList.add(new Article(url, title));
        });
        
    	articleList.forEach(System.out::println);
  
//        System.out.println("Jsoup Can read HTML page from URL, title : " + title);
  
    }
}
    class Article {
    	private String url;
    	private String name;
    	
    	public Article(String url, String name) {
    		this.url = url;
    		this.name = name;
    	}
    	public String getUrl() {
    		return url;
    	}
    	public void setUrl(String url) {
    		this.url = url;
    	}
    	public String getName() {
    		return name;
    	}
    	public void setName(String name) {
    		this.name= name;
    	}
    }
