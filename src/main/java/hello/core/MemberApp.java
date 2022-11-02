package hello.core;

import hello.core.member.Grade;
import hello.core.member.IMemberService;
import hello.core.member.Member;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        /*
        AppConfig appConfig = new AppConfig();
        IMemberService memberService = appConfig.memberService();
         */

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // Spring Container
        IMemberService memberService = applicationContext.getBean("memberService", IMemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
