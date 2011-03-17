/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.techest.asmer.core.util;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author princehaku
 */
public class Log4j {

    private static boolean isDebug = true;
    
    private static Logger logger;

    private static Logger getLogger(String obj) {
        if (logger == null) {

            BasicConfigurator.configure();
        }

        logger = Logger.getLogger(obj);

        return logger;
    }

    public static void i(Class obj, String msg) {
        if (!isDebug) {
            return;
        }
        getLogger(obj.getName()).info(msg);
    }
}
