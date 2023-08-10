package com.besafx.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@SpringBootApplication
@EnableScheduling
@RestController
public class Start {

    private static SetupUI ui;

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Start.class)
                .headless(false)
                .run(args);

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        java.awt.EventQueue.invokeLater(() -> {
            ui = new SetupUI(context);
            ui.setVisible(true);
        });
    }

    @Scheduled(fixedRate = 3000)
    public void printLogs() {
        java.awt.EventQueue.invokeLater(() -> {
            System.out.println("Hello ");
            ui.getTextAreaLogs().setText("Hello World!");
        });
    }

    @GetMapping(value = "/")
    public String index() {
        return "Server is up and running!";
    }
}
