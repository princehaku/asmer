/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
