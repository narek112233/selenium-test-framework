package com.automation.runners;

import com.automation.utils.ConfigManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

import java.util.Arrays;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.automation.steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        Object[][] scenarios = super.scenarios();
        System.out.println("scenarios " + Arrays.deepToString(scenarios));

        int parallelCount = ConfigManager.getParallelCount();
        System.out.println("parallelCount " + parallelCount);
        Object[][] result = new Object[parallelCount][2];

        for (int i = 0; i < parallelCount; i++) {
            result[i][0] = scenarios[0][0]; // name of scenario
            result[i][1] = scenarios[0][1]; // name of feature
        }
        System.out.println("result " + Arrays.deepToString(result));
        return result;
    }

}
