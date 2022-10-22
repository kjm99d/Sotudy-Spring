package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.IMemberRepository;
import hello.core.member.IMemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.IOrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 어플리케이션에 대한 환경 설정은 AppConfig에게 위임 한다.
 */
@Configuration
public class AppConfig {
    @Bean
    public IMemberService memberService() {
        MemberServiceImpl memberService = new MemberServiceImpl(memberRepository());
        System.out.println("[Register Bean] memberService()     => " + memberService);
        return memberService;
    }

    @Bean
    public IMemberRepository memberRepository() {
        IMemberRepository memberRepository = new MemoryMemberRepository();
        System.out.println("[Register Bean] memberRepository()  => " + memberRepository);
        return memberRepository;
    }

    @Bean
    public IOrderService orderService()
    {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
