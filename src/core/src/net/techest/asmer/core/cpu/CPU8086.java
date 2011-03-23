/*  Copyright 2010 princehaku
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
 *  Created on : 2011-3-15, 15:21:35
 *  Author     : princehaku
 */

package net.techest.asmer.core.cpu;

import net.techest.asmer.core.cpu.ins.*;
import net.techest.asmer.core.cpu.register.RegisterFactory;

/**160166的实现类
 *
 * @author princehaku
 */
public class CPU8086 extends CPUBase{
    
    @Override
    public void loadAnalyzer() {
        this.anayzer=new Analyzer8086(this);
    }
    
    @Override
    public void loadReg() {
        //数据寄存器
        regs.add(RegisterFactory.build("AH", 8));
        regs.add(RegisterFactory.build("BH", 8));
        regs.add(RegisterFactory.build("CH", 8));
        regs.add(RegisterFactory.build("DH", 8));
        regs.add(RegisterFactory.build("AL", 8));
        regs.add(RegisterFactory.build("BL", 8));
        regs.add(RegisterFactory.build("CL", 8));
        regs.add(RegisterFactory.build("DL", 8));
        regs.add(RegisterFactory.pasteBuild("AX", regs.getByName("AH"), regs.getByName("AL")));
        regs.add(RegisterFactory.pasteBuild("BX", regs.getByName("BH"), regs.getByName("BL")));
        regs.add(RegisterFactory.pasteBuild("CX", regs.getByName("CH"), regs.getByName("CL")));
        regs.add(RegisterFactory.pasteBuild("DX", regs.getByName("DH"), regs.getByName("DL")));
        //段寄存器
        regs.add(RegisterFactory.build("CS", 16));
        regs.add(RegisterFactory.build("DS", 16));
        regs.add(RegisterFactory.build("SS", 16));
        regs.add(RegisterFactory.build("ES", 16));
        //ex
        regs.add(RegisterFactory.build("SP", 16));
        regs.add(RegisterFactory.build("BP", 16));
        regs.add(RegisterFactory.build("SI", 16));
        regs.add(RegisterFactory.build("DI", 16));
        //指针寄存器
        regs.add(RegisterFactory.build("IP", 16));
        //标志寄存器
        regs.add(RegisterFactory.build("FR", 16));
    }

    @Override
    public void loadIns() {
        irs.add(new InstructionADD(this));
        irs.add(new InstructionSUB(this));
        irs.add(new InstructionMOV(this));
    }

    @Override
    public void writeBack() {
        //TODO :  CPU writeBack
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
