package java.be.kuleuven.myapplication;

public class UserProfile implements Profile
{
    private String userName;
    private String phoneNumber;
    private String password;
    private String firstName;
    private String lastName;

    public UserProfile(String firstName, String lastName, String newPassword, String userName, String newPhoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = newPassword;
        this.userName = userName;
        this.phoneNumber = newPhoneNumber;
    }
    public UserProfile(String userName, String newPassword){
        this.userName = userName;
        this.password = newPassword;
    }
    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
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
    /*
    @Override
    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    @Override
    public String getAddress() {
        return address;
    }
    */
    @Override
    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
