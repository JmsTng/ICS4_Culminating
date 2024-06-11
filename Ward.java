public class Ward{
   private int matchSymptomReq;
   private ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();
   private static int maxEquipment = 150;
   private int numEquipment;
   private ArrayList<Patient> patientList = new ArrayList<Patient>();
   private static int maxPatient = 100;
   private int numPatient;
   private ArrayList<Medical> medicalPersonel = new ArrayList<Medical>();
   private static int maxPersonel = 15;
   private int numPersonel;
   private double baseOperatingCost;
   
   public Ward(int matchSymptomReq){
      this.matchSymptomReq = matchSymptomReq;
      this.maxEquipment = maxEquipment;
      this.numEquipment = 0;
      this.maxPatient = maxPatient;
      this.numPatient = 0;
      this.maxPersonel = maxPersonel;
      this.numPersonel = 0;
      this.baseOperatingCost = 10000000;
   }
   
   public double getOperatingCost(){
      return this.baseOperatingCost;
      //ADD EQUIPMENT COSTS IN
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
            equipmentList.get(i).setQuantity(equipmentList.get(i).getQuantity + num);
            return true;
            //return true if equipment was added to existing object within array
         } 
      }
      equipmentList.add(Equipment(this,e.getName(),num,e.getMaintainCost));
      return false;
      //return false if new equipment object was created
   }
   
   public boolean removeEquipment(Equipment e, int num){
      for(int i = 0; i < numEquipment; i++){
         if(equipmentList.get(i).getName() == e.getName()){
            
            
         } 
      }
      return false;
   }
   
   public boolean determineSuitability(Patient p){
   
   }
}