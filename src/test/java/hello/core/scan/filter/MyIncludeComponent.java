package hello.core.scan.filter;

// 어노테이션 고르기

import java.lang.annotation.*;

@Target(ElementType.TYPE) // 클래스 레벨에 붙는 것
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {

}
