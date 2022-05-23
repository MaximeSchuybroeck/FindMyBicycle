package java.be.kuleuven.myapplication;


import android.app.Activity;
import java.util.ArrayList;

public class UserProfile extends Activity implements Profile
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
        bikeList = new ArrayList<Bike>();
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
    public void setBikeList(ArrayList<Bike> newList){
        bikeList = newList;
    }

    public void addBikeList(Bike bike){
        bikeList.add(bike);
    }

    public boolean isMemberBikeList(String bikeDiscription){
        for (int i = 0; i < bikeList.size(); i++){
            if(bikeList.get(i).getDescription().equals(bikeDiscription)){
                return true;
            }
        }
        return false;
    }



}
