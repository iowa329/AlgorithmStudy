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
	
	// hash 값을 사용하는 Collection(HashSet, HashMap, HashTable)에서는 equals와 hashCode 함수를 같이 재정의 해야한다
	@Override
	public int hashCode() {
		return x + y;
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}

public class Baekjoon3108 {

	static ArrayList<HashSet<Coordinate>> hashSetList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		
		hashSetList = new ArrayList<>();
		
		int n = Integer.parseInt(strTkr.nextToken());
		for(int square=1; square<=n; square++) {
			strTkr = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(strTkr.nextToken());
			int y1 = Integer.parseInt(strTkr.nextToken());
			int x2 = Integer.parseInt(strTkr.nextToken());
			int y2 = Integer.parseInt(strTkr.nextToken());
			
			HashSet<Coordinate> hashSet = new HashSet<>();
			hashSet = makeSquareHashSet(hashSet, x1, y1, x2, y2);
			
			while(true) {
				int matchIndex = isHashSetContain(hashSet);
				if(matchIndex == -1) {
					hashSetList.add(hashSet);
					break;
				} else {
					hashSet = addSquareHashSet(matchIndex, hashSet);
				}
			}
			
		}
		br.close();
		
		int minPU = hashSetList.size();
		for(HashSet<Coordinate> hashSet: hashSetList) {
			if(hashSet.contains(new Coordinate(0, 0))) {
				minPU--;
				break;
			}
		}
		
		System.out.println(minPU);
	}
	
	private static HashSet<Coordinate> makeSquareHashSet(HashSet<Coordinate> hashSet, int x1, int y1, int x2, int y2) {
		for(int x=x1; x<=x2; x++)
			hashSet.add(new Coordinate(x, y1));
		for(int x=x1; x<=x2; x++)
			hashSet.add(new Coordinate(x, y2));
		for(int y=y1; y<=y2; y++)
			hashSet.add(new Coordinate(x1, y));
		for(int y=y1; y<=y2; y++)
			hashSet.add(new Coordinate(x2, y));
		
		return hashSet;
	}
	
	private static int isHashSetContain(HashSet<Coordinate> hashSet) {
		for(Coordinate coordinate: hashSet)
			for(int i=0; i<hashSetList.size(); i++)
				if(hashSetList.get(i).contains(coordinate)) {
					return i;
				}
		
		return -1;
	}
	
	private static HashSet<Coordinate> addSquareHashSet(int index, HashSet<Coordinate> hashSet) {
		for(Coordinate coordinate: hashSet)
			hashSetList.get(index).add(new Coordinate(coordinate.x, coordinate.y));
		hashSet = hashSetList.get(index);
		hashSetList.remove(index);
		
		return hashSet;
	}
	
}