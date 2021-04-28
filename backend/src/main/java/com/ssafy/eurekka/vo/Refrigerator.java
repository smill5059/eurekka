package com.ssafy.eurekka.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ssafy.eurekka.util.CustomObjectIdSerializer;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Refrigerator {

  @JsonSerialize(using = CustomObjectIdSerializer.class)
  @Id
  private ObjectId id;

  List<Product> noodles;
  List<Product> snack;
  List<Product> beverage;
  List<Product> pickles;
  List<Product> diary;
  List<Product> health;
  List<Product> powder;
  List<Product> meat;
  List<Product> seasoning;
  List<Product> ocean;
  List<Product> fresh;
  List<Product> alcohol;
  List<Product> frozen;
  List<Product> ices;
  List<Product> others;
}
