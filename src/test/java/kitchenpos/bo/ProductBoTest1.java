package kitchenpos.bo;

import kitchenpos.dao.ProductDao;
import kitchenpos.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ProductBoTest1 {

    /**
     *  1. 인터페이스 추출 ()
     */
    private ProductDao productDao = new TestProductDao();
    private ProductBo productBo = null;

    @BeforeEach
    void setup(){
        productBo =  new ProductBo(productDao);
    }

    @DisplayName("상품을 등록할 수 있다.")
    @Test
    void create(){
        //given
        final Product expected = new Product();
        expected.setId(1L);
        expected.setName("프라이드 치킨");
        expected.setPrice(BigDecimal.valueOf(16_000L));

        //when
        final Product actual = productBo.create(expected);

        //then
        assertThat(actual).isNotNull();
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getPrice()).isEqualTo(expected.getPrice());

    }

    @DisplayName("상품가격이 올바르지 않으면 상품을 등록 할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-10000"})
    void test(final BigDecimal price){
        //given
        final Product expected = new Product();
        expected.setId(1L);
        expected.setName("프라이드 치킨");
        expected.setPrice(BigDecimal.valueOf(16_000L));

        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> productBo.create(expected));
    }

}
