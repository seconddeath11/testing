package ru.ac.uniyar.testingcourse;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class LinearEquationSolverTest {

    @Test
    void simpleTestCase(){
        assertEquals(2, LinearEquationSolver.solve(3, 6));
    }
    @Test
    void rationalTest(){
        assertEquals(-2.5, LinearEquationSolver.solve(-3.5, 8.75));
    }
    @Test
    void precisionOldTo(){assertEquals(0.33, LinearEquationSolver.solve(3, 1), 0.5);}
    @Test
    void simpleCase(){assertThat(LinearEquationSolver.solve(1, 3)).isEqualTo(3);}
    @Test
    void rationalCase(){assertThat(LinearEquationSolver.solve(-3.5, 8.75)).isEqualTo(-2.5);}
    @Test
    void precisionTest(){assertThat(LinearEquationSolver.solve(3, 1)).isCloseTo(0.3, within(0.1));}
    @Test
    void precision2Test(){assertThat(LinearEquationSolver.solve(3, 1)).isEqualTo(0.3, withPrecision(2d));}
    @Test
    void noRootsCase(){assertThat(LinearEquationSolver.solve(0, 1)).isNull();}
    @Test
    void exceptionCase() {
        assertThatThrownBy(() -> {
            LinearEquationSolver.solve(0, 0);
        }).isInstanceOf(LinearEquationSolver.AnyNumberIsRootException.class);
    }

}
