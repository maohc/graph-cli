package com.tmessinis.graph.algorithm;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

import com.tmessinis.graph.algorithm.TraversalUtil;


public class UtilTest {

    @Test
    public void testConversionFromStackToString() {
        Stack<String> stack = new Stack<String>();
        stack.add("A");
        stack.add("B");
        stack.add("B");
        stack.add("C");
        assertEquals("ABBC", TraversalUtil.getPath(stack));
    }

}
