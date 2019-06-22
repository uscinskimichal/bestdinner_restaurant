package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bestdinner.model.WarehouseOrder;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WarehouseOrderRepository extends JpaRepository<WarehouseOrder,Long> {
    List<WarehouseOrder> findAll();

    @Query(nativeQuery = true ,
            value = "Select * from warehouse_order wo " +
                    "where ifnull(?1,-1) = case when ?1 is null then -1 else wo.employee_id END AND " +
                    " ifnull(?2,-1) <= case when ?2 is null then -1 else wo.date END AND " +
                    " ifnull(?3,-1) >= case when ?3 is null then -1 else wo.date END " +
                    "GROUP BY wo.warehouse_order_id")
    List<WarehouseOrder> findAllWithParameters(Integer paramEmployeeId,
                                               LocalDateTime paramDateFrom,
                                               LocalDateTime paramDateTo);

}
