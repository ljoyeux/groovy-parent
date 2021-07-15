import org.junit.jupiter.api.Test

import static Complex.*

class MathTest {
    @Test
    void plus() {

        println "MathTest.plus"
        def i = 1

        println i.class.name

        def n = i + c(1g,0g)

        println n
        println n.re.class.name

        println c(0, 1)**2
        println c(-1)**0.5
    }
}
