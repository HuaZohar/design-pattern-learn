package cn.hqlearn;


public class App {
    public static void main(String[] args) {

        String data = "今天早晨吃啥了呢?:(，系统咋样了? SB 嗯哼?";

        Request request = new Request();
        request.setRequestStr(data);

        Response response = new Response();
        response.setResponseStr("main");

        FaceFilter faceFilter = new FaceFilter();
        SensitiveFilter sensitiveFilter = new SensitiveFilter();

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(faceFilter)
                .addFilter(sensitiveFilter);

        filterChain.doFilter(request, response, filterChain);

        System.out.println(request.getRequestStr());
        System.out.println(response.getResponseStr());

    }
}
