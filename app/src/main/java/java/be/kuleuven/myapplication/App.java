package java.be.kuleuven.myapplication;

public class App {

    private static Bike editBike;
    private static UserProfile user;
    private static String chooseBikeNextActivity;
    private static String toBeDeletedBikeId;

    public App(){
        //user = new UserProfile("koenraad", "testwachtwoord");
    }

    //editBike get en set
    public static Bike getEditBike() { return editBike;}
    public static void setEditBike(Bike editBike) { App.editBike = editBike; }

    //userProfile get en set
    public static UserProfile getUser(){ return user;}
    public static void setUser( UserProfile newUser){ user = newUser;}

    //ChooseBikeNextActivity get en set
    public static String getChooseBikeNextActivity() {
        return chooseBikeNextActivity;
    }
    public static void setChooseBikeNextActivity(String chooseBikeNextActivity) {App.chooseBikeNextActivity = chooseBikeNextActivity;}

    //toBeDeletedBikeId get en set
    public static String getToBeDeletedBikeId() { return toBeDeletedBikeId;}
    public static void setToBeDeletedBikeId(String toBeDeletedBikeId) { App.toBeDeletedBikeId = toBeDeletedBikeId;}
}
