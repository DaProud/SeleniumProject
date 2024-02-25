package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class LoggerUtility {

    private static final String suiteLogsPath = "target/logs/suite/";
    private static final String regressionLogsPath = "target/logs/";

    private static final Logger logger = LogManager.getLogger();

    public static synchronized void startTestCase(String testName){
        ThreadContext.put("threadName", testName);
        logger.info("======== Execution started: " + testName + " ========");
    }

    public static synchronized void endTestCase(String testName){
        logger.info("======== Execution finished: " + testName + " ========");
    }

    public static synchronized void infoLog(String message){
        logger.info(Thread.currentThread().getName() + ":" + getCallInfo() + message);
    }

    public static synchronized void errorLog(String message){
        logger.error(Thread.currentThread().getName() + ":" + getCallInfo() + message);
    }

    private static synchronized String getCallInfo(){
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        return className + ":" + methodName + " ==> ";
    }

    public static void mergeLogFilesIntoOne(){
        File dir = new File(suiteLogsPath);
        String[] fileNames = dir.list();

        try {
            PrintWriter pw = new PrintWriter(regressionLogsPath+"RegressionLogs.log");

            for (String fileName : fileNames) {
                System.out.println("Reading from " + fileName);
                File f = new File(dir, fileName);
                BufferedReader br = new BufferedReader(new FileReader(f));
                pw.println("Contents of file " + fileName);
                String line = br.readLine();
                while (line != null) {
                    pw.println(line);
                    line = br.readLine();
                }
                pw.flush();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}