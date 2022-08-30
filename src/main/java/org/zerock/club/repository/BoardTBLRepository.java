package org.zerock.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.zerock.club.entity.BoardTBL;

import javax.transaction.Transactional;
import java.util.Optional;

public interface BoardTBLRepository extends JpaRepository<BoardTBL, Long> {

    @Query("select n from BoardTBL n where n.p_id = :num")
    Optional<BoardTBL> getWithWriter(Long num);

    @Query("select n from BoardTBL n")
    Optional<BoardTBL> all();

    @Modifying
    @Transactional
    @Query("UPDATE BoardTBL n SET n.counts = n.counts +1 where n.p_id = :num")
    Integer addCounts(Long num);


}