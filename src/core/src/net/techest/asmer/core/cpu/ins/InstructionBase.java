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
 *  Created on : 2011-3-6, 21:57:15
 *  Author     : princehaku
 */
package net.techest.asmer.core.cpu.ins;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.techest.asmer.core.cpu.Args;
import net.techest.asmer.core.cpu.ArgsType;
import net.techest.asmer.core.cpu.CPUBase;
import net.techest.asmer.core.exceptions.BitsException;
import net.techest.asmer.core.util.Log4j;
import net.techest.asmer.core.util.StringUtil;

/**指令基类 所有的指令类必须由它派生
 *
 * @author princehaku
 */
public abstract class InstructionBase implements InstructionInterface{

    /**指令名
     *
     */
    protected String name;
    /**指令参数
     *
     */
    ArrayList<Args> args;
    /**指令模式串 不匹配的将作为非正常指令
     *
     */
    protected String pattren;
    /**参数长度
     *
     */
    protected int argvLength;

    protected static CPUBase cpu;

    protected CPUBase getCpu() {
        return cpu;
    }
    
    public InstructionBase(CPUBase aThis) {
        cpu=aThis;
        args=new ArrayList<Args>();
        setName("");
    }

    public int getArgvLength() {
        return argvLength;
    }

    public void setArgvLength(int argvLength) {
        this.argvLength = argvLength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPattren() {
        return pattren;
    }

    public void setPattren(String pattren) {
        this.pattren = pattren;
    }

    public void check(String ins){

        //更具逗号 设定指令长度
        this.setArgvLength(StringUtil.occurTimes(ins,",")+1);
        //分析指令 组合匹配模式
        String pattenAny="(\\S*?)\\s*?";

        for(int i=0;i<this.getArgvLength()-1;i++){
            pattenAny+="(\\S*?),";
        }

        pattenAny += "(\\S*)";
        
        this.setPattren(pattren);
        //使用cpu的寻址器分析地址
        Args t1 = new Args();
        Args t2 = new Args();
        t1.setType(ArgsType.REGISTER);
        t2.setType(ArgsType.REGISTER);
        t1.setValue("AX");
        t2.setValue("BX");
        args.add(t1);
        args.add(t2);
        Log4j.i(this.getClass(), pattenAny);

    }

    protected Args getArgv(int i) {
        return this.args.get(i-1);
    }
}
