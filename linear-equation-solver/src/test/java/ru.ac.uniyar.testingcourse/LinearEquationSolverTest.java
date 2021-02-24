package ru.ac.uniyar.testingcourse;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class LinearEquationSolverTest {

    @Test
    void simpleTestCase(){
        assertEquals(2, LinearEquationSolver.solve(3, 6));
    }
}
