package coldware;

import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class Reproductor extends Thread {
	boolean loop;

	public void run() {

		Player apl = null;

		try {
			do {
				FileInputStream buff = new FileInputStream("music/THEANIMALS.mp3");
				apl = new Player(buff);
				apl.play();
			} while (!loop);
		} catch (Exception ioe) {
                    ioe.printStackTrace();
			// TODO error handling
		}

	}

}
