package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bestdinner.model.WarehouseOrder;

import java.util.List;

public interface WarehouseOrderRepository extends JpaRepository<WarehouseOrder,Integer> {
    List<WarehouseOrder> findAll();
}
