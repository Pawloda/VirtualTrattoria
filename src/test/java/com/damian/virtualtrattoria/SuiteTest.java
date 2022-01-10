package com.damian.virtualtrattoria;

import com.damian.virtualtrattoria.repository.OrderRepositoryTest;
import com.damian.virtualtrattoria.service.OrderService;
import com.damian.virtualtrattoria.service.OrderServiceTest;
import com.damian.virtualtrattoria.service.PizzaServiceTest;
import com.damian.virtualtrattoria.service.TextServiceTest;
import com.damian.virtualtrattoria.strategy.PizzaChangerTest;
//import com.damian.virtualtrattoria.validator.InputValidatorTest;
import com.damian.virtualtrattoria.validator.InputValidatorTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * Class used to run all tests.
 *
 * @author Damian
 * @version 1.0
 * @since 05.01.2022
 */
@Suite
@SelectClasses({ OrderRepositoryTest.class, OrderServiceTest.class, PizzaServiceTest.class,
        TextServiceTest.class, PizzaChangerTest.class, InputValidatorTest.class })
public class SuiteTest {
}
