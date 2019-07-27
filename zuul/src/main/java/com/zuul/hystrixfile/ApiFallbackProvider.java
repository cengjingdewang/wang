package com.zuul.hystrixfile;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class ApiFallbackProvider implements FallbackProvider {
    @Override  //	为哪个服务提供回退，*号代表所有服务
    public String getRoute() {
        return "*";
    }

    @Override  //  	回退响应
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override //	回退时的状态码
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST;
            }

            @Override//  	数字类型状态码
            public int getRawStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST.value();
            }

            @Override  //	状态文本
            public String getStatusText() throws IOException {
                return HttpStatus.BAD_REQUEST.getReasonPhrase();
            }

            @Override// 	这个不用管
            public void close() {

            }

            @Override  //	响应体
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("请重试3".getBytes(StandardCharsets.UTF_8));
            }

            @Override//	返回的响应头
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                return httpHeaders;
            }
        };
    }
}
