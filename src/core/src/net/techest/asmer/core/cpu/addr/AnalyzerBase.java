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
 *  Created on : 2011-3-18, 20:47:59
 *  Author     : princehaku
 */
package net.techest.asmer.core.cpu.addr;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.techest.asmer.core.cpu.Args;
import net.techest.asmer.core.cpu.CPUBase;
import net.techest.asmer.core.cpu.register.Register;
import net.techest.asmer.core.exceptions.ArgsException;
import net.techest.asmer.core.util.Log4j;
/**
 * 指令参数分析器
 * 
 * @author princehaku
 */
public abstract class AnalyzerBase {
  ArrayList<net.techest.asmer.core.cpu.Args> args;

  net.techest.asmer.core.cpu.CPUBase cpu;

  public AnalyzerBase(net.techest.asmer.core.cpu.CPUBase cpu) {
        this.cpu = cpu;
        args = new ArrayList<Args>();
  }

  abstract net.techest.asmer.core.cpu.Args parse(String s) throws net.techest.asmer.core.exceptions.ArgsException ;

  /**
   * 分析参数
   * 
   * @param ins
   * @param pattren
   * @return
   */
  public ArrayList<net.techest.asmer.core.cpu.Args> parse(String ins, String pattren) throws net.techest.asmer.core.exceptions.ArgsException {

        args = new ArrayList<Args>();

        Log4j.i(this.getClass(), "Analyzing " + ins + " with Pattren " + pattren);

        Pattern pn = Pattern.compile(pattren);

        Matcher mc = pn.matcher(ins);

        if (mc.find()) {
            for (int i = 2; i <= mc.groupCount(); i++) {
                Log4j.i(this.getClass(), "Analyzing " + mc.group(i));
                parse(mc.group(i));
            }
        }

        return args;
  }

}
