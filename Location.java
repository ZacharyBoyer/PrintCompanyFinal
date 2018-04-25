package Model;

/**
 *
 * @author Alessandro S
 */
public class Location {
    int id, distrCap;
    String locationName;
    
    public Location(){
    }
    //Location constructor with only id property
    public Location(int Id){
        id = Id;
    }
    //Location constructor with all properties
    public Location(int ID, String Name, int CAP){
        id = ID;
        locationName = Name;
        distrCap = CAP;
    }

    //getter and setter methods for location
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistrCap() {
        return distrCap;
    }

    public void setDistrCap(int distrCap) {
        this.distrCap = distrCap;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
