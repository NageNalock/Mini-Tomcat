import java.io.IOException;
import java.io.InputStream;

/**
 * 对 Request 的封装
 *
 * 通过输入流，对HTTP协议进行解析，拿到了HTTP请求头的方法以及URL
 * */

public class MiniRequest {

    private String url;
    private String method;

    public MiniRequest(InputStream inputStream) throws IOException {
        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        if ((length= inputStream.read(httpRequestBytes)) > 0) {
            httpRequest = new String(httpRequestBytes,0, length);
        }


//    HTTP 请求协议
//    GET /favicon.ico HTTP/1.1
//    Accept: */*
//    Accept-Encoding: gzip, deflate
//    USER-Agent:....
//    Host: localhost:8080
//    Connection: Keep-live

        String httpHead = httpRequest.split("\n")[0];
        url = httpHead.split("\\s")[1];
        method = httpHead.split("\\s")[0];
        System.out.println(this);
    }

}
