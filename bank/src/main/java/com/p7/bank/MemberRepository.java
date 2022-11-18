package com.p7.bank;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
  @Transactional
  @Modifying
  @Query("update Member set pw=?2, name=?3, phone=?4 where id=?1")
  int updateMyinfo(String id, String pw, String name, String phone);

  @Query("select count(id) from Member")
  int countId();
} // interface