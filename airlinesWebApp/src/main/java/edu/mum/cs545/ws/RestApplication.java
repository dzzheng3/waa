package edu.mum.cs545.ws;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;  
   
/** 
 */  
public class RestApplication extends ResourceConfig {  
    public RestApplication() {  
   
     //���������ڵİ�·��  
     packages("edu.mum.cs545.ws");  
     //ע��JSONת����  
     packages("com.fasterxml.jackson.jaxrs.json");   
    }  
}  