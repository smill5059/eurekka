package com.ssafy.eurekka.service;

import com.ssafy.eurekka.repository.RefrigeratorRepository;
import com.ssafy.eurekka.vo.Product;
import com.ssafy.eurekka.vo.Refrigerator;
import java.sql.Ref;
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

  public Refrigerator createProduct(ObjectId id, String category, Product product) {
    Optional<Refrigerator> found = refrigeratorRepository.findById(id);
    if (found.isPresent()) {
      List<Product> productList = null;
      Refrigerator refrigerator = found.get();
      if (category.equals("noodles")) {
        productList = refrigerator.getNoodles();
        if (productList == null){
          productList = new ArrayList<>();
        }
        productList.add(product);
        refrigerator.setNoodles(productList);
      } else if (category.equals("snack")) {
        productList = refrigerator.getSnack();
        if (productList == null){
          productList = new ArrayList<>();
        }
        productList.add(product);
        refrigerator.setSnack(productList);
      } else if (category.equals("beverage")) {
        productList = refrigerator.getBeverage();
        if (productList == null){
          productList = new ArrayList<>();
        }
        productList.add(product);
        refrigerator.setBeverage(productList);
      } else if (category.equals("pickles")) {
        productList = refrigerator.getPickles();
        if (productList == null){
          productList = new ArrayList<>();
        }
        productList.add(product);
        refrigerator.setPickles(productList);
      } else if (category.equals("diary")) {
        productList = refrigerator.getDiary();
        if (productList == null){
          productList = new ArrayList<>();
        }
        productList.add(product);
        refrigerator.setDiary(productList);
      } else if (category.equals("health")) {
        productList = refrigerator.getHealth();
        if (productList == null){
          productList = new ArrayList<>();
        }
        productList.add(product);
        refrigerator.setHealth(productList);
      } else if (category.equals("powder")) {
        productList = refrigerator.getPowder();
        if (productList == null){
          productList = new ArrayList<>();
        }
        productList.add(product);
        refrigerator.setPowder(productList);
      } else if (category.equals("meat")) {
        productList = refrigerator.getMeat();
        if (productList == null){
          productList = new ArrayList<>();
        }
        productList.add(product);
        refrigerator.setMeat(productList);
      } else if (category.equals("seasoning")) {
        productList = refrigerator.getSeasoning();
        if (productList == null){
          productList = new ArrayList<>();
        }
        productList.add(product);
        refrigerator.setSeasoning(productList);
      } else if (category.equals("ocean")) {
        productList = refrigerator.getOcean();
        if (productList == null){
          productList = new ArrayList<>();
        }
        productList.add(product);
        refrigerator.setOcean(productList);
      } else if (category.equals("fresh")) {
        productList = refrigerator.getFresh();
        if (productList == null){
          productList = new ArrayList<>();
        }
        productList.add(product);
        refrigerator.setFresh(productList);
      } else if (category.equals("alcohol")) {
        productList = refrigerator.getAlcohol();
        if (productList == null){
          productList = new ArrayList<>();
        }
        productList.add(product);
        refrigerator.setAlcohol(productList);
      } else if (category.equals("frozen")) {
        productList = refrigerator.getFrozen();
        if (productList == null){
          productList = new ArrayList<>();
        }
        productList.add(product);
        refrigerator.setFrozen(productList);
      } else if (category.equals("ices")) {
        productList = refrigerator.getIces();
        if (productList == null){
          productList = new ArrayList<>();
        }
        productList.add(product);
        refrigerator.setIces(productList);
      } else if (category.equals("others")) {
        productList = refrigerator.getOthers();
        if (productList == null){
          productList = new ArrayList<>();
        }
        productList.add(product);
        refrigerator.setOthers(productList);
      }

      return refrigeratorRepository.save(refrigerator);
    }

    return null;
  }
}
