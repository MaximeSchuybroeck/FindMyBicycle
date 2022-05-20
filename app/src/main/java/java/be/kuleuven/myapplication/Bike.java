package java.be.kuleuven.myapplication;


public class Bike implements BikeFeatures{
    private String name;
    public BikeLocation bikeLocation;
    //public UserProfile owner;
    private String description;

    //niet meer van toepassing normaal gezien
    //public Bike(String name) {
    //    this.name = name;
    //    bikeLocation = null;
    //    this.description = "";
    //    setOwner(app.getUser());
    //}

    public Bike(String name,String description) {
        this.name = name;
        this.description = description;
        bikeLocation = null;
        setOwner(App.getUser());
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
        return App.getUser();
    }

    @Override
    public void setOwner(UserProfile userProfile) {
        App.setUser(userProfile);
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
