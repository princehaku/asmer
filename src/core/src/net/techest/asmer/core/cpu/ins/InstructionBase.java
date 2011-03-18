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

import net.techest.asmer.core.cpu.CPUBase;
import net.techest.asmer.core.util.Log4j;

/**
 *
 * @author princehaku
 */
public abstract class InstructionBase implements InstructionInterface {

    /**指令名
     *
     */
    protected String name;
    
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

    public abstract boolean check();

    public void execute(String ins) {
        //更具逗号 设定长度
        Log4j.i(this.getClass(), this.getCpu().getRegisterByName("AX").getBits());
    }

    public abstract void writeBack();
    
}