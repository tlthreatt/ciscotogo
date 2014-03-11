package order.text;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class LoadTester {
	private static Properties prop;
	
	//public static final String CONFIG_PROPERTIES = "C:\\Users\\clachan\\Workspaces\\Doug's Workspace\\TestDUmmyProject\\src\\configLoad.properties";
	public static final String CONFIG_PROPERTIES = "configLoad.properties"; 
	
	public static final String ENV_PROPERTY_KEY = "env";
	
	public static final String ENDPOINT_PROPERTY_KEY = "endpoint";
	
	public static final String ENDPOINT_NAMESPACE_PROPERTY_KEY = "endpointNameSpace";
	
	public static final String ENDPOINT_SERVICE_PROPERTY_KEY = "endpointServiceName";
	
	public static final String ENDPOINT_OPERATON_PROPERTY_KEY = "endpointOperationName";
	
	public static final String KEY_TRANSFORMATION_FILE = "Transformation_ProcessItemListEBM_ProcessItemEBMFile.xsl";
	
	public static final String GROUP_TRANSFORMATION_FILE = "Transformation_ProcessItemListEBM_ProcessItemEBM.xsl";
	
	public static final String END_POINT_OPERATION = "Transformation_ProcessItemListEBM_ProcessItemEBM.xsl";	
   
  public static void main(String[] args) { 
      //Scanner doesn't work?
      
      /**
      int threadCount = 0; 
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  
      try {  
          System.out.println("How many threads:");
          String numberOfThreads = reader.readLine();
          threadCount = Integer.parseInt(numberOfThreads);                  
       } catch (IOException e) { 
          System.err.println("Problem with input stream");  
          e.printStackTrace(); 
      }**/
      int threadCount = 30000;
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setNamespaceAware(true);
      prop = new Properties();
      try {
    	
        for(int i = 0; i < threadCount; i++) {
        	if(i%100 == 0 && i!= 0){
        		Thread.sleep(3000);
        	}        
          new Thread(new WebServiceFireThread()).start();
        }
        //conn.close();       
      }
      catch (Exception e) {
    	    e.printStackTrace(new PrintStream(System.out));
    	}
         
    }    
  
  private static String getEnv(){
		return prop.getProperty(ENV_PROPERTY_KEY);
	}
}

