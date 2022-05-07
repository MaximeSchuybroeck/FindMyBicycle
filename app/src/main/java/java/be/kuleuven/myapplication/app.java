package java.be.kuleuven.myapplication;

import java.util.ArrayList;

public class app {

    private UserProfile userProfile;
    private Bike bike;
    private UserProfile user;

    public app(){

    }
    //// LOGIN SCREEN ////

    // to login en check with the database, then forwards you to the begin screen( the manage screen)
    public void login(String username, String password){
        // TODO: 2/05/2022 in database kijken of dit account bestaat
    }

    //to add a new user to the database
    public void newUserProfile(String firstname, String lastname, String username, String password, String phonenumber){
        // TODO: 2/05/2022 input firstname en lastname filteren in database om dubbele acounts te vermijden
        userProfile = new UserProfile(firstname, lastname, password, username, phonenumber);
    }


    //// BIKE SCREEN ////

    // Adds a bike to a profile
    public void addBike(String name){
        bike = new Bike(name);
        user.addBikeList(bike);
    }
    // Edit an existing bike
    public void editBike(Bike bike, String newName){
        bike.setName(newName);
    }

    //// ACCOUNT SCREEN ////

    //edit account names
    public void editFirstname(String newFirstname, String newLastname){
        user.setName(newFirstname, newLastname);
    }

    //edit Username
    public void editUsername(String newUsername){
        // TODO: 7/05/2022 vraag of we in app.java telekens gaan linken naar de database, of in de classes zoals userProfile zelf
        user.setUserName(newUsername);
    }
}
