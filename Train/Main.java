import java.io.*;
import java.util.*;
class Main {
  public static void main(String[] args) {
   ArrayList<Train> list = Populate.populate("stop_times");
   int trip = 0;
   int counter = 0;
    try{
      //replace with your path
      File file = new File("C:\\Users\\pablo\\Downloads\\Train\\delayTime.txt");
      Scanner sc = new Scanner(file);
      list = Update.update(list, "delayTime");
    }
    catch (IOException e){
      System.out.println("An error occurred.");
    }
    
    //Writing to the file
    try {  
      FileWriter myWriter = new FileWriter("output.txt");
      System.out.println("Your almost there");
      for(int i = 0; i < list.size(); i++){
        Train x = list.get(i);
        int arrivalTime = x.getArrivalTime();
        int hr = arrivalTime/3600;
        int remainingM = arrivalTime%3600;//remaining min in sec
        int min = remainingM/60;
        int remainingS = remainingM%60;
        int sec = remainingS;
        
        int departureTime = x.getDepartureTime();
        int hr2 = departureTime/3600;
        int remainingM2 = departureTime%3600;//remaining min in sec
        int min2 = remainingM2/60;
        int remainingS2 = remainingM2%60;
        int sec2 = remainingS2;

        float shapeDistTraveled = x.getShapeDistTraveled();
        int totalpassengers = x.getPassengerAmount();
        if(counter == 0){
          myWriter.write("{ \n");
          myWriter.write("\"trip_id\": { \n");
          counter++;
        }
        if(x.getTripId()!=trip) {
          if(counter>1){
            myWriter.write("], \n");
          }
          myWriter.write("\""+x.getTripId()+ "\" :  [ \n");
          trip++;
          counter++;
        }
        myWriter.write("{ \n");
        myWriter.write("\"stop_id\" : "+x.getStopId()+",\n");
        String hour = ""+hr;
        String minute = ""+min;
        String second = ""+sec;
        String hour2 = ""+hr2;
        String minute2 = ""+min2;
        String second2 = ""+sec2;


        if(hr<10){
          hour = "0"+ hour;
        }
        if(hr2<10){
          hour2 = "0"+ hour2;
        }
        if(min<10){
          minute = "0"+minute;
        } if(min2<10){
          minute2 = "0"+ minute2;
        }
        if(sec<10){
          second = "0"+second;
        }
        if(sec2<10){
          second2 = "0"+second2;
        }
        myWriter.write("\"arrival_time\" : \"" +hour+":"+minute+":"+second+"\" , \n");
        myWriter.write("\"departure_time\" : \"" +hour2+":"+minute2+":"+second2+"\" , \n");
        myWriter.write("\"distance_traveled\" : " +shapeDistTraveled+"\n");// would need a comma before \n to count total passenegers
        //myWriter.write("\"total_passengers\" : " + totalpassengers+" \n");
        //this works but not enough time to implement onto website 
        //uncomment to test on your own
        myWriter.write("}, \n");

      }
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
  }
}