package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";  // 컨트롤러가 정적 파일(resources/static/* 에 있는 파일)보다 우선순위가 높다.
    }
}
