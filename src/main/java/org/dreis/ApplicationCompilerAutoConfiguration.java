package org.dreis;

import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.control.CompilationFailedException;
import org.codehaus.groovy.control.customizers.ImportCustomizer;

public class ApplicationCompilerAutoConfiguration extends CompilerAutoConfiguration {

    @Override
    public boolean matches(ClassNode classNode) {
        return classNode.getName().equals("Application");
    }

    @Override
    public void applyImports(ImportCustomizer imports) throws CompilationFailedException {
        imports.addImports("java.util.concurrent.atomic.AtomicInteger");
    }

}
