package hello.core.xml;

import hello.core.member.IMemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {

    @Test
    void xmlAppContext()
    {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        IMemberService memberService = ac.getBean("memberService", IMemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(IMemberService.class);


    }

}
