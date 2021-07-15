import org.junit.jupiter.api.Test

import static Complex.*

class ComplexTest {
    @Test
    void complex() {
        Complex a = c(0, 1)

        def complex = a + c(1, 1)

        println complex

        println a*a
    }
}
