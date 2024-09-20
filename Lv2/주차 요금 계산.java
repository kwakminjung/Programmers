import java.util.*;


class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        List<Car> carList = new ArrayList<>();
        for(String record : records) {
        	String[] parts = record.split(" ");
            String time = parts[0];
            String carName = parts[1];
            String inOut = parts[2];
            
        	for(int i = 0 ; i <= carList.size() ; i++) {
        		if(carList.size() == 0) {
        			carList.add(new Car(carName, time));
        			break;
        		}
        		
        		if(carList.get(i).name.equals(carName)) {
        			
        			if(inOut.equals("IN")) {
        				carList.get(i).whenPark(time);
        			} else {
        				carList.get(i).howPark(time);
        			}
        			break;
        		} else if(i == carList.size() - 1) {
        			carList.add(new Car(carName, time));
        			break;
        		}
        	}
        }
        
        Collections.sort(carList);
        int[] answer = new int[carList.size()];
        int idx = 0;
        for(Car car : carList) {
        	if(car.parkFlag) car.howPark("23:59");
        	answer[idx] = parkCost(car.parkingMin, fees[0], fees[1], fees[2], fees[3]);
        	idx ++;
        }
        for(int a : answer) {
        	System.out.println(a);
        }
        return answer;
    }
    
    int parkCost(int time, int baseTime, int baseCost, int unitTime, int unitCost) {
    	if(time <= baseTime) return baseCost;
    	
    	int midResult = (time - baseTime) % unitTime > 0 ? (time - baseTime) / unitTime + 1 : (time - baseTime) / unitTime;
    	return baseCost + midResult * unitCost; 
    }
}

class Car implements Comparable<Car> {
	String name;
	int inMin;
	int parkingMin;
	boolean parkFlag;
	
	Car(String name, String inTime) {
		this.name = name;
		whenPark(inTime);
		this.parkingMin = 0;
		this.parkFlag = true;
	}
	
	void whenPark(String IN) {
		String[] parts = IN.split(":");

        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        
		inMin = h * 60 + m;
		this.parkFlag = true;
	}
	
	void howPark(String OUT) {
		String[] parts = OUT.split(":");
		int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
		
		int outMin = h * 60 + m;
		
		parkingMin += outMin - inMin;
		this.parkFlag = false;
	}
	
	@Override
	public int compareTo(Car car) {
		for(int i = 0 ; i < 4; i++) {
			if(car.name.charAt(i) < name.charAt(i)) return 1; 
			else if(car.name.charAt(i) > name.charAt(i)) return -1;
		}
		return 0;
	}
}
