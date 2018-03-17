import java.io.IOException;
  
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public class Parser{
	  
    public static void main(String args[]) {
        Document doc;
        try {
        	
            doc = Jsoup.connect("https://www.dns-shop.ru/product/61725d5fe75b3330/185-monitor-viewsonic-va1903a-vs16216/").get();
            String searchedPrice = doc.getElementsByAttribute("data-price-value").get(0).html();
            System.out.println( "searchedPrice : " + searchedPrice  );
            String searchedName = doc.getElementsByAttribute("data-product-param").get(0).html();
            System.out.println( "searchedName : " + searchedName  );
            String searchedRating = doc.getElementsByAttributeValue("itemprop", "ratingValue").get(0).html();
            System.out.println( "searchedRating : " + searchedRating   );
       
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
