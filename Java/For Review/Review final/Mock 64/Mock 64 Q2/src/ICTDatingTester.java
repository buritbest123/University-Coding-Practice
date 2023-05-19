public class ICTDatingTester {

    public static void sortListCustomerByAge(int [][] listUser) {
        for (int i = 0; i < listUser[1].length-1; i++)
            for (int j = 0; j < listUser[1].length-i-1; j++)
                if (listUser[1][j] > listUser[1][j+1]) {
                    for(int k=0; k < 3;k++) {
                        int temp = listUser[k][j];
                        listUser[k][j] = listUser[k][j+1];
                        listUser[k][j+1] = temp;
                    }
                }
    }

    public static void main(String[] args) {
        int [][] listUser = {{20,30,10,50,60,40,1,5,7,3,2,4,6,15},			// UserID
                			{18,17,21,20,19,22,25,28,27,34,30,31,32,29},    // Age
				            {1,0,0,0,1,1,1,0,0,1,0,1,0,1,0}};               // Gender


        //===== TASK 1 =====
        //Uncomment for TASK1

	System.out.println("@Test Task1");
	User normal = new User();
	System.out.println(normal.checkValidUserID(1, listUser));
	System.out.println(normal.checkValidUserID(8, listUser));

	int[] friendID = {1,2,300};
	System.out.println(normal.msgToUserID(1, "Test Message", listUser));
	System.out.println(normal.msgToUserIDs(friendID, "Test BroadCast", listUser));
	System.out.println();


        //===== TASK 2 =====
        //Uncomment for TASK2

	System.out.println("@Test Task2");
	VIPUser vip = new VIPUser();
	System.out.println(vip.checkValidUserID(17, listUser));

	int[] friendID2 = {1,2,3,4};
	System.out.println(vip.msgToUserID(17, "VIP Message", listUser));
	System.out.println(vip.msgToUserIDs(friendID2, "VIP Broadcast", listUser));

	sortListCustomerByAge(listUser);

	System.out.print("Find uID of AGE 18 = "+ vip.findUserIDByAge(18, listUser));
	System.out.print("\nFind uID of AGE 35 = "+ vip.findUserIDByAge(35, listUser));


    }
}