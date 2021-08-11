package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {
    DataResult<List<City>> getAll();
    Result addCity(City city);
    DataResult<City> getCityByName(String name);
}
