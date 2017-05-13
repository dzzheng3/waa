package edu.mum.cs545.ws;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;  
   
/** 
 */  
public class RestApplication extends ResourceConfig {  
    public RestApplication() {  
   
     //服务类所在的包路径  
     packages("edu.mum.cs545.ws");  
     //注册JSON转换器  
     packages("com.fasterxml.jackson.jaxrs.json");   
    }  
}  
