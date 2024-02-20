package Controllers;
import Model.*;
import java.util.*;
import Dao.*;
import Views.AdminView;

public class adminController {
    public static void admin(){
             int choice = AdminView.adminwelcome();
             if(choice==1)
             {
                addBranchCon();
             }
             else if(choice==2)
             {
                    editNoOfRooms();
             }
    }
    public static void addBranchCon(){
        List<RoomTypes> list = RoomTypesDao.getRoomTypes();
        List<Branch> branch_list= AdminView.addBranch(list);
        BranchDao.createNewBranch(branch_list);
    }
    public static void editNoOfRooms(){
            String city = AdminView.editRoom_city();
            displayDao dis = new displayDao();
            List<List<String>> list=dis.display_city_query(city);
            AdminView.editRoom(List<List<String>> list);

    }
}
