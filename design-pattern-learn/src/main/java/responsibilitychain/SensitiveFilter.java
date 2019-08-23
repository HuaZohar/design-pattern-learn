package responsibilitychain;

public class SensitiveFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {

        request.setRequestStr(request.getRequestStr().replace("SB", "您") + "---> sensitive request");
        filterChain.doFilter(request, response, filterChain);

        response.setResponseStr(response.getResponseStr() + "---> sensitive response");

    }
}
