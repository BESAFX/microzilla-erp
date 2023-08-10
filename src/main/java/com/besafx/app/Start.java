package com.besafx.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@SpringBootApplication
@RestController
public class Start {

	public static void main(String[] args) {
		 ConfigurableApplicationContext context = new SpringApplicationBuilder(Start.class)
				 .headless(false)
				 .run(args);

		SwingUtilities.invokeLater(() -> {
			SetupUI ui = context.getBean(SetupUI.class);
			ui.setVisible(true);
		});
	}

	@GetMapping(value = "/")
	public String index() {
		return "Server is up and running!";
	}
}
