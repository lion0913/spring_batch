package com.ll.lion.spring_batch.app.member.repository;

import com.ll.lion.spring_batch.app.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
