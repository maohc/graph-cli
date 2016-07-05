package com.tmessinis.graph.algorithm;

import java.util.Iterator;
import java.util.Stack;

public class TraversalUtil {

	public static String getPath(Stack<String> path) {
		StringBuilder strBuilder = new StringBuilder();
		Iterator<String> iter = path.iterator();
		while (iter.hasNext()) {
			strBuilder.append(iter.next());
		}
		return strBuilder.toString();
	}

}
