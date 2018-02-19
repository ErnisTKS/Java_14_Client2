package sample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Model {
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 8080;

    private Socket _kanalas;
    private ObjectInputStream _inputStream;
    private ObjectOutputStream _outputStream;

    public Model(){
        Socket kanalas = null;
        try {
            _kanalas = new Socket(HOST, PORT);
            _outputStream = new ObjectOutputStream(kanalas.getOutputStream());
            _inputStream = new ObjectInputStream(kanalas.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SendData(String value){
        try {
            _outputStream.writeUTF("Uzduotis 1");
            _outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String GetData(){
        String result="";
        try {
            result = _inputStream.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
