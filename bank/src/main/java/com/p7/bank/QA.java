package com.p7.bank;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class QA {
  /*
   * 여기를 채워보세요.
   * qdate는 질문등록(insert)시에 날짜가 자동 생성이므로 @ 있음
   * 반면 adate는 나중에 답변등록(update)시에 결정되므로 @ 없음
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer no;
  public String id;
  @CreationTimestamp
  public LocalDateTime qdate;
  public String question;
  public LocalDateTime adate;
  public String answer;
} // class
