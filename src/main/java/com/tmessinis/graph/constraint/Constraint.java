package com.tmessinis.graph.constraint;


import com.tmessinis.graph.element.PathStats;

public interface Constraint {
    
    Boolean evaluate(double value);
    
    Boolean evaluate(PathStats pathStats);

    void setType(Type stops);
    
    Type getType();

    void setOperator(Operator greaterEqualThan);
    
    Operator getOperator();

    void setcValue(int value);
    
    int getcValue();

}
