package pl.bestdinner.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.bestdinner.dto.StatusDto;
import pl.bestdinner.mapper.StatusMapper;
import pl.bestdinner.model.Status;
import pl.bestdinner.repositories.StatusRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StatusService {
    private final StatusRepository statusRepository;
    private final StatusMapper statusMapper;

    public StatusService(StatusRepository statusRepository, StatusMapper statusMapper) {
        this.statusRepository = statusRepository;
        this.statusMapper = statusMapper;
    }

    @Transactional
    public List<StatusDto> getAll() {
        return statusMapper.convert(statusRepository.findAll());
    }

    public StatusDto get(Long statusId) {
        Status status = statusRepository.findById(statusId).orElseThrow(NoSuchElementException::new);
        return statusMapper.convert(status);
    }
}
