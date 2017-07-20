package listingProfile;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.codec.binary.Base64;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import bsh.ParseException;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

public class OLD_US_API_City_Selection {

	@Test(priority=1)
    public static void  US_API_City_selection() throws ParseException, net.minidev.json.parser.ParseException {

          try {
                String webPage = "http://ls-location-api.azurewebsites.net/api/location/ip/35.163.151.89";
                String name = "sulekha";
                String password = "kJ!ve3~q9+fNpuEC";

                String authString = name + ":" + password;
                System.out.println("auth string: " + authString);
                byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
                String authStringEnc = new String(authEncBytes);
                System.out.println("Base64 encoded auth string: " + authStringEnc);

                URL url = new URL(webPage);
                URLConnection urlConnection = url.openConnection();
                urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
                InputStream is = urlConnection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);

                int numCharsRead;
                char[] charArray = new char[1024];
                StringBuffer sb = new StringBuffer();
                while ((numCharsRead = isr.read(charArray)) > 0) {
                      sb.append(charArray, 0, numCharsRead);
                }
                String result = sb.toString();
                String txt=result;                              
                JSONObject JsonIdURL = (JSONObject)new JSONParser().parse(txt);
         String str = (String) JsonIdURL.get("CountryCode");           
         System.out.println("CountryCode--"+str);
        if(str.contentEquals("US")){
            Reporter.log("Country code displayed correctly");
            Reporter.log("Displayed message : "+str);
        }else{
            Reporter.log("Country code displayed wrongly");
            Reporter.log("Displayed message : "+str); 
            Assert.fail();
        }
   
          } catch (MalformedURLException e) {
                e.printStackTrace();
          } catch (IOException e) {
                e.printStackTrace();
          }
    }

	
}
