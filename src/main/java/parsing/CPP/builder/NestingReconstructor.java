package parsing.CPP.builder;

import ast.ASTNode;
import ast.expressions.Expression;
import ast.expressions.expressionHolders.ExpressionHolder;
import ast.statements.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.Stack;

public class NestingReconstructor {
    Stack<ASTNode> stack;

    public NestingReconstructor(Stack<ASTNode> aStack)
    {
        stack = aStack;
    }

    protected void addItemToParent(ASTNode expression) {
        ASTNode topOfStack = stack.peek();
        topOfStack.addChild(expression);
    }

    // 合并子表达式
    protected void consolidateSubExpression(ParserRuleContext ctx) {
        Expression expression = (Expression) stack.pop();
        expression.initializeFromContext(ctx);
        if (!(expression instanceof ExpressionHolder))
            expression = pullUpOnlyChild(expression);
        addItemToParent(expression);
    }

    // 修剪AST，如果一个父节点只有一个子结点那么该父节点被赋值给子结点
    private Expression pullUpOnlyChild(Expression expression) {
        if (expression.getChildCount() == 1)
            expression = (Expression) expression.getChild(0);
        return expression;
    }

    protected void consolidate()
    {

        ASTNode stmt = stack.pop();
        ASTNode topOfStack = null;

        if (stack.size() > 0)
            topOfStack = stack.peek();

        if (topOfStack instanceof CompoundStatement) {
            CompoundStatement compound = (CompoundStatement) topOfStack;
            compound.addStatement(stmt);
        }
    }
}
