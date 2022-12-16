package com.p7.bank;

import java.util.List;

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

  @Query("select balance from Member where id=?1")
  int findBalance(String id); /* 잔액 조회 */

  @Modifying
  @Query("update Member set balance=balance+?2 where id=?1")
  int updateBalance(String id, int money);

  @Query("select count(id) from Member")
  int findCount(); /* 로그인화면에서 사용했던 총회원수 메소드 */

  @Query("select sum(balance) from Member")
  int findSum(); /* 총잔액 */

  @Query("select b from Member b where balance>=50000000 order by b.id asc")
  List<Member> findVip();

} // interface