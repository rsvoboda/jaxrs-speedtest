package com.github.K0zka.dummywarhead;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("hello")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HelloService {
    @GET
    public String greet(@QueryParam("name") String name) {
        return "Hello "+ (name == null ? "world" : name) + "!";
    }

    @GET
    @Path("advanced")
    public AdvancedHello advancedGreet(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName) {
        AdvancedHello hello = new AdvancedHello();
        hello.setLangCode("en");
        hello.setTimeStamp(new Date());
        hello.setGreetingFrom(new Person("Eugene", "Cuckoo"));
        hello.setGreetingTo(new Person(firstName, lastName));
        hello.setOfficial(false);
        hello.setMessage("Dear Mr/Mrs "+lastName + ",\n\n Hello.\n\nKind regards,\nEugene Cuckoo");
        return hello;
    }
}
