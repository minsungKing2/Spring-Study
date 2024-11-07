package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //연결해주는 애노테이션(컴포넌트 스캔과 의존관계 설정)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //@GetMapping: ("")의 페이지로 들어가면, 이 메서드가 실행됨. 여기선 ("/members/new") 페이지로 들어가면,
    //members/createMemberForm 페이지를 return 해줌.
    //URL에 주소를 치는 것은 @GetMapping 방식
    @GetMapping("/members/new") //회원 가입 페이지
    public String createForm(){
        return "members/createMemberForm";
    }
    //조회 - Get, 등록 - Post
    //@PostMapping: name의 데이터를 전달 받음
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member.getName() = " + member.getName()); //soutv 단축키
        
        memberService.join(member); //회원가입하면 member를 넘겨줌.

        return "redirect:/"; //redirect: 페이지로 보내주는 역할. 여기선 회원가입이 끝나면, 홈 화면으로 보내줌.
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers(); //ctrl + alt + v 단축키 : 변수 자동 생성
        model.addAttribute("members", members); //키: members, 값: members
        //ctrl + e 단축키 : 가장 최근에 본 프로젝트 열어줌.
        return "members/memberList";
    }

}
