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
 *  Created on : 2011-3-29, 12:28:16
 *  Author     : princehaku
 */

package net.techest.asmer.core.cpu.addressing;

import net.techest.asmer.core.exceptions.AddressingException;
import net.techest.asmer.core.cpu.CPUBase;
import net.techest.asmer.core.cpu.register.Register;
import net.techest.asmer.core.util.Log4j;

/**寄存器寻址
 *
 * @author princehaku
 */
public class Register8086Addressing extends Addressing{

    public Register8086Addressing(CPUBase cpu){
        super(cpu);
    }
    
    public Addressing parse(String param) throws AddressingException{
       Register register = cpu.getRegisterByName(param);
            //寄存器寻址
            if (register != null) {
                this.setType(AddressingType.REGISTER);
                this.setValue(param);
                Log4j.i(this.getClass(), "Register " + param + " detected");
                return this;
            }
       throw new AddressingException("Not A Register");
    }
}
