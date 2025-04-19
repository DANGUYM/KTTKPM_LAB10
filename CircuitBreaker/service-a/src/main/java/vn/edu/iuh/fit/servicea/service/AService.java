package vn.edu.iuh.fit.servicea.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AService {

    private final RestTemplate restTemplate;

    @CircuitBreaker(name = "serviceB", fallbackMethod = "fallback")
    public String callB() {
        return restTemplate.getForObject("http://localhost:8081/api/b", String.class);
    }

    public String fallback(Throwable t) {
        return "⚠️ Service B không phản hồi. Đang dùng fallback.";
    }
}


