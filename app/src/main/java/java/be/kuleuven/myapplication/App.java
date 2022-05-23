package java.be.kuleuven.myapplication;

public class App {

    private static Bike editBike;
    private static UserProfile user;
    private static String chooseBikeNextActivity;

    public App(){
        user = new UserProfile("koenraad", "testwachtwoord");
        Bike testBike = new Bike("bike1", "test");
        setEditBike(testBike);
        user.getBikeList().add(testBike);
    }

    public static Bike getEditBike() {
        return editBike;
    }

    public static void setEditBike(Bike editBike) {
        App.editBike = editBike;
    }


    //userProfile getters en setters
    public static UserProfile getUser(){ return user;}
    public static void setUser( UserProfile newUser){ user = newUser;}

    //ChooseBikeNextActivity get en set
    public static String getChooseBikeNextActivity() {
        return chooseBikeNextActivity;
    }
    public static void setChooseBikeNextActivity(String chooseBikeNextActivity) {
        App.chooseBikeNextActivity = chooseBikeNextActivity;
    }
}
