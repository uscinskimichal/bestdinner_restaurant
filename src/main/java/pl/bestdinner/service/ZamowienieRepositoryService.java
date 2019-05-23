package pl.bestdinner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bestdinner.model.Klient;
import pl.bestdinner.repositories.ZamowienieRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ZamowienieRepositoryService implements ZamowienieRepository.ZamowienieRepositoryCustom {

    @Autowired
    ZamowienieRepository zamowienieRepository;

    public List<Object> executeQuery(String status, String idKlient, Date dateFrom, Date dateTo, String type) {
        if(status!=null) return zamowienieRepository.findByStatus(status);
        else if(idKlient!=null) return zamowienieRepository.findByIdKlient(Integer.parseInt(idKlient));
        else if(dateFrom!=null) return zamowienieRepository.findByDataAfter(dateFrom);
        else if(dateTo!=null) return zamowienieRepository.findByDataBefore(dateTo);
        else if(type!=null) return zamowienieRepository.findByTyp(type);
        else return  (List<Object>)(List<?>) zamowienieRepository.findAll();
    }

    public Optional findById(int id){
        return zamowienieRepository.findById(id);
    }
}
