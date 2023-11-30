package FS02;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class sendController {

    Socket thisSocket = null;
    DataOutputStream dataOutputStream = null;
    File fileToSend = null;
    OutputStream OS = null;

    @FXML
    private Button select;

    @FXML
    private TextField fileSize;

    @FXML
    private Button send;

    @FXML
    private TextField fileName;

    @FXML
    private Button sendAgain;

    @FXML
    private Button Receive;

    @FXML
    private Text status;

    @FXML
    private Button sendInfo;

    @FXML
    void receiveBtn(ActionEvent event) throws IOException {
      Main.setRoot("Receive");
    }

    @FXML
    void selectBtm(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose File");
        fileToSend = fileChooser.showOpenDialog(null);
        fileName.setText(fileToSend.getName());
        long size = fileToSend.length();
        if (size/1024 <=1000){
            fileSize.setText(String.valueOf(size/1024)+" KB");
        }
        else{
            fileSize.setText(String.valueOf(size/(1024*1024))+" MB");
        }
        status.setText("File selected");

        if(hostController.socket != null) thisSocket = hostController.socket;
        else thisSocket = connectController.socket;
    }

    @FXML
    void sendAgainBtn(ActionEvent event) throws IOException {
     Main.setRoot("Send");
    }

    @FXML
    void sendBtn(ActionEvent event) {
    }

    @FXML
    void sendInfo(ActionEvent event) throws IOException {
        OS = thisSocket.getOutputStream();
        dataOutputStream = new DataOutputStream(OS);
        dataOutputStream.writeUTF(fileToSend.getName());
        dataOutputStream.writeLong(fileToSend.length());
        dataOutputStream.flush();
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
