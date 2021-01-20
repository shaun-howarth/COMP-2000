package com;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;
import static java.util.Map.entry;

public class LoginCredentials {

    Map<String, String> logininfo = Map.ofEntries(
            entry("jasmith", "canErty6"),
            entry("apbellow", "Y$67975f")


    );


    LoginCredentials() {

        logininfo.put("jasmith","canErty6");
        logininfo.put("apbellow","Y$67975f");
    }


    protected Map<String, String> getLoginInfo() {

        return logininfo;

    }

}
