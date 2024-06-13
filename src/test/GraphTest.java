import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {
    private Graph graph;

    @Before
    public void setUp() {
        graph = new Graph();
    }

    @Test
    public void testNoWordInGraph_word1NotFound() throws GraphException {
        assertEquals("No word1 or word2 in the graph!", graph.queryBridgeWords("wordNotInGraph1", "word2"));
    }

    @Test
    public void testNoBridgeWords_word1AndWord2InGraphButNoAdjList() throws GraphException {
        graph.addEdge("word1", "word2");
        graph.addEdge("word2", "word3");
        // Ensure nodes are added without edges between word1 and word2
        assertEquals("No bridge words from word3 to word1!", graph.queryBridgeWords("word3", "word1"));
    }
    @Test
    public void testNoBridgeWords_noBridge() throws GraphException {
        graph.addEdge("word1", "word2");
        graph.addEdge("word2", "word3");
        graph.addEdge("word3", "word4");
        // Ensure nodes are added without edges between word1 and word4
        assertEquals("No bridge words from word1 to word4!", graph.queryBridgeWords("word1", "word4"));
    }


    @Test
    public void testOneBridgeWord() throws GraphException {
        graph.addEdge("word1", "middleWord");
        graph.addEdge("middleWord", "word2");

        assertEquals("The bridge words from word1 to word2 are: middleWord", graph.queryBridgeWords("word1", "word2"));
    }

    @Test
    public void testMultipleBridgeWords() throws GraphException {
        graph.addEdge("word1", "middleWord1");
        graph.addEdge("word1", "middleWord2");
        graph.addEdge("middleWord1", "word2");
        graph.addEdge("middleWord2", "word2");

        String result = graph.queryBridgeWords("word1", "word2");
        assertTrue(result.contains("middleWord1"));
        assertTrue(result.contains("middleWord2"));
    }
}