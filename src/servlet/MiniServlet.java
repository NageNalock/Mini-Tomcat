package servlet;

/**
 * 自定义 Servlet
 *
 * 抽象类
 *
 * 提供 doGet/doPost/service 方法。
 * */

public abstract class MiniServlet {

    public abstract void doGet(MiniRequest request, MiniResponse response);

    public abstract void doPost(MiniRequest request, MiniResponse response);

    // 每次客户向服务器发出请求时，服务器就会调用这个方法
    // 每次客户向服务器发请求时，服务器就会调用 service()方法(注意此处与 init 的不同
    public void service(MiniRequest request, MiniResponse response) {
        if (request.getMethod().equalsIgnoreCase("POST")) {
            doPost(request, response);
        }else if (request.getMethod().equalsIgnoreCase("GET")) {
            doGet(request, response);
        }
    }

}
