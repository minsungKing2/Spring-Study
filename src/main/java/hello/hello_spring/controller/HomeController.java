package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //컨트롤러가 우선순위, 컨트롤러가 있으면, 정적 화면 무시함. 컨트롤러가 없으면, 정적 화면 호출함.
public class HomeController {

    @GetMapping("/") //localhost8080 들어가면 나오는 화면
    public String home(){
        return "home";
    }
}
