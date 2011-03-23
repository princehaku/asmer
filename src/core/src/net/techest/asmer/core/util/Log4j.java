/**
 * Copyright (c) 2010 princehaku
 * All right reserved.
 * Author princehaku
 * Site http://3haku.net
 * Created on : 2011-3-22, 23:02:19
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

    public static void e(Class obj, String msg) {
        if (!isDebug) {
            return;
        }
        getLogger(obj.getName()).error(msg);
    }

    public static void i(Class obj, String msg) {
        if (!isDebug) {
            return;
        }
        getLogger(obj.getName()).info(msg);
    }
}
