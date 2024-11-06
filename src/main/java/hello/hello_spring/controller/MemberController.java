package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //연결해주는 애노테이션(컴포넌트 스캔과 의존관계 설정)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
