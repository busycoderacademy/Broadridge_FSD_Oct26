package com.session05.topic.map;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

class MyKey implements Comparable<MyKey>{
	private int k;

	public int getK() {
		return k;
	}

	public MyKey(int k) {
		super();
		this.k = k;
	}

	@Override
	public String toString() {
		return "MyKey [k=" + k + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(k);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyKey other = (MyKey) obj;
		return k == other.k;
	}

	@Override
	public int compareTo(MyKey o) {
		return Integer.compare(this.getK(), o.getK());
	}

}

public class I_UserDefineKey {

	public static <T> void main(String[] args) {
		
		Map<MyKey, String> map=new TreeMap<>(( o1,  o2)-> Integer.compare(o2.getK(), o1.getK()));
		
		
//		Map<MyKey, String> map=new TreeMap<>(new Comparator<MyKey>() {
//			@Override
//			public int compare(MyKey o1, MyKey o2) {
//				return Integer.compare(o2.getK(), o1.getK());
//			}
//		});
		
		map.put(new MyKey(80), "Eighty");
		map.put(new MyKey(82), "Hundered");
		map.put(new MyKey(84), "Eighty four");
		//String value=map.get(new MyKey(80));
		//System.out.println(value);
		map.forEach((k,v)->System.out.println(k+": "+ v) );

	}
}
