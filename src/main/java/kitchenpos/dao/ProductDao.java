package kitchenpos.dao;

import kitchenpos.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    /**
     *  ProductDao가 너무 많은 책임을 갖고 있는것이 아닌가? 를 의심 할 수 있다.
     */
    Product save(Product entity);

    Optional<Product> findById(Long id);

    List<Product> findAll();
}
