package com.tmessinis.graph.command;

import com.tmessinis.graph.element.Graph;

public class TripsBetweenNodes implements CommandBase {

	/** Command string to be executed */
	private String command;

	/** Graph on which command is executed */
	private Graph graph;

	@Override
	public Object accept(CommandVisitor commandVisitor) {
		return commandVisitor.visit(this);
	}

	@Override
	public void setCommand(String command) {
		this.command = command;
	}

	public String getCommand() {
		return this.command;
	}

	@Override
	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	/**
	 * @return the graph
	 */
	public Graph getGraph() {
		return graph;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((command == null) ? 0 : command.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TripsBetweenNodes other = (TripsBetweenNodes) obj;
		if (command == null) {
			if (other.command != null)
				return false;
		} else if (!command.equals(other.command))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TripsBetweenNodes [command=" + command + ", graph=" + graph + "]";
	}

}
