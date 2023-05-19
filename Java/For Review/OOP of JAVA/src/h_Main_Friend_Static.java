public class h_Main_Friend_Static {

    public static void main(String[] args) {

        // static = modifier. A single copy of a variable/method is created and shared.
        //			The class "owns" the static member

        h_Friend friend1 = new h_Friend("Sponegbob");
        h_Friend friend2 = new h_Friend("Patrick");
        h_Friend friend3 = new h_Friend("Patrick");

        System.out.println(h_Friend.numberOfFriends);
    }
}