package com.demo.heavenandhell.service;

import static com.demo.heavenandhell.constant.AuthenticationConstant.INVALID;
import static com.demo.heavenandhell.constant.AuthenticationConstant.TIMEOUT;
import static com.demo.heavenandhell.constant.AuthenticationConstant.VALID;

public class AuthenticationService {


  public int checkTokenV2(String token)
  {
    if(token.compareToIgnoreCase("T") == 0)
    {
      return TIMEOUT;
    }
    else if(token.compareToIgnoreCase("I") == 0)
    {
      return INVALID;
    }
    else if(token.compareToIgnoreCase("V") == 0)
    {
      return VALID;
    }
    return TIMEOUT;
  }


  public int checkToken(String token) throws IllegalAccessException {
    if(token.compareToIgnoreCase("T") == 0)
    {
      return TIMEOUT;
    }
    else if(token.compareToIgnoreCase("I") == 0)
    {
      return INVALID;
    }
    else if(token.compareToIgnoreCase("V") == 0)
    {
      return VALID;
    }
    else {
      throw new IllegalAccessException();
    }

  }
}
