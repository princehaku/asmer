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
 *  Created on : 2011-3-17, 11:32:09
 *  Author     : princehaku
 */
package net.techest.asmer.core.cpu.ins;

import net.techest.asmer.core.cpu.ArgsType;
import net.techest.asmer.core.cpu.CPUBase;
import net.techest.asmer.core.cpu.ins.base.InstructionBase;
import net.techest.asmer.core.exceptions.BitsException;
import net.techest.asmer.core.exceptions.InsException;
import net.techest.asmer.core.util.BitsString;
import net.techest.asmer.core.util.Log4j;
import net.techest.asmer.core.util.StringUtil;
/**
 * 
 * @author princehaku
 */
public class InstructionADD extends net.techest.asmer.core.cpu.ins.base.InstructionBase {
  public InstructionADD(net.techest.asmer.core.cpu.CPUBase aThis) {
        super(aThis);
        this.setName("ADD");
  }

  public void execute() throws net.techest.asmer.core.exceptions.InsException {
        String bitsA = "";
        String bitsB = "";
        if (this.getArgv(1).getType() == ArgsType.REGISTER && this.getArgv(2).getType() == ArgsType.REGISTER) {
            bitsA = cpu.getRegisterByName(this.getArgv(1).getValue()).getBits();
            bitsB = cpu.getRegisterByName(this.getArgv(2).getValue()).getBits();
        }
        if (this.getArgv(1).getType() == ArgsType.REGISTER && this.getArgv(2).getType() == ArgsType.INSNUMBER) {
            bitsA = cpu.getRegisterByName(this.getArgv(1).getValue()).getBits();
            bitsB = this.getArgv(2).getValue();
        }
        try {
            String H = BitsString.plus(bitsA, bitsB);
            //溢出检测 如果溢出了
            if (H.length() > cpu.getRegisterByName(this.getArgv(1).getValue()).getLength()) {
                Log4j.i(this.getClass(), "ADD OVERFLOW");
                //丢弃最高位
                H = H.substring(H.length() - cpu.getRegisterByName(this.getArgv(1).getValue()).getLength(), H.length());
                //设置符号位 和溢出位
                try {
                    cpu.getRegisterByName("FR").setBits("11111111");
                } catch (Exception ex) {
                    Log4j.i(this.getClass(),"Flag Register FR Not FOUND "+ex.getMessage());
                }
            }
            cpu.getRegisterByName(this.getArgv(1).getValue()).setBits(StringUtil.plusZero(H, cpu.getRegisterByName(this.getArgv(1).getValue()).getLength()));
        } catch (BitsException ex) {
            Log4j.i(this.getClass(), ex.getMessage());
        }
  }

}
