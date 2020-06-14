package webcam;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Recherche {
	
	private int red;
	private int green;
	private int blue;
	private int tolerance = 10;
	private String image;
	private int pointOK = 50;
	
	public Recherche() {
		super();
		
	}

	public Recherche(int red, int green, int blue, int tolerance, String image, int pointOK) {
		super();
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.tolerance = tolerance;
		this.image = image;
		this.pointOK = pointOK;
	}
	
	

	public Recherche(int red, int green, int blue, String image) {
		super();
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.image = image;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	public int getTolerance() {
		return tolerance;
	}

	public void setTolerance(int tolerance) {
		this.tolerance = tolerance;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPointOK() {
		return pointOK;
	}

	public void setPointOK(int pointOK) {
		this.pointOK = pointOK;
	}

	boolean analyse() throws IOException {
		
		boolean resultat  = false;
		
		  System.out.println("ref red: " + this.red);
		  System.out.println("ref green: " + this.green);
		  System.out.println("ref blue: " + this.blue);
		  
	      File file= new File(this.image);
	      BufferedImage test = ImageIO.read(file);
	      int points = 0;
	      for (int y = 0; y < test.getHeight(); y++) {
	         for (int x = 0; x < test.getWidth(); x++) {
	            //Retrieving contents of a pixel
	            int pixel = test.getRGB(x,y);
	            //Creating a Color object from pixel value
	            Color color = new Color(pixel, true);
	            //Retrieving the R G B values
	            int redMesure = color.getRed();
	            int greenMesure = color.getGreen();
	            int blueMesure = color.getBlue();
	            if (redMesure > this.red - this.tolerance &&  redMesure < this.red + this.tolerance   
	             && greenMesure > this.green - this.tolerance &&  greenMesure < this.green + this.tolerance 
	             && blueMesure > this.blue - this.tolerance &&  blueMesure < this.blue + this.tolerance  ) { 
	            	
	            	points++;
	            	
	            }
	            
	            System.out.println(red + " " + green + " " + blue + " points: " + points);
	            
	         }
	      }
	      
	      System.out.println("points Ok relevés: " + points);
	      System.out.println("Image analysée: " + this.image);
	      System.out.println("ref red: " + this.red);
		  System.out.println("ref green: " + this.green);
		  System.out.println("ref blue: " + this.blue);
		  
	      if (points > this.pointOK ) {
	      	
	      	System.out.println("Résultat analyse: conforme");
	      	resultat = true;
	      }else {
	      	System.out.println("Résultat analyse: non conforme");
	      	resultat = false;
	      }
	      
	    
	      
	   
		return resultat;
	}
	
	

	
	
	
}