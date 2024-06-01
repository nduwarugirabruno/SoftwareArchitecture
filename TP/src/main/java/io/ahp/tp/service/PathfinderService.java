package io.ahp.tp.service;

import io.ahp.tp.entity.Node;

import java.util.List;

public interface PathfinderService {
    List<Node> findPath(Node start, Node goal, int[][] grid);
}
