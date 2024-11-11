package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Spring은 컨트롤러 만들때 해줘야됨.
public class HelloController {

    @GetMapping("hello") // hello가 들어오면, 이 메서드를 호출시켜줌.
    public String hello(Model model){ // MVC의 model임.
        model.addAttribute("data","hello!!"); // 키, 속성
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http의 body에 이 데이터의 내용을 직접 넣어준다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; //"hello spring" 위와 다르게, html 태그 없이 내용만 나옴.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // hello라는 객체를 넘김 -> JSON 방식으로 html이 나옴. key:value, Spring은 JSON으로 반환하는게 디폴트임.

    }

    static class Hello{
        private String name;
        // 프로퍼티 방식 getter setter
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
