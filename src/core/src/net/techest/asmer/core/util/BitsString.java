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
    
      public static String plus(String bitsStringA, String bitsStringB)
      {
                    int a=Integer.parseInt(bitsStringA, 2);
                    int b=Integer.parseInt(bitsStringB, 2);
                    int c=a+b;
                    return Integer.toBinaryString(c);
      }

      public static String multi(String bitsStringA, String bitsStringB)
      {
                    int a=Integer.parseInt(bitsStringA, 2);
                    int b=Integer.parseInt(bitsStringB, 2);
                    int c=a*b;
                    return Integer.toBinaryString(c);
      }

      public static String minus(String bitsStringA, String bitsStringB)
      {
                    int a=Integer.parseInt(bitsStringA, 2);
                    int b=Integer.parseInt(bitsStringB, 2);
                    int c=a-b;
                    return Integer.toBinaryString(c);
      }

}
