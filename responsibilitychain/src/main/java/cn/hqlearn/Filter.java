package cn.hqlearn;

public interface Filter {
    void doFilter(Request request, Response response, FilterChain filterChain);
}
