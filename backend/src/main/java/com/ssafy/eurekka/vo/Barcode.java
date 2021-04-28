package com.ssafy.eurekka.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Barcode {

  @Id
  private ObjectId id;

  private int code;
  private String name;
  private String imgUrl;
  private String expiration;
  private String category;
}
