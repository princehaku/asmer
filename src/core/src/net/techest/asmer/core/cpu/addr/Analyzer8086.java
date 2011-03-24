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
 *  Created on : 2011-3-23, 18:07:24
 *  Author     : princehaku
 */

package net.techest.asmer.core.cpu.addr;

import net.techest.asmer.core.cpu.Args;
import net.techest.asmer.core.cpu.ArgsType;
import net.techest.asmer.core.cpu.CPUBase;
import net.techest.asmer.core.cpu.register.Register;
import net.techest.asmer.core.exceptions.ArgsException;
import net.techest.asmer.core.util.Log4j;

/**
 *
 * @author princehaku
 */
public class Analyzer8086 extends AnalyzerBase {

    
    public Analyzer8086(CPUBase cpu){
        super(cpu);
    }

    protected Args parse(String s) throws ArgsException {
        
        Args arg = new Args();
        
        try {
            Register register = cpu.getRegisterByName(s);
            //寄存器
            if (register != null) {
                arg.setType(ArgsType.REGISTER);
                arg.setValue(s);
                Log4j.i(this.getClass(), "Register " + s + " detected");
            }
            //寄存器间接寻址
            

            //TODO:ROM表查询

            //立即数
            if (s.indexOf("H") != -1) {
                Long h = Long.parseLong(s.replace("H", ""), 16);
                arg.setType(ArgsType.INSNUMBER);
                arg.setValue(Long.toBinaryString(h));
            }
        } catch (Exception ex) {
            throw new ArgsException("Parse Error");
        }
        if (arg.getValue() != null) {
            args.add(arg);
        }
        return arg;
    }

    
}
