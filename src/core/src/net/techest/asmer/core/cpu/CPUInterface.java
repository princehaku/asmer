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
 *  Created on : 2011-3-25, 22:34:29
 *  Author     : princehaku
 */

package net.techest.asmer.core.cpu;

import net.techest.asmer.core.exceptions.InsException;

/**
 *
 * @author princehaku
 */
public interface CPUInterface {

    void execute(String ins) throws InsException;

    /**
     * 读取指令分析器
     */
    void loadAnalyzer();

    /**
     * 载入指令
     */
    void loadIns();

    /**
     * 载入寄存器
     */
    void loadReg();

    /**
     * 载入主存
     */
    void loadRom();

    void writeBack();

}
