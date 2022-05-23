package java.be.kuleuven.myapplication;

public interface BikeFeatures {
    int getNumber();
    void setNumber(int number);
    BikeLocation getLocation();
    void setLocation(BikeLocation location);
    UserProfile getOwner();
    void setOwner(UserProfile userProfile);
    void setDescription(String description);
    String getDescription();



}
