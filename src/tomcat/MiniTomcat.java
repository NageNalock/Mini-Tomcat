package tomcat;

import mapping.ServletMapping;
import mapping.ServletMappingConfig;
import servlet.MiniRequest;
import servlet.MiniResponse;
import servlet.MiniServlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MiniTomcat {

    private int port = 8080;

    private Map<String, String> urlServletMap = new HashMap<>();

    public MiniTomcat(int port) {
        this.port = port;
    }

    public MiniTomcat() {
        // 缺省端口为 8080
    }


    public void start() {
        // 初始化 url 与对应 servlet 之间的关系
        initServletMapping();

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("MyTomcat is start...");

            while (true) {
                // 如果有 socket 到达则执行
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                MiniRequest request = new MiniRequest(inputStream);
                MiniResponse response = new MiniResponse(outputStream);

                // 请求分发
                dispatch(request, response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void initServletMapping() {
        for(ServletMapping mapping : ServletMappingConfig.servletMappingList) {
            System.out.println("init:" + mapping.getClazz());
            urlServletMap.put(mapping.getUrl(), mapping.getClazz());
        }
    }

    private void dispatch(MiniRequest request, MiniResponse response) {
        String clazz = urlServletMap.get(request.getUrl());

        // 反射生成 Servlet 类
        try {
            if (clazz != null) {
                Class<MiniServlet> miniServletClass = (Class<MiniServlet>) Class.forName(clazz);
                MiniServlet servlet = miniServletClass.newInstance();

                // 执行 get 或 post 方法
                servlet.service(request, response);
            }else {
                System.out.println("无法找到类：" + request.getUrl());
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
        e.printStackTrace();
        } catch (IllegalAccessException e) {
        e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MiniTomcat(8080).start();
    }
}
