package com.besafx.app;

import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.io.File;

@SpringBootApplication
@RestController
public class Start {

    public static final String LOG_FILE_PATH = "microzilla-logs/app.log";

    private static SetupUI ui;

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Start.class)
                .headless(false)
                .run(args);

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(() -> {
            ui = new SetupUI();

            TailerListener listener = new MyTrailerListener(ui);
            File file = new File(LOG_FILE_PATH);
            Tailer tailer = new Tailer(file, listener, 1000);

            Thread thread = new Thread(tailer);
            thread.setDaemon(true);
            thread.start();
        });
    }

    @GetMapping(value = "/")
    public String index() {
        return "Server is up and running!";
    }
}
