package com.tmessinis.graph.element;

import java.util.HashSet;
import java.util.Set;

/**
 * Node class
 * 
 * @author tmessini
 *
 */
public class Node {

	private String name;

	private Set<Edge> edges;

	public Node(String name) {
		this.setName(name);
		this.edges = new HashSet<Edge>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addEdge(Edge connection) {
		edges.add(connection);

	}

	public Set<Edge> getEdges() {
		return edges;
	}

	@Override
	public String toString() {
		return "Node [name=" + name + ", edges=" + edges + "]";
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
		result = prime * result + ((edges == null) ? 0 : edges.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (edges == null) {
			if (other.edges != null)
				return false;
		} else if (!edges.equals(other.edges))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
