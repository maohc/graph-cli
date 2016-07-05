package com.tmessinis.graph;

import com.tmessinis.graph.command.CommandExecutor;
import com.tmessinis.graph.command.CommandExecutorImpl;

public class App {

	public static void main(String[] args) {

		CommandExecutor commandExecutor = new CommandExecutorImpl();

		/** Check whether all arguments are in place */
		if (args.length == 2) {
			String graphFileLocation = args[0];
			String commandsFileLocation = args[1];
			commandExecutor.execute(graphFileLocation, commandsFileLocation);
		} else {
			System.err.append("Usage: java -jar target/graph-1.0-SNAPSHOT.jar graph.txt commands.txt");
		}
	}

}
