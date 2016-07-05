package com.tmessinis.graph.command;

import com.tmessinis.graph.element.Graph;

/**
 * @author tmessini
 */
public interface CommandBase {

	public Object accept(CommandVisitor commandVisitor);

	public void setCommand(String command);

	public void setGraph(Graph graph);

}
