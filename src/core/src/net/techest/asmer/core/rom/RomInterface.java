/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.techest.asmer.core.rom;

/**主存接口
 * 
 * @author princehaku
 */
public interface RomInterface {
    void RomInterface(long byteSize);
    void getSize();
    void readBlock(long pos);
    void writeBlock(long pos,String value);
}
