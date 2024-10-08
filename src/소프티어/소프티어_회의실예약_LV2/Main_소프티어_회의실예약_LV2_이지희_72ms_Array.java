package 소프티어.소프티어_회의실예약_LV2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_소프티어_회의실예약_LV2_이지희_72ms_Array {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 회의실 수 
		int M = Integer.parseInt(st.nextToken()); // 예약된 회의 수
		
		List<String> names = new ArrayList<>();
		for(int n=0; n<N; n++) {
			names.add(br.readLine());
		}
		
		Collections.sort(names);
		// 0 : 09-10
		// 1 : 10-11
		// 2 : 11-12
		// 3 : 12-13
		// 4 : 13-14
		// 5 : 14-15
		// 6 : 15-16
		// 7 : 16-17
		// 8 : 17-18
		int[][] reservation = new int[N][9]; 
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int idx = names.indexOf(st.nextToken());
			int start = Integer.parseInt(st.nextToken()) - 9;
			int end = Integer.parseInt(st.nextToken()) - 9;
			
			for(int t=start; t<end; t++) {
				reservation[idx][t] = 1;
			}
		}
		
		for(int n=0; n<N; n++) {
			List<int[]> list = new ArrayList<>();
			int start = 9;
			int end = 9;
			for(int i=0; i<9; i++) {
				if(reservation[n][i] != 0) {
					end = i+9;
					if(start != end) {
						list.add(new int[] {start, end});
					}
					start = i+10;
				}
				if(i == 8) {
					end = i+10;
					if(start != end) {
						list.add(new int[] {start, end});
					}
				}
			}
			
			sb.append("Room ").append(names.get(n)).append(":\n");
			if(list.isEmpty()) {
				sb.append("Not available\n");
			}else {
				sb.append(list.size()).append(" available:\n");
				for(int[] time : list) {
					if(time[0] == 9) sb.append("09");
					else sb.append(time[0]);
					sb.append("-").append(time[1]).append("\n");
				}
			}
			if(n != N-1) sb.append("-----\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
