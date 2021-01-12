package com;

import java.util.HashMap;

public class LoginCredentials {

    HashMap<String,String> logininfo = new HashMap<String,String>();

    LoginCredentials() {

        logininfo.put("jasmith","canErty6");
        logininfo.put("apbellow","Y$67975f");
    }


    protected HashMap<String, String> getLoginInfo() {
        return logininfo;
    }

}
