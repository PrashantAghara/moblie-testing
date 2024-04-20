package dao;

import database.MobileDB;
import exception.MobileNotFoundException;
import model.Mobile;

import java.util.List;

public class MobileDAO {
    private final MobileDB mobileDB;

    public MobileDAO() {
        this.mobileDB = new MobileDB();
    }

    public List<Mobile> getAllAvailableMobiles() {
        return mobileDB.getAllMobiles().stream().filter(Mobile::getAvailable).toList();
    }

    public Mobile getMobileByName(String name) {
        Mobile mobile = mobileDB.getMobileByName(name);
        if (mobile == null) {
            throw new MobileNotFoundException("Mobile not found with name : " + name);
        }
        return mobile;
    }

    public void setMobileInDB(Mobile mobile) {
        mobileDB.setMobileInDB(mobile);
    }
}
