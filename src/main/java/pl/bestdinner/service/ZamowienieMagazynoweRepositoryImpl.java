package pl.bestdinner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bestdinner.repositories.ZamowienieMagazynoweRepository;

import java.sql.Date;
import java.util.List;
// To nie jest impl
@Service
public class ZamowienieMagazynoweRepositoryImpl {

//    @Autowired
//    ZamowienieMagazynoweRepository zamowienieMagazynoweRepository;
//
//    public List<Object> filterAllByDataAfter(Date data){
//        return zamowienieMagazynoweRepository.findByDataAfter(data);
//    }
//
//    public List<Object> filterAllByDataBefore(Date data){
//        return zamowienieMagazynoweRepository.findByDataBefore(data);
//    }
//
//    public List<Object> executeQuery(Date dateFrom, Date dateTo) {
//        if(dateFrom!=null) return filterAllByDataAfter(dateFrom);
//        else if(dateTo!=null) return filterAllByDataBefore(dateTo);
//        else return  (List<Object>)(List<?>) zamowienieMagazynoweRepository.findAll();
//    }
//
//    public Object findZamowienieMagazynoweById(int id){
//        return zamowienieMagazynoweRepository.findZamowienieMagazynowe(id);
//    }
}
