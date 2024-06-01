package io.ahp.ahp.controller;

import io.ahp.ahp.service.PathfinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathfinderController {

    final
    PathfinderService pathfinderService;

    @Autowired
    public PathfinderController(PathfinderService pathfinderService) {
        this.pathfinderService = pathfinderService;
    }
}