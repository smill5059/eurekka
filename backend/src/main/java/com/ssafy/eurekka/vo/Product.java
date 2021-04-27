package com.ssafy.eurekka.vo;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  private String name;
  @Temporal(TemporalType.TIMESTAMP)
  private Date expirationDate;
}
