package vn.edu.iuh.fit.servicea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.servicea.service.AService;

@RestController
public class AController {

    private final AService aService;

    public AController(AService aService) {
        this.aService = aService;
    }

    @GetMapping("/api/a")
    public String getDataFromB() {
        return aService.callServiceB();
    }
}


