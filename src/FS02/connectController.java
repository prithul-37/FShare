package FS02;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class connectController {

    String IP = null;
    int port = 0;
    static Socket socket = null;

    @FXML
    private TextField enterIP;

    @FXML
    private TextField enterPort;

    @FXML
    private Button connect;

    @FXML
    private Button cont;

    @FXML
    private Text confirm;

    @FXML
    void connectx(ActionEvent event) throws IOException {
        IP = enterIP.getText();
        port = Integer.parseInt(enterPort.getText());
        socket = new Socket(IP,port);
        confirm.setText("connected");
        cont.setDisable(false);

    }

    @FXML
    void cont(ActionEvent event) throws IOException {
        Main.setRoot("step3");
    }
    @FXML
    private Button EXIT;

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    double x,y ;

    @FXML
    void Move(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    void Move1(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

}
