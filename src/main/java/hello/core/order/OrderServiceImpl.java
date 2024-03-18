package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;

    private final DiscountPolicy discountPolicy; //인터페이스에만 의존하도록 변경

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy, MemberRepository memberRepository1, DiscountPolicy discountPolicy1) {

        this.memberRepository = memberRepository1;
        this.discountPolicy = discountPolicy1;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);


        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}

