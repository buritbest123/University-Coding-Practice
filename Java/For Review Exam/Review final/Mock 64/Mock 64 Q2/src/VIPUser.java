public class VIPUser extends User implements Searchable{

    @Override
    public int findUserIDByAge(int age, int[][] listAllUser) {
        for (int i = 0; i < listAllUser[1].length - 1; i++) {
            if (age == listAllUser[1][i]) {
                return listAllUser[0][i];
            }
        }
        return -1;
    }

    @Override
    public boolean checkValidUserID(int uID, int[][] listAllUser) {
        for (int[] rows : listAllUser) {
            for (int columns : rows) {
                if (columns == uID) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String msgToUserID(int uID, String message, int[][] listAllUser) {
        if (checkValidUserID(uID, listAllUser)) {
            return uID + "|" + message;
        }
        else {
            return "0";
        }
    }

    @Override
    public String msgToUserIDs(int[] uID, String message, int[][] listAllUser) {
        return super.msgToUserIDs(uID, message, listAllUser);
    }
}