package base;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URISyntaxException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.DefaultCaret;

public class Client extends JFrame{

	static final long serialVersionUID = 1L;
	
	String VERSION = "2.0";
	
	JEditorPane chat = new JEditorPane();
	JScrollPane scroll = new JScrollPane(chat);
	JTextField champs = new JTextField();
	Socket socket;
	BufferedReader in;
    PrintWriter out;
    String[] last = null;
    int lastnb = 0;
    Log l;
    Thread t;
    boolean conn = false;
    Timer check;
    
	public static void main(String[] args) {
		new Client();
	}
	
	public Client(){
		
		makeFenetre();
		l.say(Html.info1("Entrez "+Html.gras("/connect IPduServeur")+" pour vous connecter."));
		check = new Timer(1000,new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(l.conn == false && conn == true){
					deco();
				}
			}
		});
		
		check.start();
	}
	
	void deco(){
		try {
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		l.say(Html.info1("Déconnecté"));
		l.conn = false;
		conn = false;
	}
	
	void connexion(InetAddress a) throws IOException{
		l.say(Html.info1("Tentative de connection à "+a+" ..."));
		socket = new Socket(a,2000);
		in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream());
		l.say(Html.info1("Connecté à "+a));
		l.conn = true;
		conn = true;
		Thread t = new Thread(new Reception(in,l));
		t.start();
	}
	
	void makeFenetre(){
		this.setTitle("LanChat - Client (v"+VERSION+")");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
            	close();
            }
        });
		chat.setEditable(false);
		chat.setText("");
		chat.addHyperlinkListener(new HyperlinkListener() {
		    public void hyperlinkUpdate(HyperlinkEvent e) {
		        if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
		        	if(Desktop.isDesktopSupported()) {
		        	    try {
							Desktop.getDesktop().browse(e.getURL().toURI());
						} catch (IOException e1) {
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							e1.printStackTrace();
						}
		        	}
		        }
		    }
		});
		((DefaultCaret)chat.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		scroll.setAutoscrolls(true);
		this.add(scroll,BorderLayout.CENTER);
		this.add(champs,BorderLayout.SOUTH);
		
		champs.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent arg0) {}
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()){
					case KeyEvent.VK_ENTER:
						envoyer();
						break;
					case KeyEvent.VK_UP:
						if(lastnb > 0){
							lastnb--;
						}
						champs.setText(last[lastnb]);
						break;
					case KeyEvent.VK_DOWN:
						if(lastnb < last.length){
							lastnb++;
						}
						if(lastnb == last.length){
							champs.setText("");
						}else{
							champs.setText(last[lastnb]);
						}
						break;
					default:
						lastnb = last==null?0:last.length;
						break;
				}
			}
			
		});
		l = new Log(chat,this);
		l.say(Html.info1("LanChat Client version "+VERSION));
		l.refresh();
		this.setVisible(true);
	}
	
	void close(){
		if(conn)deco();
    	l.deleteTemp();
		this.dispose();
		System.exit(ABORT);
	}
	
	void envoyer(){
		String msg = champs.getText();
		champs.setText(null);
		last = Util.extend(last,new String[]{msg});
		lastnb = last.length;
		
		if(conn && msg != null &&  msg != "" && msg.toCharArray().length > 0){
			out.println(msg);
			out.flush();
			if(msg.split(" ")[0].equals("/disconnect"))deco();
		}else if(!conn){
			if(msg.split(" ")[0].equals("/connect") && msg.split(" ").length >= 2){
				try {
					if(msg.split(" ")[1].equalsIgnoreCase("localhost")){
						connexion(InetAddress.getLocalHost());
					}else{
						connexion(InetAddress.getByName(msg.split(" ")[1]));
					}
				} catch (IOException e) {
					l.say(Html.err("Erreur de connexion"));
				}
			}else{
				l.say(Html.err("Pas connecté, pour vous connecter, tapez : "+Html.gras("/connect IPduServeur")));
			}
		}
	}


}

class Reception implements Runnable{

	private char ctemp = 0;
	private Log l;
	private BufferedReader in;
	private boolean stop = false;
	
	public Reception(BufferedReader in,Log l){
		this.in = in;
		this.l = l;
	}
	
	@Override
	public void run() {
		while(!stop){
			try {
				ctemp = (char) in.read();
				if(in.ready()){
					String msg = in.readLine();
					if(msg != null && msg != ""){
						if(ctemp > 0)msg = ctemp+msg;
						l.say(msg);
					}
				}			
			} catch (IOException e2) {
				stop = true;
				l.conn = false;
			}
		}
	}
	
}
