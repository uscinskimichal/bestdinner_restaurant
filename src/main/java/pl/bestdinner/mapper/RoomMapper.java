package pl.bestdinner.mapper;

import org.mapstruct.Mapper;
import pl.bestdinner.dto.RoomDto;
import pl.bestdinner.model.Room;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomDto convert(Room in);
    Room convert(RoomDto in);
    List<RoomDto> convert(List<Room> in);
}
