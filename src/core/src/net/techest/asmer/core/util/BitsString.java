/**
 * Copyright (c) 2010 princehaku
 * All right reserved.
 * Author princehaku
 * Site http://3haku.net
 * Created on : 2011-3-22, 23:04:19
 */

package net.techest.asmer.core.util;

/**
 *
 * @author princehaku
 */
public class BitsString {
    
        public static String plus(String bitsStringA,String bitsStringB){
                Long a=Long.parseLong(bitsStringA, 2);
                Long b=Long.parseLong(bitsStringB, 2);
                Long c=a+b;
                return Long.toBinaryString(c);
        }

        public static String minus(String bitsStringA,String bitsStringB){
                Long a=Long.parseLong(bitsStringA, 2);
                Long b=Long.parseLong(bitsStringB, 2);
                Long c=a-b;
                return Long.toBinaryString(c);
        }
}
