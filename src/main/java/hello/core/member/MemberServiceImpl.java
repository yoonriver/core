package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    // AppConfig에서 생성한 생성자를 통해 MemoryMemberRepository 주입
    public MemberServiceImpl(MemberRepository memberRepository) { 
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
