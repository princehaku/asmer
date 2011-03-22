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
 *  Created on : 2011-3-6, 21:47:06
 *  Author     : princehaku
 */

package net.techest.asmer.core.cpu;

import net.techest.asmer.core.cpu.ins.InstructionBase;
import net.techest.asmer.core.cpu.ins.InstructionWorker;
import net.techest.asmer.core.cpu.register.Register;
import net.techest.asmer.core.cpu.register.RegisterWorker;
import net.techest.asmer.core.exceptions.InsException;
import net.techest.asmer.core.util.Log4j;
import net.techest.asmer.core.util.StringUtil;

/**CPU基类 所有CPU必须由它派生
 *
 * @author princehaku
 */
public abstract class CPUBase {

    protected InstructionWorker irs;
    
    protected RegisterWorker regs;

    public CPUBase(){
        regs=new RegisterWorker();
        irs= new InstructionWorker();
        LoadReg();
        LoadIns();
    }
    
    public abstract void LoadReg();

    public abstract void LoadIns();

    public void execute(String ins){
        //第一步 读取指令名称
        String insName=StringUtil.findMc(ins,"(\\S*?)\\s",1);
        Log4j.i(this.getClass(),"Instruction detected "+insName);
        InstructionBase ir=null;
        try {
            //让指令检查是否存在此指令
            ir =irs.getByName(insName);
            //检查指令参数
            ir.check(ins);
        } catch (InsException ex) {
            Log4j.e(this.getClass(),"insName"+ ex.getMessage());
        }
        
        ir.execute();

    }

    public abstract void writeBack();

    public Register getRegisterByName(String name){
            for(int i=0;i<regs.size();i++){
                if(regs.get(i).getName().equals(name))
                {
                    return regs.get(i);
                }

            }
        return null;
    }
}
