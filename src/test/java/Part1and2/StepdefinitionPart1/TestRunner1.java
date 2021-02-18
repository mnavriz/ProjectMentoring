package Part1and2.StepdefinitionPart1;

import Part1and2.Base;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(
            features = {"src/main/resources/Part1.feature"},
            glue = {"StepDefinitionPart1"},
            plugin = {"html:target/report/index.html"}
    )
    public class TestRunner1 extends AbstractTestNGCucumberTests {


    public static void BeforeMethod(){
        Base base = new Base();

    }
    }

