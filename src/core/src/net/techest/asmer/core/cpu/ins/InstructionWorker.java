/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.techest.asmer.core.cpu.ins;

import java.util.ArrayList;

/**
 *
 * @author princehaku
 */
public class InstructionWorker extends ArrayList<InstructionBase>{

    public InstructionBase getByName(String name){
            for(int i=0;i<this.size();i++){
                if(this.get(i).getName().equals(name))
                {
                    return this.get(i);
                }

            }
        return null;
    }

}
