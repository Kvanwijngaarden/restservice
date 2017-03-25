package nl.hu.iac.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kvanwijngaarden on 25/03/2017.
 */

public class LocationImpl {
    private List<Location> locations = new ArrayList<Location>();
    protected static final String LATITUDE_PATTERN="^(\\+|-)?(?:90(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\.[0-9]{1,6})?))$";
    protected static final String LONGITUDE_PATTERN="^(\\+|-)?(?:180(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[0-7][0-9])(?:(?:\\.[0-9]{1,6})?))$";


    public LocationImpl() {
        locations.add(new Location("Paris", "48.865899", "2.330247"));
        locations.add(new Location("Berlin", "52.519233", "13.395483"));
    }

    private void addLocationToList(Location loc) {
        locations.add(loc);
    }

    public String createLocation(String name, String lat, String lon) {

        boolean latitude = lat.matches(LATITUDE_PATTERN);
        boolean longitude = lon.matches(LONGITUDE_PATTERN);
        boolean locationExist = false;

        for (Location location : locations) {
            if (location.getName().toUpperCase().equals(name.toUpperCase())) {
                locationExist = true;
            }
        }

        if (latitude && longitude && !locationExist){
            Location loc = new Location(name, lat, lon);
            addLocationToList(loc);

            return "200";
        }else{
            return "400";
        }

    }

    public List<Location> getAllLocations() {
        return locations;
    }

    public String getLocationByName(String name) {

        for (Location location : locations) {
            if (location.getName().toUpperCase().equals(name.toUpperCase())) {
                return location.getName() + " - " + location.getLat() + " - " + location.getLon();
            }
        }

        return "400";

    }


}
