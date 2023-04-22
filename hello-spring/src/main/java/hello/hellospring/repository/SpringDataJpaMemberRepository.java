package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository를 받고 있는 인터페이스라면 구현체를 자동으로 만들어서 스프링 빈에 등록해줌 (스프링 데이터 jpa가)
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
    // "findBy~~" 메서드를 overide 하면 ~~와 반환타입을 사용해서 자동으로 sql을 만들어준다.
    // 여기서는 자동으로 "select m from Member m where m.name = ?" 이라는 JPQL을 만들어준다.
}
