package ie.itsligo.roomroute;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class QRSound {
	private static final int A = 1; // Go to main message
	
	private static final int B = 2; // Go to science message
	
	private static final int C = 3;
	
	private static final int D = 4; // Go to business  message
	
	private static final int E = 5;
	
	private static final int F = 6; // Go to engineering message
	
	private static final int unknowBuilding = 7;
	
	private static final int floor_0 = 8;
	
	private static final int floor_1 = 9;
	
	private static final int floor_2 = 10;
	
	private static final int unknowFloor = 11;
	
	private static final int room_006 = 12;
	
	private static final int room_007 = 13;
	
	private static final int room_003 = 14;
	
	private static final int room_004 = 15;
	
	private static final int unknowRoom = 16;
	
	private static final int unknow = 17;
	
	public static void buildingSound(char building) {
		if(building == 'A'){
			playit(A);
			delayfor(5);	// delay for 5 seconds
		}
		else if(building == 'B'){
			playit(B);
			delayfor(10);	// delay for 10 seconds
		}
		else if(building == 'C'){
			playit(C);
			delayfor(13);	// delay for 13 seconds
		}
		else if(building == 'D'){
			playit(D);
			delayfor(13);	// delay for 13 seconds
		}
		else if(building == 'E'){
			playit(E);
			delayfor(6);	// delay for 6 seconds
		}
		else if(building == 'F'){
			playit(F);
			delayfor(9);	// delay for 9 seconds
		}
		else{
			playit(unknowBuilding);
			delayfor(4);	// delay for 4 seconds
		}
	}
	
	public static void floorSound(char floor) {
		if(floor == '0'){
			playit(floor_0);
			delayfor(2);	// delay for 2 seconds
		}
		else if(floor == '1'){
			playit(floor_1);
			delayfor(4);	// delay for 4 seconds
		}
		else if(floor == '2'){
			playit(floor_2);
			delayfor(5);	// delay for 5 seconds
		}
		else{
			playit(unknowFloor);
			delayfor(4);	// delay for 4 seconds
		}
	}
	
	public static void locationOnFloorSound(int locationOnFloor) {
		if(locationOnFloor == 006){
			playit(room_006);
			delayfor(3);	// delay for 3 seconds
		}
		else if(locationOnFloor == 007){
			playit(room_007);
			delayfor(3);	// delay for 3 seconds
		}
		else if(locationOnFloor == 003){
			playit(room_003);
			delayfor(3);	// delay for 3 seconds
		}
		else if(locationOnFloor == 004){
			playit(room_004);
			delayfor(4);	// delay for 4 seconds
		}
		else{
			playit(unknowRoom);
			delayfor(4);	// delay for 4 seconds
		}
	}
	
	public static void unknow() {
		playit(unknow);
		delayfor(3);
	}
	
	public static void delayfor(int n)
	{
		try {
		    Thread.sleep(n * 1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
    /*
	 * Method is passed a sound flag it will play that sound there is only one
	 * currently supported. To use this sound - call new playit(SOUND);
	 */
	public static void playit(int soundRequired) {
		String fn = null;
		File sound; 
        //URL location = QRSound.class.getProtectionDomain().getCodeSource().getLocation();
        
		switch (soundRequired) {
		case A:
			fn = /*location.getFile() + */"./src/resources/Building_A.wav";
			break;
		
		case B:
			fn = /*location.getFile() + */"./src/resources/Building_B.wav";
			break;
			
		case C:
			fn = /*location.getFile() + */"./src/resources/Building_C.wav";
			break;
			
		case D:
			fn = /*location.getFile() + */"./src/resources/Building_D.wav";
			break;
			
		case E:
			fn = /*location.getFile() + */"./src/resources/Building_E.wav";
			break;
			
		case F:
			fn = /*location.getFile() + */"./src/resources/Building_F.wav";
			break;
			
		case unknowBuilding:
			fn = /*location.getFile() + */"./src/resources/Building_Default.wav";
			break;
			
		case floor_0:
			fn = /*location.getFile() + */"./src/resources/Floor_0.wav";
			break;
			
		case floor_1:
			fn = /*location.getFile() + */"./src/resources/Floor_1.wav";
			break;
			
		case floor_2:
			fn = /*location.getFile() + */"./src/resources/Floor_2.wav";
			break;
			
		case unknowFloor:
			fn = /*location.getFile() + */"./src/resources/Floor_Default.wav";
			break;
			
		case room_006:
			fn = /*location.getFile() + */"./src/resources/Room_006.wav";
			break;
			
		case room_007:
			fn = /*location.getFile() + */"./src/resources/Room_007.wav";
			break;
			
		case room_003:
			fn = /*location.getFile() + */"./src/resources/Room_003.wav";
			break;
			
		case room_004:
			fn = /*location.getFile() + */"./src/resources/Room_004.wav";
			break;
			
		case unknowRoom:
			fn = /*location.getFile() + */"./src/resources/Room_Default.wav";
			break;
			
		case unknow:
			fn = /*location.getFile() + */"./src/resources/Unknow.wav";
			break;
			
		default:
			break;

		}

		// Go for it!
		try {
			// Open an audio input stream.
			sound = new File(fn);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
			// plays
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

