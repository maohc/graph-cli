package com.tmessinis.graph.command.factory;

import com.tmessinis.graph.command.CommandBase;
import com.tmessinis.graph.command.DistanceOfPath;
import com.tmessinis.graph.command.DistanceOfShortestPath;
import com.tmessinis.graph.command.TripsBetweenNodes;
import com.tmessinis.graph.command.factory.CommandFactory;
import com.tmessinis.graph.command.factory.CommandFactoryImpl;
import com.tmessinis.graph.element.Graph;
import com.tmessinis.graph.factory.GraphFactory;
import com.tmessinis.graph.factory.GraphFactoryImpl;

import static org.junit.Assert.*;
import org.junit.Test;


public class CommandFactoryTest {

	CommandFactory commandFactory = new CommandFactoryImpl();
	GraphFactory graphFactory = new GraphFactoryImpl();

	@Test
	public void testCommandFactoryDistanceABC() {
		Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
		String commandString = "DISTANCE_OF_PATH ABC";
		CommandBase command = commandFactory.parseCommand(commandString, graph);
		DistanceOfPath distanceCommand = new DistanceOfPath();
		distanceCommand.setCommand("ABC");
		distanceCommand.setGraph(graph);
		assertEquals(distanceCommand, command);
	}

	@Test
	public void testCommandFactoryDistanceAD() {
		Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
		String commandString = "DISTANCE_OF_PATH AD";
		CommandBase command = commandFactory.parseCommand(commandString, graph);
		DistanceOfPath distanceCommand = new DistanceOfPath();
		distanceCommand.setCommand("AD");
		distanceCommand.setGraph(graph);
		assertEquals(distanceCommand, command);
	}

	@Test
	public void testCommandFactoryDistanceADC() {
		Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
		String commandString = "DISTANCE_OF_PATH ADC";
		CommandBase command = commandFactory.parseCommand(commandString, graph);
		DistanceOfPath distanceCommand = new DistanceOfPath();
		distanceCommand.setCommand("ADC");
		distanceCommand.setGraph(graph);
		assertEquals(distanceCommand, command);
	}
	
    @Test
	public void testCommandFactoryTripsWithConstraintsTripsCC3() {
		Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
		String commandString = "TRIPS_BETWEEN_NODES CC STOPS LESS 3";
		CommandBase command = commandFactory.parseCommand(commandString, graph);
		TripsBetweenNodes tripsCommand = new TripsBetweenNodes();
		tripsCommand.setCommand("CC STOPS LESS 3");
		tripsCommand.setGraph(graph);
		assertEquals(tripsCommand, command);

	}
   
    @Test
	public void testCommandFactoryTripsWithConstraintsTripsAC4() {
		Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
		String commandString = "TRIPS_BETWEEN_NODES CC STOPS < 3";
		CommandBase command = commandFactory.parseCommand(commandString, graph);
		TripsBetweenNodes tripsCommand = new TripsBetweenNodes();
		tripsCommand.setCommand("CC STOPS < 3");
		tripsCommand.setGraph(graph);
		assertEquals(tripsCommand, command);
	}

	public void testCommandFactoryShortestDistanceAC() {
		Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
		String commandString = "DISTANCE_OF_SHORTEST_PATH AC";
		CommandBase command = commandFactory.parseCommand(commandString, graph);
		DistanceOfShortestPath shortestPathDistanceCommand = new DistanceOfShortestPath();
		shortestPathDistanceCommand.setCommand("AC");
		shortestPathDistanceCommand.setGraph(graph);
		assertEquals(shortestPathDistanceCommand, command);
	}

	public void testCommandFactoryShortestDistanceBB() {
		Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
		String commandString = "DISTANCE_OF_SHORTEST_PATH BB";
		CommandBase command = commandFactory.parseCommand(commandString, graph);
		DistanceOfShortestPath shortestPathDistanceCommand = new DistanceOfShortestPath();
		shortestPathDistanceCommand.setCommand("BB");
		shortestPathDistanceCommand.setGraph(graph);
		assertEquals(shortestPathDistanceCommand, command);
	}

	public void testCommandFactoryTripsCC30() {
		Graph graph = graphFactory.initGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");
		String commandString = "TRIPS_BETWEEN_NODES CC DISTANCE LESS 30";
		CommandBase command = commandFactory.parseCommand(commandString, graph);
		TripsBetweenNodes tripsCommand = new TripsBetweenNodes();
		tripsCommand.setCommand("CC DISTANCE LESS 30");
		tripsCommand.setGraph(graph);
		assertEquals(tripsCommand, command);
	}
}
