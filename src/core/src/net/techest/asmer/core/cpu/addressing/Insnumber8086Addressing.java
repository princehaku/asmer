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
 *  Created on : 2011-3-29, 12:29:40
 *  Author     : princehaku
 */

package net.techest.asmer.core.cpu.addressing;

import net.techest.asmer.core.exceptions.AddressingException;
import net.techest.asmer.core.util.Log4j;
import net.techest.asmer.core.util.StringUtil;

/**立即数寻址
 *
 * @author princehaku
 */
public class Insnumber8086Addressing extends Addressing{
    
    @Override
    public Addressing parse(String param) throws AddressingException {
        String findMc = StringUtil.findMc(param.replaceAll("H",""), "([\\dA-F]*)", 1);
        Log4j.i(this.getClass(), findMc);
        if(findMc.equals(param.replaceAll("H",""))){
           this.setType(AddressingType.INSNUMBER);
            if (param.indexOf("H") != -1) {
                Long h = Long.parseLong(param.replace("H", ""), 16);
                this.setValue(Long.toBinaryString(h));
                return this;
            }
                Long h = Long.parseLong(param.replace("H", ""), 10);
                this.setValue(Long.toBinaryString(h));
                return this;
        }
        throw new AddressingException("Not An Insnumber");
    }

}
