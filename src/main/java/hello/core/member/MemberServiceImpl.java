package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //null오류 때문에 구현객체(MemoryMemberRepository)를 선택해줘야한다
    private final MemberRepository memberRepository;

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
}
