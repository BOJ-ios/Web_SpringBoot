package com.p7.bank;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QARepository extends JpaRepository<QA, Integer> {
  @Transactional
  @Modifying
  @Query("update QA set adate=now(), answer=?2 where no=?1")
  int updateAnswer(int no, String answer);

  @Query("select count(id) from QA where id=?1")
  int findQCount(String id);
} // interface