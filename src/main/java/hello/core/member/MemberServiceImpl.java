package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 리파지토리가 추상화와 구체화 모두에 이존하고 있다. DIP 위반
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
