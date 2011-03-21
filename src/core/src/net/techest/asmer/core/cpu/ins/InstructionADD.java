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
 *  Created on : 2011-3-17, 11:32:09
 *  Author     : princehaku
 */

package net.techest.asmer.core.cpu.ins;

import net.techest.asmer.core.cpu.Args;
import net.techest.asmer.core.cpu.CPUBase;

/**
 *
 * @author princehaku
 */
public class InstructionADD extends InstructionBase {

    public InstructionADD(CPUBase aThis) {
        super(aThis);
        this.setName("ADD");
    }

    public void execute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void writeBack() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}