package net.techest.asmer.core;

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
 *  Created on : 2011-3-6, 20:34:52
 *  Author     : princehaku
 */



import java.util.logging.Level;
import java.util.logging.Logger;
import net.techest.asmer.core.cpu.CPU8086;
import net.techest.asmer.core.cpu.CPUBase;
import net.techest.asmer.core.exceptions.InsException;

/**
 *
 * @author princehaku
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Asmer as=new Asmer();
        CPUBase cpu =new CPU8086();
        try {
            cpu.execute("ADD AX,AA0FH");
            cpu.execute("MOV BX,AA0FH");
            cpu.execute("SUB AX,BX");
        } catch (InsException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
