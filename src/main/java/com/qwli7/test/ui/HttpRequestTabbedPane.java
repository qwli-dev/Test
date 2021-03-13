package com.qwli7.test.ui;

import javax.swing.*;

public class HttpRequestTabbedPane extends AbstractTabbedPane {
    @Override
    public JComponent createPane() {

//        JPanel jPanel = new JPanel();

        JSplitPane jSplitPane = new JSplitPane();

        jSplitPane.setLeftComponent(new JButton("左边按钮"));
        jSplitPane.setRightComponent(new JButton("右边按钮"));

        jSplitPane.setOneTouchExpandable(true);

        jSplitPane.setContinuousLayout(true);
        jSplitPane.setDividerLocation(150);

//        jPanel.add(jSplitPane);
        return jSplitPane;
    }
}
