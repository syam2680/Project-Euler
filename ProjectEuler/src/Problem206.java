public class Problem206 {

    public static void main(String args[]) {
        //1_2_3_4_5_6_7_8_9_0
        long lb = 1020304050607080900L;
        long ub = 1929394959697989990L;
        
        
        lb = (long) Math.sqrt(lb);
        ub = (long) Math.sqrt(ub);
        
        
        for (long i = lb; i <= ub; i++) {
            String s = Long.toString(i*i);
            if(s.charAt(0)  != '1') continue;
            if(s.charAt(2)  != '2') continue;
            if(s.charAt(4)  != '3') continue;
            if(s.charAt(6)  != '4') continue;
            if(s.charAt(8)  != '5') continue;
            if(s.charAt(10) != '6') continue;
            if(s.charAt(12) != '7') continue;
            if(s.charAt(14) != '8') continue;
            if(s.charAt(16) != '9') continue;
            if(s.charAt(18) != '0') continue;
            System.out.println("Found  :" + i);
            break;
        }

     }

}