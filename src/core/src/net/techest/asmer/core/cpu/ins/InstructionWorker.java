/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.techest.asmer.core.cpu.ins;

import net.techest.asmer.core.exceptions.InsException;
import java.util.ArrayList;

/**指令工作站
 * 负责分发和注册指令
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
