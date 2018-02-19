package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {

    public TextArea logArea;
    public TextField nickInput;
    public TextField messageInput;
    public Button sendButton;
    private Model _model;

    public Controller(){
        Run();
    }


    public void onKeyPressed(KeyEvent keyEvent){
        if (nickInput.getText().equals("") || messageInput.getText().equals("")) {
            sendButton.setDisable(true);
        } else{
            sendButton.setDisable(false);
        }

        if (sendButton.isDisabled()==false){
            if (keyEvent.getCode() == KeyCode.ENTER){
                onSendButton();
            }
        }
    }

    public void onSendButton(){
        String msg = "";
        msg+=nickInput.getText();
        msg+=": "+messageInput.getText()+"\n";
        _model.SendData(msg);
        logArea.appendText(msg);
        messageInput.setText("");
        sendButton.setDisable(true);
        messageInput.clear();
    }

    public void Run(){

    }
}