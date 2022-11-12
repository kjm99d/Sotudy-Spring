package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        /*
        * 아래 내용을 지정 하지 않는다면, Default로 동작한다.
        *
        * 지정하지 않을 경우 AutoAppConfig Class의 시작 위치가 basePackageClass가 된다.
        * 권장하는 방법: Configuration이 붙은 클래스를 최상단에 넣어두고 사용한다.
        *
        * >> ComponentScan의 대상
        *   컴포넌트 스캔의 대상은 @Component 만이 아니라 다음과 같은 어노테이션 또한 대상이 된다.
        * @Component
        * @Controller
        * @Service
        * @Repository
        * @Configuration
        *
        * 왜? 대상이 되는가?
        * -> @Serivce 또한 @Component를 사용하기 때문이다.
        *
        basePackages = "hello.core.member", // <<<  어디서부터 찾을지 지정이 가능하다.
        basePackageClasses = AutoAppConfig.class, // <<< 햔재 패키지는 hello.core (1) 참조
        */
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
