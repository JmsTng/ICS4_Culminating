import java.util.ArrayList;

public class Paedology extends Ward{
   
   public Paedology(){
      super();
      this.baseOperatingCost = 100000;
   }
   
   public double getOperatingCost(){
      double total = 0;
      total += baseOperatingCost;
      for(int i = 0; i < numEquipment; i++){
         total += equipmentList.get(i).getMaintenanceCost()*equipmentList.get(i).getQuantity();
      }
      return total;
   }
   
   public boolean addPatient(Patient p){
      if(numPatient < maxPatient){
         patientList.add(p);
         numPatient++;
         return true;
         //true if capacity
      }
      return false;
      //false if full
   }
   
   public boolean removePatient(String id){
      for(int i = 0; i < numPatient; i++){
         if(id == patientList.get(i).getName()){
            patientList.remove(i);
            numPatient--;
            return true;
            //return true if id matches an object
         }
      }
      return false;
      //return false if no matching id found
   }
   
   public boolean addEquipment(Equipment e, int num){
      if(this.totalEquipment()<maxEquipment){
         for(int i = 0; i < numEquipment; i++){
            if(equipmentList.get(i).getName() == e.getName()){
               equipmentList.get(i).setQuantity(equipmentList.get(i).getQuantity() + num);
               return true;
               //return true if equipment was added to existing object within array
            } 
         }
         equipmentList.add(new Equipment(this,e.getName(),num,e.getMaintenanceCost()));
         return true;
         //or, return true if new equipment was made and added to array
      }
      return false;
   }
   
   public boolean removeEquipment(Storage s, Equipment e, int num){
      for(int i = 0; i < numEquipment; i++){
         if(equipmentList.get(i).getName() == e.getName()){
            equipmentList.remove(i);
            numEquipment--;
            s.addEquipment(e, num);
            return true;
            //return true if equipment with matching name succesfully REMOVED from array
         } 
      }
      return false;
      //return false if equipment with name not found
   }
   
   public Equipment getEquipment(String name){
      for(int i = 0; i < numEquipment; i++){
         if(equipmentList.get(i).getName() == name){
            return equipmentList.get(i);
            //returns Equipment object with name matching parameter String 
         }         
      }
      return null;
   }
   
   public int totalEquipment(){
      int sum = 0;
      for(int i = 0; i < numEquipment; i++){
         sum+=equipmentList.get(i).getQuantity();
      }
      return sum;
   }
   
   public boolean addStaff(Medical m){
      if(numMedical < maxMedical){
         medicalList.add(m);
         numMedical++;
         return true;
      }
      return false;
   }
   
   public boolean removeStaff(String id){
      for(int i = 0; i < numMedical; i++){
         if(medicalList.get(i).getEmployeeNum() == id){
            medicalList.remove(i);
            numMedical--;
            return true;
         }
      }
      return false;
   }
   
   public boolean determineSuitability(Patient p){
   //if patient is a child, they are suitable
      if(p instanceof Child){
         return true;
      }
      return false;
   }
   public String toString(){
      return "Paedology Ward\nNumber of Staff: " +numMedical+"\nNumber of Patients: "+numPatient+"\nNumber of Equipment: "+this.totalEquipment();
   }
}