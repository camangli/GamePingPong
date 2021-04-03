import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.*;

public class mainkan extends MIDlet implements CommandListener {

	private Display layar;
	private Form formulir;
	private Command keluar, mulai;
	private StringItem pesan;
	
	public mainkan() {
		layar = Display.getDisplay(this);
		keluar = new Command("Keluar", Command.EXIT, 1);
		mulai = new Command("Mulai", Command.OK, 2);
		pesan = new StringItem("PINGPONG VERSI 2013, Silahkan Pilih Mulai Untuk Memulai Game ini ", null);
		formulir = new Form("WELCOME");
		formulir.addCommand(keluar);
		formulir.append(pesan);
		formulir.addCommand(mulai);
		formulir.setCommandListener(this);
	}

	protected void startApp() {
		layar.setCurrent(formulir);
	}

	protected void pauseApp() {
		notifyPaused();
	}

	protected void destroyApp(boolean arg0) {
		notifyDestroyed();

	}
	public void commandAction(Command c, Displayable d) {
		if (c == keluar) {
			destroyApp(true);
		} else if (c == mulai) {
			otakgame otak = new otakgame();
			layar.setCurrent(otak);
			otak.startGame();
		}
	}

}
