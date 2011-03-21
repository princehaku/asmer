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
 *  Created on : 2011-3-21, 17:19:23
 *  Author     : princehaku
 */

package net.techest.asmer.core.cpu;

/**参数类
 *
 * @author princehaku
 */
public class Args {
    /**参数类型
     *
     */
    private ArgsType type;
    /**参数的值
     *
     */
    private String value;

    public ArgsType getType() {
        return type;
    }

    public void setType(ArgsType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
