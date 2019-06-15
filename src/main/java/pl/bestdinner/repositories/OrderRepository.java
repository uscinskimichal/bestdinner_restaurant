package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bestdinner.model.Order;

import java.sql.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findAll();
    List<Order> findAllByStatus(String status);
    List<Order> findAllByType(String type);
    List<Order> findAllByDateGreaterThanEqual(Date date);
    List<Order> findAllByDateIsLessThanEqual(Date date);


    @Query("Select o from orders o JOIN o.employee e where e.idEmployee=?1")
    List<Order> findAllByEmployee(int idEmployee);

    @Query("Select o from orders o JOIN o.clients c where c.idClient = ?1")
    List<Order> findAllByClients(int id);

}
