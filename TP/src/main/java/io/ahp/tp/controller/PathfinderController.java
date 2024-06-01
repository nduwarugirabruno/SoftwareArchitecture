package io.ahp.tp.controller;

import io.ahp.tp.entity.Node;
import io.ahp.tp.service.PathfinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PathfinderController {

    final
    PathfinderService pathfinderService;

    @Autowired
    public PathfinderController(PathfinderService pathfinderService) {
        this.pathfinderService = pathfinderService;
    }

    @GetMapping("/find-path")
    public List<Node> findPath(@RequestParam int startX, @RequestParam int startY, @RequestParam int goalX, @RequestParam int goalY, @RequestParam int[][] grid) {
        Node start = new Node(startX, startY);
        Node goal = new Node(goalX, goalY);
        return pathfinderService.findPath(start, goal, grid);
    }
}