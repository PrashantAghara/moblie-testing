package util;

import database.MobileDB;

public class Initializer {
    public static void initializeApplication() {
        MobileDB.initializeMobileDB();
    }
}
