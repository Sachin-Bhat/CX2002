/**
 * 
 */
package Control;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

import Entity.RoomService;
import Entity.MenuItem;

/**
 *
 */
public class RoomServiceManager {
	
    private ArrayList<RoomService> rsList;
    private FileIOHandler fileIO;
    private int count = 1;
    private Scanner sc;
    
    public RoomServiceManager() {
    	
    }
    public void RoomServiceManager(Scanner sc) {
        // TODO implement here
    }

    public RoomService orderRoomService(ArrayList<MenuItem> mList) {
        RoomService rs = new RoomService(mList, dateTime, remarks, rsList.size());
        rsList.add(rs);
        return rs;
        return null;
    }
    
    public void removeRoomService(RoomService rs) {
        int id = rs.getId();
        RoomService temp;
        rsList.remove(id);
        for(int i=id;i<rsList.size();i++) {
        	temp = rsList.get(i);
        	temp.setId(id);
        	rsList.set(i, temp);
        }
        return;
    }
    
    public void updateRoomService(RoomService rs) {
        // TODO implement here
        return;
    }
    
    private void updateRoomServiceMenu() {
        // TODO implement here
        return;
    }

    /**
     * @param option 
     * @param input 
     * @return
     */
    private int verifyOption(int option, String input) {
        // TODO implement here
        return 0;
    }

    /**
     * @param id 
     * @return
     */
    public RoomService getRoomServiceById(int id) {
        return rsList.get(id);
    }
}
