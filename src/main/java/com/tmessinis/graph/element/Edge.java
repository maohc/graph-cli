package com.tmessinis.graph.element;

/**
 * Edge class
 * 
 * @author tmessini
 *
 */
public class Edge {

	private Node endingNode;
	private int distance;

	public Edge(Node endingNode, int distance) {
		this.setDistance(distance);
		this.setEndingNode(endingNode);
	}

	public Node getEndingNode() {
		return endingNode;
	}

	public void setEndingNode(Node endingNode) {
		this.endingNode = endingNode;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
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
		result = prime * result + distance;
		result = prime * result + ((endingNode == null) ? 0 : endingNode.getName().hashCode());
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
		Edge other = (Edge) obj;
		if (distance != other.distance)
			return false;
		if (endingNode == null) {
			if (other.endingNode != null)
				return false;
		} else if (!endingNode.getName().equals(other.endingNode.getName()))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Edge [endingNode=" + endingNode.getName() + ", distance=" + distance + "]";
	}

}
