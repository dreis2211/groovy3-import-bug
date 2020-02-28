package org.dreis;

import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.classgen.GeneratorContext;
import org.codehaus.groovy.control.CompilationFailedException;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.control.customizers.CompilationCustomizer;
import org.codehaus.groovy.control.customizers.ImportCustomizer;

import java.util.Arrays;
import java.util.List;

public class ImportCompilationCustomizer extends CompilationCustomizer {

    public ImportCompilationCustomizer() {
        super(CompilePhase.CONVERSION);
    }

    @Override
    public void call(SourceUnit source, GeneratorContext context, ClassNode classNode)
            throws CompilationFailedException {

        ImportCustomizer importCustomizer = new ImportCustomizer();
        List<CompilerAutoConfiguration> compilerAutoConfigurations = Arrays.asList(new ApplicationCompilerAutoConfiguration(), new ExampleCompilerAutoConfiguration());
        for (CompilerAutoConfiguration autoConfiguration : compilerAutoConfigurations) {
            // if (source.getAST().getClasses().stream().anyMatch(autoConfiguration::matches)) {
            if (autoConfiguration.matches(classNode)) {
                autoConfiguration.applyImports(importCustomizer);
                importCustomizer.call(source, context, classNode);
            }
        }
    }

}
