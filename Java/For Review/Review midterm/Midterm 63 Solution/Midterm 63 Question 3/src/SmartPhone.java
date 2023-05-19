import java.util.ArrayList;

public class SmartPhone extends Product { // Inheritance by extends Product

    // add the following class variables
    private String model = null; // Model of this smartphone
    private boolean used = false; // True if this is a used phone, false if this is a new phone.
    private ArrayList<App> apps = null; //list of apps installed on this phone.

    // implement the constructor
    public SmartPhone(double _basePrice, int _age, String _model, boolean _used) {
        super(_basePrice, _age); // appropriately calls the superclass’ constructor,
        this.apps = new ArrayList<App>();
        this.model = _model;
        this.used = _used;
    }

    @Override
    public double getPrice() {
        double hardware = super.getPrice() * (Math.pow(0.95, super.getAge()));
        double software = 0;
        for (App app : apps) {
            software += app.getPrice();
        }
        return hardware + software;
    }

    public String getModel() {
        return this.model; // Return the smartphone’s model.
    }

    public void install(App newApp) {
        apps.add(newApp); //  Add newApp to apps.
    }

    public void install(App[] newApps) {
        for (App app : newApps) {
            this.install(app); // Add every app in newApps to apps
        }
    }

    public void updateApp(String appTitle) {
        for (App app : this.apps) {
            if (app.getAppTitle().equals(appTitle)) {
                app.update(); // Update the app whose title is appTitle.
            }
        }
    }

    public void updateApp() {
        for (App app : apps) {
            app.update(); // Update every app installed on this phone.
        }
    }

}
