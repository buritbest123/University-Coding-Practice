public interface Chattable {
    public boolean checkValidUserID(int uID, int [][] listAllUser);
    public String msgToUserID(int uID, String message, int [][] listAllUser);
    public String msgToUserIDs(int[] uID, String message, int [][] listAllUser);
}