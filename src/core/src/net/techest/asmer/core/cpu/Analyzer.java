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
 *  Created on : 2011-3-18, 20:47:59
 *  Author     : princehaku
 */
package net.techest.asmer.core.cpu;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.techest.asmer.core.cpu.register.Register;
import net.techest.asmer.core.exceptions.ArgsException;
import net.techest.asmer.core.util.Log4j;

/**指令参数分析器
 *
 * @author princehaku
 */
public class Analyzer {

    ArrayList<Args> args;
    CPUBase cpu;

    public Analyzer(CPUBase cpu) {
        this.cpu = cpu;
        args = new ArrayList<Args>();
    }

    private Args parse(String s) throws ArgsException {
        Args arg = new Args();
        Register register = cpu.getRegisterByName(s);
        try {
            //寄存器查询
            if (register != null) {
                arg.setType(ArgsType.REGISTER);
                arg.setValue(s);
                Log4j.i(this.getClass(), "Register " + s + " detected");
            }
            //TODO:ROM表查询

            //立即数转换
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

    /**分析参数
     *
     * @param ins
     * @param pattren
     * @return
     */
    public ArrayList<Args> parse(String ins, String pattren) throws ArgsException {

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
