package base;


public class Util {

	//NUMBERS
	
	public static int[] extend(int[] l1,int[] l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		int[] l3 = new int[l1.length+l2.length];
		for(int i = 0; i < l1.length; i++){
			l3[i]=l1[i];
		}
		for(int i = 0; i < l2.length; i++){
			l3[i+l1.length]=l2[i];
		}
		return l3;	
	}

	public static int[] retractBeg(int[] l, int i){
		if(l == null)return null;
		int[] l2 = new int[l.length-i];
		for(int i2 = i; i2 < l.length; i++){
			l2[i2-i]=l[i2];
		}
		return l2;
	}
	
	public static int[] retractEnd(int[] l, int i){
		if(l == null)return null;
		int[] l2 = new int[l.length-i];
		for(int i2 = 0; i2 < l2.length; i2++){
			l2[i2]=l[i2];
		}
		return l2;
	}
	
	public static int[] suppr(int[] l, int pos, int i){
		int[] l2 = new int[l.length-i];
		for(int i2 = 0; i2 < l.length; i2++){
			if(i2 < pos){
				l2[i2]=l[i2];
			}else if(i2 >= pos+i){
				l2[i2-i]=l[i2];
			}
		}
		return l2;
	}
	
	public static int[] invert(int[] l){
		int[] l2 = new int[l.length];
		for(int i = 0; i < l.length; i++){
			l2[i] = l[l.length-(i+1)];
		}
		return l2;
	}

	public static int[] sortD(int[] i){
		if(i.length <= 1){
			return i;
		}else if(i.length == 2){
			if(i[0] < i[1]){
				int i2 = i[0];
				i[0] = i[1];
				i[1] = i2;		
			}
		}else{
			int k = 0;
			while(k != i.length-1){
				if(i[k] < i[k+1]){
					int i2 = i[k];
					i[k] = i[k+1];
					i[k+1] = i2;
					k = -1;
				}
				k++;
			}
		}
		return i;
	}
	
	public static int[] sortA(int[] i){
		int[] j = i;
		int k = 0;
		
		if(j.length <= 1){
			return j;
		}else if(j.length == 2){
			if(j[0] > j[1]){
				int i2 = j[0];
				j[0] = j[1];
				j[1] = i2;		
			}
		}else{
			while(k != j.length-1){
				if(j[k] > j[k+1]){
					int i2 = j[k];
					j[k] = j[k+1];
					j[k+1] = i2;
					k = -1;
				}
				k++;
			}
		}
		return j;
	}
	
	public static boolean equals(int[] l1, int[] l2){
		if(l1.length != l2.length)return false;
		for(int i = 0; i < l1.length; i++){
			for(int j = 0; j < l2.length; j++){
				if(l1[i]==l2[j]){

					l1 = suppr(l1,i,1);
					i--;
					l2 = suppr(l2,j,1);	
					
					break;
				}else if(j==l2.length-1)return false;
			}
		}
		return true;
	}

	public static int[] find(int[] l, int i){
		int[] sortie = null;
		for(int i2 = 0; i2 <l.length;i2++){
			if(l[i2]==i){
				sortie = extend(sortie,new int[]{i});
			}
		}
		return sortie;
	}
	
	public static int[] randomize(int[] l){
		int[] l2 = new int[0];
		while(l.length > 0){
			int r = randomInt(0,l.length-1);
			l2 = extend(l2,new int[]{l[r]});
			l = suppr(l,r,1);
		}
		return l2;
	}
	
 	public static int[][] extend(int[][] l1,int[][] l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		int[][] l3 = new int[l1.length+l2.length][];
		for(int i = 0; i < l1.length; i++){
			l3[i]=l1[i];
		}
		for(int i = 0; i < l2.length; i++){
			l3[i+l1.length]=l2[i];
		}
		return l3;	
	}

	public static int[][] retractBeg(int[][] l, int i){
		if(l == null)return null;
		int[][] l2 = new int[l.length-i][];
		for(int i2 = i; i2 < l.length; i++){
			l2[i2-i]=l[i2];
		}
		return l2;
	}
	
	public static int[][] retractEnd(int[][] l, int i){
		if(l == null)return null;
		int[][] l2 = new int[l.length-i][];
		for(int i2 = 0; i2 < l2.length; i2++){
			l2[i2]=l[i2];
		}
		return l2;
	}

	public static int[][] suppr(int[][] l, int pos, int i){
		int[][] l2 = new int[l.length-i][];
		for(int i2 = 0; i2 < l.length; i2++){
			if(i2 < pos){
				l2[i2]=l[i2];
			}else if(i2 >= pos+i){
				l2[i2-i]=l[i2];
			}
		}
		return l2;
	}
	
	public static int[][] invert(int[][] l){
		int[][] l2 = new int[l.length][];
		for(int i = 0; i < l.length; i++){
			l2[i] = l[l.length-(i+1)];
		}
		return l2;
	}

