package blservice.userblservice;

import util.*;
import vo.BillVO;
import vo.CreditVO;
import vo.OrderRoomVO;
import vo.OrderVO;

import java.util.ArrayList;

/**
 * Created by Kray on 2016/10/12.
 */
public class UserBLService_Driver {

    public void driver(UserBLService userBLService) {
        String userName = "admin";
        String password = "123456";
        String oldPassword = "123456";
        String newPassword = "1234567890";
        String clientID = "000000007";
        int credit = 20;

        CreditAction creditAction = CreditAction.ADD_CREDIT;

        LoginState loginState = userBLService.login(userName, password);
        if (loginState == LoginState.LOGIN_SUCCESS_Client) {
            System.out.println("LOGIN SUCCESS");
        } else if (loginState == LoginState.LOGIN_FAIL) {
            System.out.println("LOGIN FAIL");
        }
        loginState = userBLService.logout();
        if (loginState == LoginState.LOGOUT) {
            System.out.println("LOGOUT");
        }

        ResetState resetState = userBLService.reset(userName, oldPassword, newPassword);
        if (resetState == ResetState.RESET_SUCCESS) {
            System.out.println("RESET SUCCESS");
        } else if (resetState == ResetState.RESET_FAIL) {
            System.out.println("RESET FAIL");
        }

        ArrayList<OrderRoomVO> rooms = new ArrayList<OrderRoomVO>();
        OrderRoomVO room1 = new OrderRoomVO(RoomType.DoubleRoom, 300, 1);
        rooms.add(room1);

        OrderVO order1 = new OrderVO("20161012010112340000", "01011234", "000000001", rooms,
                new DateUtil(2016, 10, 12), new DateUtil(2016, 10, 13), null, null,
                null, null, new TimeUtil(2016, 10, 11, 14, 0, 0), 2, false, OrderState.Unexecuted, new BillVO(null, null, 300, 280), null);

        ResultMessage resultMessage = userBLService.addCreditRecord(clientID, new CreditVO(200, 700, CreditAction.ADD_CREDIT, order1,  new DateUtil(2016, 10, 13)));
        if (resultMessage == ResultMessage.EXIST) {
            System.out.println("EXIST");
        } else if (resultMessage == ResultMessage.SUCCESS) {
            System.out.println("SUCCESS");
        } else if (resultMessage == ResultMessage.FAILED) {
            System.out.println("FAIL");
        }

//        int creditByID = userBLService.searchCreditByID(clientID);
//        if(creditByID == 500){
//            System.out.println("SEARCH SUCCESS");
//        }else{
//            System.out.println("SEARCH FAIL");
//        }
    }

}
