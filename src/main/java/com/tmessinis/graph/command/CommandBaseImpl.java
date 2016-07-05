package com.tmessinis.graph.command;

import com.tmessinis.graph.element.Graph;

public class CommandBaseImpl implements CommandBase {

	@Override
	public Object accept(CommandVisitor commandVisitor) {
		return "Unrecognized Command";
	}

	@Override
	public void setCommand(String command) {
	}

	@Override
	public void setGraph(Graph graph) {
	}

}
