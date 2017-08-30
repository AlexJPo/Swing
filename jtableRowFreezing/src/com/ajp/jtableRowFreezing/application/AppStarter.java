package com.ajp.jtableRowFreezing.application;

import com.ajp.jtableRowFreezing.application.controller.TableController;
import com.ajp.jtableRowFreezing.application.controller.TableFixedController;

public class AppStarter {

	public static void main(String[] args) {
		TableController tableController = new TableController();
		//tableController.Run();
		
		TableFixedController tableFixed = new TableFixedController();
		tableFixed.Run();
	}

}
