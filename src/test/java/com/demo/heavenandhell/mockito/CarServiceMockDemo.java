package com.demo.heavenandhell.mockito;

import com.demo.heavenandhell.dao.CarDAO;
import com.demo.heavenandhell.entity.Car;
import com.demo.heavenandhell.service.AuthenticationService;
import com.demo.heavenandhell.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarServiceMockDemo {
    @Mock
    CarDAO carDAO;

    @Spy
    AuthenticationService authService;

    @InjectMocks
    CarService carService;

    @Test
    public void getCarInfoTest() {
        Car car = new Car();

        when(carDAO.findCarById(anyInt())).thenReturn(car);

        // we don't define behavior of the method checkTokenV2(String userToken)
        // but authService is a spy object --> it will call real method by default
        Car carInfoV2 = carService.getCarInfoV2("V", 5);

        // getCarInfoV2 changed carId to 4
        assertEquals(4, car.getId());
        assertSame(car, carInfoV2);
    }
}
