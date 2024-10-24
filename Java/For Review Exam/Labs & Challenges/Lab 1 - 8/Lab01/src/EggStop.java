public class EggStop {
    public static void Egg_Fall(){
        System.out.println("""
                  ______\s
                 /      \\\s
                /        \\
                \\        /\s
                 \\______/
                """);
    }

    public static void Egg_Stop(){
        System.out.println("""
                  ______\s
                 /      \\\s
                /        \\
                |  STOP  |
                \\        /\s
                 \\______/
                +--------+
                """);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
            Egg_Fall();
            Egg_Fall();
        System.out.println("+--------+");
            Egg_Stop();
    }
}