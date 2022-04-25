package java.be.kuleuven.myapplication;//package be.kuleuven.findmybicycle;

public  interface Profile {
    public String getFirstName();
    public String getLastName();
    public void setName(String firstName, String lastName);
    public void setPassword(String newPassword);
    public void setAddress(String newAddress);
    public String getAddress();
    public void setPhoneNumber(String newPhoneNumber);
    public String getPhoneNumber();

}
