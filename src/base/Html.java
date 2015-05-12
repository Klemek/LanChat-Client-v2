package base;

public class Html {

	/*
	 * 
	    font-family
	    font-style
	    font-size (supports relative units)
	    font-weight
	    font
	    color
	    background-color (with the exception of transparent)
	    background-image
	    background-repeat
	    background-position
	    background
	    background-repeat
	    text-decoration (with the exception of blink and overline)
	    vertical-align (only sup and super)
	    text-align (justify is treated as center)
	    margin-top
	    margin-right
	    margin-bottom
	    margin-left
	    margin
	    padding-top
	    padding-right
	    padding-bottom
	    padding-left
	    border-style (only supports inset, outset and none)
	    list-style-type
	    list-style-position

	The following are modeled, but currently not rendered.

	    font-variant
	    background-attachment (background always treated as scroll)
	    word-spacing
	    letter-spacing
	    text-indent
	    text-transform
	    line-height
	    border-top-width (this is used to indicate if a border should be used)
	    border-right-width
	    border-bottom-width
	    border-left-width
	    border-width
	    border-top
	    border-right
	    border-bottom
	    border-left
	    border
	    width
	    height
	    float
	    clear
	    display
	    white-space
	    list-style

	 * 
	 */
	
	protected static int[] NOIR = {0,0,0};
	protected static int[] BLANC = {255,255,255};
	
	protected static int[] GRIS1 = {50,50,50};
	protected static int[] GRIS2 = {100,100,100};
	protected static int[] GRIS3 = {150,150,150};
	protected static int[] GRIS4 = {200,200,200};
	
	protected static int[] ROUGE1 = {128,0,0};
	protected static int[] VERT1 = {0,128,0};
	protected static int[] BLEU1 = {0,0,128};
	protected static int[] JAUNE1 = {128,128,0};
	protected static int[] VIOLET1 = {128,0,128};
	protected static int[] CYAN1 = {0,128,128};
	
	protected static int[] ROUGE2 = {255,0,0};
	protected static int[] VERT2 = {0,255,0};
	protected static int[] BLEU2 = {0,0,255};
	protected static int[] JAUNE2 = {255,255,0};
	protected static int[] VIOLET2 = {255,0,255};
	protected static int[] CYAN2 = {0,255,255};
	
	protected static int[] ROUGE3 = {255,128,128};
	protected static int[] VERT3 = {128,255,128};
	protected static int[] BLEU3 = {128,128,255};
	protected static int[] JAUNE3 = {255,255,128};
	protected static int[] VIOLET3 = {255,128,255};
	protected static int[] CYAN3 = {128,255,255};
	
	
	public static String couleur(String msg,int[] clr){
		return "<span style=\"color: rgb("+clr[0]+","+clr[1]+","+clr[2]+");\">"+msg+"</span>";				
	}
	
	public static String gras(String msg){
		return "<b>"+msg+"</b>";
	}
	
	public static String italique(String msg){
		return "<i>"+msg+"</i>";
	}
	
	public static String souligne(String msg){
		return "<u>"+msg+"</u>";
	}
	
	public static String barre(String msg){
		return "<s>"+msg+"</s>";
	}
	
	public static String err(String msg){
		return couleur(msg,ROUGE2);				
	}
	
	public static String info1(String msg){
		return couleur(msg,GRIS1);				
	}
	
	public static String info2(String msg){
		return couleur(msg,GRIS2);				
	}
	
	public static String lien(String lnk,String msg){
		return "<a href=\"http://"+lnk+"\">"+msg+"</a>";
	}
	
	public static String image(String lnk,String msg){
		return "<img src=\""+lnk+"\" alt=\""+msg+"\" />";
	}
	
	public static String image(String lnk){
		return "<img src=\""+lnk+"\" />";
	}
	
	public static String saut(){
		return "<br/>";
	}
	
	public static int[] getCoulByName(String name){
		switch(name){
			case "dark-red":
			case "rouge-foncé":
				return ROUGE1;
			case "red":
			case "rouge":
				return ROUGE2;
			case "light-red":
			case "rouge-claire":
				return ROUGE3;
			case "dark-green":
			case "vert-foncé":
				return VERT1;
			case "green":
			case "vert":
				return VERT2;
			case "light-green":
			case "vert-claire":
				return VERT3;
			case "dark-blue":
			case "bleu-foncé":
				return BLEU1;
			case "blue":
			case "bleu":
				return BLEU2;
			case "light-blue":
			case "bleu-claire":
				return BLEU3;
			case "dark-yellow":
			case "jaune-foncé":
				return JAUNE1;
			case "yellow":
			case "jaune":
				return JAUNE2;
			case "light-yellow":
			case "jaune-claire":
				return JAUNE3;
			case "dark-pruple":
			case "violet-foncé":
				return VIOLET1;
			case "pruple":
			case "violet":
				return VIOLET2;
			case "light-pruple":
			case "violet-claire":
				return VIOLET3;
			case "dark-cyan":
			case "cyan-foncé":
				return CYAN1;
			case "cyan":
				return CYAN2;
			case "light-cyan":
			case "cyan-claire":
				return CYAN3;
			case "dark-gray":
			case "gris-foncé":
				return GRIS1;
			case "gray":
			case "gris":
				return GRIS2;
			case "light-gray":
			case "gris-claire":
				return GRIS3;
			case "black":
			case "noir":
				return NOIR;
			case "white":
			case "blanc":
				return NOIR;
			default:
				return null;
		}
	}
	
}
