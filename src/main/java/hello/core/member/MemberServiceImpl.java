package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Component("memberService2") //Bean이름 직접 지정하는 방법
public class MemberServiceImpl implements MemberService{
    //null오류 때문에 구현객체(MemoryMemberRepository)를 선택해줘야한다
    private final MemberRepository memberRepository;

    @Autowired //ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } //생성자를 통해 멤버 리포지토리에 구현체가 뭐가 들어갈지 선택함

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
