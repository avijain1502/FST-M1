package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"StepDefinition"},
        tags = "@activity1",
        publish = true,
        monochrome = true,
        plugin = {"html:src/reports/HTML_Report.html",
        "html:src/reports/JSON_Report.json",
        "html:src/reports/XML_Report.xml",
        }
)

public class TestRunner {

}
