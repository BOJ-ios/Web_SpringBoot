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
  @Query("update Star set count_semi=count_semi+1 where name=?1")
  int updateSemiCount(String name);

  @Transactional
  @Modifying
  @Query("update Star set count_final=count_final+1 where name=?1")
  int updateFinalCount(String name);

  @Transactional
  @Modifying
  @Query("update Star set count_semi=0, count_final=0")
  int resetCount();
}
