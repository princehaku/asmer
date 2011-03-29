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
 *  Created on : 2011-3-21, 17:19:23
 *  Author     : princehaku
 */
package net.techest.asmer.core.cpu.addressing;

import net.techest.asmer.core.exceptions.AddressingException;
import net.techest.asmer.core.cpu.CPUBase;

/**
 * 寻址类
 * 
 * @author princehaku
 */
public abstract class Addressing {
  /**
   * 寻址类型
   * 
   * 
   */
  protected AddressingType type;

  /**
   * 参数的值
   * 
   */
  protected String value;

  protected CPUBase cpu;

  public Addressing(){
      
    }

  public Addressing(CPUBase cpu){
    this.cpu=cpu;
    }

   /**需要由继承类实现
     *
     * @param param
     * @return
     * @throws AddressingException
     */
  public abstract Addressing parse(String param) throws AddressingException;


  public CPUBase getCpu() {
        return cpu;
    }

  public AddressingType getType() {
        return type;
  }

  public void setType(AddressingType type) {
        this.type = type;
  }

  public String getValue() {
        return value;
  }

  public void setValue(String value) {
        this.value = value;
  }
}
