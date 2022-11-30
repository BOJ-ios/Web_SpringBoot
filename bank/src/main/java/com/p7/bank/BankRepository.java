package com.p7.bank;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
  @Query("select b from Bank b where id=?1 order by tdate desc")
  List<Bank> findByIdOrderByTdateDesc(String id); /* 최근일순 조회 */

  @Query("select balance from Member where id=?1")
  int findBalance(String id);/* 잔액 조회 */

  @Query("select b from Bank b order by id asc, tdate desc")
  List<Bank> findAllOrderByIdTdateDesc();

  @Query("select m from Member m where balance<0")
  List<Member> findByBalanceWhereMinus();
} // interface