package com.example.home_share.services;


import com.example.home_share.models.membre;

public class auth {

    public static membre localUser;


    public static void setCurrentUser(membre u){
        localUser = u;
    }

    public static boolean isLogged(){
        return (localUser != null);
    }




}
