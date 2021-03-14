package com.qwli7.test.ui;

import javax.swing.*;
import java.awt.*;

public class HttpServerTabbedPane extends AbstractTabbedPane {


    @Override
    public JComponent createPane() {
        JPanel httpServerPanel = new JPanel();
//        httpServerPanel.setLayout(new GridLayout(4, 1));

        httpServerPanel.setLayout(new BoxLayout(httpServerPanel, BoxLayout.Y_AXIS));


        JLabel ipAddressLabel = new JLabel("本机地址:");
//        ipAddressLabel.setLocation(8, 8);
//        ipAddressLabel.setFont(new Font(null, Font.PLAIN, 15));
//        ipAddressLabel.setSize(80, 30);

        JLabel ipAddressTextLabel = new JLabel();
//        ipAddressTextLabel.setLocation(96, 8);
//        ipAddressTextLabel.setSize(300, 30);


        Box hBox01 = Box.createHorizontalBox();
        hBox01.add(ipAddressLabel);
        hBox01.add(ipAddressTextLabel);



        Box hBox02 = Box.createHorizontalBox();

        JLabel portLabel = new JLabel("启动端口:");
        JTextField jTextField = new JTextField();
        JButton jButton = new JButton("检测端口占用");
        hBox02.add(portLabel);
        hBox02.add(jTextField);
        hBox02.add(jButton);


        Box hBox03 = Box.createHorizontalBox();
        JButton jButton1 = new JButton("启动服务");
        JButton jButton2 = new JButton("清空");
        hBox03.add(jButton1);
        hBox03.add(jButton2);


        Box hBox04 = Box.createHorizontalBox();
        JTextArea jTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(
                jTextArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        hBox04.add(scrollPane);


        // 创建一个垂直箱容器，放置上面两个水平箱（Box组合嵌套）
        Box vBox = Box.createVerticalBox();
        vBox.add(hBox01);
        vBox.add(hBox02);
        vBox.add(hBox03);
        vBox.add(hBox04);

        httpServerPanel.add(vBox);

        return httpServerPanel;
    }
}
