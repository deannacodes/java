/**
 * Author: Deanna Streffer
 *
 * Description: Computer class which declares and provides getters for all pieces of the custom build computer.
 * 
 */

package hw3;

public class Computer {
	private Case towercase;
	private Monitor monitor;
	private CPU cpu;
	private VideoCard videoCard;
	private HardDrive hardDrive;
	private Memory memory;
	
	public Computer(Case towercase, Monitor monitor, CPU cpu, VideoCard videoCard, HardDrive hardDrive, Memory memory) {
		this.towercase = towercase;
		this.monitor = monitor;
		this.cpu = cpu;
		this.videoCard = videoCard;
		this.hardDrive = hardDrive;
		this.memory = memory;
	}

	public Case getTowercase() {
		return towercase;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public CPU getCpu() {
		return cpu;
	}

	public VideoCard getVideoCard() {
		return videoCard;
	}

	public HardDrive getHardDrive() {
		return hardDrive;
	}

	public Memory getMemory() {
		return memory;
	}
	
	public double getTotalCost() {
		double totalCost = towercase.getPrice() +
						   monitor.getPrice() + 
						   cpu.getPrice() +
						   videoCard.getPrice() +
						   hardDrive.getPrice() +
						   memory.getPrice();
		return totalCost;
	}
	
	public void displayReceipt() {
		System.out.println("***************Receipt***************\n" + 
						   towercase.toString() + "\n" +
						   monitor.toString() + "\n" +
						   cpu.toString() + "\n" +
						   videoCard.toString() + "\n" +
						   hardDrive.toString() + "\n" +
						   memory.toString() + "\n" +
						   "TOTAL COST:...................................$" + getTotalCost() + "\n");
	}
}
