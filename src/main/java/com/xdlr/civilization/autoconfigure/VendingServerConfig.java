package com.xdlr.civilization.autoconfigure;

import com.xdlr.civilization.controller.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

@Configuration
public class VendingServerConfig {

    @Bean
    public VendingServer getVendingServer() {
        VendingServer vendingServer = new VendingServer();
        vendingServer.start();
        return vendingServer;
    }

    public static class VendingServer extends Thread {

        private static final int VENDING_PORT = 7777;

        private DataOutputStream out;

        public void sendUserInfo(UserInfo userInfo) {
            try {
                if (out == null) {
                    // log
                    return;
                }
                out.writeUTF(userInfo.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(VENDING_PORT);
                serverSocket.setReuseAddress(true);
                serverSocket.setSoTimeout(100000);

                System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                server.setReuseAddress(true);
                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
                out = new DataOutputStream(server.getOutputStream());
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (serverSocket != null) {
                        serverSocket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}