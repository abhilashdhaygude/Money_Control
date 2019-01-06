package MoneyControlRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(features={"classpath:\\FeatureFile\\Moneycontrol.feature"},glue={"MoneyControlStepDefination"})
public class Runner extends AbstractTestNGCucumberTests
{

}
