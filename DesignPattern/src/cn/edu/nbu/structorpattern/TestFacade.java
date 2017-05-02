package cn.edu.nbu.structorpattern;

//���������֮���������ϵ������������֮�����϶ȣ���ģʽ���漰�ӿ�
//Ϊʹ�����ṩͳһ����ӿڣ���ʹ�������ξ���ʵ��
public class TestFacade {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer c = new Computer();
		c.startup();
		c.shutdown();
	}
}

class CPU{
	public void startup(){
		System.out.println("cpu startup");
	}
	
	public void shutdown(){
		System.out.println("cpu shutdown");
	}
}

class Memory{
	public void startup(){
		System.out.println("memeory startup");
	}
	
	public void shutdown(){
		System.out.println("memeory shutdown");
	}
}

class Disk{
	public void startup(){
		System.out.println("disk startup");
	}
	
	public void shutdown(){
		System.out.println("disk shutdown");
	}
}

class Computer{
	private CPU cpu;
	private Memory memory;
	private Disk disk;
	
	public Computer(){
		this.cpu = new CPU();
		this.memory = new Memory();
		this.disk = new Disk();
	}
	
	public void startup(){
		System.out.println("startup the computer");
		cpu.startup();
		memory.startup();
		disk.startup();
		System.out.println("computer startup finished");
	}
	
	public void shutdown(){
		System.out.println("computer begin to shutdown");
		cpu.shutdown();
		memory.shutdown();
		disk.shutdown();
		System.out.println("computer closed");
	}
}
