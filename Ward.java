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
   }
   
   public boolean addPatient(Patient p){
      if(numPatient < maxPatient){
         patientList.add(p);
         numPatient++;
         return true;
      }
      return false;
   }
   
   public boolean removePatient(String id){
      for(int i = 0; i < numPatient; i++){
         if(id = patientList.get(i)){
            patientList.remove(i);
            numPatient--;
            return true;
         }
      }
      return false;
   }
   
   public boolean addEquipment(Equipment e, int num){
   
   }
   
   public boolean removeEquipment(Equipment e, int num){
   
   }
   
   public boolean determineSuitability(Patient p){
   
   }
}