/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.techest.asmer.core.cpu.register;

import java.util.ArrayList;

/**寄存器工作站
 * 负责分发和注册寄存器
 * @author princehaku
 */
public class RegisterWorker extends ArrayList<Register>{
    
    public Register getByName(String name){
            for(int i=0;i<this.size();i++){
                if(this.get(i).getName().equals(name))
                {
                    return this.get(i);
                }

            }
        return null;
    }
}
