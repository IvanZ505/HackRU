import java.io.*;
import java.util.*;
public class Populate{
  public static ArrayList<Train> populate(String stopTimes){
    ArrayList<Train> list = new ArrayList<Train>();
    try{

      //Replace with your path
      File file = new File("C:\\Users\\pablo\\Downloads\\Train\\stop_times.txt");
      Scanner sc = new Scanner(file);
      File passAmt = new File("C:\\Users\\pablo\\Downloads\\Train\\intrain.txt");
      Scanner sc2 = new Scanner(passAmt);
    while(sc.hasNextLine()){
      int tripId = (int) sc.nextInt();
    
      int hr = sc.nextInt() * 3600;
      int min = sc.nextInt() * 60;
      int sec = sc.nextInt();
      int arrivalInSec = hr + min + sec;

      int hr2 = sc.nextInt() * 3600;
      int min2 = sc.nextInt() * 60;
      int sec2 = sc.nextInt();
      int departureTime = hr2 + min2 + sec2;
      
      int stopId = sc.nextInt();
      int stopSequence = sc.nextInt();
      int pickupType = sc.nextInt();
      int dropOffType = sc.nextInt();
      float shapeDistTraveled = sc.nextFloat();
    
      int passengers = sc2.nextInt();
      Train t = new Train(tripId, arrivalInSec, departureTime, stopId, stopSequence, pickupType, dropOffType, shapeDistTraveled,passengers);
    list.add(t);
      }
    }
    catch (IOException e){
      System.out.println("An error occurred");
    }
//    String skipLine = sc.readString();
      return list;
  }
}
