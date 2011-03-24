/**
 *   Copyright 2010 princehaku
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * 
 *  Created on : 2011-3-14, 13:34:52
 *  Author     : princehaku
 */
package net.techest.asmer.core.cpu.register;

import java.util.Collection;
import net.techest.asmer.core.util.Log4j;
/**
 * 寄存器构造工厂
 * 
 * @author princehaku
 */
public class RegisterFactory {
  public static Register build(String name, int length)
  {
            Register r=new  Register(name,length) ;
            Log4j.i(RegisterFactory.class,"Register Build "+name +" bit length "+length);
            return r;
  }

  /**
   * 创建一个组合寄存器
   * 
   * @param name
   * @param A
   * @param B
   * @return
   */
  public static Register pasteBuild(String name, Register A, Register B)
  {
            Register r=new  Register(name,0) ;
            r.add(A);
            r.add(B);
            Log4j.i(RegisterFactory.class,"Register Build "+name+" From "+A.getName()+" & "+B.getName() +" bit length "+r.length);
            return r;
  }

  public static Collection<Register> groupBuild(String name, int length)
  {
            return null;
  }

}
