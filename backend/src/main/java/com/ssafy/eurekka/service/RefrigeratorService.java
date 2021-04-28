package com.ssafy.eurekka.service;

import com.ssafy.eurekka.vo.Product;
import com.ssafy.eurekka.vo.Refrigerator;
import org.bson.types.ObjectId;

public interface RefrigeratorService {

  Refrigerator createProduct(ObjectId id, String category, Product product);
}
