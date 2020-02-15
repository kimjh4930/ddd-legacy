package kitchenpos.bo;

import kitchenpos.dao.ProductDao;
import kitchenpos.model.Product;

import java.util.*;

public class TestProductDao implements ProductDao {

    /**
     *  해시맵을 이용해서 in-memory db 처럼 사용한다.
     */
    private final Map<Long, Product> values = new HashMap<>();

    @Override
    public Product save(Product entity) {
        values.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(values.get(id));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(values.values());
    }
}
