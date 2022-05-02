package java.be.kuleuven.myapplication;

import java.util.ArrayList;

public class UserProfile implements Profile
{
    private String userName;
    private String phoneNumber;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private ArrayList<Bike> bikeList;

    public UserProfile(String firstName, String lastName, String newPassword, String userName, String newPhoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = newPassword;
        this.userName = userName;
        this.phoneNumber = newPhoneNumber;
        bikeList = new ArrayList<Bike>();
    }
    public UserProfile(String userName, String newPassword){
        this.userName = userName;
        this.password = newPassword;
    }
    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
    
    @Override
    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public ArrayList<Bike> getBikeList(){return bikeList;}
    
    public void addBikeList(Bike bike){
        bikeList.add(bike);
        // TODO: 2/05/2022 uploaden naar database 
    }
    
    /*
    @Override
    public void setAddress(String newAddress) {
        this.address = newAddress;
    }
    @Override
    public String getAddress() {
        return this.address;
    }
    */
    
}
