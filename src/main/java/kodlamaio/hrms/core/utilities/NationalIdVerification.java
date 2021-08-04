package kodlamaio.hrms.core.utilities;

public class NationalIdVerification {
	public static boolean isTCKNCorrect(String id) {
	      if (id == null) return false;

	      if (id.length() != 11) return false;

	      char[] chars = id.toCharArray();
	      int[] a = new int[11];
	  
	      for(int i=0; i<11; i++) {
	          a[i] = chars[i] - '0';
	      }

	      if(a[0] == 0) return false;
	      if(a[10] % 2 == 1) return false;

	      if(((a[0] + a[2] + a[4] + a[6] + a[8]) * 7 - (a[1] + a[3] + a[5] + a[7])) % 10 != a[9]) return false;

	      if((a[0] + a[1] + a[2] + a[3] + a[4] + a[5] + a[6] + a[7] + a[8] + a[9]) % 10 != a[10]) return false;

	      return true;
	  }
}
