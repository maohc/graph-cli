package com.tmessinis.graph.element;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Graph class
 * 
 * @author tmessini
 *
 */
public class Graph {

	/**
	 * Storing nodes of graph
	 */
	private Map<String, Node> nodes;

	public void setNodes(Map<String, Node> nodes) {
		this.nodes = nodes;
	}

	public Collection<Node> getNodes() {
		return nodes.values();
	}

	/**
	 * Adding a node to Graph.
	 * 
	 * @param node
	 */
	public void addNode(String name, Node node) {
		if (nodes == null) {
			nodes = new ConcurrentHashMap<String, Node>();
		}
		nodes.put(name, node);
	}

	/**
	 * Get node based on name.
	 * 
	 * @param nodeName
	 * @return
	 */
	public Node getNode(String nodeName) {
		if (nodes == null) {
			nodes = new ConcurrentHashMap<String, Node>();
		}
		if (nodes.get(nodeName) == null) {
			addNode(nodeName, new Node(nodeName));
		}
		return nodes.get(nodeName);
	}

	@Override
	public String toString() {
		return "Graph [nodes=" + nodes + "]";
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
		result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
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
		Graph other = (Graph) obj;
		if (nodes == null) {
			if (other.nodes != null)
				return false;
		} else if (!nodes.equals(other.nodes))
			return false;
		return true;
	}

}
