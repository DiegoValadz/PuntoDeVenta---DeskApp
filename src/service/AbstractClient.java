/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author diego
 */
import java.util.logging.Logger;
 
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
 
/**
 * @author raidentrance
 *
 */
public class AbstractClient {
    protected final String url = "http://localhost:3000/";
    //protected final String url = "https://puntoventa74.herokuapp.com/";
    protected String contextPath;
 
    private static final Logger log = Logger.getLogger(AbstractClient.class.getName());
 
    public AbstractClient(String contextPath) {
        this.contextPath = contextPath;
    }
 
    protected ResteasyWebTarget createClient(String path) {
        String assembledPath = assembleEndpoint(path);
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(assembledPath);
        return target;
        
             
    }
    

        
                
    private String assembleEndpoint(String path) {
        String endpoint = url.concat(contextPath).concat(path);
        log.info(String.format("Calling endpoint %s", endpoint));
        return endpoint;
    }
}