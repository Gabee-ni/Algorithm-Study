import java.util.*;

class Solution {
	public int[] solution(int[] fees, String[] records) {
		Map<String, Integer> inTime = new HashMap<>();
		Map<String, Integer> total = new TreeMap<>();

		for(String record : records){
			String[] p = record.split(" ");
			int time = toMinutes(p[0]);
			String car = p[1];

			if("IN".equals(p[2])){
				inTime.put(car, time);
			} else {
				total.merge(car, time - inTime.remove(car), Integer::sum);
			}
		}

		int endOfDay = 23 * 60 + 59;

		for(var e : inTime.entrySet()){
			total.merge(e.getKey(), endOfDay - e.getValue(), Integer::sum);
		}

		int[] result = new int[total.size()];
		int idx = 0;
		for(int t : total.values()){
			result[idx++] = calcFee(fees, t);
		}

		return result;
	}

	private int toMinutes(String hhmm){
		String[] t = hhmm.split(":");
		return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
	}

	private int calcFee(int[] fees, int time){
		int fee = fees[1];
		if(time > fees[0])
			fee += (int) Math.ceil((double)(time - fees[0]) / fees[2]) * fees[3];
		return fee;
	}
}