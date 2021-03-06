package servlet;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 封装 Response
 *
 * 基于HTTP协议的格式进行输出写入。
 * */

public class MiniResponse {

    private OutputStream outputStream;

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public MiniResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String content) throws IOException {
//        HTTP 响应协议
//        HTTP/1.1 200 OK
//        Content-Type: text/html
//
//        <html><body>Your Content</body></html>

        StringBuffer httpRsponse = new StringBuffer();
        httpRsponse.append("HTTP/1.1 200 OK\n")
                .append("Content-Type: text/html\n")
                .append("\r\n")
                .append("<html><body>")
                .append(content)
                .append("</body></html>");

        outputStream.write(httpRsponse.toString().getBytes());
        outputStream.close();
    }
}
