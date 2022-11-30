package com.example.sql.p5;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StarRepository extends JpaRepository<Star, Integer> {
  @Transactional
  @Modifying
  @Query("update Star s set s.count_semi=s.count_semi+1 where name=?1")
  int updateSemiCount(String name);

  @Transactional
  @Modifying
  @Query("update Star s set s.count_final=s.count_final+1, s.count_semi=s.count_semi-1 where name=?1")
  int updateFinalCount(String name);

  @Transactional
  @Modifying
  @Query("update Star s set s.count_semi=0, s.count_final=0")
  int resetCount();
}
