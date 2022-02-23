package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("second")
public class SecondController {

    @GetMapping("/cars")
    public  String getCar(@RequestParam(value = "count",defaultValue = "5") int allCars, Model model){
        List<Car> cars=new ArrayList<>();
        cars.add(new Car(1,"Toyota1","AB1213"));
        cars.add(new Car(2,"Toyota2","AB12132"));
        cars.add(new Car(3,"Toyota3","AB12133"));
        cars.add(new Car(4,"Toyota4","AB12134"));
        cars.add(new Car(5,"Toyota5","AB12135"));
        cars = CarService.carsCount(cars, allCars);
        model.addAttribute("list",cars);
        return "second/car";
    }

}
