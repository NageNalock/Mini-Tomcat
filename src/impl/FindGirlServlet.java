package impl;

import servlet.MiniRequest;
import servlet.MiniResponse;
import servlet.MiniServlet;

import java.io.IOException;

public class FindGirlServlet extends MiniServlet {

    @Override
    public void doGet(MiniRequest request, MiniResponse response) {
        try {
            response.write("get girl...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
