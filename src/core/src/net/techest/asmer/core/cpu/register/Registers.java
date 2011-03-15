/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.techest.asmer.core.cpu.register;

import java.util.ArrayList;

/**
 *
 * @author princehaku
 */
public class Registers extends ArrayList<Register>{
    
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
