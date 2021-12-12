package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // ------------ 구현체를 정해주는 메소드 작성 ------------
    // MemoryMemberRepository()를 반환하는 메소드 생성, 나중에 데이터베이스에 관해 변동 사항이 있을 경우 이 부분만 수정하면 됨
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    // FixDiscountPolicy()를 반환하는 메소드 생성, 나중에 할인에 관해 변동 사항이 있을 경우 이 부분만 수정하면 됨
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }


    // ------------ 생성자를 통해 구현체를 주입 하는 메소드 작성 ------------
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); // 생성해둔 메소드를 통해 반환 된 객체를 생성자로 전달
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
    // return new OrderServiceImpl(memberRepository(), discountPolicy()); // 생성해둔 메소드를 통해 반환 된 객체를 생성자로 전달
        return null;
    }


}
