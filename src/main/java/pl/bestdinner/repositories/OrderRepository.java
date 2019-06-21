package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bestdinner.model.Order;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findAll();

    @Query(nativeQuery = true ,
            value = "Select * from orders o " +
                    "LEFT JOIN status s on o.status_id=s.status_id " +
                    "LEFT JOIN client_order co on co.order_id=o.order_id " +
                    "LEFT JOIN client c on c.client_id=co.client_id " +
                    "where ifnull(?1,-1) = case when ?1 is null then -1 else s.status_id END AND " +
                    " ifnull(?2,-1) = case when ?2 is null then -1 else c.client_id END AND " +
                    " ifnull(?3,-1) = case when ?3 is null then -1 else o.employee_id END AND " +
                    " ifnull(?4,-1) <= case when ?4 is null then -1 else o.date END AND " +
                    " ifnull(?5,-1) >= case when ?5 is null then -1 else o.date END AND " +
                    " ifnull(?6,-1) = case when ?6 is null then -1 else o.type END " +
                    "GROUP BY o.order_id")
    List<Order> findAllWithParameters(String paramStatus,
                        Integer paramClientId ,
                        Integer paramEmployeeId,
                        LocalDateTime paramDateFrom,
                        LocalDateTime paramDateTo,
                        String paramType);
}