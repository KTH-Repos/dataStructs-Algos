import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for GraphAlgorithms.
 *
 * @author [Tomas]
 * @version [2021-02-25]
 */

public class GraphAlgorithmsTest {
    @Before
    public void setUp() {}

    @Test
    public void hasCycleTrueMultipleComponents() {
        // Arrange
        // Three components:
        // 0 - 1 - 5
        // 2 - 3
        //  \ /
        //   9
        // 4 - 6 - 7 - 8
        Graph g = new Graph(10);
        g.add(0, 1, 0);
        g.add(1, 5, 0);
        g.add(9, 2, 0);
        g.add(2, 3, 0);
        g.add(3, 9, 0);
        g.add(4, 6, 0);
        g.add(6, 7, 0);
        g.add(7, 8, 0);

        // Act
        boolean hasCycle = GraphAlgorithms.hasCycle(g);

        // Assert
        assertTrue(hasCycle);
    }

    @Test
    public void hasPathTrueTreeGraph() {
        // Arrange
        //            0
        //           / \
        //          1   2
        //         / \   \
        //        3   4   5
        //       / \   \
        //      6   7   8
        //               \
        //                9
        Graph g = new Graph(10);
        g.add(0, 1, 0);
        g.add(0, 2, 0);
        g.add(1, 3, 0);
        g.add(1, 4, 0);
        g.add(2, 5, 0);
        g.add(3, 6, 0);
        g.add(3, 7, 0);
        g.add(4, 8, 0);
        g.add(8, 9, 0);

        // Act
        boolean hasPath = GraphAlgorithms.hasPath(g, 0, 9);

        // Assert
        assertTrue(hasPath);
    }

    @Test
    public void hasCycleFalseSingleComponent() {
        //fail("Not implemented!");
        //Arrange
        //0-1-2-3
        Graph myGraph = new Graph(4);
        myGraph.add(0,1,0);
        myGraph.add(1,2,0);
        myGraph.add(2,3,0);

        //Act
        boolean hasCycle = GraphAlgorithms.hasCycle(myGraph);

        //Assert
        assertFalse(hasCycle);
    }

  @Test
    public void hasCycleTrueSingleComponent() {
        //fail("Not implemented!");
        //Arrange
        //0-1-2-3
        // \ /
        //  4
        Graph myGraph = new Graph(5);
        myGraph.add(0,4,0);
        myGraph.add(0,1,0);
        myGraph.add(1,2,0);
        myGraph.add(2,3,0);
        myGraph.add(4,2,0);

        //Act
        boolean hasCycle = GraphAlgorithms.hasCycle(myGraph);

        //Assert
        assertTrue(hasCycle);
  }

  @Test
    public void hasCycleFalseMultipleComponents() {
        //fail("Not implemented!");
      // Arrange
      // Three components:
      // 0 - 1 - 5
      // 2 - 3 - 9
      // 4 - 6 - 7 - 8
      Graph g = new Graph(10);
      g.add(0, 1, 0);
      g.add(1, 5, 0);
      g.add(2, 3, 0);
      g.add(3, 9, 0);
      g.add(4, 6, 0);
      g.add(6, 7, 0);
      g.add(7, 8, 0);

      //Act
      boolean hasCycle = GraphAlgorithms.hasCycle(g);

      //Assert
      assertFalse(hasCycle);


  }

    @Test
    public void graphWithCycleHasPathToSelf() {
        //fail("Not implemented!");
        //Assert
        //0-1-2-3
        // \ /
        //  4
        Graph myGraph = new Graph(5);
        myGraph.add(0,4,0);
        myGraph.add(0,1,0);
        myGraph.add(1,2,0);
        myGraph.add(2,3,0);
        myGraph.add(4,2,0);

        //Act
        boolean hasPathToSelf = GraphAlgorithms.hasPath(myGraph,2,2);

        //Assert
        assertTrue(hasPathToSelf);
    }

    @Test
    public void verteciesOnDifferentComponentsHasPathIsFalse() {
         //fail("Not implemented!");
        //Arrange
        //Two Components:
        //0-1-2
        //3-4-5
        Graph myGraph = new Graph(6);
        myGraph.add(0,1,0);
        myGraph.add(1,2,0);
        myGraph.add(3,4,0);
        myGraph.add(4,5,0);

        //Act
        boolean hasPath = GraphAlgorithms.hasPath(myGraph,1,4);

        //Assert
        assertFalse(hasPath);
    }

    @Test
    public void graphWithVerteciesWithoutEdgesHasPathIsFalse() {
        //fail("Not implemented!");
        //Arrange
        Graph myGraph = new Graph(3);

        //Act
        boolean hasPath = GraphAlgorithms.hasPath(myGraph,0,2);

        //Assert
        assertFalse(hasPath);
    }
}
