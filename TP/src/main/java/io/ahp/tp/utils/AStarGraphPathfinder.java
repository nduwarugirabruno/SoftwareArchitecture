package io.ahp.tp.utils;

import java.util.*;

public class AStarGraphPathfinder {
    static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int MAX_DISTANCE = 10000;

    public static List<Node> search(Node start, Node end, Graph graph) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.fCost));
        // PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.fCost - n2.fCost);
        Map<Node, Node> parents = new HashMap<>();
        start.gCost = 0;
        start.hCost = heuristic(start, end);
        queue.add(start);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (current.equals(end)) {
                List<Node> path = new ArrayList<>();
                Node parent = parents.get(end);
                while (parent != null) {
                    path.add(parent);
                    parent = parents.get(parent);
                }
                Collections.reverse(path);
                return path;
            }
            for (Node neighbor : graph.getNeighbors(current)) {
                int newCost = current.gCost + getManhattanDistance(current, neighbor);
                if (newCost < neighbor.gCost || !queue.contains(neighbor)) {
                    neighbor.gCost = newCost;
                    neighbor.hCost = heuristic(neighbor, end);
                    parents.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
        return null;
    }

    private static int heuristic(Node node1, Node node2) {
        return getManhattanDistance(node1, node2);
    }

    private static int getManhattanDistance(Node node1, Node node2) {
        return Math.abs(node1.row - node2.row) + Math.abs(node1.col - node2.col);
    }
}

class Node {
    int row;
    int col;
    int gCost;
    int hCost;
    int fCost;

    Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node node) {
            return row == node.row && col == node.col;
        }
        return false;
    }
}

class Graph {
    private final int[][] grid;
    private final int rows;
    private final int cols;

    Graph(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
    }

    List<Node> getNeighbors(Node node) {
        List<Node> neighbors = new ArrayList<>();
        for (int[] direction : AStarGraphPathfinder.directions) {
            int newRow = node.row + direction[0];
            int newCol = node.col + direction[1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 0) {
                neighbors.add(new Node(newRow, newCol));
            }
        }
        return neighbors;
    }
}