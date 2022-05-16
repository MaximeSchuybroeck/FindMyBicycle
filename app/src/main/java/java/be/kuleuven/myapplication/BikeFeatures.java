package java.be.kuleuven.myapplication;

public interface BikeFeatures {
    String getName();
    void setName(String name);
    BikeLocation getLocation();
    void setLocation(BikeLocation location);
    UserProfile getOwner();
    void setOwner(UserProfile userProfile);
    void setDescription(String description);
    String getDescription();



}
