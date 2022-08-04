package com.dao.operations;


public class InputSecurity {

    public static void checkSession() {
        if (UserManager.session == null) {
            System.exit(0);
        }
    }
}
