package com.app.gogol.service;

import com.app.gogol.entity.Product;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author unalpolat
 */
public interface ProductService {

  Optional<Product> get(Long id);

  List<Product> getByIds(Collection<Long> ids);

  void destock(Long id, Integer newQuantity);
}
