import java.util.ArrayList;

public class Ward{
   protected ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();
   protected static int maxEquipment = 150;
   protected int numEquipment;
   protected ArrayList<Patient> patientList = new ArrayList<Patient>();
   protected static int maxPatient = 100;
   protected int numPatient;
   protected ArrayList<Medical> medicalList = new ArrayList<Medical>();
   protected static int maxMedical = 15;
   protected int numMedical;
   protected double baseOperatingCost;
   
   
   public Ward(){
      //constructor to set num of counter fields, as well as cost
      this.numEquipment = 0;
      this.numPatient = 0;
      this.numMedical = 0;
      this.baseOperatingCost = 1000000;
   }
   
   public double getOperatingCost(){
      //takes base cost, and adds Equipment cost
      double total = 0;
      total += baseOperatingCost;
      for(int i = 0; i < numEquipment; i++){
         total += equipmentList.get(i).getMaintenanceCost()*equipmentList.get(i).getQuantity();
      }
      return total;
   }

   public double getBaseOperatingCost(){
      return baseOperatingCost;
   }

   public void setBaseOperatingCost(double cost) {
      baseOperatingCost = cost;
   }
   
   public boolean addPatient(Patient p){
      //adds Patients up to cap
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
      //searches for Patient id, removes if id found
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
      //adds Equipment to existing Equipment object, or creates new Equipment object
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
      //searches Equipment name, removes if found
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
      //find if Equipment exists within Ward
      for(int i = 0; i < numEquipment; i++){
         if(equipmentList.get(i).getName() == name){
            return equipmentList.get(i);
            //returns Equipment object with name matching parameter String 
         }         
      }
      return null;
   }
   
   public int totalEquipment(){
      //calculates and returns total quantity of Equipment in Ward
      int sum = 0;
      for(int i = 0; i < numEquipment; i++){
         sum+=equipmentList.get(i).getQuantity();
      }
      return sum;
   }
   
   public boolean addStaff(Medical m){
      //adds Medical if space
      if(numMedical < maxMedical){
         medicalList.add(m);
         numMedical++;
         return true;
      }
      return false;
   }
   
   public boolean removeStaff(String id){
      //searches by Medical id to remove 
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
   //if triage is less than 5, they are suitable for this ward
      if(p.getTriage()<5){
         return true;
      }
      return false;
   }

   public String toString(){
      return "General Ward\nNumber of Staff: " +numMedical+"\nNumber of Patients: "+numPatient+"\nNumber of Equipment: "+this.totalEquipment();
   }
}