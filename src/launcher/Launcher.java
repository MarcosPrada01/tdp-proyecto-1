package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SimplePresentationScreen presentacion= new SimplePresentationScreen(new Student(124335,"Marcos Damian","Prada","marcosprada01@gmail.com","https://github.com/MarcosPrada01","/images/Captura.PNG"));
            	presentacion.setVisible(true);
            }
        });
    }
}	