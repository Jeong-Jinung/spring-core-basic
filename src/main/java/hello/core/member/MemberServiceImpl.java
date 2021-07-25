package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MemberServiceImpl implements MemberService {

    // 리파지토리가 추상화와 구체화 모두에 이존하고 있다. DIP 위반
    private final MemberRepository memberRepository;

    @Autowired //ac.getBean(MemberRepository.class) 비슷하게 자동으로 들어가게됨
    public MemberServiceImpl(MemberRepository memberRepository){
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

    //테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
