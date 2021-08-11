package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.users.CityDao;
import kodlamaio.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    private final CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }


    @Override
    public Result addCity(City city) {

        if(cityDao.existsCityByCityName(city.getCityName())) return new ErrorResult("Şehir sisteme daha önce kaydolmuş");

        cityDao.save(city);
        return new SuccessResult(city.getCityName() + " Eklendi");
    }

    @Override
    public DataResult<City> getCityByName(String name) {
        if(!cityDao.existsCityByCityName(name)) return new ErrorDataResult<>(name + " Sistemde mevcut değil");
        else return new SuccessDataResult<>(cityDao.getByCityName(name));
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<>(cityDao.findAll());
    }
}
