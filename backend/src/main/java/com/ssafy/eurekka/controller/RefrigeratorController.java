package com.ssafy.eurekka.controller;

import com.ssafy.eurekka.service.RefrigeratorService;
import com.ssafy.eurekka.vo.Product;
import com.ssafy.eurekka.vo.Refrigerator;
import io.swagger.annotations.ApiOperation;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/refrigerator")
public class RefrigeratorController {

  @Autowired
  private RefrigeratorService refrigeratorService;

  @ApiOperation(value = "제품등록", notes = "냉장고 id와 제품 정보를 인자로 받아 제품 등록")
  @PutMapping("/register")
  public ResponseEntity<?> createProduct(
      @RequestParam("id") ObjectId id, @RequestParam("category") String category, @RequestBody Product product) {
    Refrigerator result = refrigeratorService.createProduct(id, category, product);
    if (result == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<>(result, HttpStatus.OK);
    }
  }

}
