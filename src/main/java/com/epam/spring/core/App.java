package com.epam.spring.core;

import com.epam.spring.core.domain.Client;
import com.epam.spring.core.loggers.ConsoleEventLogger;

public class App {


	private ConsoleEventLogger eventLogger;
	private Client client;

	public App(ConsoleEventLogger eventLogger, Client client){
		this.eventLogger = eventLogger;
		this.client = client;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//App app = new App();
		
		/*app.client = new Client("1", "Sponge Bob");
		app.eventLogger = new ConsoleEventLogger();
		
		app.logEvent("Some event for user 1");*/
	}
	
	private void logEvent(String msg) {
		eventLogger
		.logEvent(
				msg.replaceAll(client.getId(), client.getFullName()));
	}

}
