package java.be.kuleuven.myapplication;

import java.util.ArrayList;

public class app {

    private UserProfile userProfile;
    private Bike bike;
    private ArrayList<Bike> ;

    public app(){}

    //to add a new user to the database
    public void newUserProfile(String firstname, String lastname, String username, String password, String phonenumber){
        // TODO: 2/05/2022 input firstname en lastname filteren in database om dubbele acounts te vermijden
        userProfile = new UserProfile(firstname, lastname, password, username, phonenumber);
    }

    // to login en check with the database, then forwards you to the begin screen( the manage screen)
    public void login(String username, String password){
        // TODO: 2/05/2022 in database kijken of dit account bestaat
    }

    // bike toevoegen aan profiel
    public void addBike()
    {

    }








}
