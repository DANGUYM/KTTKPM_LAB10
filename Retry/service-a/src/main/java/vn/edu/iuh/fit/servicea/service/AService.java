package vn.edu.iuh.fit.servicea.service;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AService {

    private final RestTemplate restTemplate;

    public AService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Retry(name = "serviceB", fallbackMethod = "fallback")
    public String callServiceB() {
        return restTemplate.getForObject("http://localhost:8081/api/b", String.class);
    }

    public String fallback(Throwable t) {
        System.out.println("❌ Retry fallback triggered: " + t.getMessage());
        return "⚠️ Service B is not available. Fallback response.";
    }
}

