package data.hotel;

import dataimpl.Hotel.HotelDataServiceFactory;
import dataservice.hoteldataservice.HotelDataService;
import org.junit.Ignore;
import org.junit.Test;
import po.HotelPO;
import po.HotelRoomPO;
import util.Place;
import util.ResultMessage;
import util.RoomType;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by SilverNarcissus on 16/11/13.
 */
public class HotelDataServiceImplTest {
    private HotelDataService hotelDataService;

    public HotelDataServiceImplTest() {
        hotelDataService = HotelDataServiceFactory.getHotelDataService();
    }

    @Test
    public void addHotel() throws Exception {
        ResultMessage resultMessage = hotelDataService.addHotel(new HotelPO("00000000", "Test hotel 1", "Nanjing University", Place.XIANLIN, 5, "The test hotel", "All"));
        ResultMessage resultMessage1 = hotelDataService.addHotel(new HotelPO("00000001", "Test hotel 2", "Nanjing Medical University", Place.XIANLIN, 4, "The test hotel", "All"));
        ResultMessage resultMessage2 = hotelDataService.addHotel(new HotelPO("00000002", "Test hotel 3", "Nanjing University", Place.XIANLIN, 3, "The test hotel", "All"));
        ResultMessage resultMessage3 = hotelDataService.addHotel(new HotelPO("00000003", "Test hotel 4", "Nanjing University", Place.XIANLIN, 5, "The test hotel", "All"));
        ResultMessage resultMessage4 = hotelDataService.addHotel(new HotelPO("00000004", "Test hotel 5", "Nanjing Technical University", Place.XIANLIN, 4, "The test hotel", "All"));
        assertEquals(ResultMessage.SUCCESS, resultMessage);

    }

    @Test
    public void addRoom() throws Exception {
        ResultMessage resultMessage = hotelDataService.addRoom(new HotelRoomPO("00000102", "000001", RoomType.SingleRoom, 258.5, 8,false));
        assertEquals(ResultMessage.SUCCESS, resultMessage);
    }

    @Test
    public void searchHotel() {
        ArrayList<HotelPO> hotelPOs = hotelDataService.prefixSearchHotel("address", "Nanjing");
        assertEquals(5, hotelPOs.size());
    }

    @Test
    public void getHotel() throws Exception {
        HotelPO hotelPO = hotelDataService.getHotel("00000001");
        assertEquals("00000001", hotelPO.getID());
    }

    @Test
    public void getRoom() throws Exception {
        ArrayList<HotelRoomPO> hotelRoomPOs = hotelDataService.getRoom("000001");
        assertEquals(1, hotelRoomPOs.size());
    }

    @Test
    public void updateHotel() throws Exception {
        ResultMessage resultMessage = hotelDataService.updateHotel(new HotelPO("00000001", "Hotel", "Nanjing News University", Place.XIANLIN, 5, "The test hotel", "All"));
        assertEquals(ResultMessage.SUCCESS, resultMessage);
    }

    @Test
    public void updateRoom() throws Exception {
        ResultMessage resultMessage = hotelDataService.updateRoom(new HotelRoomPO("00000102", "000001", RoomType.Suite, 888.5, 2,false));
        assertEquals(ResultMessage.SUCCESS, resultMessage);
    }

    @Test
    public void deleteHotel() throws Exception {
        ResultMessage resultMessage = hotelDataService.deleteHotel("00000102");
        assertEquals(ResultMessage.NOT_EXIST, resultMessage);
    }

    @Test
    public void deleteRoom() throws Exception {
        ResultMessage resultMessage = hotelDataService.deleteRoom("00000102");
        assertEquals(ResultMessage.NOT_EXIST, resultMessage);
    }


}