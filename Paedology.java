import java.util.ArrayList;

public class Paedology extends Ward{
   public Paedology(){
      super();
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
         if(id = patientList.get(i)){
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
      for(int i = 0; i < numEquipment; i++){
         if(equipmentList.get(i).getName() == e.getName()){
            equipmentList.get(i).setQuantity(equipmentList.get(i).getQuantity() + num);
            return true;
            //return true if equipment was added to existing object within array
         } 
      }
      equipmentList.add(new Equipment(this,e.getName(),num,e.getMaintainCost()));
      return false;
      //return false if new equipment object was created
   }
   
   public boolean removeEquipment(Equipment e, int num){
      for(int i = 0; i < numEquipment; i++){
         if(equipmentList.get(i).getName() == e.getName()){
            equipmentList.remove(i);
            numEquipment--;
            return true
         } 
      }
      return false;
   }
   
   public Equipment getEquipment(String name){
      for(int i = 0; i < numEquipment; i++){
         if(equipmentList.get(i).getName() == name){
            return equipmentList.get(i);
         }         
      }
      return null;
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
         if(medicalList.get(i).getId == id){
            medicalList.remove(i);
            numMedical--;
            return true;
         }
      }
      return false;
   }
   
   public boolean determineSuitability(Patient p){
   //if triage is less than 5, they are suitable for this ward
      if(p.getTriage()<5){
         return true;
      }
      return false;
   }
   
   public String toString(){
      return "Paedology Ward\nNumber of Staff: " +numStaff+"\nNumber of Patients: "+numPatient+"\nNumber of Equipment: "+numEquipment;
   }

}