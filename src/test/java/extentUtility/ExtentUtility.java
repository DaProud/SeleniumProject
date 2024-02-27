package extentUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.concurrent.ConcurrentHashMap;

public class ExtentUtility {

    private static ExtentReports extent;
    private static String pathToProject = System.getProperty("user.dir") + "/target/extentReports/";
    private static ConcurrentHashMap<String, ExtentTest> context = new ConcurrentHashMap<>();

    // metoda care sa initializeze fiserul html
    public static synchronized void initiateReportt() {
        // metoda care sa imi faca un folder
        createDirectory();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(pathToProject + "ExtentReport.html");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    // metoda care sa faca un extentTest pentru fiecare test
    public static synchronized void createTest(String testName) {
        ExtentTest testReport = extent.createTest(testName + " - report");
        context.put(Thread.currentThread().getName(), testReport);
        attachLog(ReportStep.INFO_STEP, "---- START TEST ----" + testName);

    }

    // metoda care sa inchida un extentTest
    public static synchronized void finishTest(String testName) {
        attachLog(ReportStep.INFO_STEP, "---- FINISH TEST ----" + testName);
    }

    // metoda care sa logheze informatia
    public static synchronized void attachLog(String attachType, String message) {
        String threadName = Thread.currentThread().getName();
        if (attachType.equals(ReportStep.INFO_STEP)) {
            context.get(threadName).log(Status.INFO, message);
        }
        if (attachType.equals(ReportStep.PASS_STEP)) {
            context.get(threadName).log(Status.PASS, message);
        }
    }
    // metoda care sa recunoasca threadul curent

    // metoda care sa faca un screenshot
    public static synchronized void attachLog(String reportName, String message, WebDriver driver) {
        String theadName = Thread.currentThread().getName();
        context.get(theadName)
            .fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(driver, reportName))
                .build());
    }

    private static String getScreenshot(WebDriver driver, String reportName) {
        try {
            String path = pathToProject + reportName + ".png";
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(path));
            byte[] imageBytes = IOUtils.toByteArray(Files.newInputStream(Paths.get(path)));
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException exception) {
            System.out.println("The path is not correct");
        }
        return null;
    }

    // metoda care sa genereze raportul final
    public static synchronized void generateReport() {
        extent.flush();
    }

    private static void createDirectory() {
        File directory = new File(pathToProject);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }


}
