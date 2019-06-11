package pl.bestdinner.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bestdinner.dto.RoomDto;
import pl.bestdinner.mapper.RoomMapper;
import pl.bestdinner.model.Room;
import pl.bestdinner.repositories.RoomRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }


    @Transactional
    public List<RoomDto> getAll() {
        return roomMapper.convert(roomRepository.findAll());
    }

    @Transactional
    public RoomDto create(RoomDto in) {
        Room room = roomMapper.convert(in);
        room.setRoomId(0);
        roomRepository.save(room);
        return roomMapper.convert(room);
    }

    public void delete(Integer roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(NoSuchElementException::new);
        roomRepository.delete(room);
    }

    public RoomDto get(Integer roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(NoSuchElementException::new);
        return roomMapper.convert(room);
    }

    public RoomDto update(RoomDto roomDto, Integer roomId) {
        Room room = roomMapper.convert(roomDto);
        room.setRoomId(roomId);
        roomRepository.save(room);
        return roomMapper.convert(roomRepository.findById(roomId).orElseThrow(NoSuchElementException::new));
    }


}