	public static int[][] sortD(int[][] i,int i2){
		int[][] j = i;
		int k = 0;
		
		if(j.length <= 1){
			return j;
		}else if(j.length == 2){
			if(j[0][i2] < j[1][i2]){
				int[] i3 = j[0];
				j[0] = j[1];
				j[1] = i3;		
			}
		}else{
			while(k != j.length-1){
				if(j[k][i2] < j[k+1][i2]){
					int[] i3 = j[k];
					j[k] = j[k+1];
					j[k+1] = i3;
					k = -1;
				}
				k++;
			}
		}
		return j;
	}
	
	public static int[][] sortA(int[][] i,int i2){
		int[][] j = i;
		int k = 0;
		
		if(j.length <= 1){
			return j;
		}else if(j.length == 2){
			if(j[0][i2] > j[1][i2]){
				int[] i3 = j[0];
				j[0] = j[1];
				j[1] = i3;		
			}
		}else{
			while(k != j.length-1){
				if(j[k][i2] > j[k+1][i2]){
					int[] i3 = j[k];
					j[k] = j[k+1];
					j[k+1] = i3;
					k = -1;
				}
				k++;
			}
		}
		return j;
	}
	
	public static boolean equals(int[][] l1, int[][] l2){
		if(l1.length != l2.length)return false;
		for(int i = 0; i < l1.length; i++){
			for(int j = 0; j < l2.length; j++){
				if(l1[i]==l2[j]){
					
					l1 = suppr(l1,i,1);
					i--;
					l2 = suppr(l2,j,1);	
					
					break;
				}else if(j==l2.length-1)return false;
			}
		}
		return true;
	}

	public static int[][] randomize(int[][] l){
		int[][] l2 = new int[0][];
		while(l.length > 0){
			int r = randomInt(0,l.length-1);
			l2 = extend(l2,new int[][]{l[r]});
			l = suppr(l,r,1);
		}
		return l2;
	}
	
	public static int randomInt(int min, int max){
		return (int)random(min,max);
	}

	public static double random(double min, double max){
		return Math.random()*(max+1-min)+min;
	}
	
	public static int random(double[] d){
		
		double base = Math.random()*101;
		
		int sortie = 0;
		
		for(int i = 0; i < d.length; i++){
			int b = 0;
			for(int i2 = 0; i2 < i; i2++){
				b+=d[i2];
			}
			if(i == 0){
				
				if(base >= 0 && base < d[i])sortie = i; 
				
			}else if(i == d.length-1){
				
				if(base >= b && base < 100)sortie = i; 
				
			}else{
				
				if(base >= b && base < b+d[i])sortie = i; 
				
			}
		}
		return sortie;
	}
	
	public static int arrondi(double i){
		return (int)(i+0.5);
	}
	
	public static int somme(int[] i){
		int s = 0;
		for(int j = 0; j < i.length; j++){
			s+=i[j];
		}
		return s;
	}
	
	public static int somme(int[] i, int start, int stop){
		int s = 0;
		for(int j = start; j <= stop; j++){
			s+=i[j];
		}
		return s;
	}

	//STRINGS
	
	public static char randomChar(){
		return (char)randomInt(97,122);
	}
	
	public static String[] extend(String[] l1,String[] l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		String[] l3 = new String[l1.length+l2.length];
		for(int i = 0; i < l1.length; i++){
			l3[i]=l1[i];
		}
		for(int i = 0; i < l2.length; i++){
			l3[i+l1.length]=l2[i];
		}
		return l3;	
	}
	
	public static String[] retractBeg(String[] l1, int i){
		if(l1 == null)return null;
		String[] l2 = new String[l1.length-i];
		for(int i2 = i; i2 < l1.length; i++){
			l2[i2-i]=l1[i2];
		}
		return l2;
	}
	
	public static String[] retractEnd(String[] l1, int i){
		if(l1 == null)return null;
		String[] l2 = new String[l1.length-i];
		for(int i2 = 0; i2 < l2.length; i2++){
			l2[i2]=l1[i2];
		}
		return l2;
	}
	
	public static String[] suppr(String[] l, int pos, int i){
		String[] l2 = new String[l.length-i];
		for(int i2 = 0; i2 < l.length; i2++){
			if(i2 < pos){
				l2[i2]=l[i2];
			}else if(i2 >= pos+i){
				l2[i2-i]=l[i2];
			}
		}
		return l2;
	}
	
	public static String[] invert(String[] l){
		String[] l2 = new String[l.length];
		for(int i = 0; i < l.length; i++){
			l2[i] = l[l.length-(i+1)];
		}
		return l2;
	}
	
