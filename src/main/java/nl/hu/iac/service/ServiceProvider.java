package nl.hu.iac.service;


public class ServiceProvider {
    private static LocationImpl location = new LocationImpl();
    private static SunRiseImpl sunrise = new SunRiseImpl();
    private static SunSetImpl sunset = new SunSetImpl();

    public static LocationImpl getLocationImpl() {

        return location;
    }

    public static SunRiseImpl getSunRiseImpl() {

        return sunrise;
    }

    public static SunSetImpl getSunSetImpl() {

        return sunset;
    }

}