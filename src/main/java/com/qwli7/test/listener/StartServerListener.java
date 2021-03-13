package com.qwli7.test.listener;

import com.qwli7.test.http.HttpServer;
import com.qwli7.test.util.DateUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class StartServerListener implements ActionListener {


    private final int port;

    private volatile boolean isOpen = true;
    private final JButton startBtn;
    private final JTextArea jTextArea;

    public StartServerListener(int port, JButton startBtn, JTextArea jTextArea) {
        this.port = port;
        this.startBtn = startBtn;
        this.jTextArea = jTextArea;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        SwingWorker<String, Integer> startServerTask = new SwingWorker<String, Integer>() {
            @Override
            protected String doInBackground() throws Exception {
                Thread httpServerThread = new Thread(() -> {
                    HttpServer httpServer = new HttpServer(port, jTextArea);
                    if(isOpen) {
                        jTextArea.append(DateUtil.format(new Date()) + " : 监听端口『" + port + "』\n");
                        jTextArea.append(DateUtil.format(new Date()) + " : 服务正在启动中......\n");
                        isOpen = false;
                        jTextArea.append(DateUtil.format(new Date()) + " : 服务启动成功......\n");

                        startBtn.setText("关闭服务");
                        try{
                            httpServer.start();
                        } catch (Exception ex) {
                            isOpen = true;
                            startBtn.setText("启动服务");
                        }
                    } else {
                        isOpen = true;
                        jTextArea.append(DateUtil.format(new Date()) + " : 服务已关闭......\n");
                        System.out.println("服务关闭成功");
                        try {
                            httpServer.shutDown();
                        } catch (Exception ignored) {

                        }
                        startBtn.setText("启动服务");
                    }
                    jTextArea.setCaretPosition(jTextArea.getText() != null ? jTextArea.getLineCount() : 0);
                });

                httpServerThread.setDaemon(true);
                httpServerThread.start();
                return "success";
            }

        };
        startServerTask.execute();
    }
}
