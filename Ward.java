import java.util.ArrayList;

public class Ward{
   private ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();
   private static int maxEquipment = 150;
   private int numEquipment;
   private ArrayList<Patient> patientList = new ArrayList<Patient>();
   private static int maxPatient = 100;
   private int numPatient;
   private ArrayList<Medical> medicalList = new ArrayList<Medical>();
   private static int maxMedical = 15;
   private int numMedical;
   private double baseOperatingCost;
   
   
   public Ward(){
      this.maxEquipment = maxEquipment;
      this.numEquipment = 0;
      this.maxPatient = maxPatient;
      this.numPatient = 0;
      this.maxMedical = maxMedical;
      this.numMedical = 0;
      this.baseOperatingCost = 1000000;
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
   
   public boolean removeEquipment(Equipment e, int num){
      for(int i = 0; i < numEquipment; i++){
         if(equipmentList.get(i).getName() == e.getName()){
            equipmentList.remove(i);
            numEquipment--;
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
         if(medicalList.get(i).getId() == id){
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
      return "General Ward\nNumber of Staff: " +numMedical+"\nNumber of Patients: "+numPatient+"\nNumber of Equipment: "+numEquipment;
   }
}