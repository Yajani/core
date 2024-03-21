package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
/*
    컴포넌트 스캔을 사용하면 @Configuration 이 붙은 설정 정보도 자동으로 등록되기 때문에,
    AppConfig, TestConfig 등 앞서 만들어두었던 설정 정보도 함께 등록되고, 실행되어 버린다.
    그래서 excludeFilters 를 이용해서 설정정보는 컴포넌트 스캔 대상에서 제외했다.
    보통 설정 정보를 컴포넌트 스캔 대상에서 제외하지는 않지만,
    기존 예제 코드를 최대한 남기고 유지하기 위해서 이 방법을 선택했다.
* */
/*
@ComponentScan(
* basePackages = "hello.core" )- 탐색할 패키지의 시작 위치를 지정한다
basePackages = {"hello.core", "hello.service"} -> 여러 시작위치 지정가능
지정하지 않으면 하위 패키지까지 다 뒤진다 (권장하는 방법)
* */
@Configuration
@ComponentScan( //뺄것을 지정해줌(Appconfig에 있는 @Configuration 어노테이션 뺴줌)
        basePackages = "hello.core.member", //탐색할 패키지의 시작 위치를 지정
        basePackageClasses = AutoAppConfig.class, //지정한 클래스의 패키지를 탐색 시작 위치로 지정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
)
public class AutoAppConfig { //수동등록 Bean이 우선권을 갖는다 (수동 빈이 자동 빈을 오버라이딩 해버린다.)
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
