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
 *  Created on : 2011-3-21, 17:32:32
 *  Author     : princehaku
 */

package net.techest.asmer.core.cpu.ins;

/**所有指令都必须实现的接口
 * 已经被基类继承
 * @author princehaku
 */
public interface InstructionInterface {

    void check(String ins);

    void execute();

    void writeBack();

}
