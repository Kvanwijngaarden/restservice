package nl.hu.iac.rest;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by kvanwijngaarden on 25/03/2017.
 */

public class SunRestServiceTest {
    SunRestService restService = new SunRestService();

    @Test
    public void getAllLocations() throws Exception {
        assertEquals("getAllLocations should be 200", 200, restService.getAllLocations().getStatus());
    }

    @Test
    public void getlocationbyname() throws Exception {
        assertEquals("getlocationbyname should be 200", 200, restService.getlocationbyname("Paris").getStatus());
        assertEquals("getlocationbyname should be 200", 400, restService.getlocationbyname("Amsterdam").getStatus());
    }

    @Test
    public void createLocation() throws Exception {
        assertEquals("createLocation should be 200", 200, restService.createLocation("Amsterdan", "20", "20").getStatus());
        assertEquals("createLocation should be 200", 400, restService.createLocation("Amsterdan", "20", "20").getStatus());
    }

    @Test
    public void getSunRise() throws Exception {
        assertEquals("getSunRise should be 200", 200, restService.getSunRise("Paris").getStatus());
        assertEquals("getSunRise should be 200", 400, restService.getlocationbyname("Amsterdam").getStatus());
    }

    @Test
    public void getSunSet() throws Exception {
        assertEquals("getSunSet should be 200", 200, restService.getSunSet("Paris").getStatus());
        assertEquals("getSunSet should be 400", 400, restService.getlocationbyname("Amsterdam").getStatus());
    }

}