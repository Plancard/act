package org.zerock.club.repository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.club.entity.MemberTBL;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<MemberTBL, String>{

    @EntityGraph(attributePaths = "m_email", type = EntityGraph.EntityGraphType.LOAD)
    @Query("select n from MemberTBL n where n.m_id = :num")
    Optional<MemberTBL> getWithWriter(Long num);

    @Query("select n from MemberTBL n")
    Optional<MemberTBL> all();
}
