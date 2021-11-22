package io.github.kimmking.gateway.lalinski;


import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class HttpRequestFilter implements io.github.kimmking.gateway.filter.HttpRequestFilter {

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        String uri = fullRequest.uri();
        System.out.println("filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx)接收到的请求,url: " + uri);
        if (uri.startsWith("/hello")) {
            return;
        } else {
            ctx.write("不支持的uri:" + uri);
            ctx.flush();
        }

    }

}
