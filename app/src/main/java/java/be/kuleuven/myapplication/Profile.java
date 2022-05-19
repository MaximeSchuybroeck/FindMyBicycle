package java.be.kuleuven.myapplication;

public  interface Profile {
    String getUserName();
    void setUserName(String newUserName);
    void setPassword( String newPassword);
    String getPassword();
    /*
    public void setAddress(String newAddress);
    public String getAddress();
     */
    void setPhoneNumber(String newPhoneNumber);
    String getPhoneNumber();

}
