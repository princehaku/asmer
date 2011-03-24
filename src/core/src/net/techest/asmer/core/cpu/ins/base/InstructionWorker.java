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
 *  Created on : 2011-3-22, 11:32:09
 *  Author     : princehaku
 */

package net.techest.asmer.core.cpu.ins.base;

import net.techest.asmer.core.exceptions.InsException;
import java.util.ArrayList;

/**指令工作站
 * 负责注册,分发指令
 * @author princehaku
 */
public class InstructionWorker extends ArrayList<InstructionBase>{

    public InstructionBase getByName (String name) throws InsException{
            for(int i=0;i<this.size();i++){
                if(this.get(i).getName().equals(name))
                {
                    return this.get(i);
                }

            }
        throw new InsException("Ins Not Found");
    }

}
