package java.be.kuleuven.myapplication;


public class Bike implements BikeFeatures{
    private String name;
    public Location bikeLocation;
    public UserProfile owner;

    public Bike(String name, Location location)
    {
        this.name = name;
        bikeLocation = location;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Location getLocation() {
        return this.bikeLocation;
    }

    @Override
    public void setLocation(Location location) {
        bikeLocation = location;
    }

    @Override
    public UserProfile getOwner() {
        return this.owner;
    }

    @Override
    public void setOwner(UserProfile userProfile) {
        owner = userProfile;
    }
}
