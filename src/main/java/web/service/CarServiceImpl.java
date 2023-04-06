package web.service;

import org.springframework.stereotype.Controller;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarServiceImpl implements CarService {

    private final List<Car> carsList = new ArrayList<>();

    {
        carsList.add(new Car("BMW", "black", 120_200));
        carsList.add(new Car("Mazda", "blue", 90_000));
        carsList.add(new Car("Vaz", "green", 20_000));
        carsList.add(new Car("Opel", "yellow", 100_000));
        carsList.add(new Car("Nissan", "red", 700_550));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count == 0) {
            return carsList;
        }
        return carsList.stream().limit(count >= 5 ? carsList.size() : count).collect(Collectors.toList());
    }
}
