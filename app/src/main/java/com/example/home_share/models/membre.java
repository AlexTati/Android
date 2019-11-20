package com.example.home_share.models;

import org.json.JSONObject;

public class membre {

    public int Id;
    public String Lastname;
    public String Firstname;
    public String Email;
    public String Phone;
    public String Username;
    public String Password;
    public int Role;
    public String Home_street;
    public String Home_num;
    public String Home_box;
    public int Home_city_id;
    public String Home_City_Name;
    public String Home_City_Zip;
    public int Home_Country_id;
    public String Home_Country_Name;
    public int Account_type;
    
    public membre(JSONObject o){
        
        try{
            Id = o.optInt("Id");
            Lastname = o.optString("Lastname");
            Firstname = o.optString("Firstname");
            Email = o.optString("Email");
            Phone = o.optString("Phone");
            Username = o.optString("Username");
            Password = o.optString("Password");
            Role = o.optInt("Role");
            Home_street = o.optString("Home_street");
            Home_num = o.optString("Home_num");
            Home_box = o.optString("Home_box");
            Home_city_id = o.getInt("Home_city_id");
            Home_City_Name = o.optString("Home_City_Name");
            Home_City_Zip = o.optString("Home_City_Zip");
            Home_Country_id = o.getInt("Home_Country_id");
            Home_Country_Name = o.optString("Home_Country_Name");
            Account_type = o.optInt("Account_type");
        }catch (Exception e) {

        }

    }
        
}
