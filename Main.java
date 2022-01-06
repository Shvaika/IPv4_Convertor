import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static Scanner data = new Scanner(System.in);
    public static int[] ipaddress = new int[4];
    public static int[] submusk = new int[4];
    public static int[] submusk2 = new int[4];
    
	public static void main(String[] args) {
		System.out.println("Type IP address ");
		ipaddress[0] = data.nextInt();
		System.out.print(".");
        ipaddress[1] = data.nextInt();
        System.out.print(".");
        ipaddress[2] = data.nextInt();
        System.out.print(".");
        ipaddress[3] = data.nextInt();
        
        System.out.println("Subnet mask ");
		submusk[0] = data.nextInt();
		submusk2[0] = submusk[0];
		System.out.print(".");
        submusk[1] = data.nextInt();
        submusk2[1] = submusk[1];
        System.out.print(".");
        submusk[2] = data.nextInt();
        submusk2[2] = submusk[2];
        System.out.print(".");
        submusk[3] = data.nextInt();
        submusk2[3] = submusk[3];
        
        if(ipaddress[0] < 0 && ipaddress[1] < 0 && ipaddress[2] < 0 && ipaddress[3] < 0){
            System.out.println("!!!--****--!!!");
        }else if(ipaddress[0] > 255 && ipaddress[1] > 255 && ipaddress[2] > 255 && ipaddress[3] > 255){
            System.out.println("!!!--****--!!!");
        }else if(submusk[0] < 0 && submusk[1] < 0 && submusk[2] < 0 && submusk[3] < 0){
        	System.out.println("!!!--**** 1--!!!");
        }else if(ipaddress[0] > 255 && ipaddress[1] > 255 && ipaddress[2] > 255 && ipaddress[3] > 255){
            System.out.println("!!!--**** 255--!!!");
        }else { 
        	System.out.println("its ok "); 
        	firstmethod();
        	secondmethod();
        	thirtymethod();
        }
       
	}
	
	public static int[] netipadd;
	public static int[] firsthostipadd;

	public static void firstmethod(){

		netipadd  = new int[4];
		firsthostipadd = new int[4];

		
		netipadd[0] = ipaddress[0] & submusk[0];
		firsthostipadd[0] = netipadd[0];
		netipadd[1] = ipaddress[1] & submusk[1];
		firsthostipadd[1] = netipadd[1];
		netipadd[2] = ipaddress[2] & submusk[2];
		firsthostipadd[2] = netipadd[2];
		netipadd[3] = ipaddress[3] & submusk[3];
		firsthostipadd[3] = netipadd[3] +1; 

		for (int i = 0; i < 4; i++) {
            if(i == 0){ 
            	System.out.println("---network ip---");
                System.out.print(netipadd[0]);
                System.out.print("."); 
                }else if(i == 1){ 
                System.out.print(netipadd[1]);
                System.out.print("."); 
                }else if(i == 2){
                System.out.print(netipadd[2]);
                System.out.print("."); 
                }else{ System.out.println(netipadd[3]); } 
            }
		
		for (int i = 0; i < 4; i++) { 
			if(i == 0){ 
				System.out.println("---first host---");
                System.out.print(firsthostipadd[0]);
                System.out.print("."); 
                }else if(i == 1){ 
                System.out.print(firsthostipadd[1]);
                System.out.print("."); 
                }else if(i == 2){ 
                System.out.print(firsthostipadd[2]);
                System.out.print("."); 
                }else{ System.out.println(firsthostipadd[3]); } 
			}
	}
    
	public static List<Integer> ones = new ArrayList<Integer>();
	
	public static void secondmethod() {
		
		int[] broadcast = new int[4];
		int[] lasthostipadd = new int[4];
		
        for (int i = 0; i < 8; i++) {
            if(i == 0){
                System.out.println("---broadcast---");
                int j = 0;
                int[] tab = new int[8];

                while(submusk[0] != 0) {
                    tab[j++] = submusk[0]%2;
                    submusk[0]/=2;
                }

                for (int m = 0; m < 8; m++) {
                    if(tab[m] == 0){
                        tab[m] = 1;
                    }else{
                        tab[m] = 0;
                    }
                }
                String stroktet = tab[7] + "" + tab[6] + "" + tab[5] + "" + tab[4] + "" + tab[3] + "" + tab[2] + "" + tab[1] + "" + tab[0] + "";
                int decimalnum = Integer.parseInt(stroktet, 2); 
                int finaldecimalokt = netipadd[0] + decimalnum; 
                System.out.print(finaldecimalokt);
                System.out.print(".");
                
                for(int r = 0; r < tab.length; r++) {
                	if(tab[r] == 0)
                		ones.add(1);
                }
                
            }else if(i == 1 || i == 5){
                
                if(i == 1) {
                	int j = 0;
                    int[] tab = new int[8];

                    while(submusk[1] != 0) {
                        tab[j++] = submusk[1]%2;
                        submusk[1]/=2;
                    }

                    for (int m = 0; m < 8; m++) {
                        if(tab[m] == 0){
                            tab[m] = 1;
                        }else{
                            tab[m] = 0;
                        }
                    }
                    String stroktet1 = tab[7] + "" + tab[6] + "" + tab[5] + "" + tab[4] + "" + tab[3] + "" + tab[2] + "" + tab[1] + "" + tab[0] + "";
                    int decimalnum1 = Integer.parseInt(stroktet1, 2);
                    int finaldecimalokt1 = netipadd[1] + decimalnum1;
                    System.out.print(finaldecimalokt1);
                    System.out.print(".");
                    
                    for(int r = 0; r < tab.length; r++) {
                    	if(tab[r] == 0)
                    		ones.add(1);
                    }
                }else {
                	int j = 0;
                    int[] tab = new int[8];

                    while(submusk2[1] != 0) {
                        tab[j++] = submusk2[1]%2;
                        submusk2[1]/=2;
                    }

                    for (int m = 0; m < 8; m++) {
                        if(tab[m] == 0){
                            tab[m] = 1;
                        }else{
                            tab[m] = 0;
                        }
                    }
                    String stroktet1 = tab[7] + "" + tab[6] + "" + tab[5] + "" + tab[4] + "" + tab[3] + "" + tab[2] + "" + tab[1] + "" + tab[0] + "";
                    int decimalnum1 = Integer.parseInt(stroktet1, 2);
                    int finaldecimalokt1 = netipadd[1] + decimalnum1;
                    System.out.print(finaldecimalokt1);
                    System.out.print(".");
                }	
            }else if(i == 2 || i == 6){
                if(i == 2) {
                	int j = 0;
                    int[] tab = new int[8];

                    while(submusk[2] != 0) {
                        tab[j++] = submusk[2]%2;
                        submusk[2]/=2;
                    }

                    for (int m = 0; m < 8; m++) {
                        if(tab[m] == 0){
                            tab[m] = 1;
                        }else{
                            tab[m] = 0;
                        }
                    }
                    String stroktet2 = tab[7] + "" + tab[6] + "" + tab[5] + "" + tab[4] + "" + tab[3] + "" + tab[2] + "" + tab[1] + "" + tab[0] + "";
                    int decimalnum2 = Integer.parseInt(stroktet2, 2);
                    int finaldecimalokt2 = netipadd[2] + decimalnum2;
                    System.out.print(finaldecimalokt2);
                    System.out.print(".");
                    
                    for(int r = 0; r < tab.length; r++) {
                    	if(tab[r] == 0)
                    		ones.add(1);
                    }
                }else {
                	int j = 0;
                    int[] tab = new int[8];

                    while(submusk2[2] != 0) {
                        tab[j++] = submusk2[2]%2;
                        submusk2[2]/=2;
                    }

                    for (int m = 0; m < 8; m++) {
                        if(tab[m] == 0){
                            tab[m] = 1;
                        }else{
                            tab[m] = 0;
                        }
                    }
                    String stroktet2 = tab[7] + "" + tab[6] + "" + tab[5] + "" + tab[4] + "" + tab[3] + "" + tab[2] + "" + tab[1] + "" + tab[0] + "";
                    int decimalnum2 = Integer.parseInt(stroktet2, 2);
                    int finaldecimalokt2 = netipadd[2] + decimalnum2;
                    System.out.print(finaldecimalokt2);
                    System.out.print(".");
                }
            }else if(i == 3 || i == 7){
                if(i == 3) {
                	int j=0;
                    int[] tab = new int[8];

                    while(submusk[3] != 0) {
                        tab[j++] = submusk[3]%2;
                        submusk[3]/=2;
                    }

                    for (int m = 0; m < 8; m++) {
                        if(tab[m] == 0){
                            tab[m] = 1;
                        }else{
                            tab[m] = 0;
                        }
                    }
                    String stroktet3 = tab[7] + "" + tab[6] + "" + tab[5] + "" + tab[4] + "" + tab[3] + "" + tab[2] + "" + tab[1] + "" + tab[0] + "";
                    int decimalnum3 = Integer.parseInt(stroktet3, 2);
                    int finaldecimalokt3 = netipadd[3] + decimalnum3;
                    System.out.print(finaldecimalokt3 - 1);
                    
                    for(int r = 0; r < tab.length; r++) {
                    	if(tab[r] == 0)
                    		ones.add(1);
                    }
                }else {
                	int j=0;
                    int[] tab = new int[8];

                    while(submusk2[3] != 0) {
                        tab[j++] = submusk2[3]%2;
                        submusk2[3]/=2;
                    }

                    for (int m = 0; m < 8; m++) {
                        if(tab[m] == 0){
                            tab[m] = 1;
                        }else{
                            tab[m] = 0;
                        }
                    }
                    String stroktet3 = tab[7] + "" + tab[6] + "" + tab[5] + "" + tab[4] + "" + tab[3] + "" + tab[2] + "" + tab[1] + "" + tab[0] + "";
                    int decimalnum3 = Integer.parseInt(stroktet3, 2);
                    int finaldecimalokt3 = netipadd[3] + decimalnum3;
                    System.out.print(finaldecimalokt3);
                }
            }else{
            	System.out.println("");
                System.out.println("---last host---");
                int j2 = 0;
                int[] tab2 = new int[8];

                while( submusk2[0] != 0) {
                    tab2[j2++] = submusk2[0]%2;
                    submusk2[0]/=2;
                }

                for (int m = 0; m < 8; m++) {
                    if(tab2[m] == 0){
                        tab2[m] = 1;
                    }else{
                        tab2[m] = 0;
                    }
                }
                String troktet = tab2[7] + "" + tab2[6] + "" + tab2[5] + "" + tab2[4] + "" + tab2[3] + "" + tab2[2] + "" + tab2[1] + "" + tab2[0] + "";
                int ecimalnum = Integer.parseInt(troktet, 2); //decimalnum (decimal number) - jeden oktet maski podsieci w postaci dziesiêtnej
                int inaldecimalokt = netipadd[0] + ecimalnum; // finaldecimalokt (final decimal oktet) - wartoœæ jednego oktetu adresu broadcast
                System.out.print(inaldecimalokt);
                System.out.print(".");
            }
        }    
	}
	public static int numberOfHosts = 2;
	public static void thirtymethod() {
		for(int i = 0; i < 32-ones.size()-1; i++) {
			numberOfHosts = numberOfHosts*2;
		}
		System.out.println("");
		System.out.println("---number of hosts---");
		System.out.println(numberOfHosts);
	}
}
