package automationcraft.delivery.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/automationcraft/testcreation/jetsmart/features"},
        glue = {"automationcraft.testcreation.jetsmart.steps","automationcraft.engine.bdd"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class JetSmartRunner {
}
