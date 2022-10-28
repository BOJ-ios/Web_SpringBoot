package com.example.sql.p5;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Sale {
  @Id
  public Integer no;
  public String id;
  public String product;
  @CreationTimestamp
  public LocalDateTime bdate;
  public Integer bcount;
  public Integer bprice;
}