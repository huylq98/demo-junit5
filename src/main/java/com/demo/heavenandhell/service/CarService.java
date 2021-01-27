package com.demo.heavenandhell.service;

import static com.demo.heavenandhell.constant.AuthenticationConstant.BLACK;
import static com.demo.heavenandhell.constant.AuthenticationConstant.INVALID;
import static com.demo.heavenandhell.constant.AuthenticationConstant.SHOW_LIST;
import static com.demo.heavenandhell.constant.AuthenticationConstant.SHOW_ONE;
import static com.demo.heavenandhell.constant.AuthenticationConstant.TIMEOUT;
import static com.demo.heavenandhell.constant.AuthenticationConstant.VALID;
import static com.demo.heavenandhell.constant.AuthenticationConstant.WHITE;

import com.demo.heavenandhell.dao.CarDAO;
import com.demo.heavenandhell.entity.Car;

public class CarService {



  private CarDAO carDAO;
  private AuthenticationService authenticationService;

  public CarService() {
  }

  public CarService(CarDAO carDAO, AuthenticationService authenticationService) {
    this.carDAO = carDAO;
    this.authenticationService = authenticationService;
  }

//  private CarDAO carDAO = new CarDAO();
//  private AuthenticationService authenticationService = new AuthenticationService();

  public void displayCarList(int requestType)
  {
    if(requestType == SHOW_ONE)
    {
      carDAO.findCarByColor(BLACK);
    }
    else if(requestType == SHOW_LIST)
    {
      carDAO.findCarByColor(BLACK);
      carDAO.findCarByColor(WHITE);
    }
  }

  public Car getCarInfo(String userToken, int carId) throws IllegalAccessException {
    int status = authenticationService.checkToken(userToken);
    Car car;
    if(status == VALID)
    {
      car = carDAO.findCarById(carId);
      // do something to change car info
      car.setId(4);
      return car;
    }
    else if(status == INVALID)
    {
      throw new IllegalAccessException();
    }
    return null;

  }


  public Car getCarInfoV2(String userToken, int carId) {
    int status = authenticationService.checkTokenV2(userToken);
    Car car;
    if(status == VALID)
    {
      car = carDAO.findCarById(carId);
//      car = carDAO.findCarById(carId + 1);
//      car = carDAO.findCarById(2);
      // do something to change car info
      car.setId(4);
      return car;
    }
    else if(status == TIMEOUT)
    {
      throw null;
    }
    return null;

  }

  public Car makeColorful(Car car)
  {
    return new Car();
  }



}
