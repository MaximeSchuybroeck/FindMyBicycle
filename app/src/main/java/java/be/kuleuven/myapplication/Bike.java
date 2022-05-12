package java.be.kuleuven.myapplication;


import android.view.View;

public class Bike implements BikeFeatures{
    private String name;
    public BikeLocation bikeLocation;
    public UserProfile owner;
    private String description;

    public Bike(String name)
    {
        this.name = name;
        bikeLocation = null;
        this.description = null;
    }

    public Bike(String name, String description)
    {
        this.name = name;
        this.description = description;
        bikeLocation = null;
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
    public BikeLocation getLocation() {
        return this.bikeLocation;
    }

    @Override
    public void setLocation(BikeLocation location) {
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

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return this.description;
    }


}
