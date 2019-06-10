package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bestdinner.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