	public static String[] sortD(String[] i){
		
		char[][] i2 = new char[i.length][];
		String[] i3 = new String[i.length];
		for(int k = 0; k < i.length; k++){
			i2[k] = i[k].toCharArray();
		}
		
		if(i.length <= 1){
			return i;
		}else if(i2.length == 2){
			int l = 0;
			while(i2[0][l] == i2[1][l]){l++;}
			if(i2[0][l] < i2[1][l]){
				char[] i4 = i2[0];
				i2[0] = i2[1];
				i2[1] = i4;		
			}
		}else{
			int k = 0;
			while(k != i2.length-1){
				int l = 0;
				while(i2[k][l] == i2[k+1][l]){l++;}
				if(i2[k][l] < i2[k+1][l]){
					char[] i4 = i2[k];
					i2[k] = i2[k+1];
					i2[k+1] = i4;
					k = -1;
				}
				k++;
			}
		}
		for(int k = 0; k < i.length; k++){
			i3[k] = new String(i2[k]);
		}
		return i3;
	}
	
	public static String[] sortA(String[] i){
		char[][] i2 = new char[i.length][];
		String[] i3 = new String[i.length];
		for(int k = 0; k < i.length; k++){
			i2[k] = i[k].toCharArray();
		}
		
		if(i.length <= 1){
			return i;
		}else if(i2.length == 2){
			int l = 0;
			while(i2[0][l] == i2[1][l]){l++;}
			if(i2[0][l] > i2[1][l]){
				char[] i4 = i2[0];
				i2[0] = i2[1];
				i2[1] = i4;		
			}
		}else{
			int k = 0;
			while(k != i2.length-1){
				int l = 0;
				while(i2[k][l] == i2[k+1][l]){l++;}
				if(i2[k][l] > i2[k+1][l]){
					char[] i4 = i2[k];
					i2[k] = i2[k+1];
					i2[k+1] = i4;
					k = -1;
				}
				k++;
			}
		}
		for(int k = 0; k < i.length; k++){
			i3[k] = new String(i2[k]);
		}
		return i3;
	}
	
	public static boolean equals(String[] l1, String[] l2){
		if(l1.length != l2.length)return false;
		for(int i = 0; i < l1.length; i++){
			for(int j = 0; j < l2.length; j++){
				if(l1[i]==l2[j]){
					System.out.println(l1[i]);
					
					l1 = suppr(l1,i,1);
					i--;
					l2 = suppr(l2,j,1);	
					
					break;
				}else if(j==l2.length-1)return false;
			}
		}
		return true;
	}

	public static String[] randomize(String[] l){
		String[] l2 = new String[0];
		while(l.length > 0){
			int r = randomInt(0,l.length-1);
			l2 = extend(l2,new String[]{l[r]});
			l = suppr(l,r,1);
		}
		return l2;
	}
	
	public static String nb(int i){
		String s = null;
		if(i < 10){
			switch(i){
			case 0:s = "Zéro";break;
			case 1:s = "Un";break;
			case 2:s = "Deux";break;
			case 3:s = "Trois";break;
			case 4:s = "Quatre";break;
			case 5:s = "Cinq";break;
			case 6:s = "Six";break;
			case 7:s = "Sept";break;
			case 8:s = "Huit";break;
			case 9:s = "Neuf";break;
			}
		}else{
			int i2 = i/10;
			int i3 = i-i2*10;
			if(i == 10 || i > 16){
				switch(i2){
				case 1:s = "Dix";break;
				case 2:s = "Vingt";break;
				case 3:s = "Trente";break;
				case 4:s = "Quarante";break;
				case 5:s = "Cinquante";break;
				case 6:s = "Soixante";break;
				case 7:s = "Soixante";break;
				case 8:s = i3==0?"Quatre-vingts":"Quatre-vingt";break;
				case 9:s = "Quatre-vingt";break;
				}
				if(i2 == 7 || i2 == 9){
					switch(i3){
					case 0:s=s.concat("-dix");break;
					case 1:if(i2 == 7)s=s.concat(" et onze");else s=s.concat("-onze");break;
					case 2:s=s.concat("-douze");break;
					case 3:s=s.concat("-treize");break;
					case 4:s=s.concat("-quatorze");break;
					case 5:s=s.concat("-quinze");break;
					case 6:s=s.concat("-seize");break;
					case 7:s=s.concat("-dix-sept");break;
					case 8:s=s.concat("-dix-huit");break;
					case 9:s=s.concat("-dix-neuf");break;
					}
				}else{
					if(i2 != 8 && i3 == 1){
						s = s.concat(" et ");
					}else{
						if(i3 != 0)
							s = s.concat("-");
					}
					switch(i3){
					case 1:s=s.concat("un");break;
					case 2:s=s.concat("deux");break;
					case 3:s=s.concat("trois");break;
					case 4:s=s.concat("quatre");break;
					case 5:s=s.concat("cinq");break;
					case 6:s=s.concat("six");break;
					case 7:s=s.concat("sept");break;
					case 8:s=s.concat("huit");break;
					case 9:s=s.concat("neuf");break;
					}
				}
				
			}else{
				switch(i3){
				case 1:s = "Onze";break;
				case 2:s = "Douze";break;
				case 3:s = "Treize";break;
				case 4:s = "Quatorze";break;
				case 5:s = "Quinze";break;
				case 6:s = "Seize";break;
				}
			}
			
		}
		return s;
		
	}
	
}
