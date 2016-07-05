package com.tmessinis.graph;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import com.tmessinis.graph.command.CommandBase;
import com.tmessinis.graph.command.CommandVisitor;
import com.tmessinis.graph.command.CommandVisitorImpl;
import com.tmessinis.graph.command.factory.CommandFactory;
import com.tmessinis.graph.command.factory.CommandFactoryImpl;
import com.tmessinis.graph.element.Graph;
import com.tmessinis.graph.factory.GraphFactory;
import com.tmessinis.graph.factory.GraphFactoryImpl;
import com.tmessinis.graph.file.FileRead;
import com.tmessinis.graph.file.FileReadImpl;

public class CommandExecutorImpl implements CommandExecutor {
    
    private final static Logger LOGGER = Logger.getLogger(CommandExecutorImpl.class.getName()); 

	@Override
	public void execute(String graphFileLocation, String commandsFileLocation) {

		/** Initialize graph factory service */
		GraphFactory graphFactory = new GraphFactoryImpl();

		/** Initialize file read service */
		FileRead fileRead = new FileReadImpl();

		/** Initialize command factory */
		CommandFactory commandFactory = new CommandFactoryImpl();

		/** Initialize command visitor */
		CommandVisitor commandVisitor = new CommandVisitorImpl();

		/** Read files content */
		List<String> graphStr = new ArrayList<>();
		List<String> commands = new ArrayList<>();
		try {
			graphStr = fileRead.readContent(graphFileLocation);
			commands = fileRead.readContent(commandsFileLocation);
		} catch (FileNotFoundException e) {
			LOGGER.severe(e.getMessage());
		} catch (IOException e) {
	         LOGGER.severe(e.getMessage());
		}

		/** Construct the Graph */
		Graph graph = graphFactory.initGraph(graphStr.get(0));
		/** Initialize commands */
		Iterator<String> commandIter = commands.iterator();
		int count = 0;
		while (commandIter.hasNext()) {
			String commandStr = commandIter.next();
			/** create command */
			CommandBase command = commandFactory.parseCommand(commandStr, graph);
			/** execute command */
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Command");
			stringBuilder.append(++count);
			stringBuilder.append(": ");
			stringBuilder.append(commandStr);
			stringBuilder.append(" = ");
			/** command execution on visit */
			stringBuilder.append(command.accept(commandVisitor));
			LOGGER.info(stringBuilder.toString());
		}
	}
}
