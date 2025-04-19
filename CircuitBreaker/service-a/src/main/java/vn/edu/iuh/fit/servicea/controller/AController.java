package vn.edu.iuh.fit.servicea.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.servicea.service.AService;


@RestController
@RequiredArgsConstructor
public class AController {

    private final AService aService;

    @GetMapping("/api/a")
    public String fromA() {
        String bResponse = aService.callB();
        return "A nhận từ B ➡️ " + bResponse;
    }
}


