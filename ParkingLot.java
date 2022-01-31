import java.io.File;
import java.util.Scanner;

/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class ParkingLot {
	/**
	 * The delimiter that separates values
	 */
	private static final char SEPARATOR = ',';

	/**
	 * The delimiter that separates the parking lot design section from the parked
	 * car data section
	 */
	private static final String SECTIONER = "###";

	/**
	 * Instance variable for storing the number of rows in a parking lot
	 */
	private int numRows;

	/**
	 * Instance variable for storing the number of spaces per row in a parking lot
	 */
	private int numSpotsPerRow;

	/**
	 * Instance variable (two-dimensional array) for storing the lot design
	 */
	private CarType[][] lotDesign;

	/**
	 * Instance variable (two-dimensional array) for storing occupancy information
	 * for the spots in the lot
	 */
	private Car[][] occupancy;

	/**
	 * Constructs a parking lot by loading a file
	 * 
	 * @param strFilename is the name of the file
	 */
	public ParkingLot(String strFilename) throws Exception {

		if (strFilename == null) {
			System.out.println("File name cannot be null.");
			return;
		}

		// determine numRows and numSpotsPerRow; you can do so by
		// writing your own code or alternatively completing the 
		// private calculateLotDimensions(...) that I have provided
		calculateLotDimensions(strFilename);

		// instantiate the lotDesign and occupancy variables!
		// WRITE YOUR CODE HERE!
		//lotDesign[0][0] = ('s',)
		lotDesign = new CarType[numRows][numSpotsPerRow];
		occupancy = new Car[numRows][numSpotsPerRow];
		//occupancy[0][0].setType('s');
		//System.out.println(lotDesign[0][0]);
		//System.out.println(occupancy[0][0]);
		//occupancy[0][0].getType();


		// populate lotDesign and occupancy; you can do so by
		// writing your own code or alternatively completing the 
		// private populateFromFile(...) that I have provided
		populateFromFile(strFilename);
	}

	/**
	 * Parks a car (c) at a give location (i, j) within the parking lot.
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @param c is the car to be parked
	 */
	public void park(int i, int j, Car c) {
		// WRITE YOUR CODE HERE!
	}

	/**
	 * Removes the car parked at a given location (i, j) in the parking lot
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return the car removed; the method returns null when either i or j are out
	 *         of range, or when there is no car parked at (i, j)
	 */
	public Car remove(int i, int j) {
		// WRITE YOUR CODE HERE!
		return null; // REMOVE THIS STATEMENT AFTER IMPLEMENTING THIS METHOD

	}

	/**
	 * Checks whether a car (which has a certain type) is allowed to park at
	 * location (i, j)
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return true if car c can park at (i, j) and false otherwise
	 */
	public boolean canParkAt(int i, int j, Car c) {
		// WRITE YOUR CODE HERE!
		return false; // REMOVE THIS STATEMENT AFTER IMPLEMENTING THIS METHOD

	}

	/**
	 * @return the total capacity of the parking lot excluding spots that cannot be
	 *         used for parking (i.e., excluding spots that point to CarType.NA)
	 */
	public int getTotalCapacity() {
		// WRITE YOUR CODE HERE!
		return -1; // REMOVE THIS STATEMENT AFTER IMPLEMENTING THIS METHOD

	}

	/**
	 * @return the total occupancy of the parking lot (i.e., the total number of
	 *         cars parked in the lot)
	 */
	public int getTotalOccupancy() {
		// WRITE YOUR CODE HERE!
		return -1; // REMOVE THIS STATEMENT AFTER IMPLEMENTING THIS METHOD		
	}

	private void calculateLotDimensions(String strFilename) throws Exception {

		Scanner scanner = new Scanner(new File(strFilename));

		//initiating some variables

		// flag is false before the line with the hashtags
		boolean flag = false;
		// comma is used to find the number of commas in the first line of the file
		// I use this as the number of columns in the parking garage is the number of commas +1
		int comma = 0;
		// holder is used to compare for commas
		char holder;

		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			// WRITE YOUR CODE HERE!
			
			// intsantiate lot design and occupancy

			// find the number of columns
			if (numRows == 0){
				for (int i = 0; i < str.length(); i++){
					holder = str.charAt(i);

					if (holder == SEPARATOR){
						comma++;
					}
				}
			}
			
			if (str.equals(SECTIONER)){
				flag = true;
				//counter = 0;
			}

			// if we havent reached the ### line yet and the line isnt empty, this counts the amount of rows
			if ((flag == false) && (str.isEmpty() == false)){
				numRows++;
			}
		}

		numSpotsPerRow = comma+1;
		scanner.close();
	}

	private void populateFromFile(String strFilename) throws Exception {

		Scanner scanner = new Scanner(new File(strFilename));

		// YOU MAY NEED TO DEFINE SOME LOCAL VARIABLES HERE!
		// flag is false before the line with the hashtags
		boolean flag = false;
		// holder is used to check for the type of the car
		char holder;
		// rowcounter is used to count the number of rows we have found before hashtags
		int rowcounter = 0;
		// carcounter is used to couont the number of cars we have found before hashtags
		int carcounter = 0;

		//after hashtags
		// comma is used to count the number of counters after hashtags
		int comma = 0;
		// type is used to store the car type
		char type;
		// x and y are used to store the x and y variables of the cars in the lot
		//int x = 0,y = 0;
		// plate is used to store the license plate of the car and platecounter is used to count the 3 characters on the license plate
		String plate = "";
		int platecounter = 0;

		// while loop for reading the lot design
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			// WRITE YOUR CODE HERE!
			//lotDesign[0][0] =  CarType.SMALL;
			if (str.equals(SECTIONER)){
				flag = true;
			}
			if (str.isEmpty() == false && flag == false){
				for (int i = 0; i < str.length(); i++){
					holder = str.charAt(i);
					if (holder == 'E'){
						lotDesign[rowcounter][carcounter] = CarType.ELECTRIC;
					}
					if (holder == 'S'){
						lotDesign[rowcounter][carcounter] = CarType.SMALL;
					}
					if (holder == 'R'){
						lotDesign[rowcounter][carcounter] = CarType.REGULAR;
					}
					if (holder == 'L'){
						lotDesign[rowcounter][carcounter] = CarType.LARGE;
					}
					if (holder == 'N'){
						lotDesign[rowcounter][carcounter] = CarType.NA;
					}
					else if(holder == (SEPARATOR)){
						carcounter++;
					}
				}
				carcounter = 0;
				rowcounter++;
			}
		}
		// need to reinstantiate scanner for second while loop
		Scanner scann = new Scanner(new File(strFilename));
		flag = false;
		// while loop for reading occupancy data
		while (scann.hasNext()) {
			String str = scann.nextLine();
			// WRITE YOUR CODE HERE!

			//reinstantiating the variables here at the start of the loop
			plate = "";
			int x = 0,y = 0;
			comma = 0;
			type = ' ';



			if (str.equals(SECTIONER)){
				flag = true;
			}
			if (str.isEmpty() == false && flag == true && str.equals(SECTIONER) == false){
				for (int i = 0; i < str.length(); i++){
					holder = str.charAt(i);
					if (holder == SEPARATOR){
						comma++;
					}
					else if (comma == 3 && platecounter < 3 && holder != ' '){
						plate = plate+holder;
					}
					else if (comma == 2 && holder != ' '){
						type = holder;
						}
					else if (comma == 1 && holder != ' '){
						y = Character.getNumericValue(holder);
					}
					else if (comma == 0 && holder != ' '){
						x = Character.getNumericValue(holder);
					}
				}
				
				if (type == 'E'){
					occupancy[x][y] = new Car(CarType.ELECTRIC,plate);
				}
				if (type == 'S'){
					occupancy[x][y] = new Car(CarType.SMALL,plate);
				}
				if (type == 'R'){
					occupancy[x][y] = new Car(CarType.REGULAR,plate);
				}
				if (type == 'L'){
					occupancy[x][y] = new Car(CarType.LARGE,plate);
				}
				if (type == 'N'){
					occupancy[x][y] = new Car(CarType.NA,plate);
				}
			}
		}

		scanner.close();
	}

	/**
	 * Produce string representation of the parking lot
	 * 
	 * @return String containing the parking lot information
	 */
	public String toString() {
		// NOTE: The implementation of this method is complete. You do NOT need to
		// change it for the assignment.
		StringBuffer buffer = new StringBuffer();
		buffer.append("==== Lot Design ====").append(System.lineSeparator());

		for (int i = 0; i < lotDesign.length; i++) {
			for (int j = 0; j < lotDesign[0].length; j++) {
				buffer.append((lotDesign[i][j] != null) ? Util.getLabelByCarType(lotDesign[i][j])
						: Util.getLabelByCarType(CarType.NA));
				if (j < numSpotsPerRow - 1) {
					buffer.append(", ");
				}
			}
			buffer.append(System.lineSeparator());
		}

		buffer.append(System.lineSeparator()).append("==== Parking Occupancy ====").append(System.lineSeparator());

		for (int i = 0; i < occupancy.length; i++) {
			for (int j = 0; j < occupancy[0].length; j++) {
				buffer.append(
						"(" + i + ", " + j + "): " + ((occupancy[i][j] != null) ? occupancy[i][j] : "Unoccupied"));
				buffer.append(System.lineSeparator());
			}

		}
		return buffer.toString();
	}

	/**
	 * <b>main</b> of the application. The method first reads from the standard
	 * input the name of the file to process. Next, it creates an instance of
	 * ParkingLot. Finally, it prints to the standard output information about the
	 * instance of the ParkingLot just created.
	 * 
	 * @param args command lines parameters (not used in the body of the method)
	 * @throws Exception
	 */

	public static void main(String args[]) throws Exception {

		StudentInfo.display();

		System.out.print("Please enter the name of the file to process: ");

		Scanner scanner = new Scanner(System.in);

		String strFilename = scanner.nextLine();

		ParkingLot lot = new ParkingLot(strFilename);

		System.out.println("Total number of parkable spots (capacity): " + lot.getTotalCapacity());

		System.out.println("Number of cars currently parked in the lot: " + lot.getTotalOccupancy());

		System.out.print(lot);

	}
}
