package ast.expressions.primaryExpression;

import ast.walking.ASTNodeVisitor;

public class CharExpression extends PrimaryExpression{
    @Override
    public void accept(ASTNodeVisitor visitor) {
        visitor.visit(this);
    }
}
