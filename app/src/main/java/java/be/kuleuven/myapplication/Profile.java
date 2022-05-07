package java.be.kuleuven.myapplication;

public  interface Profile {
    String getFirstName();
    String getLastName();
    void setName(String firstName, String lastName);
    String getUserName();
    void setUserName(String newUserName);
    void setPassword(String oldPassword, String newPassword);
    String getPassword();
    /*
    public void setAddress(String newAddress);
    public String getAddress();
     */
    void setPhoneNumber(String newPhoneNumber);
    String getPhoneNumber();

}
