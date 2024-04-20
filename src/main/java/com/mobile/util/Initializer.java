package com.mobile.util;

import com.mobile.database.MobileDB;

public class Initializer {
    public static void initializeApplication() {
        MobileDB.initializeMobileDB();
    }
}
