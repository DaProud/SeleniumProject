package ShareData;

import logger.LoggerUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class Hooks extends ShareData {

    public String testName;

    @BeforeMethod
    public void prepareEnvironment() {
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTestCase(testName);
        prepareBrowser();
    }

    @AfterMethod
    public void clearEnvironment(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            LoggerUtility.errorLog(result.getThrowable().getMessage());
        }
        clearBrowser();
        // pentru moment toate sunt bune
        LoggerUtility.endTestCase(testName);
    }

    @AfterSuite
    public void finaliseLogFiles(){
        LoggerUtility.mergeLogFilesIntoOne();
    }



}
