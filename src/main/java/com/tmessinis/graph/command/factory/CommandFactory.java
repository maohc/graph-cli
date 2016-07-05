package com.tmessinis.graph.command.factory;

import com.tmessinis.graph.command.CommandBase;
import com.tmessinis.graph.element.Graph;


public interface CommandFactory  {
    
    CommandBase parseCommand(String command, Graph graph);

}
