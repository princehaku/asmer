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
 *  Created on : 2011-3-29, 12:30:15
 *  Author     : princehaku
 */

package net.techest.asmer.core.cpu.addressing;

import net.techest.asmer.core.cpu.CPUBase;
import net.techest.asmer.core.exceptions.AddressingException;
import net.techest.asmer.core.util.Log4j;
import net.techest.asmer.core.util.StringUtil;

/**直接寻址
 *
 * @author princehaku
 */
public class Direct8086Addressing extends Addressing{
    
    public Direct8086Addressing(CPUBase cpu){
        super(cpu);
    }

    @Override
    public Addressing parse(String param) throws AddressingException {
            //间接寻址模式 \\(\\w*?)[(\\w*?)\\]
            String rex1=StringUtil.findMc(param, "(\\w*?)\\[(\\w*?)\\]", 1);
            String rex2=StringUtil.findMc(param, "(\\w*?)\\[(\\w*?)\\]", 2);
            Log4j.i(this.getClass(), "Get Conntent " + rex2);
            if(!rex2.equals("")){
                this.setType(AddressingType.DIRECT);
                String xxx="";
                int pos=-1;
                if(rex2.indexOf("H")!=-1){
                    pos=Integer.parseInt(rex2.replaceAll("H", ""),16);
                }else{
                    pos=Integer.parseInt(rex2);
                }
                //写入的是10进制数
                this.setValue(pos+"");
                return this;
            }
       throw new AddressingException("Not A Direct Number");
    }

}
