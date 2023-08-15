package com.besafx.app;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class SetupUI extends JFrame {

    private JTextArea textAreaLogs;

    private ConfigurableApplicationContext context;

    public SetupUI(ConfigurableApplicationContext context) {
        this.context = context;
        initComponents();
    }

    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();

        JTextField jTextField1 = new JTextField();
        JTextField jTextField2 = new JTextField();
        JTextField jTextField3 = new JTextField();

        textAreaLogs = new javax.swing.JTextArea();
        textAreaLogs.setColumns(20);
        textAreaLogs.setRows(5);
        textAreaLogs.setBackground(new java.awt.Color(51, 51, 51));
        textAreaLogs.setForeground(new java.awt.Color(0, 153, 0));
        textAreaLogs.setFont(new java.awt.Font("Consolas", Font.PLAIN, 14));
        textAreaLogs.setEditable(false);
        textAreaLogs.setFocusable(false);

        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setViewportView(textAreaLogs);

        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();

        JLabel jLabel2 = new JLabel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();

        JSeparator jSeparator1 = new JSeparator();

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setText("Server Configuration:  ");

        jLabel2.setText("Server Port");
        jLabel2.setMaximumSize(new Dimension(80, 50));

        jLabel3.setText("Initial RAM");
        jLabel3.setMaximumSize(new Dimension(80, 50));

        jLabel4.setText("Max RAM");
        jLabel4.setMaximumSize(new Dimension(80, 50));

        jTextField1.setText("4040");
        jTextField1.setEnabled(false);
        jTextField2.setText("1024 MB");
        jTextField2.setEnabled(false);
        jTextField3.setText("2048 MB");
        jTextField3.setEnabled(false);

        jButton1.setText("Shut Down");
        jButton1.addActionListener(e -> shutdown());
        jButton2.setText("Hide");
        jButton2.addActionListener(e -> minimize());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField1, 150, 150, 150))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField2, 150, 150, 150))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField3, 150, 150, 150)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(100, Short.MAX_VALUE)
                                .addComponent(jButton1, 100, 100, 100)
                                .addComponent(jButton2, 100, 100, 100)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()

                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                                .addComponent(jSeparator1, 1, 1, 1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        initTray();

        pack();

        initWindow();
    }

    private void initWindow() {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Micro Academy");
        setName("Micro Academy");
        setResizable(false);
        setPreferredSize(new Dimension(500, 500));
        setSize(new Dimension(500, 500));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);

        setVisible(true);
    }

    private void initTray() {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }

        final PopupMenu popup = new PopupMenu();
        Resource path = new ClassPathResource("icon.png");
        Image img;
        try {
            img = Toolkit.getDefaultToolkit().getImage(path.getURL());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        final TrayIcon trayIcon = new TrayIcon(img, "Micro Academy", popup);
        final SystemTray tray = SystemTray.getSystemTray();

        MenuItem aboutItem = new MenuItem("About");

        MenuItem clearLogsItem = new MenuItem("Clear logs");
        clearLogsItem.addActionListener(e -> clearLogs());

        MenuItem restartItem = new MenuItem("Restart");
        restartItem.addActionListener(e -> restart());

        MenuItem exitItem = new MenuItem("Exit");
        exitItem.addActionListener(e -> shutdown());

        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(clearLogsItem);
        popup.add(restartItem);
        popup.add(exitItem);

        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
    }

    private void minimize() {
        setState(JFrame.ICONIFIED);
    }

    private void shutdown() {
        clearLogs();
        System.exit(0);
    }

    private void clearLogs() {
        try {
            FileUtils.write(new File(Start.LOG_FILE_PATH), "", Charset.defaultCharset());
            textAreaLogs.setText("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void restart() {
        ApplicationArguments args = this.context.getBean(ApplicationArguments.class);
        Thread thread = new Thread(() -> {
            context.close();
            context = new SpringApplicationBuilder(Start.class)
                    .headless(false)
                    .run(args.getSourceArgs());
        });
        thread.setDaemon(false);
        thread.start();
    }

    public JTextArea getTextAreaLogs() {
        return textAreaLogs;
    }

}
