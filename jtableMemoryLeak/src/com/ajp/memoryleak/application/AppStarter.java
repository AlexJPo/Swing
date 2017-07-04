package com.ajp.memoryleak.application;

import com.ajp.memoryleak.application.controller.TableController;

public class AppStarter {

	public static void main(String[] args) {
		TableController tableController = new TableController();
		tableController.Run();
	}
}
