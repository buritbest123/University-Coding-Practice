public class App extends Product { // Inheritance by extends Product

    private String appTitle; // //Title of the app

    // implement the constructor
    public App(double _basePrice, int _age, String _appTitle) {
        super(_basePrice, _age); // appropriately calls the superclass’ constructor.
        // set appTitle to _appTitle.
        this.appTitle = _appTitle;
    }

    @Override
    public double getPrice() {
        return super.getPrice() * (Math.pow(0.95, super.getAge()));
    }

    public String getAppTitle() {
        return this.appTitle; // Return the title of the app.
    }

    public void update() {
        super.setAge(0); // Reset the age of the app to 0.
    }

}
