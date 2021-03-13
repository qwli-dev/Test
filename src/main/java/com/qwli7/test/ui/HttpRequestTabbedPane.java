package com.qwli7.test.ui;

import javax.swing.*;
import java.awt.*;

public class HttpRequestTabbedPane extends AbstractTabbedPane {
    @Override
    public JComponent createPane() {

        JPanel jPanel = new JPanel(new GridLayout(1, 1));

        JLabel jLabel = new JLabel("HttpRequest");
        jLabel.setFont(new Font(null, Font.PLAIN, 50));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);

        jPanel.add(jLabel);
        return jPanel;
    }
}
