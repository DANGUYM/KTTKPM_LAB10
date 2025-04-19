package vn.edu.iuh.fit.serviceb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class BController {

    @GetMapping("/api/b")
    public String handle() {
        return "✅ Hello from Service B at " + LocalTime.now();
    }
}
