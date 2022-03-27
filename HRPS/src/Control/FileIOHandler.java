/**
 * 
 */
package Control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

import java.util.ArrayList;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 *
 */
public class FileIOHandler {
	/**
     * Default constructor for the FileIOHandler
     */
    public FileIOHandler() {
    }

    /**
     * 
     */
    private String directory = "";

    /**
     * passing an object (like `Guest` for instance)
     * takes in c as "guest.getClass()"(e.g.) where guest is: Guest guest = new Guest()
     * returns all objects stored in a file like guest details.
     * @param class 
     * @return objList.toArray()
     */
    public Object[] readObject(Class<?> c) {
        // TODO implement here
    	directory = c + ".txt";
    	ArrayList<Object> objList = new ArrayList<>();
    	
    	try {
    		FileInputStream fIn = new FileInputStream(new File(directory));
    		ObjectInputStream oIn = new ObjectInputStream(fIn);
    		
    		// Read object
    		boolean readObj = true;
    		
    		while(readObj) {
    			Object o = oIn.readObject();
    			
    			if(o == null)
    				readObj = !(readObj);
    			else
    				objList.add(o);
    		}
    		
    		oIn.close();
    		fIn.close();
    	}
    	catch(FileNotFoundException exception) {
    		if(exception.getMessage() == null)
    			System.out.println("File not found...");
    		else
    			System.out.println("File not found. Errored out with following message:\n"+exception.getMessage());
    	}
    	catch(ClassNotFoundException exception) {
    		System.out.println("Class not found. Printing stack trace...");
    		exception.printStackTrace();
    	}
    	catch(IOException exception) {
    		if(exception.getMessage() != null)
    			System.out.println("Errored out while initialising stream with the following message:\n"+exception.getMessage());
    	}
        return objList.toArray();
    }

    /**
     * serializes and writes objects into .txt
     * passes array of all the same objects stored
     * takes in c as "guest.getClass()" (e.g.) where guest is: Guest guest = new Guest()
     * @param objList 
     * @param class 
     * @return
     */
    public void writeObject(Object[] objList, Class<?> c) {
        // TODO implement here
    	directory = c + ".txt";
		try {
			FileOutputStream fOut = new FileOutputStream(new File(directory));
			ObjectOutputStream oOut = new ObjectOutputStream(fOut);

			// Write array of objects to file
			for (int i = 0; i < objList.length; i++)
				oOut.writeObject(objList[i]);
			
			oOut.close();
			fOut.close();
		} 
		
		catch(IOException exception) {
    		if(exception.getMessage() != null)
    			System.out.println("Errored out while initialising stream with the following message:\n"+exception.getMessage());
    		else
    			System.out.println("Errored out while initialising stream...");
    	}
        return;
    }

    /**
     * similar to the above method, but only writes a single object
     * @param obj 
     * @param class 
     * @return
     */
    public void writeSingleObject(Object o, Class<?> c) {
        // TODO implement here
    	directory = c + ".txt";
		Object[] storedObjList = readObject(c);
		
		try {
			FileOutputStream fOut = new FileOutputStream(new File(directory));
			ObjectOutputStream oOut = new ObjectOutputStream(fOut);

			
			// Write objects to file 
			for (int i = 0; i < storedObjList.length; i++)
				oOut.writeObject(storedObjList[i]); 
			
			oOut.writeObject(o);
			
			oOut.close();
			fOut.close();
		} 
		
		catch(IOException exception) {
    		if(exception.getMessage() != null)
    			System.out.println("Errored out while initialising stream with the following message:\n"+exception.getMessage());
    		else
    			System.out.println("Errored out while initialising stream...");
    	}
        return;
    }
}
