package org.dreis;

import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.control.CompilationFailedException;
import org.codehaus.groovy.control.customizers.ImportCustomizer;

public class ExampleCompilerAutoConfiguration extends CompilerAutoConfiguration {

    @Override
    public boolean matches(ClassNode classNode) {
        return classNode.getName().equals("Example");
    }

    @Override
    public void applyImports(ImportCustomizer imports) throws CompilationFailedException {
        imports.addImports("java.util.concurrent.atomic.AtomicLong");
    }

}
