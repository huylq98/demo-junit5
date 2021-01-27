package com.demo.heavenandhell.testsuite;

import com.demo.heavenandhell.login.LoginSuccessTest;
import com.demo.heavenandhell.welcome.HelloWorldTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({"com.demo.heavenandhell.login", "com.demo.heavenandhell.welcome"})
//@SelectPackages({"com.demo.heavenandhell"})
//@SelectClasses({LoginSuccessTest.class, HelloWorldTest.class})
public class LoginSuccessAndWelcomeTest {

}
