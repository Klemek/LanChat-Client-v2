package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.text.html.HTMLEditorKit;

public class Log {

	JEditorPane chat;
	String[] log = {};
	boolean conn = false;
	JFrame f;
	String beg = "<HTML><HEAD><style>body{font-family:Arial;font-size:10px;text-align:justified;}</style></HEAD><BODY>";
	String end = "</BODY></HTML>";
	
	File file = new File("tmpLanChat.html");
	
	public Log(JEditorPane chat2,JFrame f){
		this.chat = chat2;
		this.f= f;
		try {
			file.createNewFile();
			file.deleteOnExit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void say(String msg){
		log = Util.extend(log,new String[]{msg});
		refresh();
		f.toFront();
	}
	
	@SuppressWarnings("deprecation")
	public void refresh(){
		if(log != null){
			String text = beg+log[0];
			for(int k = 1; k < log.length; k++){
				text = text+"<br />"+log[k];
			}
			text+=end;
			FileWriter fw = null;            
	        try {
	        	fw = new FileWriter(file);
	        	fw.write(text);
	        	fw.close();
	        } catch (FileNotFoundException e1) {
	        	e1.printStackTrace();
	        } catch (IOException e1) {
	        	e1.printStackTrace();
	        }
	        try {
	        	chat.setEditorKit(new HTMLEditorKit());               
	        	chat.setPage(file.toURL());
	        } catch (IOException e1) {
	        	e1.printStackTrace();
	        }
		}
	}
	
	public void deleteTemp(){
		file.delete();
	}
	
	
	
}
