package hello.core;

import hello.core.member.Grade;
import hello.core.member.IMemberService;
import hello.core.member.Member;
import hello.core.member.MemberServiceImpl;
import hello.core.order.IOrderService;
import hello.core.order.Order;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        /*
            AppConfig appConfig = new AppConfig();
            IMemberService memberService = appConfig.memberService();
            IOrderService orderService = appConfig.orderService();
        */

        ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);
        IMemberService memberService = appCtx.getBean("memberService", IMemberService.class);
        IOrderService orderService = appCtx.getBean("orderService", IOrderService.class);

        System.out.println("[Get Bean] memberService    => " + memberService);


        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());


    }
}
