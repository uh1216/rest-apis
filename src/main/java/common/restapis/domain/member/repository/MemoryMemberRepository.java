package common.restapis.domain.member.repository;

import common.restapis.domain.member.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Long sequence = 0L;
    private static final Map<Long, Member> store = new HashMap<>();


    @Override

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }

    @Override
    public Optional<Member> findByUserId(String Userid) {
        return findAll().stream()
                .filter(m -> m.getUserId().equals(Userid))
                .findFirst();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void ClearData() {
        store.clear();
    }
}
