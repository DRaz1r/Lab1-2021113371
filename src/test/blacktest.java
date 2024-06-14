import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class blacktest {
    private Graph graph;

    @Before
    public void setUp() {
        graph = new Graph();
        graph.addEdge("is", "much");
        graph.addEdge("much", "good");
        graph.addEdge("much", "good");
        graph.addEdge("it", "is");
        graph.addEdge("it", "is");
        graph.addEdge("is", "very");
        graph.addEdge("wow", "it");
        graph.addEdge("yes", "much");
        graph.addEdge("very", "nice");
        graph.addEdge("nice", "good");
    }

    @Test
    public void testCalcShortestPath_ValidPath() throws GraphException {
        String expected = "Shortest path from it to nice is: it -> is -> very -> nice with total weight 4";
        String actual = graph.calcShortestPath("it", "nice");
        assertEquals(expected, actual);
    }

    @Test
    public void testCalcShortestPath_invalidPath() throws GraphException {
        String expected = "No path from is to it!";
        String actual = graph.calcShortestPath("is", "it");
        assertEquals(expected, actual);
    }

    @Test
    public void testCalcShortestPath_NotinPath() throws GraphException {
        String expected = "No startWord or endWord in the graph!";
        String actual = graph.calcShortestPath("start", "end");
        assertEquals(expected, actual);
    }

    @Test
    public void testCalcShortestPath_SameWord() throws GraphException {
        String expected = "Shortest path from very to very is: very with total weight 0";
        String actual = graph.calcShortestPath("very", "very");
        assertEquals(expected, actual);
    }

    @Test
    public void testCalcShortestPath_MultipleShortestPaths() throws GraphException {
        String expected = "Shortest path from is to good is: is -> much -> good with total weight 3";
        String actual = graph.calcShortestPath("is", "good");
        assertEquals(expected, actual);
    }
}