package io.ahp.tp.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    private int x;
    private int y;
    private double g; // actual cost from start to this node
    private double h; // heuristic estimated cost from this node to the goal
    private double f; // total estimated cost (g + h)
    private Node parent;

    public Node() {
        super();
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}