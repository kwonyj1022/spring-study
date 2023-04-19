package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/** @Controller
 * 스프링이 처음에 뜰 때 스프링 컨테이너라는 스프링 통이 생김.
 * 이때 @Controller 가 있는 객체를 생성해서 스프링 컨테이너에 넣어두고 스프링이 관리함
 */
@Controller
public class MemberController {

    private final MemberService memberService;

    /** @Autowired
     * MemberController 생성할 때 이 생성자가 호출되는데
     * @Autowired 가 있으면 스프링 컨테이너에 있는 MemberService를 알아서 연결시켜줌 (의존 관계 주입)
     * 따라서 MemberService도 빈으로 등록해놔야 함
     */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
