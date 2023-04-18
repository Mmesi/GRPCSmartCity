package ds.lightingsystem;

/*This Java Exception handles special cases and communicates to users to correct the cases.
*/
public class InvalidEntryException extends Exception {

	public InvalidEntryException(){

		super("ID cannot be empty. Please correct this");

}
	public String getLocationmessage() {
		return "Please Enter a Location";
	}
}
