package cn.hqlearn;

public class FaceFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.setRequestStr(request.getRequestStr().replace(":(", "^-^") + "---> face request");

        filterChain.doFilter(request, response, filterChain);
        response.setResponseStr(response.getResponseStr() + "---> face response");
    }
}
