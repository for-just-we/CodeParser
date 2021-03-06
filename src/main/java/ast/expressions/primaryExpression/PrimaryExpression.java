package ast.expressions.primaryExpression;

import ast.expressions.Expression;
import ast.walking.ASTNodeVisitor;

public class PrimaryExpression extends Expression {
    @Override
    public void accept(ASTNodeVisitor visitor) {
        visitor.visit(this);
    }
}
