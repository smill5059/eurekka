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

  List<ObjectId> noodles;
  List<ObjectId> snack;
  List<ObjectId> beverage;
  List<ObjectId> pickles;
  List<ObjectId> diary;
  List<ObjectId> health;
  List<ObjectId> powder;
  List<ObjectId> meat;
  List<ObjectId> seasoning;
  List<ObjectId> ocean;
  List<ObjectId> fresh;
  List<ObjectId> alcohol;
  List<ObjectId> frozen;
  List<ObjectId> ices;
  List<ObjectId> others;
}
