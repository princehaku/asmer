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

/**
 *
 * @author princehaku
 */
public class InstructionBase {
    /**指令名
     *
     */
    private String name;

    private String pattren;
    /**参数长度
     *
     */
    private int argvLength;

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
    
    void Instruction(CPUBase aThis) {
        
    }

    public boolean check() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void execute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void writeBack() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    
}
