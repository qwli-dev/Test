package com.qwli7.test;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.qwli7.test.ui.HttpRequestTabbedPane;
import com.qwli7.test.ui.HttpServerTabbedPane;
import com.qwli7.test.ui.JsonFormatTabbedPane;

import javax.swing.*;

public class MainUi {


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MainUi mainUi = new MainUi();
            mainUi.createMainUi();
        });
    }


    public void createMainUi() {
        FlatDarculaLaf.install();

        JFrame jFrame = new JFrame("WeTest");
        jFrame.setSize(800, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final JTabbedPane jTabbedPane = new JTabbedPane();
        HttpServerTabbedPane httpServerTabbedPane = new HttpServerTabbedPane();
        HttpRequestTabbedPane httpRequestTabbedPane = new HttpRequestTabbedPane();
        JsonFormatTabbedPane jsonFormatTabbedPane = new JsonFormatTabbedPane();

        jTabbedPane.add("服务器", httpServerTabbedPane.createPane());
        jTabbedPane.add("HTTP请求", httpRequestTabbedPane.createPane());
        jTabbedPane.add("json格式化", jsonFormatTabbedPane.createPane());

        jTabbedPane.setSelectedIndex(0);


        jFrame.setContentPane(jTabbedPane);
        jFrame.setVisible(true);
    }
}
