package pl.bestdinner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bestdinner.repositories.ZamowienieRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ZamowienieRepositoryImpl {

    @Autowired
    ZamowienieRepository zamowienieRepository;



    public List<Object> filterAllByStatus(String status){
        return zamowienieRepository.findByStatus(status);
    }

    public List<Object> filterAllByTyp(String typ){
        return zamowienieRepository.findByTyp(typ);
    };

    public List<Object> executeQuery(String status, String idKlient, Date dateFrom, Date dateTo, String type) {
        if(status!=null) return filterAllByStatus(status);
        else if(idKlient!=null) return filterAllByIdKlient(idKlient);
        else if(dateFrom!=null) return filterAllByDataAfter(dateFrom);
        else if(dateTo!=null) return filterAllByDataBefore(dateTo);
        else if(type!=null) return filterAllByTyp(type);
        else return  (List<Object>)(List<?>) zamowienieRepository.findAll();
    }

    public List<Object> filterAllByIdKlient(String id){
        return zamowienieRepository.findByIdKlient(Integer.parseInt(id));
    }

    public List<Object> filterAllByDataAfter(Date data){
        return zamowienieRepository.findByDataAfter(data);
    };

    public List<Object> filterAllByDataBefore(Date data){
        return zamowienieRepository.findByDataBefore(data);
    };

    public Object findZamowienieById(int id){
        return zamowienieRepository.findZamowienieById(id);
    }
}
