package ast.statements.blockstarters;

import ast.ASTNode;
import ast.declaration.IdentifierDeclType;
import ast.expressions.Identifier;
import ast.statements.CompoundStatement;

public class CatchStatement extends BlockStarter{
    private IdentifierDeclType exceptionType = null;
    private Identifier exceptionIdentifier = null;
    private CompoundStatement content = null;

    public IdentifierDeclType getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(IdentifierDeclType exceptionType) {
        this.exceptionType = exceptionType;
        super.addChild(this.exceptionType);
    }

    public Identifier getExceptionIdentifier() {
        return this.exceptionIdentifier;
    }

    public void setExceptionIdentifier(Identifier exceptionIdentifier) {
        this.exceptionIdentifier = exceptionIdentifier;
    }

    public CompoundStatement getContent() {
        return this.content;
    }

    public void setContent(CompoundStatement content) {
        this.content = content;
    }

    @Override
    public void addChild(ASTNode node) {
        if (node instanceof Identifier)
            setExceptionIdentifier((Identifier) node);
        else if (node instanceof CompoundStatement)
            setContent((CompoundStatement) node);
        super.addChild(node);
    }
}
