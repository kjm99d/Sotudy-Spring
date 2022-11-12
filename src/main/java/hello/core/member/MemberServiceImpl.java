package hello.core.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MemberServiceImpl implements IMemberService{


    private IMemberRepository memberRepository;

    /*
    이전에 AppConfig에서는 @Bean으로 직접 설정 정보를 입력했으나, 이제는 그러지 않는다.
     */

    @Autowired  // << ac.getBean(MemberRepository.class) 유사하게 동작한다.
    public MemberServiceImpl(IMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
