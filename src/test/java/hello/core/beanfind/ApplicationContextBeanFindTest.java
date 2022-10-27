package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.IMemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        IMemberService memberService = ac.getBean("memberService", IMemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    
    @Test
    @DisplayName("이름없이 타입으로 조회")
    void findBeanByType() {
        IMemberService memberService = ac.getBean(IMemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }



    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        IMemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX()
    {
//        ac.getBean("xxxxx", IMemberService.class);
        //IMemberService xxxxx = ac.getBean("xxxxx", IMemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", IMemberService.class));
    }
}
