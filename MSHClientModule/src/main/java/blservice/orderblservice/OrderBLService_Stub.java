package blservice.orderblservice;

import util.*;
import vo.AssessmentVO;
import vo.BillVO;
import vo.OrderRoomVO;
import vo.OrderVO;

import java.util.ArrayList;

/**
 * Created by Sorumi on 16/10/11.
 */
public class OrderBLService_Stub implements OrderBLService {

    public ResultMessage checkCredit() {
        return ResultMessage.SUCCESS;
    }

    public ResultMessage modifyDate(DateUtil start, DateUtil end) {
        if (start.equals(new DateUtil(2016, 11, 10))) {
            return ResultMessage.FAILED;
        } else {
            return ResultMessage.SUCCESS;
        }
    }

    public ResultMessage modifyRoomQuantity(RoomType type, int quantity) {
        if (type == RoomType.SingleRoom && quantity > 3) {
            return ResultMessage.FAILED;
        } else {
            return ResultMessage.SUCCESS;
        }
    }

    public BillVO getBill(String hotelID, String clientID, DateUtil date, DateUtil start, DateUtil end, int quantity) {
        return new BillVO(null, null, 300, 300);
    }

    public ResultMessage generateOrder(String hotelID, TimeUtil latest, int peopleQuantity, boolean hasChildren) {
        if (hotelID.equals("01011234"))
            return ResultMessage.SUCCESS;
        else
            return ResultMessage.FAILED;
    }


    public ResultMessage revokeOrder(String orderID) {
        if (orderID.equals("20161012010112340000")) {
            return ResultMessage.SUCCESS;
        } else {
            return ResultMessage.NOT_EXIST;
        }
    }

    public ResultMessage checkInOrder(String orderID, TimeUtil time) {
        if (orderID.equals("20161012010112340000")) {
            return ResultMessage.SUCCESS;
        } else {
            return ResultMessage.NOT_EXIST;
        }
    }

    public ResultMessage checkOutOrder(String orderID, TimeUtil time) {
        if (orderID.equals("20161012010112340000")) {
            return ResultMessage.SUCCESS;
        } else {
            return ResultMessage.NOT_EXIST;
        }
    }

    public ResultMessage editOrderAssessment(String orderID, AssessmentVO assessment) {
        if (orderID.equals("20161012010112340000"))
            return ResultMessage.SUCCESS;
        else
            return ResultMessage.NOT_EXIST;

    }

    public OrderVO searchOrderByID(String orderID) {
        if (orderID.equals("20161012010112340000")) {
            ArrayList<OrderRoomVO> rooms = new ArrayList<OrderRoomVO>();
            OrderRoomVO room1 = new OrderRoomVO(RoomType.DoubleRoom, 300, 1);
            rooms.add(room1);
            return new OrderVO("20161012010112340000", "01011234", "000000001", "喵喵酒店", "小茗同学", rooms,
                    new DateUtil(2016, 10, 12), new DateUtil(2016, 10, 13), null, null,
                    null, null, new TimeUtil(2016, 10, 11, 14, 0, 0), 2, false, OrderState.Unexecuted, new BillVO(null, null, 300, 280), null);
        } else {
            return null;
        }
    }

    public ArrayList<OrderVO> searchOrder(OrderState os, String keyword) {
        ArrayList<OrderVO> orderVOs = new ArrayList<OrderVO>();

        ArrayList<OrderRoomVO> rooms = new ArrayList<OrderRoomVO>();
        OrderRoomVO room1 = new OrderRoomVO(RoomType.DoubleRoom, 300, 1);
        rooms.add(room1);

        OrderVO order1 = new OrderVO("20161012010112340000", "01011234", "000000001", "喵喵酒店", "小茗同学", rooms,
                new DateUtil(2016, 10, 12), new DateUtil(2016, 10, 13), null, null,
                new TimeUtil(2016, 10, 10, 14, 0, 0), null, new TimeUtil(2016, 10, 11, 14, 0, 0), 2, false, OrderState.Unexecuted, new BillVO(null, null, 300, 280), null);

        OrderVO order2 = new OrderVO("20161012010112340001", "01011234", "000000001", "喵喵酒店", "小茗同学", rooms,
                new DateUtil(2016, 10, 12), new DateUtil(2016, 10, 13), new TimeUtil(2016, 10, 12, 14, 0, 0), null,
                new TimeUtil(2016, 10, 10, 14, 0, 0), null, new TimeUtil(2016, 10, 11, 14, 0, 0), 2, false, OrderState.Executed, new BillVO(null, null, 300, 280), new AssessmentVO(5,5,5,5, "很好很舒适"));

        OrderVO order3 = new OrderVO("20161012010112340002", "01011234", "000000001", "喵喵酒店", "小茗同学", rooms,
                new DateUtil(2016, 10, 12), new DateUtil(2016, 10, 13), null, null,
                new TimeUtil(2016, 10, 10, 14, 0, 0), null, new TimeUtil(2016, 10, 11, 14, 0, 0), 2, false, OrderState.Abnormal, new BillVO(null, null, 300, 280), null);

        OrderVO order4 = new OrderVO("20161012010112340003", "01011234", "000000001", "喵喵酒店", "小茗同学", rooms,
                new DateUtil(2016, 10, 12), new DateUtil(2016, 10, 13), null, null,
                new TimeUtil(2016, 10, 10, 14, 0, 0), new TimeUtil(2016, 10, 11, 14, 0, 0), new TimeUtil(2016, 10, 11, 14, 0, 0), 2, false, OrderState.Cancelled, new BillVO(null, null, 300, 280), null);

        OrderVO order5 = new OrderVO("20161012010112340003", "01011234", "000000001", "喵喵酒店", "小茗同学", rooms,
                new DateUtil(2016, 10, 12), new DateUtil(2016, 10, 13), null, null,
                new TimeUtil(2016, 10, 10, 14, 0, 0), new TimeUtil(2016, 10, 11, 14, 0, 0), new TimeUtil(2016, 10, 11, 14, 0, 0), 2, false, OrderState.Cancelled, new BillVO(null, null, 300, 280), null);

        if (os != null) {
            switch (os) {
                case Unexecuted:
                    orderVOs.add(order1);
                    break;
                case Executed:
                    orderVOs.add(order2);
                    break;
                case Abnormal:
                    orderVOs.add(order3);
                    break;
                case Cancelled:
                    orderVOs.add(order4);
                    break;
            }
        } else {
            orderVOs.add(order1);
            orderVOs.add(order2);
            orderVOs.add(order3);
            orderVOs.add(order4);
            orderVOs.add(order5);
        }

        return orderVOs;
    }

    public ArrayList<OrderVO> searchClientOrder(String clientID, OrderState os, String keyword) {
        if (clientID.equals("000000001"))
            return searchOrder(os, null);
        else
            return new ArrayList<OrderVO>();
    }

    public ArrayList<OrderVO> searchHotelOrder(String hotelID, OrderState os, String keyword) {
        if (hotelID.equals("01011234"))
            return searchOrder(os, null);
        else
            return new ArrayList<OrderVO>();
    }
}