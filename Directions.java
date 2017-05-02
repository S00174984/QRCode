package ie.itsligo.roomroute;

public class Directions {
	private final int ROOM_LENGTH = 5; // size of the room string
	private char building ;
	private char floor;
	private String locationOnFloor = null;
	private int location;

	public Directions() {

	}

	
	public char getBuilding() {
		return building;
	}


	public void setBuilding(char building) {
		this.building = building;
	}


	public char getFloor() {
		return floor;
	}


	public void setFloor(char floor) {
		this.floor = floor;
	}


	public String getLocationOnFloor() {
		return locationOnFloor;
	}

	public void setLocationOnFloor(String locationOnFloor) {
		this.locationOnFloor = locationOnFloor;
	}

	/*
	 * This method takes in a room eg E2004 and splits up into the correct block
	 * (Engineering, Science, Business, etc) The correct floor The correct room
	 * number
	 */
	public boolean validate(String room) {
		if (room.length() != ROOM_LENGTH) {
			return false;
		}
		if (Character.isLetter(room.charAt(0)) == false) {
			return false; // room must start with a letter
		}
		for (int i = 1; i < ROOM_LENGTH; i++) {
			if (Character.isDigit(room.charAt(i)) == false) {
				return false; // room must have 4 digits after the letter
			}
		}
		
		// all ok - store the info
		building = room.charAt(0);
		floor = room.charAt(1);
		locationOnFloor = room.substring(2);
		
		return true;
	}
	
	/*
	 * Get directions to building
	 */
	public String toBuilding() {
		String directions = null;
		switch (this.building) {
		case 'A':
			// TODO play the sound here for this here
			QRSound.buildingSound(building);
			directions = "The room is in Main block.\nFrom reception, walk straight ahead and then turn to your right.";
			break;
		case 'B':
			// TODO play the sound here for this here
			QRSound.buildingSound(building);
			directions = "The room is in Science block.\nFrom reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest.";
			break;
		case 'C':
			// TODO play the sound here for this here
			QRSound.buildingSound(building);
			directions = "The room is in C block.\nFrom reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest, then turn left and conrinute through long corridor.";
			break;
		case 'D':
			// TODO play the sound here for this here
			QRSound.buildingSound(building);
			directions = "The room is in Business block.\nFrom reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest, then turn left and conrinute through long corridor.";
			break;
		case 'E':
			// TODO play the sound here for this here
			QRSound.buildingSound(building);
			directions = "The room is in E block.\nFrom reception, move the the centre of reception and turn left into the engineering building.";
			break;
		case 'F':
			// TODO play the sound here for this here
			QRSound.buildingSound(building);
			directions = "The room is in Engineering block.\nFrom reception, walk outside and turn to your right.  Walk past the engineering building and the F block is straigt in front.";
			break;
		default:
			QRSound.buildingSound(building);
			directions = "Sorry, that building is not recognised.";
			break;
			
		}
		return(directions);
	}
	
	/*
	 * Get directions to floor
	 */
	public String toFloor() {
		String directions = null;
		switch (this.floor) {
		case '0':
			// TODO play the sound here for this here
			QRSound.floorSound(floor);
			directions = "Stay on this floor.";
			break;
		case '1':
			// TODO play the sound here for this here
			QRSound.floorSound(floor);
			directions = "Ascend the stairs or take the lift to the first floor.";			
			break;
		case '2':
			// TODO play the sound here for this here
			QRSound.floorSound(floor);
			directions = "Ascend two flight of stairs or take the lift to the second floor.";			
			break;
		default:
			QRSound.floorSound(floor);
			directions = "Sorry, floor " + this.floor + " is not recognised.";
			break;
			
		}
		return(directions);
	}

	/*
	 * Get directions to floor
	 */
	public String toLocation() {
		String directions = null;
		switch (this.locationOnFloor) {
		case "006":
			// TODO play the sound here for this here
			location = 006;
			QRSound.locationOnFloorSound(location);
			directions = "This is a room to the right on this level.";
			break;
		case "007":
			// TODO play the sound here for this here
			location = 007;
			QRSound.locationOnFloorSound(location);
			directions = "This is a room to the right on this level.";			
			break;
		case "003":
			// TODO play the sound here for this here
			location = 003;
			QRSound.locationOnFloorSound(location);
			directions = "This is the last room to the right on this level.";			
			break;
		case "004":
			// TODO play the sound here for this here
			location = 004;
			QRSound.locationOnFloorSound(location);
			directions = "This is the second last room to the right on this level.";			
			break;
		default:
			location = 000;
			QRSound.locationOnFloorSound(location);
			directions = "Sorry, that room is not recognised.";
			break;
			
		}
		return(directions);
	}

}
