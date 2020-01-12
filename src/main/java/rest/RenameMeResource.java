package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Dayplan;
import utils.EMF_Creator;
import facades.FacadeExample;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

//Todo Remove or change relevant parts before ACTUAL use
@Path("person")
public class RenameMeResource {

    private static EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final FacadeExample FACADE =  FacadeExample.getFacadeExample(EMF);
    //private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getPersonCount() {
        long count = FACADE.getPersonCount();
        return "{\"count\":"+count+"}";
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllPersons() {
        List<Dayplan> dayplans = FACADE.getAllPersons();
        return GSON.toJson(dayplans);
    }

    /*@Path("name/{firstName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonsByFirstName(Dayplan entity, @PathParam("firstName") String firstName) throws NotFoundException, ParseException, IOException {
        List<Dayplan> dayplans = FACADE.getAllPersons();
        List<Dayplan> sortedPersonsByFirstName = new ArrayList<>();
        for (Dayplan p : dayplans) {
            if (p.getFirstName().equalsIgnoreCase(firstName)) {
                sortedPersonsByFirstName.add(p);
            }
        }
        if(sortedPersonsByFirstName.isEmpty()){throw new NotFoundException("Der blev ikke fundet nogen person med dette navn");}
            return GSON.toJson(sortedPersonsByFirstName);
    }*/
}