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
 *  Created on : 2011-3-29, 12:30:50
 *  Author     : princehaku
 */

package net.techest.asmer.core.cpu.addressing;

import java.util.ArrayList;
import net.techest.asmer.core.cpu.CPUBase;
import net.techest.asmer.core.exceptions.AddressingException;
import net.techest.asmer.core.util.Log4j;

/**
 *
 * @author princehaku
 */
public class AddressingFactory {
    ArrayList<Addressing> ads;

    public AddressingFactory(CPUBase cpu) {
        ads=new ArrayList<Addressing>();
    }
    
    public void registerAddressing(Addressing add){
        ads.add(add);
    }

    public Addressing provideAddressing(String param) throws AddressingException {
        for(int i=0;i<ads.size();i++){
            Addressing a=ads.get(i);
            try{
                a.parse(param);
                return a;
            }catch(AddressingException ex){
                Log4j.i(this.getClass(), ex.getMessage());
            }
        }
        throw new AddressingException("Can't be addressing");
    }

    
}
