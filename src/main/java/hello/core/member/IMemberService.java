package hello.core.member;

public interface IMemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
