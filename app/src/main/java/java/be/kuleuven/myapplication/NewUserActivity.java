package java.be.kuleuven.myapplication;

import android.app.Activity;
import android.os.Bundle;

public class NewUserActivity extends Activity {
    private UserProfile newUser;
    private String userName;
    private String phoneNumber;
    protected String password;
    private String firstName;
    private String lastName;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        newUser = new UserProfile("","","","","");
    }

    public void setFirstName(String name){

    }
}
