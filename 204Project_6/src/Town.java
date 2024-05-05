//Aidan Buergin
import java.util.*;
public class Town implements Comparable<Town>{
	
	private String name;
	private ArrayList<Town> adjList = new ArrayList<Town>();
	
	public Town(String n) {
		name = n;
	}

	public Town(Town templateTown) {
		name = templateTown.getName();
		adjList = (ArrayList<Town>) templateTown.getAdjList().clone();
	}

	@Override
	public int compareTo(Town o) {
		return Town.stringCompare(this.getName(), o.getName());
	}
	
	/**
	 * @Summary provides the logic for the compareTo method
	 * @param s1
	 * @param s2
	 * @return 0 if equal, neg or pos int if not equal
	 */
	public static int stringCompare(String s1, String s2) {
		
		String str1 = s1;
		String str2 = s2;
		
        int l1 = str1.length(); 
        int l2 = str2.length(); 
        int lmin = Math.min(l1, l2); 
  
        for (int i = 0; i < lmin; i++) { 
            int str1_ch = (int)str1.charAt(i); 
            int str2_ch = (int)str2.charAt(i); 
  
            if (str1_ch != str2_ch) { 
                return str1_ch - str2_ch; 
            }    
        }
        
        if (l1 != l2) { 
            return l1 - l2; 
        } 
        else { 
            return 0; 
        } 
	}
	
	/**
	 * @summary uses the compareTo method to determine equality
	 */
	@Override
	public boolean equals(Object obj) {
		//null arg check
		if(obj == null) {
			return false;
		}
		if(this.compareTo((Town) obj) == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
	
	@Override
	public int hashCode() {
		String n = getName();
		int sum = 0;
		for(int i = 0; i < n.length(); i++) {
			sum += (int) n.charAt(i); 
		}
		return sum;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the adjList
	 */
	public ArrayList<Town> getAdjList() {
		return adjList;
	}
}
