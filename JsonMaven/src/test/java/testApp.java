
 import com.mycompany.jsonmaven.JsonMaven;
import java.util.Arrays;
 import junit.framework.Assert;
 
 
public class testApp {
   public void testVerifierUic()
{
    JsonMaven jsonMaven=new JsonMaven();
     Assert.assertEquals(true,jsonMaven.verfierUic(Arrays.asList("12365478", "12364878", "1255878")) ) ;
}}
    
 