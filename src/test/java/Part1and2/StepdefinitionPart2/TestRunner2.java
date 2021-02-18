package Part1and2.StepdefinitionPart2;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class TestRunner2 {

    @CucumberOptions(
            features = {"src/main/resources/Part2.feature"},
            glue = {"StepDefinitionPart1"},
            plugin = {"html:target/report/index.html"}
    )
    public static class TestRunner extends AbstractTestNGCucumberTests {
    }
}
