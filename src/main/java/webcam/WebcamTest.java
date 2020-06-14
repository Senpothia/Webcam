package webcam;
import java.awt.List;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.*;

public class WebcamTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Webcam webcam = Webcam.getDefault();
		webcam.open();
		ImageIO.write(webcam.getImage(), "JPG", new File("image.jpg"));
		webcam.close();
		
		new WebcamDiscoveryListener();
		Thread.sleep(1200);
		System.out.println("Bye!");
		
		java.util.List<Webcam> webcams = Webcam.getWebcams();
		
		for (Webcam w : webcams) {
			
			System.out.println("Nom: " + w.getName());
			
		}
		
		Webcam webcam2 =  Webcam.getWebcamByName("AUKEY PC-LM1 USB Camera 1");
		webcam2.open();
		ImageIO.write(webcam2.getImage(), "JPG", new File("image2.jpg"));
		webcam2.close();
		
		Recherche rechercheVert = new Recherche(35, 177, 75, "C:\\Users\\kinte\\eclipse-workspace\\webcam\\image2.jpg");
	    boolean vert = rechercheVert.analyse();
	    
	    Recherche rechercheRouge = new Recherche(80, 49, 80, "C:\\Users\\kinte\\eclipse-workspace\\webcam\\image2.jpg");
	    boolean rouge = rechercheRouge.analyse();

	}

}
