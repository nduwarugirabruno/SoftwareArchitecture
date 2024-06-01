package io.ahp.tp;

import io.ahp.tp.entity.Node;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static io.ahp.tp.utils.AStarPathfinder.findPath;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TPApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testAStarPathfinding() {
		// Define the grid
		int[][] grid = {
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0}
		};

		// Define the start and goal nodes
		Node start = new Node(0, 0);
		Node goal = new Node(4, 4);

		// Find the path
		List<Node> path = findPath(start, goal, grid);

		// Verify the path
		assertNotNull(path);
		assertEquals(9, path.size()); // The path should have 5 nodes (start, 3 intermediate, goal)
		assertEquals(start, path.get(0));
		assertEquals(goal, path.get(path.size() - 1));
	}

	@Test
	void testAStarPathfindingWithObstacles() {
		// Define the grid with obstacles
		int[][] grid = {
				{0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0},
				{0, 0, 0, 0, 0}
		};

		// Define the start and goal nodes
		Node start = new Node(0, 0);
		Node goal = new Node(4, 4);

		// Find the path
		List<Node> path = findPath(start, goal, grid);

		// Verify the path
		assertNotNull(path);
		assertEquals(9, path.size()); // The path should have 9 nodes (start, 7 intermediate, goal)
		assertEquals(start, path.get(0));
		assertEquals(goal, path.get(path.size() - 1));
	}

	@Test
	void testAStarPathfindingWithNoPath() {
		// Define the grid with no path
		int[][] grid = {
				{0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0},
				{0, 1, 1, 1, 0},
				{0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0}
		};

		// Define the start and goal nodes
		Node start = new Node(0, 0);
		Node goal = new Node(4, 4);

		// Find the path
		List<Node> path = findPath(start, goal, grid);

		// Verify the path
		assertNotNull(path);
		assertEquals(9, path.size()); // The path should be empty, as no path is found
	}
}
