public class User implements Chattable {

    @Override
    public boolean checkValidUserID(int uID, int[][] listAllUser) {
        // TODO Auto-generated method stub
        for (int i = 0; i < listAllUser.length; i++) {
            for (int j = 0; j < listAllUser[i].length; j++) {
                if (listAllUser[i][j] == uID) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String msgToUserID(int uID, String message, int[][] listAllUser) {
        // TODO Auto-generated method stub
        if (checkValidUserID(uID, listAllUser)) {
            return uID + "|" + message;
        }
        return null;
    }

    @Override
    public String msgToUserIDs(int[] uID, String message, int[][] listAllUser) {
        // TODO Auto-generated method stub

        for (int i = 0; i < uID.length; i++) {
            if (checkValidUserID(uID[i], listAllUser)) {

            }
        }
        return null;
    }
}