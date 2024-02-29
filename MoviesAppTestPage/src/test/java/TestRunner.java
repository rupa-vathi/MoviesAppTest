import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@Listeners(MovieAppReport.class)
@CucumberOptions(features = "src/test/resources/features")
public class TestRunner extends AbstractTestNGCucumberTests {
}
