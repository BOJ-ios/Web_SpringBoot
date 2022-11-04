package com.example.sql.p5;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Member {
  @Id
  public String id;
  public String pw;
  String name;
  public String phone;
  public Integer balance;
  @CreationTimestamp
  public LocalDateTime rdate;
}