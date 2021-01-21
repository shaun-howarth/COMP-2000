package com;

import java.util.Map;
import java.lang.String;
import static java.util.Map.entry;


public class LoginCredentials {

    //HashMap used for AdminPage Login
    Map<String, String> logininfo = Map.ofEntries(
            entry("jasmith", "canErty6"),
            entry("apbellow", "Y$67975f")
    );


    //Constructor used to put character values for each of the KEYs and Values from the two HashMap entries
    LoginCredentials() {

        logininfo.put("jasmith","canErty6");
        logininfo.put("apbellow","Y$67975f");
    }


    // Getter method used to return logininfo object
    protected Map<String, String> getLoginInfo() {

        return logininfo;

    }

}
