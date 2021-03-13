package com.qwli7.test.ui;

import javax.swing.*;
import java.awt.*;

public class HttpServerTabbedPane extends AbstractTabbedPane {


    @Override
    public JComponent createPane() {
        JPanel httpServerPanel = new JPanel();
        httpServerPanel.setLayout(null);


        JLabel ipAddressLabel = new JLabel("本机地址:");
        ipAddressLabel.setLocation(8, 8);
//        ipAddressLabel.setFont(new Font(null, Font.PLAIN, 15));
        ipAddressLabel.setSize(80, 30);

        JLabel ipAddressTextLabel = new JLabel();
        ipAddressTextLabel.setLocation(96, 8);
        ipAddressTextLabel.setSize(300, 30);




        httpServerPanel.add(ipAddressLabel);
        httpServerPanel.add(ipAddressTextLabel);



        return httpServerPanel;
    }
}
