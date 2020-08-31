package com.macdonnacha.app.solver;

import static org.junit.Assert.assertTrue;

import com.macdonnacha.app.sudoku.Grid;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class SolverTest {
    private Grid[] grid;
    private Solver solver;


    @Before
    public void setUp() {
        grid = new Grid[]{
            new Grid("006481300020000040700000009800090004600342001500060002300000005090000070005716200"),
            new Grid("008571900000403000100090008810000025304000601520000073200050004000704000001932500")
        };
        
    }

    @After
    public void tearDown() {
        grid = null;
    }

    @Test
    public void cleanupShouldNotChangeValues(){
        String answer = "006481300020000040700000009800090004600342001500060002300000005090000070005716200";
        solver = new Solver(grid[0]);
        solver.cleanUpGrid();
        String after = grid[0].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);
    }

    @Test
    public void nakedSingleTest(){
        String answer = "956481307020000040700000009800090004670342001500060002300020005090000070405716200";
        solver = new Solver(grid[0]);
        solver.cleanUpGrid();
        solver.setNakedSingle();
        String after = grid[0].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);

    }

    @Test
    public void uniqueTest(){
        String answer = "906481327020070040700000009802090004600342001500060002367000005291000070485716293";
        solver = new Solver(grid[0]);
        solver.cleanUpGrid();
        solver.setUnique();
        String after = grid[0].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);

    }

    @Test
    public void cleanupShouldNotChangeValues2(){
        String answer = "008571900000403000100090008810000025304000601520000073200050004000704000001932500";
        solver = new Solver(grid[1]);
        solver.cleanUpGrid();
        String after = grid[1].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);
    }

    @Test
    public void nakedSingleTest2(){
        String answer = "008571900000403000100096008810000425304000601520000073200050004000704000001932500";
        solver = new Solver(grid[1]);
        solver.cleanUpGrid();
        solver.setNakedSingle();
        String after = grid[1].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);

    }

    @Test
    public void uniqueTest2(){
        String answer = "008571902000483000100296008810300025304025691520000873200050004000704009001932500";
        solver = new Solver(grid[1]);
        solver.cleanUpGrid();
        solver.setUnique();
        String after = grid[1].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);

    }

    @Test
    public void level0StrategiesTest(){
        String answer = "956481327020070040700200009802090004670342001500060002367020005291000070485716293";
        solver = new Solver(grid[0]);
        solver.cleanUpGrid();
        solver.level0Strategies();
        String after = grid[0].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);
    }

    @Test
    public void level0StrategiesTest2(){
        String answer = "008571902000483000100296008810300425304025691520040873200050004000714009001932500";
        solver = new Solver(grid[1]);
        solver.cleanUpGrid();
        solver.level0Strategies();
        String after = grid[1].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);
    }

    @Test
    public void solveTest(){
        String answer = "956481327123679548748253619832195764679342851514867932367924185291538476485716293";
        solver = new Solver(grid[0]);
        solver.solve();
        String after = grid[0].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);
    }

    @Test
    public void solveTest2(){
        String answer = "438571962962483157157296348819367425374825691526149873293658714685714239741932586";
        solver = new Solver(grid[1]);
        solver.solve();        
        String after = grid[1].solutionAsSingleLine();

        boolean shouldBeTrue = answer.equals(after);

        assertTrue(shouldBeTrue);
    }

}