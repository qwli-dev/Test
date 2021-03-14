package com.qwli7.test;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.qwli7.test.ui.HttpRequestTabbedPane;
import com.qwli7.test.ui.HttpServerTabbedPane;
import com.qwli7.test.ui.JsonFormatTabbedPane;

import javax.swing.*;
import java.awt.*;

public class MainUi {


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MainUi mainUi = new MainUi();
            mainUi.createMainUi();
        });
    }


    public void createMainUi() {
        FlatDarculaLaf.install();

        JFrame mainFrame = new JFrame("WeTest");
//        jFrame.setSize(800, 600);
        mainFrame.setMinimumSize(new Dimension(800, 600));
        mainFrame.setMaximumSize(new Dimension(800, 600));

//        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        if(screenSize.getWidth() < 1366) {
//            mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        }

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        final JTabbedPane jTabbedPane = new JTabbedPane();
        HttpServerTabbedPane httpServerTabbedPane = new HttpServerTabbedPane();
        HttpRequestTabbedPane httpRequestTabbedPane = new HttpRequestTabbedPane();
        JsonFormatTabbedPane jsonFormatTabbedPane = new JsonFormatTabbedPane();

        jTabbedPane.add("服务器", httpServerTabbedPane.createPane());
        jTabbedPane.add("HTTP请求", httpRequestTabbedPane.createPane());
        jTabbedPane.add("JSON格式化", jsonFormatTabbedPane.createPane());

        jTabbedPane.setSelectedIndex(0);


        mainFrame.setContentPane(jTabbedPane);
        mainFrame.setVisible(true);
    }
}
