package com.ssafy.eurekka.service;

import com.ssafy.eurekka.repository.ProductRepository;
import com.ssafy.eurekka.repository.RefrigeratorRepository;
import com.ssafy.eurekka.vo.Product;
import com.ssafy.eurekka.vo.Refrigerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefrigeratorServiceImpl implements RefrigeratorService{

  @Autowired
  private RefrigeratorRepository refrigeratorRepository;
  @Autowired
  private ProductRepository productRepository;

  @Override
  public Refrigerator createProduct(ObjectId id, int category, Product product) {
    //product db에 저장
    Product p = productRepository.save(product);

    //refrigerator에 product 추가
    Optional<Refrigerator> found = refrigeratorRepository.findById(id);
    if (found.isPresent()) {
      List<Product> productList = null;
      Refrigerator refrigerator = found.get();
      switch (category) {
        case 0:
          productList = refrigerator.getNoodles();
          if (productList == null) {
            productList = new ArrayList<>();
          }
          productList.add(p);
          refrigerator.setNoodles(productList);
          break;
        case 1:
          productList = refrigerator.getSnack();
          if (productList == null) {
            productList = new ArrayList<>();
          }
          productList.add(p);
          refrigerator.setSnack(productList);
          break;
        case 2:
          productList = refrigerator.getBeverage();
          if (productList == null) {
            productList = new ArrayList<>();
          }
          productList.add(p);
          refrigerator.setBeverage(productList);
          break;
        case 3:
          productList = refrigerator.getPickles();
          if (productList == null) {
            productList = new ArrayList<>();
          }
          productList.add(p);
          refrigerator.setPickles(productList);
          break;
        case 4:
          productList = refrigerator.getDiary();
          if (productList == null) {
            productList = new ArrayList<>();
          }
          productList.add(p);
          refrigerator.setDiary(productList);
          break;
        case 5:
          productList = refrigerator.getHealth();
          if (productList == null) {
            productList = new ArrayList<>();
          }
          productList.add(p);
          refrigerator.setHealth(productList);
          break;
        case 6:
          productList = refrigerator.getPowder();
          if (productList == null) {
            productList = new ArrayList<>();
          }
          productList.add(p);
          refrigerator.setPowder(productList);
          break;
        case 7:
          productList = refrigerator.getMeat();
          if (productList == null) {
            productList = new ArrayList<>();
          }
          productList.add(p);
          refrigerator.setMeat(productList);
          break;
        case 8:
          productList = refrigerator.getSeasoning();
          if (productList == null) {
            productList = new ArrayList<>();
          }
          productList.add(p);
          refrigerator.setSeasoning(productList);
          break;
        case 9:
          productList = refrigerator.getOcean();
          if (productList == null) {
            productList = new ArrayList<>();
          }
          productList.add(p);
          refrigerator.setOcean(productList);
          break;
        case 10:
          productList = refrigerator.getFresh();
          if (productList == null) {
            productList = new ArrayList<>();
          }
          productList.add(p);
          refrigerator.setFresh(productList);
          break;
        case 11:
          productList = refrigerator.getAlcohol();
          if (productList == null) {
            productList = new ArrayList<>();
          }
          productList.add(p);
          refrigerator.setAlcohol(productList);
          break;
        case 12:
          productList = refrigerator.getFrozen();
          if (productList == null) {
            productList = new ArrayList<>();
          }
          productList.add(p);
          refrigerator.setFrozen(productList);
          break;
        case 13:
          productList = refrigerator.getIces();
          if (productList == null) {
            productList = new ArrayList<>();
          }
          productList.add(p);
          refrigerator.setIces(productList);
          break;
        case 14:
          productList = refrigerator.getOthers();
          if (productList == null) {
            productList = new ArrayList<>();
          }
          productList.add(p);
          refrigerator.setOthers(productList);
          break;
      }
      return refrigeratorRepository.save(refrigerator);
    }

    return null;
  }

  @Override
  public List[] findAllProduct(ObjectId id) {
    Optional<Refrigerator> found = refrigeratorRepository.findById(id);
    if (found.isPresent()) {
      Refrigerator refrigerator = found.get();
      List[] products = new List[15];
      products[0] = refrigerator.getNoodles();
      products[1] = refrigerator.getSnack();
      products[2] = refrigerator.getBeverage();
      products[3] = refrigerator.getPickles();
      products[4] = refrigerator.getDiary();
      products[5] = refrigerator.getHealth();
      products[6] = refrigerator.getPowder();
      products[7] = refrigerator.getMeat();
      products[8] = refrigerator.getSeasoning();
      products[9] = refrigerator.getOcean();
      products[10] = refrigerator.getFresh();
      products[11] = refrigerator.getAlcohol();
      products[12] = refrigerator.getFrozen();
      products[13] = refrigerator.getIces();
      products[14] = refrigerator.getOthers();
      return products;
    }

    return null;
  }

  @Override
  public List<Product> findByCategory(ObjectId id, int category) {
    Optional<Refrigerator> found = refrigeratorRepository.findById(id);
    if (found.isPresent()) {
      List<Product> productList = null;
      Refrigerator refrigerator = found.get();
      switch (category) {
        case 0:
          productList = refrigerator.getNoodles();
          break;
        case 1:
          productList = refrigerator.getSnack();
          break;
        case 2:
          productList = refrigerator.getBeverage();
          break;
        case 3:
          productList = refrigerator.getPickles();
          break;
        case 4:
          productList = refrigerator.getDiary();
          break;
        case 5:
          productList = refrigerator.getHealth();
          break;
        case 6:
          productList = refrigerator.getPowder();
          break;
        case 7:
          productList = refrigerator.getMeat();
          break;
        case 8:
          productList = refrigerator.getSeasoning();
          break;
        case 9:
          productList = refrigerator.getOcean();
          break;
        case 10:
          productList = refrigerator.getFresh();
          break;
        case 11:
          productList = refrigerator.getAlcohol();
          break;
        case 12:
          productList = refrigerator.getFrozen();
          break;
        case 13:
          productList = refrigerator.getIces();
          break;
        case 14:
          productList = refrigerator.getOthers();
          break;
      }
      return productList;
    }

    return null;
  }
}
