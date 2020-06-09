
public class PowerOfTwo {
	
    public boolean isPowerOfTwo(int n) {
    	if(n==0) {
    		return true;
    	}
    	if(n==1) {
    		return true;
    	}
    	if(n%2 != 0) {
    		return false;
    	}
    	
    	return isPowerOfTwo(n/2);
    }
	
	public static void main(String[] args) {
	}
}
