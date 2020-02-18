package org.dreis;

import org.codehaus.groovy.control.CompilationUnit;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.Phases;
import org.junit.jupiter.api.Test;

class ImportTest {

    @Test
    public void importBreaks() {
        CompilerConfiguration configuration = new CompilerConfiguration();
        configuration.addCompilationCustomizers(new ImportCompilationCustomizer());
        CompilationUnit compilationUnit = new CompilationUnit(configuration);
        compilationUnit.addSource(getClass().getClassLoader().getResource("beans.groovy"));
        compilationUnit.compile(Phases.CLASS_GENERATION);
    }

}