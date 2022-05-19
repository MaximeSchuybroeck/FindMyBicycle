package java.be.kuleuven.myapplication;

import java.util.ArrayList;

public class UserProfile implements Profile
{
    private String userName;
    private String phoneNumber;
    protected String password;
    private static ArrayList<Bike> bikeList;


    public UserProfile( String userName, String newPassword, String newPhoneNumber){
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
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String newUserName) {
        // TODO: 7/05/2022 checken met database of input UNIEK is 
        // TODO: 7/05/2022 miss methode veranderen in een boolean teruggave, dat de methode teruggeeft of de EDIT succesvol was of niet 
        this.userName = newUserName;
    }
    
    @Override
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    @Override
    public String getPassword() {
        return password;
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
    public void addStringBikeList(String bikeName, String bikeDescription) {
        Bike addBike = new Bike(bikeName, bikeDescription);
        bikeList.add(addBike);
    }

    public boolean isMemberBikeList(String bikeName){
        for (int i = 0; i < bikeList.size(); i++){
            if(bikeList.get(i).getName().equals(bikeName)){
                return true;
            }
        }
        return false;
    }

}
