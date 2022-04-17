package Control;

/**
 * @author BHAT SACHIN <SACHIN008@e.ntu.edu.sg>
 * @author CHNG QIHON <LCHNG002@e.ntu.edu.sg>
 * @author JIANG YUNJUN <YJIANG035@e.ntu.edu.sg>
 * @author NEO SUNWEN <SNEO020@e.ntu.edu.sg>
 * @author ZAKI BIN ZAINUDIN <ZAKI003@e.ntu.edu.sg>
 */
abstract class Manager {
	/**
	 * Default constructor for class
	 */
	Manager() {}
	
	/**
	 * Abstract method to verify that the input is of type int
	 * method must be implemented by other manager classes
	 * @param option
	 * @param input
	 */
	abstract int verifyOption(int option, String input);
}
