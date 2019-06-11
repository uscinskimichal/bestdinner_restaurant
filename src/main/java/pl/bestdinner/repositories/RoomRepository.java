package pl.bestdinner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bestdinner.model.Room;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer> {
    List<Room> findAll();
}
