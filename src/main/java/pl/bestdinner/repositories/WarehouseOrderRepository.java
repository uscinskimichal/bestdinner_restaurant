package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bestdinner.model.WarehouseOrder;

import java.util.List;

@Repository
public interface WarehouseOrderRepository extends JpaRepository<WarehouseOrder,Long> {
    List<WarehouseOrder> findAll();
}
