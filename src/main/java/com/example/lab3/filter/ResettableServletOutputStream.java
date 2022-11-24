package com.example.lab3.filter;

import javax.servlet.ServletOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import java.io.OutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;

public class ResettableServletOutputStream extends ServletOutputStream {



    public OutputStream outputStream;
    private ResettableStreamHttpServletResponse wrappedResponse;
    private ServletOutputStream servletOutputStream = new ServletOutputStream(){
        boolean isFinished = false;
        boolean isReady = true;
        WriteListener writeListener = null;

        @Override
        public void setWriteListener(WriteListener writeListener) {
            this.writeListener = writeListener;
        }

        public boolean isReady(){
            return isReady;
        }
        @Override
        public void write(int w) throws IOException{
            outputStream.write(w);
            wrappedResponse.rawData.add(Integer.valueOf(w).byteValue());
        }
    };

    public ResettableServletOutputStream(ResettableStreamHttpServletResponse wrappedResponse) throws IOException {
        this.outputStream = wrappedResponse.response.getOutputStream();
        this.wrappedResponse = wrappedResponse;
    }

    @Override
    public void close() throws IOException {
        System.out.println("** RESPONSE CLOSE **");
        outputStream.close();
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {
        servletOutputStream.setWriteListener( writeListener );
    }
    @Override
    public boolean isReady(){
        return servletOutputStream.isReady();
    }

    @Override
    public void write(int w) throws IOException {
        servletOutputStream.write(w);
    }
}
