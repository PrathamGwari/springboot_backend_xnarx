package uz.xnarx.xnarx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.xnarx.xnarx.entity.PriceHistory;
import uz.xnarx.xnarx.payload.PriceHistoryDto;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Integer> {
    @Query("SELECT NEW uz.xnarx.xnarx.payload.PriceHistoryDto(ph.id, ph.product_name, ph.store_name, ph.product_link, ph.price,ph.date) " +
            "FROM  pricehistory AS ph WHERE LOWER( ph.product_name) LIKE LOWER(:product_name) ")
    Page<PriceHistoryDto> getAllProductsWithPriceHistory(@Param("product_name") String product_name, Pageable pageable);

}
