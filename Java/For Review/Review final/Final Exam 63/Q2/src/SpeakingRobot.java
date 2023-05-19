import java.util.List;

public class SpeakingRobot extends Robot{
    public SpeakingRobot (String _name, int _x, int _y) { // Constructor
        // Your code goes here
        super(_name, _x, _y);
    }

    public SpeakingRobot(String _name) { // Another Constructor
        // Your code goes here
        super(_name);
    }

    public void greeting(List<Robot> robots){
        System.out.print("Hi [");
        String result = "";
        for (int i = 0; i < robots.size(); i++) {
            if (robots.get(i).getLocation().equals(this.getLocation())) {
                result += robots.get(i).getName() + ", ";
            }
        }
        if (result.length() > 0) {
            result = result.substring(0, result.length() - 2);
        }
        System.out.print(result);
        System.out.print("], I'm " + this.getName() + ". Nice to meet you\n");
    }
}