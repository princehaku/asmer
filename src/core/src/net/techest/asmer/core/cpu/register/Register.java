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
 *  Created on : 2011-3-14, 13:34:52
 *  Author     : princehaku
 */
package net.techest.asmer.core.cpu.register;

import net.techest.asmer.core.exceptions.BitsException;
import net.techest.asmer.core.util.Log4j;

/**
 *
 * @author princehaku
 */
public class Register implements RegisterInterface {

    protected String name = "";
    protected int length = 0;
    protected String bits = "";
    protected RegisterWorker registers = new RegisterWorker();
    protected boolean protect = false;

    /**
     *
     * @param name
     * @param length
     */
    Register(String name, int length) {
        this.name = name;
        this.length = length;
    }

    /**得到寄存器的名字
     *
     * @return
     */
    protected String getName() {
        return name;
    }

    /**设置寄存器的内容
     *
     * @param bits
     * @throws BitsException
     */
    public void setBits(String bits) throws BitsException {
        if (bits.length() != this.length || protect) {
            throw new BitsException("Set Bits Error , Length incorrect or been protected");
        }
        int r = 0;
        for (int i = 0; i < this.registers.size(); i++) {
            Register rtmp = this.registers.get(i);
            Log4j.i(this.getClass(),rtmp.getName() + " set as " + bits.substring(r, r + rtmp.getLength()));
            rtmp.setBits(bits.substring(r, r + rtmp.getLength()));
            r = r + rtmp.getLength();
        }
        this.bits = bits;
    }

    /**组合一个寄存器进入
     * 先进入的在前面
     * @param e
     * @return
     */
    public boolean add(Register e) {
        registers.add(e);
        //调整组合寄存器的属性
        this.length += e.length;
        this.bits = e.getBits() + bits;
        return true;
    }

    /**得到位元大小
     *
     * @return
     */
    public int getLength() {
        return this.length;
    }

    /**得到位元
     *
     * @return
     */
    public String getBits() {
        return this.bits;
    }

    /**移除组合寄存器中的一个
     *
     */
    public boolean remove(Register e) {
        // TODO:移除组合寄存器中的一个
        return false;
    }
}
