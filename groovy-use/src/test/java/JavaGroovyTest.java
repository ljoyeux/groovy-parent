import groovy.lang.GroovyShell;
import org.junit.jupiter.api.Test;

public class JavaGroovyTest {
    @Test
    void callGroovy() {
        GroovyShell groovyShell = new GroovyShell();
        Object evaluate = groovyShell.evaluate("Complex.c(0, -1)**0.5");
        System.out.println(evaluate);
    }
}
