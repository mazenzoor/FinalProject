package cloud.thecode.finalproject;

/**
 * Created by Mazen on 1/18/2018.
 */

public class Place {
    String longitude, latitude;

    public Place(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Place() {}

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Long: " + longitude + ", Lat: " + latitude;
    }
}
