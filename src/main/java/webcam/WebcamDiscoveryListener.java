package webcam;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryEvent;

public class WebcamDiscoveryListener implements com.github.sarxos.webcam.WebcamDiscoveryListener{

	
	
	public WebcamDiscoveryListener() {
		
		for (Webcam webcam : Webcam.getWebcams()) {
			System.out.println("Webcam detected: " + webcam.getName());
		}
		Webcam.addDiscoveryListener(this);
		System.out.println("\n\nPlease connect additional webcams, or disconnect already connected ones. Listening for events...");
	}

	public void webcamFound(WebcamDiscoveryEvent event) {
		System.out.format("Webcam connected: %s \n", event.getWebcam().getName());
		
	}

	public void webcamGone(WebcamDiscoveryEvent event) {
		System.out.format("Webcam disconnected: %s \n", event.getWebcam().getName());
		
	}

}
