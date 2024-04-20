import util.Driver;
import util.Initializer;

public class MobileSoftwareMain {
    public static void main(String[] args) {
        Initializer.initializeApplication();
        Driver driver = new Driver();
        driver.drive();
    }
}
