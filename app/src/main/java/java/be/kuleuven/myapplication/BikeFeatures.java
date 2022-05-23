package java.be.kuleuven.myapplication;

public interface BikeFeatures {
    String getNumber();
    void setNumber(String number);
    BikeLocation getLocation();
    void setLocation(BikeLocation location);
    UserProfile getOwner();
    void setOwner(UserProfile userProfile);
    void setDescription(String description);
    String getDescription();



}
