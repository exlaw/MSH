package ui.viewcontroller.client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import main.Main;
import vo.OrderVO;

import java.io.IOException;
import java.util.Stack;

/**
 * Created by Sorumi on 16/11/24.
 */
public class ClientOrderViewController {

    private BorderPane rootPane;

    private Node initNode;
    private Stack<Node> stack = new Stack<Node>();

    public ClientOrderViewController(BorderPane rootPane) {
        this.rootPane = rootPane;
    }

    /**
     * 返回上一界面
     */
    public void back() {
        if (!stack.empty()) {
            Node node = stack.pop();
            rootPane.setCenter(node);

        }
    }

    /**
     * 客户订单列表
     */
    public void showClientOrderList() {
        if (initNode != null) {
            rootPane.setCenter(initNode);
            return;
        }

        System.out.print("!!!");
        try {
            FXMLLoader listLoader = new FXMLLoader();
            listLoader.setLocation(Main.class.getResource("../view/client/ClientOrderListView.fxml"));
            ScrollPane list = listLoader.load();

            ClientOrderListViewController clientOrderListViewController = listLoader.getController();
            clientOrderListViewController.setClientViewController(this);

            initNode = list;
//            stack.push(list);

            rootPane.setCenter(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 客户订单详情
     */
    public void showClientOrderDetail(OrderVO order) {

        try {
            FXMLLoader orderLoader = new FXMLLoader();
            orderLoader.setLocation(Main.class.getResource("../view/client/ClientOrderDetailView.fxml"));
            ScrollPane view = orderLoader.load();

            ClientOrderDetailViewController clientOrderDetailViewController = orderLoader.getController();
            clientOrderDetailViewController.setClientViewController(this);
            clientOrderDetailViewController.showOrder(order);

//            stack.push(view);
            Node node = rootPane.getCenter();
            stack.push(node);

            rootPane.setCenter(view);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}