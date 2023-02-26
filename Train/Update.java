import java.io.*;
import java.util.*;
public class Update{

  public static ArrayList<Train> update(ArrayList<Train> list, String delayTime){
  int arrivalTime = 0;
  int departureTime = 0;
  int waitTime = 0;
  
    try{
      File file = new File("delayTime.txt");
      Scanner sc = new Scanner(file);
      for (int i = 0; i < list.size(); i++){
        Train choochoo = list.get(i);
        if(i+1 < list.size()){
          Train choochoo2 = list.get(i+1);
          if (choochoo.getTripId() == choochoo2.getTripId()){
           departureTime = choochoo.getDepartureTime() +waitTime;
           arrivalTime = choochoo2.getArrivalTime();
           waitTime = sc.nextInt();

           departureTime = departureTime + waitTime;
          arrivalTime = arrivalTime + waitTime;

          choochoo.setDepartureTime(departureTime);
          choochoo2.setArrivalTime(arrivalTime);

    
          list.set(i, choochoo);
          list.set(i+1, choochoo2);
          }
          else{
            
            departureTime = choochoo.getDepartureTime();
            departureTime = departureTime + waitTime;
            choochoo.setDepartureTime(departureTime);
            list.set(i, choochoo);

          }
        }    
        else{
          departureTime = choochoo.getDepartureTime();
          departureTime = departureTime + waitTime;
          choochoo.setDepartureTime(departureTime);
          list.set(i, choochoo);
        }
      }
    }
    catch (IOException e){
      System.out.println("An error occurred");
    }
   
  return list;
}
}