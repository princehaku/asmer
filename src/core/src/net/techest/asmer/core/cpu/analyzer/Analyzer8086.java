/**
 *   Copyright 2010 princehaku
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
package net.techest.asmer.core.cpu.analyzer;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.techest.asmer.core.cpu.CPUBase;
import net.techest.asmer.core.cpu.addressing.Addressing;
import net.techest.asmer.core.cpu.addressing.AddressingFactory;
import net.techest.asmer.core.cpu.addressing.Direct8086Addressing;
import net.techest.asmer.core.cpu.addressing.Insnumber8086Addressing;
import net.techest.asmer.core.cpu.addressing.Register8086Addressing;
import net.techest.asmer.core.exceptions.AddressingException;
import net.techest.asmer.core.exceptions.ArgsException;
/**
 * 
 * @author princehaku
 */
public class Analyzer8086 extends AnalyzerBase {
    
  public Analyzer8086(CPUBase cpu) {
        super(cpu);
  }

  protected void parseArgs(String s) throws AddressingException{
      
        AddressingFactory addfac=new AddressingFactory(this.cpu);

        addfac.registerAddressing(new Register8086Addressing(this.cpu));
        addfac.registerAddressing(new Insnumber8086Addressing());
        addfac.registerAddressing(new Direct8086Addressing(this.cpu));

        Addressing ads = addfac.provideAddressing(s);

        if(ads!=null&&!ads.getValue().equals("")){
                args.add(ads);
            }
  }

}
