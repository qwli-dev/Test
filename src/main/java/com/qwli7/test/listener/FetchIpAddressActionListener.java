package com.qwli7.test.listener;

import com.qwli7.test.util.InetAddressUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FetchIpAddressActionListener implements ActionListener {


    private final JTextField ipTextField;

    public FetchIpAddressActionListener(JTextField ipTextField) {
        this.ipTextField = ipTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SwingWorker<String, String> fetchIpWorker = new SwingWorker<String, String>() {
            @Override
            protected String doInBackground() throws Exception {
                return InetAddressUtil.getIpAddress();
            }

            @Override
            protected void done() {
                String ipAddress = "";
                try{
                    ipAddress = get();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                ipTextField.setText(ipAddress);
            }
        };
        fetchIpWorker.execute();

    }
}
