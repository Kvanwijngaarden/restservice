package nl.hu.iac.service;

import org.json.JSONObject;

/**
 * Created by kvanwijngaarden on 25/03/2017.
 */
public class SunRiseImpl {
    LocationImpl locationImpl = ServiceProvider.getLocationImpl();

    public String getSunRise(String name, String date) {

        if (ValidateDate.validateDate(date)) {

            for (Location location : locationImpl.getAllLocations()) {

                if (location.getName().toUpperCase().equals(name.toUpperCase())) {

                    try {

                        JSONObject json = new JSONObject(ReadUrl.readUrl("http://api.sunrise-sunset.org/json?lat=" + location.getLat() + "&lng=-" + location.getLon() + "&date=" + date));
                        return "The sunrise in: " + name + " is at: " + json.getJSONObject("results").getString("sunrise");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return "400";
        }else{
            return "400";
        }
    }
}

