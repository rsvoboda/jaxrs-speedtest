package com.github.K0zka.dummywarhead.jaxrsjersey;

import com.github.K0zka.dummywarhead.HelloService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class Application extends ResourceConfig {
     public Application() {
         register(RequestContextFilter.class);
         register(HelloService.class);
     }
}
