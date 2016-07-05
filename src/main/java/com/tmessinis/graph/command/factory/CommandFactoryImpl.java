package com.tmessinis.graph.command.factory;

import com.tmessinis.graph.command.CommandBase;
import com.tmessinis.graph.command.CommandBaseImpl;
import com.tmessinis.graph.command.DistanceOfPath;
import com.tmessinis.graph.command.DistanceOfShortestPath;
import com.tmessinis.graph.command.TripsBetweenNodes;
import com.tmessinis.graph.element.Graph;

/**
 * Command Factory
 * 
 * 
 * @author tmessini
 */
public class CommandFactoryImpl implements CommandFactory {

	@Override
	public CommandBase parseCommand(String commandString, Graph graph) {
		CommandBase command = new CommandBaseImpl();
		if (commandString.contains("DISTANCE_OF_PATH")) {
			command = new DistanceOfPath();
			String commandStr = commandString.replace("DISTANCE_OF_PATH", "");
			command.setCommand(commandStr.trim());
			command.setGraph(graph);
		} else if (commandString.contains("DISTANCE_OF_SHORTEST_PATH")) {
			command = new DistanceOfShortestPath();
			String commandStr = commandString.replace("DISTANCE_OF_SHORTEST_PATH", "");
			command.setCommand(commandStr.trim());
			command.setGraph(graph);
		} else if (commandString.contains("TRIPS_BETWEEN_NODES")) {
			command = new TripsBetweenNodes();
			String commandStr = commandString.replace("TRIPS_BETWEEN_NODES", "");
			command.setCommand(commandStr.trim());
			command.setGraph(graph);
		}
		return command;
	}
}
