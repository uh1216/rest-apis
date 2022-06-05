package common.restapis.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        memberRepository.ClearData();
    }

    @Test
    void save() {
        //given
        Member member = new Member("dd", "123", "123");
        //when
        Member savedMember = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(member.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("1", "1", "1");
        Member member2 = new Member("2", "2", "2");

        memberRepository.save(member1);
        memberRepository.save(member2);
        //when

        List<Member> findAllMembers = memberRepository.findAll();

        //then
        assertThat(findAllMembers.size()).isEqualTo(2);
        assertThat(findAllMembers).contains(member1, member2);
    }
}