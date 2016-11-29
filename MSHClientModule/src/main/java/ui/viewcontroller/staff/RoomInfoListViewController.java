package ui.viewcontroller.staff;

import bl.hotelbl.HotelBLFactory;
import blservice.hotelblservice.HotelBLService;
import blservice.hotelblservice.HotelBLService_Stub;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.Main;
import ui.componentcontroller.hotel.RoomInfoCellController;
import ui.componentcontroller.hotel.RoomInfoShowHeaderPaneController;
import vo.HotelRoomVO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by SilverNarcissus on 2016/11/27.
 */
public class RoomInfoListViewController {
    //上层组件
    private RoomInfoViewController roomInfoViewController;

    @FXML
    private VBox contentVBox;

    // for time
    private FXMLLoader[] cellLoaders = new FXMLLoader[3];
    private Node[] cells = new Node[3];


    private HotelBLService hotelBLService;

    /**
     * Initializes the ClientOrderListViewController class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    public void initialize() {
        hotelBLService = HotelBLFactory.getHotelBLService();

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../component/hotel/RoomInfoViewHeaderPane.fxml"));
            VBox pane = loader.load();

            RoomInfoShowHeaderPaneController roomInfoShowHeaderPaneController=loader.getController();
            roomInfoShowHeaderPaneController.setRoomInfoListViewController(this);

            contentVBox.getChildren().add(pane);

            for (int i = 0; i < 3; i++) {
                FXMLLoader cellLoader = new FXMLLoader();
                cellLoader.setLocation(Main.class.getResource("../component/hotel/HotelRoomInfoCell.fxml"));
                HBox roomCell = cellLoader.load();

                cellLoaders[i] = cellLoader;
                cells[i] = roomCell;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setRoomInfoViewController(RoomInfoViewController roomInfoViewController) {
        this.roomInfoViewController = roomInfoViewController;
    }

    public void showRooms() {
//TODO 酒店ID从哪里获得？
//        contentVBox.getChildren().remove(1, contentVBox.getChildren().size()-1);
        for (Node cell : cells) {
            contentVBox.getChildren().remove(cell);
        }

        ArrayList<HotelRoomVO> hotelRoomVOs = hotelBLService.getRoom("00000000");
//        try {
        for (int i = 0; i < hotelRoomVOs.size() && i < 3; i++) {
//                FXMLLoader loader = new FXMLLoader();
//                loader.setLocation(Main.class.getResource("../component/order/OrderCell.fxml"));

            HotelRoomVO hotelRoomVO = hotelRoomVOs.get(i);
            FXMLLoader loader = cellLoaders[i];
            Node roomCell = cells[i];

            RoomInfoCellController roomInfoCellController = loader.getController();
            roomInfoCellController.setRoomInfoListViewController(this);
            roomInfoCellController.setRoom(hotelRoomVO);

            contentVBox.getChildren().add(roomCell);
        }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}