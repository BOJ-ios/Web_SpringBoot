package com.example.sql.p5;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Star {
  @Id
  public Integer no;
  public String name;
  public Integer count_semi;
  public Integer count_final;
}