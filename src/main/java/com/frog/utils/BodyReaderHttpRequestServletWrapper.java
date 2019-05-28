package com.frog.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 
 * @author Robert.Jiang
 * @date 2019年5月21日 下午6:10:32
 */
public class BodyReaderHttpRequestServletWrapper extends HttpServletRequestWrapper {
    private final byte[] body;

    public BodyReaderHttpRequestServletWrapper(HttpServletRequest request) {
        super(request);
        body = readRequestInputStream(request).getBytes(Charset.forName("utf-8"));
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream(), Charset.forName("utf-8")));
    }

    public String getBodyString(){
        return new String(body, Charset.forName("utf-8"));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException{
        final ByteArrayInputStream byteInputStream = new ByteArrayInputStream(body);
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {

            }

            @Override
            public int read() throws IOException {
                return byteInputStream.read();
            }
        };
    }

    private String readRequestInputStream(HttpServletRequest request) {
        try {
            StringBuilder result = new StringBuilder();
            InputStream requestInputStream = request.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(requestInputStream, Charset.forName("utf-8")));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append(System.getProperty("line.separator"));
            }
            return result.toString().trim();
        } catch (IOException e){
            e.printStackTrace();
            return "";
        }
    }

}
