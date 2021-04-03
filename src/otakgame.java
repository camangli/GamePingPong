import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.GameCanvas;

public class otakgame extends GameCanvas implements Runnable {

	Graphics g;
	private int korXraket1 = getWidth() / 2;
	private int korYraket1 = getHeight() + 10;
	private int lebarRaket1 = 45;
	private int tinggiRaket1 = 7;
	private int korXraket2 = getWidth() / 2;
	private int korYraket2 = 0;
	private int lebarRaket2 = 45;
	private int tinggiRaket2 = 7;
	private int bolaX = getWidth ()/2;
	private int bolaY= getHeight ()/2;
	private int speedRaket1 = 10;
	private int speedBolaX = 2;
	private int speedBolaY = 5;
	private int score = 0;
	private int nyawa = 3;
	private int korYgarisTengah = getHeight() / 2;
	private int korXgarisTengah = 0 ;
	private int lebarGarisTengah = 1000;
	private int tinggiGarisTengah = 2;
	private int korYgarisAtas = getHeight() / 22 ;
	private int korXgarisAtas = 0;
	private int lebarGarisAtas = 1000;
	private int tinggiGarisAtas = 2;
	private int korYgarisBawah = getHeight() / 1;
	private int korXgarisBawah = 0 ;
	private int lebarGarisBawah = 1000;
	private int tinggiGarisBawah = 2;
	private int korYgarisKanan = getHeight() / 22;
	private int korXgarisKanan = 238 ;
	private int lebarGarisKanan = 2;
	private int tinggiGarisKanan = 280;
	private int korYgarisKiri = getHeight() / 22;
	private int korXgarisKiri = 0 ;
	private int lebarGarisKiri = 2;
	private int tinggiGarisKiri = 280;
	private void raket1() {
		g.setColor(111,0 ,0);
		g.fillRect(korXraket1, korYraket1, lebarRaket1, tinggiRaket1);
	}

	private void raket2() {
		g.setColor(11,27 ,11);
		g.fillRect(korXraket2, korYraket2, lebarRaket2, tinggiRaket2);
	}

	private void bola() {
		g.setColor(39, 24, 232);
		g.fillArc(bolaX, bolaY, 7, 7, 0, 360);
	}

	private void gerakRaket1(){
		int keyState = getKeyStates();
		if ((keyState & LEFT_PRESSED) != 0) {
			korXraket1 -= speedRaket1;
			

		} else if ((keyState & RIGHT_PRESSED) != 0) {
			korXraket1 += speedRaket1;
		}
		if (korXraket1 <= 0) {
			korXraket1 = 0;
		} else if ((korXraket1 + lebarRaket1) >= getWidth()) {
			korXraket1 = getWidth() - lebarRaket1;
		}
	}

	private void gerakBola() {
			bolaY += speedBolaY;
			bolaX += speedBolaX;
		if(bolaX < 0 || (bolaX + 7) > getWidth()) {
			speedBolaX *= -1;
		}
		if(bolaY <= 0 || (bolaY + 7) > getHeight()) {
			speedBolaY *= -1;
			
		}
	}
		private void tabrakRaket1 () {
			if ((bolaY + 7) > korYraket1 && bolaX >= korXraket1 && bolaX <= (korXraket1 + lebarRaket1)) {
				speedBolaY *= -1;
				score +=10;
			}
		}
		private void tabrakRaket2() {
			if (bolaY < (korYraket2+tinggiRaket2)) {
				speedBolaY *= -1;
			}
		}
		private void gerakRaket2(){
			korXraket2 = bolaX;
			if (korXraket2 <= 0){
				korXraket2 = 0;
			} else if ((korXraket2 + lebarRaket2) >= getWidth()){
				korXraket2 = getWidth() - lebarRaket2;				
			}
		}
		private void tulisanScore() {
			g.setColor(0,0,0);
			g.drawString("Score : " + score, 10, 20, 0);
		}
		private void nyawa(){
			g.setColor(0,0,0);
			g.drawString("Life : " + nyawa, getWidth()-40, 20, 0);
			if((bolaY + 7)> getHeight()){
				nyawa = nyawa - 1;
			}
		}
		private void GameOver(){
			if(nyawa <= 0){
				g.setColor(0,0,0);
				g.drawString("GAME OVER !", 90, (getHeight()/2)-20, 0);
				g.drawString("Your High Score "+score, 80, getHeight()/2, 0);
				g.drawString("|Guna1mansuR|", 88, (getHeight()/2)+20, 0);
			}
		}
		private void GarisTengah(){
			g.setColor(250,250 ,250);
			g.fillRect(korXgarisTengah, korYgarisTengah, lebarGarisTengah, tinggiGarisTengah);
		}
		private void GarisAtas(){
			g.setColor(250,250 ,250);
			g.fillRect(korXgarisAtas, korYgarisAtas, lebarGarisAtas, tinggiGarisAtas);
		}
		private void GarisBawah(){
			g.setColor(250,250 ,250);
			g.fillRect(korXgarisBawah, korYgarisBawah, lebarGarisBawah, tinggiGarisBawah);
		}
		private void GarisKanan(){
			g.setColor(250,250 ,250);
			g.fillRect(korXgarisKanan, korYgarisKanan, lebarGarisKanan, tinggiGarisKanan);
		}
		private void GarisKiri(){
			g.setColor(250,250 ,250);
			g.fillRect(korXgarisKiri, korYgarisKiri, lebarGarisKiri, tinggiGarisKiri);
		}
	public void run() {
		while (nyawa > 0) {
			latarbelakang();
			GarisTengah();
			GarisAtas();
			GarisBawah();
			GarisKanan();
			GarisKiri();
			raket1();
			raket2();
			bola();
			gerakRaket1();
			gerakBola();
			tabrakRaket1();
			tabrakRaket2();
			gerakRaket2();
			tulisanScore();
			nyawa();
			GameOver();
			try {
				Thread.sleep(1000 / 30);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			flushGraphics();

		}
	}

	public otakgame() {
		super(false);
		this.setFullScreenMode(true);
		g = getGraphics();
	}

	private void latarbelakang() {
		g.setColor(11, 150, 11);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	protected void startGame() {
		Thread thread = new Thread(this);
		thread.start();
	}
}
