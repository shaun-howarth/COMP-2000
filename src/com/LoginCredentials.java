package com;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;
import static java.util.Map.entry;

public class LoginCredentials {

    Map<String, String> logininfo = Map.ofEntries(
            entry("a", "jasmith"),
            entry("b", "canErty6"),
            entry("c", "apbellow"),
            entry("d", "Y$67975f")

    );


    LoginCredentials() {

        logininfo.put("jasmith","canErty6");
        logininfo.put("apbellow","Y$67975f");
    }


    protected Map<String, String> getLoginInfo() {

        return logininfo;

    }

}
