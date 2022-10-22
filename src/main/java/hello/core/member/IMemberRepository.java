package hello.core.member;

public interface IMemberRepository {

    void save(Member member);
    Member findById(Long memberId);
}
