package com.app.gogol.service.impl;

import com.app.gogol.entity.Product;
import com.app.gogol.repository.ProductRepository;
import com.app.gogol.service.ProductService;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * @author unalpolat
 */
@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository repository;

  public ProductServiceImpl(ProductRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<Product> get(Long id) {
    return repository.findById(id);
  }

  @Override
  public List<Product> getByIds(Collection<Long> ids) {
    return repository.findAllById(ids);
  }

  @Override
  public void destock(Long id, Integer newQuantity) {
    repository.destock(id, newQuantity, new Date());
  }
}
