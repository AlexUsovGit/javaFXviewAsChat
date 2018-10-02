package com.uaa.javamsgfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    @FXML
    private ScrollPane msgScroll;
    @FXML
    private VBox msgVBox;
    @FXML
    private TextArea msgInput;
    @FXML
    private Button btnMsgSend;
    @FXML
    private TextArea msgField;

    private void sendMsg() {
        msgField.appendText(msgInput.getText() + "\n");
        msgInput.clear();
    }

    private String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private void addMsg() {

        Label usrLabel = new Label("user send:");
        usrLabel.setTextFill(Color.web("#0076a3"));
        usrLabel.setFont(new Font("Arial", 15));

        Label usrTime = new Label(getCurrentDate());

        Label msg = new Label(msgInput.getText() + "\n\n");
        msgScroll.setVvalue(1.0);
        msgVBox.getChildren().addAll(usrLabel, usrTime, msg);

        msgInput.clear();
    }

    @FXML
    private void keyListenerCtrlEnter(KeyEvent keyEvent) {
        if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.ENTER) {
            // sendMsg();
            addMsg();
        }

    }

    @FXML
    private void btnSendListener(MouseEvent mouseEvent) {
        //sendMsg();
        addMsg();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
