// package utils;

// import java.io.IOException;
// import java.text.DateFormat;
// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.util.logging.FileHandler;
// import java.util.logging.Level;
// import java.util.logging.LogManager;
// import java.util.logging.Logger;

// public class LoggerHandler {
//     static DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
//     static Date date = new Date();

//     static String LOG_FILE = "/home/coder/project/workspace/Project/src/main/logs/log.log"+"-"+dateFormat.format(date);
    
//     public static final Logger log = Logger.getLogger(LoggerHandler.class.getName());
    
//     static {
//         try {
//             LogManager.getLogManager().reset(); // Reset any existing logging configuration
            
//             FileHandler fileHandler = new FileHandler(LOG_FILE, true);
//             fileHandler.setFormatter(new java.util.logging.SimpleFormatter());
//             log.addHandler(fileHandler);
//             log.setLevel(Level.ALL);
//         } catch (IOException e) {
//             System.err.println("Could not set up logger configuration: " + e.toString());
//         }
//     }
    
//     public static Logger getLogger() {
//         return log;
//     }
// }


package utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerHandler {
    private static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
    private static Date date = new Date();
    private static String logDirectoryPath = "/home/coder/project/workspace/Project/src/main/logs";
    private static String logFilePath = logDirectoryPath + File.separator + dateFormat.format(date) + ".log";
    
    public static final Logger log = Logger.getLogger(LoggerHandler.class.getName());
    
    static {
        try {
            LogManager.getLogManager().reset(); // Reset any existing logging configuration
            
            // Ensure the log directory exists
            File logDirectory = new File(logDirectoryPath);
            if (!logDirectory.exists()) {
                if (logDirectory.mkdirs()) {
                    System.out.println("Log directory created: " + logDirectoryPath);
                } else {
                    System.err.println("Failed to create log directory: " + logDirectoryPath);
                }
            }
            
            FileHandler fileHandler = new FileHandler(logFilePath, true);
            fileHandler.setFormatter(new java.util.logging.SimpleFormatter());
            log.addHandler(fileHandler);
            log.setLevel(Level.ALL);
        } catch (IOException e) {
            log.log(Level.SEVERE, "Could not set up logger configuration", e);
        }
    }
    
    public static Logger getLogger() {
        return log;
    }
}
