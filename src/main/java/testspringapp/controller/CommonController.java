package testspringapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/common")
public class CommonController {

    @GetMapping("/delay")
    public String getDelay() {
        for (int i = 0; i < 1000000; i++) {
            final int i1 = i % 2;
        }
        return  null;
    }
}
