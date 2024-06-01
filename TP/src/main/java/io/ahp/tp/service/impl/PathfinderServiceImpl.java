package io.ahp.tp.service.impl;

import io.ahp.ahp.entity.Node;
import io.ahp.ahp.service.PathfinderService;
import io.ahp.ahp.utils.AStarPathfinder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PathfinderServiceImpl implements PathfinderService {
    @Override
    public List<Node> findPath(Node start, Node goal, int[][] grid) {
        return AStarPathfinder.findPath(start, goal, grid);
    }
}
