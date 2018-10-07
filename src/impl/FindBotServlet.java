package impl;

import servlet.MiniRequest;
import servlet.MiniResponse;
import servlet.MiniServlet;

import java.io.IOException;

public class FindBotServlet extends MiniServlet {

    @Override
    public void doGet(MiniRequest request, MiniResponse response) {
        try {
            response.write("get boy...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MiniRequest request, MiniResponse response) {
        try {
            response.write("post boy...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
