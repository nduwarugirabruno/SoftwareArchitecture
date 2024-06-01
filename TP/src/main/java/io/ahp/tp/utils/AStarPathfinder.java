package io.ahp.tp.utils;

import io.ahp.tp.entity.Node;

import java.util.*;

public class AStarPathfinder {
    public static List<Node> findPath(Node start, Node goal, int[][] grid) {
        // PriorityQueue<Node> open = new PriorityQueue<>((a, b) -> Double.compare(a.getF(), b.getF()));
        PriorityQueue<Node> open = new PriorityQueue<>(Comparator.comparingDouble(Node::getF));
        Set<Node> closed = new HashSet<>();

        start.setG(0);
        start.setH(heuristic(start, goal));
        start.setF(start.getH());
        open.offer(start);

        while (!open.isEmpty()) {
            Node current = open.poll();

            if (current.equals(goal)) {
                return reconstructPath(current);
            }

            closed.add(current);

            for (Node neighbor : getNeighbors(current, grid)) {
                if (closed.contains(neighbor)) continue;

                double tentativeG = current.getG() + 1; // assuming uniform cost
                if (!open.contains(neighbor) || tentativeG < neighbor.getG()) {
                    neighbor.setParent(current);
                    neighbor.setG(tentativeG);
                    neighbor.setH(heuristic(neighbor, goal));
                    neighbor.setF(neighbor.getG() + neighbor.getH());
                    if (!open.contains(neighbor)) {
                        open.offer(neighbor);
                    }
                }
            }
        }

        return null; // no path found
    }

    private static List<Node> reconstructPath(Node goal) {
        List<Node> path = new ArrayList<>();
        Node current = goal;
        while (current != null) {
            path.add(0, current);
            current = current.getParent();
        }
        return path;
    }

    private static double heuristic(Node a, Node b) {
        // You can use different heuristic functions, such as Euclidean distance
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    private static List<Node> getNeighbors(Node node, int[][] grid) {
        List<Node> neighbors = new ArrayList<>();
        int x = node.getX();
        int y = node.getY();
        int rows = grid.length;
        int cols = grid[0].length;

        // Vérifier les voisins haut, bas, gauche et droite
        if (y > 0 && grid[y - 1][x] != 1) { // Haut
            neighbors.add(new Node(x, y - 1));
        }
        if (y < rows - 1 && grid[y + 1][x] != 1) { // Bas
            neighbors.add(new Node(x, y + 1));
        }
        if (x > 0 && grid[y][x - 1] != 1) { // Gauche
            neighbors.add(new Node(x - 1, y));
        }
        if (x < cols - 1 && grid[y][x + 1] != 1) { // Droite
            neighbors.add(new Node(x + 1, y));
        }

        return neighbors;
    }
}