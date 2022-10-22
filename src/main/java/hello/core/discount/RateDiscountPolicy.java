package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP)
        {
            /*
                금액이 만약 10000원 인 경우, 1000원을 할인 해주고,
                금액이 만약 20000원 인 경우, 2000원을 할인 해주준다.
                
                주문 금액 대비 할인 정책 개발
             */
            return price * discountPercent / 100;
        }
        return 0;
    }
}
