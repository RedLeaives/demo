package com.zhazhapan.demo.pattern.interpreter;

/**
 * @author pantao
 * @since 2018-07-25
 */
public class OrExpression implements Expression {

    private Expression expression1;

    private Expression expression2;

    public OrExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return expression2.interpret(context) || expression1.interpret(context);
    }
}
