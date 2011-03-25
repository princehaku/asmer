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

/**
 * 
 * @author princehaku
 */
public class RomBase implements RomInterface {
  Hashtable hs;

  private int addrLength;

  public RomBase(int addrLength) {
        Log4j.i(this.getClass(), "New rom create with address length"+addrLength);
        this.addrLength=addrLength;
        hs=new Hashtable(this.addrLength);
        hs.get(1);
  }

  public int getSize() {
        return 2^addrLength;
  }

  public String readBlock(int pos) {
        throw new UnsupportedOperationException("Not supported yet.");
  }

  public void writeBlock(int pos, String value) {
        throw new UnsupportedOperationException("Not supported yet.");
  }

}
