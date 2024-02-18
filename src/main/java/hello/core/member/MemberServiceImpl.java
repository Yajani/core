package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //null오류 때문에 구현객체(MemoryMemberRepository)를 선택해줘야한다
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
