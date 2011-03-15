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

import net.techest.asmer.core.cpu.register.Registers;

/**
 *
 * @author princehaku
 */
public abstract class CPUBase implements CPUInterface{

    protected InstructionWorker ir;
    
    protected Registers regs;

    public CPUBase(){
        regs=new Registers();
        LoadReg();
        LoadIns();
    }


    public abstract void LoadReg();

    public abstract void LoadIns();
    
    public void fetch() {
        //TODO:编码
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void decode() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void execute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void writeback() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
