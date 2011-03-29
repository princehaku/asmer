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

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.techest.asmer.core.cpu.addressing.AddressingType;
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
public class Instruction8086MOV extends InstructionBase {
  public Instruction8086MOV(CPUBase aThis) {
        super(aThis);
        this.setName("MOV");
  }

  public void execute() throws InsException {
        String bitsB = "";
        if (this.getArgv(1).getType() == AddressingType.REGISTER && this.getArgv(2).getType() == AddressingType.REGISTER) {
            bitsB = cpu.getRegisterByName(this.getArgv(2).getValue()).getBits();
        }
        if (this.getArgv(1).getType() == AddressingType.REGISTER && this.getArgv(2).getType() == AddressingType.INSNUMBER) {
            //8086不支持直接写入ds和es
            if(this.getArgv(1).getValue().equals("DS")||this.getArgv(1).getValue().equals("ES")){
                throw new InsException("8086 doesn't support this");
            }
            bitsB = this.getArgv(2).getValue();
        }
        if (this.getArgv(1).getType() == AddressingType.DIRECT && this.getArgv(2).getType() == AddressingType.REGISTER) {
            //间接
            bitsB = cpu.getRegisterByName(this.getArgv(2).getValue()).getBits();
            try {
                String pos=BitsString.plus(BitsString.multi(cpu.getRegisterByName("DS").getBits(),"10000"),Integer.toBinaryString(Integer.parseInt(this.getArgv(1).getValue())));
                //pos是2进制数
                cpu.getRom().writeBlock(Integer.parseInt(pos, 2), bitsB);
            } catch (IOException ex) {
                throw new InsException("Write to rom error "+ex.getMessage());
            }

            return ;
        }
        try {
            String H = bitsB;
            cpu.getRegisterByName(this.getArgv(1).getValue()).setBits(StringUtil.plusZero(H, cpu.getRegisterByName(this.getArgv(1).getValue()).getLength()));
        } catch (BitsException ex) {
            Log4j.i(this.getClass(), ex.getMessage());
        }
  }

}
