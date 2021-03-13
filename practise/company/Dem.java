package design.pattern.interview;

import java.util.*;

class Device {
	public int price;
	public String name;
	public String model;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}

class Speaker extends Device {
	int voiceEnable;

	public int getVoiceEnable() {
		return voiceEnable;
	}

	public void setVoiceEnable(int voiceEnable) {
		this.voiceEnable = voiceEnable;
	}
}

class TV extends Device {
	public int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}

/**
 * Comparison to order the devices 
 */
class sortDevice implements Comparator<Device> {

	@Override
	public int compare(Device o1, Device o2) {
		if (o1.getPrice() == o2.getPrice()) {
			if (o1.getName().equals("TV") && o2.getName().equals("TV"))
				return ((TV) o2).getSize() - ((TV) o1).getSize();
			if (o1.getName().equals("Speaker") && o2.getName().equals("Speaker"))
				return ((Speaker) o1).getVoiceEnable() - ((Speaker) o2).getVoiceEnable();
			if (o1.getName().equals("TV") && o2.getName().equals("Speaker"))
				return o2.getName().compareTo(o1.getName());
		}
		return o1.getPrice() - o2.getPrice();
	}
}

/**
 * Device(base) class is inherited by TV & Speaker
 * iterating through input set values to the classes. Sort Device object implementing
 * comparator by sortDevice class following all the conditions mentioned in question.
 * Set all the models to an array to return array of string which is printed.
 */

public class Dem {

	/**
	 * @param type &  model
	 * @param price
	 * @param type
	 * @return array of model
	 */
	public static String[] result(String[] A, int[] price, int[] type) {
		Device[] devices = new Device[3];
		for (int i = 0; i < A.length; i++) {
			TV tv = new TV();
			Speaker speaker = new Speaker();

			if (A[i].contains("T") || A[i].contains("t")) {
				tv.setSize(type[i]);
				tv.setPrice(price[i]);
				tv.setName("TV");
				tv.setModel(A[i]);
				devices[i]=tv;
			} else {
				speaker.setPrice(price[i]);
				speaker.setVoiceEnable(type[i]);
				speaker.setName("Speaker");
				speaker.setModel(A[i]);
				devices[i]=speaker;
			}
		}
		Arrays.sort(devices, new sortDevice());
		String[] modelArray = new String[3];
		for (int i = 0; i < modelArray.length; i++) {
			modelArray[i] = devices[i].getModel();
		}
		return modelArray;
	}
	
	/**
	 * Driver method
	 */
	public static void main(String[] args) {
		// 1st use case
		String[] A = {"T01","T02","S01"};
		int[] price = {300,300,150};
		int[] type = {50,55,1};
		// 2nd use case
		String[] A1 = {"S01","S03","S02"};
		int[] price1 = {300,300,150};
		int[] type1 = {1,0,1};
		System.out.println("1st use case: " + Arrays.toString(result(A, price, type)));
		System.out.println("2nd use case: " + Arrays.toString(result(A1, price1, type1)));
	}

}
