package com.besafx.app;

import org.apache.commons.io.input.TailerListenerAdapter;

import java.util.Objects;

public class MyTrailerListener extends TailerListenerAdapter {

    private final SetupUI ui;

    public MyTrailerListener(SetupUI ui) {
        this.ui = ui;
    }

    public void handle(String line) {
        java.awt.EventQueue.invokeLater(() -> {
            if (Objects.nonNull(ui)) {
                ui.getTextAreaLogs().setText(ui.getTextAreaLogs().getText().concat("\n").concat(line));
            }
        });
    }
}