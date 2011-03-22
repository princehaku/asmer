/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.techest.asmer.core.cpu;

import net.techest.asmer.core.cpu.ins.InstructionADD;
import net.techest.asmer.core.cpu.register.RegisterFactory;

/**8086的实现类
 *
 * @author princehaku
 */
public class CPU8086 extends CPUBase{

    @Override
    public void LoadReg() {
        //数据寄存器
        regs.add(RegisterFactory.build("AH", 4));
        regs.add(RegisterFactory.build("BH", 4));
        regs.add(RegisterFactory.build("CH", 4));
        regs.add(RegisterFactory.build("DH", 4));
        regs.add(RegisterFactory.build("AL", 4));
        regs.add(RegisterFactory.build("BL", 4));
        regs.add(RegisterFactory.build("CL", 4));
        regs.add(RegisterFactory.build("DL", 4));
        regs.add(RegisterFactory.pasteBuild("AX", regs.getByName("AH"), regs.getByName("AL")));
        regs.add(RegisterFactory.pasteBuild("BX", regs.getByName("BH"), regs.getByName("BL")));
        regs.add(RegisterFactory.pasteBuild("CX", regs.getByName("CH"), regs.getByName("CL")));
        regs.add(RegisterFactory.pasteBuild("DX", regs.getByName("DH"), regs.getByName("DL")));
        //段寄存器
        regs.add(RegisterFactory.build("CS", 8));
        regs.add(RegisterFactory.build("DS", 8));
        regs.add(RegisterFactory.build("SS", 8));
        regs.add(RegisterFactory.build("ES", 8));
        //ex
        regs.add(RegisterFactory.build("SP", 8));
        regs.add(RegisterFactory.build("BP", 8));
        regs.add(RegisterFactory.build("SI", 8));
        regs.add(RegisterFactory.build("DI", 8));
        //指针寄存器
        regs.add(RegisterFactory.build("IP", 8));
        //标志寄存器
        regs.add(RegisterFactory.build("FR", 8));
    }

    @Override
    public void LoadIns() {
        irs.add(new InstructionADD(this));
    }

    @Override
    public void writeBack() {
        //TODO :  CPU writeBack
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
