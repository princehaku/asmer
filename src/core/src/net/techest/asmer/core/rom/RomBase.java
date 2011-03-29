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
 *  Created on : 2011-3-22, 11:31:28
 *  Author     : princehaku
 */

package net.techest.asmer.core.rom;

import java.io.IOException;
import java.util.Hashtable;
import net.techest.asmer.core.util.Log4j;

/**
 * 
 * @author princehaku
 */
public class RomBase implements RomInterface {
    
  Hashtable hs;

  private int addrLength;

  public RomBase(int addrLength) {
        Log4j.i(this.getClass(), "New rom create with address length "+addrLength);
        this.addrLength=addrLength;
        hs=new Hashtable(this.addrLength);
        hs.put(0, "asdasd");
  }

  public int getSize() {
        return 2^addrLength;
  }

  public int getOffset(String paName) {
        return 2^addrLength;
  }

  public String readBlock(int pos)  throws IOException{
        if(hs.containsKey(pos)){
            Log4j.i(this.getClass(), "Get rom block at "+pos);
            return hs.get(pos).toString();
        }else{
            Log4j.i(this.getClass(), "No rom block found at "+pos);
            byte[] d = " ".getBytes();
            return new String(d,8);
        }
  }
/**
 *
 * @param pos 10进制
 * @param value
 * @throws IOException
 */
  public void writeBlock(int pos, String value) throws IOException{
      if(value.length()%8!=0||!value.replaceAll("1", "").replaceAll("0","").equals("")){
            Log4j.e(this.getClass(), "value error "+value);
            throw new IOException("writeBlock invaild value");
      }
        if(hs.containsKey(pos)){
            Log4j.i(this.getClass(), "Overwrite rom block at "+pos);
            hs.put(pos,value);
        }else{
            Log4j.i(this.getClass(), "No rom Block Found "+Integer.toHexString(pos)+"H");
            hs.put(pos,value);
        }
  }

}
