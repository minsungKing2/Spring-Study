package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.ArrayList;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //멤버 저장
    Optional<Member> findById(Long id); //Optional은 변수에 값이 없으면, null을 반환함.
    Optional<Member> findByName(String name);
    ArrayList<Member> findAll();
}
