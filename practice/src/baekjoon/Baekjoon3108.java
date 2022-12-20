package baekjoon;

import java.io.*;
import java.util.*;

class Coordinate {
	int x, y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		Coordinate coordinate = (Coordinate) obj;
		return x == coordinate.x && y == coordinate.y;
	}
}

public class Baekjoon3108 {

	static ArrayList<HashSet<Coordinate>> setList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		
		setList = new ArrayList<>();
		
		int n = Integer.parseInt(strTkr.nextToken());
		for(int square=1; square<=n; square++) {
			strTkr = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(strTkr.nextToken());
			int y1 = Integer.parseInt(strTkr.nextToken());
			int x2 = Integer.parseInt(strTkr.nextToken());
			int y2 = Integer.parseInt(strTkr.nextToken());
			
			LoopRange:
			for(int rangeX=x1; rangeX<=x2; rangeX++) {
				for(HashSet<Coordinate> hashSet: setList) {
					if(hashSet.contains(new Coordinate(rangeX, y1)))
						continue LoopRange;
				}
				
				
					
				
				HashSet<Coordinate> hashSet = new HashSet<>();
				hashSet.add(new Coordinate(rangeX, rangeY));
				setList.add(hashSet);
			}
			
			int rangeX = x1;
			LoopRange:
			for(int rangeX=x1; rangeX<=x2; rangeX++, rangeY++) {
				for(HashSet<Coordinate> hashSet: setList)
					if(hashSet.contains(new Coordinate(rangeX, rangeY))) continue LoopRange;
				
				HashSet<Coordinate> hashSet = new HashSet<>();
				hashSet.add(new Coordinate(rangeX, rangeY));
				setList.add(hashSet);
			}
		}
		br.close();

	}
	
	private static void name(int start, int end, int fixCoordinate) {
		for(int range=start; range<=end; range++) {
			isContainCoordinate(rangeX, rangeX)
			
			
				
			
			HashSet<Coordinate> hashSet = new HashSet<>();
			hashSet.add(new Coordinate(rangeX, rangeY));
			setList.add(hashSet);
		}
	}
	
	private static boolean isContainCoordinate(int targetX, int targetY) {
		for(HashSet<Coordinate> hashSet: setList)
			if(hashSet.contains(new Coordinate(targetX, targetY)))
				return true;
		
		return false;
	}
	
}






















