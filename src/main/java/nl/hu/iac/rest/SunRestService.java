package nl.hu.iac.rest;

import java.util.List;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nl.hu.iac.service.*;

/**
 * Created by kvanwijngaarden on 20/03/2017.
 */
@Path("/sun")
public class SunRestService {
    LocationImpl locationImpl = ServiceProvider.getLocationImpl();
    SunRiseImpl sunRise = ServiceProvider.getSunRiseImpl();
    SunSetImpl sunSet = ServiceProvider.getSunSetImpl();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getSun() {

        String output = "The sun service is working! Hooray!";
        return Response.status(200).entity(output).build();
    }

    @Path("/locations")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllLocations() {

        if (locationImpl.getAllLocations().isEmpty()) {
            return Response.status(204).entity("There are no locations to display").build();
        } else {
            return Response.status(200).entity(locationImpl.getAllLocations()).build();
        }
    }

    @Path("/location/{name}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getlocationbyname(@PathParam("name") String name) {

        if (locationImpl.getLocationByName(name).equals("400")) {
            return Response.status(400).entity("There is no location with the name: " + name).build();
        } else {
            return Response.status(200).entity(locationImpl.getLocationByName(name)).build();
        }
    }

    @Path("location/{name}/{lat}/{lon}")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response createLocation(@PathParam("name") String name, @PathParam("lat") String lat, @PathParam("lon") String lon) {

        if(locationImpl.createLocation(name, lat, lon).equals("200")){
            return Response.status(200).entity("The location: " + name + " - " + lat + " - " + lon + " has been added.").build();
        }else{
            return Response.status(400).entity("The latitude or longitude are invalid or the location name already exist.").build();
        }
    }

    @Path("/sunrise/{name}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getSunRise(@PathParam("name") String name) {

        String date = "today";

        if (sunRise.getSunRise(name, date).equals("400")) {
            return Response.status(400).entity("There is no location with the name: " + name).build();
        } else {
            return Response.status(200).entity(sunRise.getSunRise(name, date)).build();
        }
    }

    @Path("/sunrise/{name}/{date}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getSunRiseWithDate(@PathParam("name") String name, @PathParam("date") String date) {

        if (sunRise.getSunRise( name, date ).equals("400")) {
            return Response.status(400).entity("There is no location with the name: " + name).build();
        } else {
            return Response.status(200).entity(sunRise.getSunRise( name, date )).build();
        }
    }

    @Path("/sunset/{name}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getSunSet(@PathParam("name") String name) {

        String date = "today";

        if (sunSet.getSunSet(name, date).equals("400")) {
            return Response.status(400).entity("There is no location with the name: " + name).build();
        } else {
            return Response.status(200).entity(sunSet.getSunSet(name, date)).build();
        }
    }

    @Path("/sunset/{name}/{date}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getSunSetWithDate(@PathParam("name") String name, @PathParam("name") String date) {

        if (sunSet.getSunSet(name, date).equals("400")) {
            return Response.status(400).entity("There is no location with the name: " + name).build();
        } else {
            return Response.status(200).entity(sunSet.getSunSet(name, date)).build();
        }
    }

}
