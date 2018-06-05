
package finalprojectB;

import junit.framework.TestCase;
import org.junit.Test;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   @Test
   public void testManualTest()
   {
	   String[] schemes = {"http","https", ""};
	   UrlValidator urlValidator = new UrlValidator(schemes);
	   UrlValidator urlVal = new UrlValidator();
	   assertFalse(urlVal.isValid(null));
	   assertTrue(urlVal.isValid("http://www.google.com/"));

   }
   
   
   public void testValidPartition()
   {
	 String[] schemes = {"http", "https", ""};
	 UrlValidator urlValidator = new UrlValidator(schemes);
	 assertTrue(urlValidator.isValid("http://www.google.com"));
	 assertTrue(urlValidator.isValid("http://www.google.com/"));
	 assertTrue(urlValidator.isValid("www.google.com"));
	 assertTrue(urlValidator.isValid("www.google.com/"));
	 assertTrue(urlValidator.isValid("http://www.google.com:80"));
	 assertTrue(urlValidator.isValid("www.google.com:80"));
	 assertTrue(urlValidator.isValid("https://www.google.com:80/"));
	 assertTrue(urlValidator.isValid("http://google.com"));




   }
   
   public void testInvalidPartition(){
	   String[] schemes = {"http", "https", ""};
		 UrlValidator urlValidator = new UrlValidator(schemes);
		 assertFalse(urlValidator.isValid("http://www.google"));
		 assertFalse(urlValidator.isValid("http://ww3w.google.com"));
		 assertFalse(urlValidator.isValid("http://www.google,com"));
		 assertFalse(urlValidator.isValid("http:www.google.com"));
		 assertFalse(urlValidator.isValid("ht3tp:www.google.com"));

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing
       String[] schemes = {"http://", "https:/", "ftp://", "about:", "stuff//", "sandwich/", ""};
       String[] authority = {"www.amazon.com", "www.amazon.au", "amazon.com", "amazon", "1.1.1.1.1", ""};
       String[] path = {"/mail/", "/images", "./video/", "/things/stuff/", "//things", ""};
       String[] port = {":80", ":-80", ":", "80", ":a", ""};
       UrlValidator validator = new UrlValidator();
       for(int i = 0; i < schemes.length; i++) {
    	   String URL = schemes[i];
    	   for(int j = 0; j < authority.length; j++) {
    		   String URL1 = URL;
    		   URL1 = URL1 + authority[j];
    		   for(int k = 0; k < port.length; k++) {
    			   String URL2 = URL1;
    			   URL2 = URL2 + port[k];
    			   for(int l = 0; l < path.length; l++) {
    				   String URL3 = URL2;
    				   URL3 = URL2 + path[l];
    				   if(!validator.isValid(URL3)) {
    					   System.out.println(URL3);
    				   }
    			   }
    		   }
    	   }
       }
       
       
   }
   


}
