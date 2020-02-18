package org.dreis;

import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.classgen.GeneratorContext;
import org.codehaus.groovy.control.CompilationFailedException;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.control.customizers.CompilationCustomizer;
import org.codehaus.groovy.control.customizers.ImportCustomizer;

import java.util.Arrays;

public class ImportCompilationCustomizer extends CompilationCustomizer {

    public ImportCompilationCustomizer() {
        super(CompilePhase.CONVERSION);
    }

    @Override
    public void call(SourceUnit source, GeneratorContext context, ClassNode classNode)
            throws CompilationFailedException {

        ImportCustomizer importCustomizer = new ImportCustomizer();
        for (CompilerAutoConfiguration autoConfiguration : Arrays.asList(new ApplicationCompilerAutoConfiguration(), new ExampleCompilerAutoConfiguration())) {
            if (autoConfiguration.matches(classNode)) {
                autoConfiguration.applyImports(importCustomizer);
                importCustomizer.call(source, context, classNode);
            }
        }

        importCustomizer.call(source, context, classNode);
    }

}
