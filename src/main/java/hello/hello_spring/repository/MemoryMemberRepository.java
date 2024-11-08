package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //id 셋팅
        store.put(member.getId(), member);//store 맵에 멤버의 아이디와 멤버의 이름 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //Optional.ofNullable: id의 값이 없으면, null 반환해줌.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) //람다식
                .findAny(); //람다식으로 루프를 돌아서 이름 값이 같으면, 이름을 반환하고, 없으면 Optional의 null이 포함돼서 반환.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //member들이 반환됨.
    }

    public void clearStore() {
        store.clear(); // store 비워줌
    }
}