import Staff.*;
import Patient.*;
import Ward.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;

public class Hospital {

   //FIELDS
   private String name;
   private double budget;
   private int numWards;
   private int numPatients;
   private int numStaff;
   
   private ArrayList<Patient> patients = new ArrayList<Patient>();
   private ArrayList<Ward> wards = new ArrayList<Ward>();
   private ArrayList<Staff> staff = new ArrayList<Staff>();
   
   private Scanner sc;

   //CONSTRUCTOR
   public Hospital(String name, double budget) {
      this.name = name;
      this.budget = budget;
      this.numWards = 0;
      this.numPatients = 0;
      this.numStaff = 0;
      
      this.sc = new Scanner(System.in);
   }

   //Creates new ward in ward array list
   //Returns true if successful, otherwise returns false
   public boolean createWard(int match, int max) {
      //Prompts user for type of ward
      System.out.println("Select ward type to add:\n(1) ICU\n(2) Oncology\n(3) Emergency\n(4) Paedology\n(5) Other");
      //Switch case :(
      switch (sc.nextInt()) {
         case 1 -> {
            wards.add(new ICU(match, max));
         }
         case 2 -> {
            wards.add(new Oncology(match, max));
         }
         case 3 -> {
            wards.add(new Emergency(match, max));
         }
         case 4 -> {
            wards.add(new Paedology(match, max));
         }
         case 5 -> {
            wards.add(new Ward(match, max));
         }
         default -> {
            return false;
         }
      }
      numWards++;
      return true;
   }
   
   //Removes ward from ward array list
   //Returns true if successful, otherwise returns false
   public boolean destroyWard(int index) {
      //Checks if index is in array list
       if (index < numWards){
         numWards--;
         wards.remove(index);
         return true;
       }else{
         return false;
       }
   }
   
   //Creates new staff in staff array list
   //Returns true if successful, otherwise returns false
   public boolean addStaff(String name, double salary, double overtime) {
      //Prompt user for type of staff
      System.out.println("Select staff to add:\n(1) Doctor\n(2) Medical\n(3) Admin\n(4) Other");
      switch (sc.nextInt()) {
         case 1 -> {
            //Prompts for specialty if doctor is selected
            System.out.println("Enter the doctor's specialty:\n");
            String specialty = sc.nextLine();
            staff.add(new Doctor(specialty, name, salary, overtime));
         }
         case 2 -> {
            staff.add(new Medical(name, salary, overtime));
         }
         case 3 -> {
            staff.add(new Admin(name, salary, overtime));
         }
         case 4 -> {
            staff.add(new Staff(name, salary, overtime));
         }
         default -> {
            return false;
         }
      }
      numStaff++;
      return true;
   }
   
   //Removes staff from staff array list
   //Returns true if successful, otherwise returns false
   public boolean removeStaff(String id) {
      //Checks if any staff have a matching employee number
       for (int i = 0; i < staff.size(); i++){
         if (staff.get(i).getEmployeeNum.equals(id)){
            staff.remove(i);
            return true;
         }
       }
       return false;
   }
   
   //Adds or Removes equipment from a ward
   //Returns true if successful, otherwise returns false
   public boolean assignEquipment(Ward w) {
      //Prompts user for add or remove
      System.out.println("Select an option:\n(1) Add equipment\n(2) Remove equipment");
      int select = sc.nextInt();
      if (select <= 2 && select >= 1){
         //Prompts user for type of equipment and amount
         System.out.println("Enter an equipment:");
         String type = sc.nextLine();
         System.out.println("Enter an amount:");
         int amount = sc.nextInt();
         //Runs wards methods for adding or removing equipment
         if (select == 1){
            w.addEquipment(type, amount);
         }else{
            w.removeEquipment(type, amount);
         }
         return true;
      }else{
         return false
      }
   }
   
   //Adds patient to patient array list
   //Returns true if successful, otherwise returns false
   public boolean addPatient(String name) {
      //Prompts user for type of patient
      System.out.println("Select patient type to add:\n(1) Normal\n(2) Child");
      switch (sc.nextInt()) {
         case 1 -> {
            patients.add(new Patient(name));
         }
         case 2 -> {
            patients.add(new Child(name));
         }
         default -> {
            return false;
         }
      }
      numPatients++;
      return true;
   }
   
   //Removes patient from patient array list
   //Returns true if successful, otherwise returns false
   public void removePatient(String id) {
      //Checks if any patients have a matching id
      for (int i = 0; i < patients.size(); i++){
         if (patients.get(i).getId.equals(id)){
            patients.remove(i);
            return true;
         }
       }
       return false;
   }
   
   public Ward getWard(int index){
      return ward.get(i);
   }
   
   //Returns array list of patient containing all matches of search for patient
   //Returns null if bad input
   public ArrayList<Patient> searchPatient() {
      //Prompts user for field
      System.out.println("Select field to search by:\n(1) Name\n(2) ID");
      int searchType = sc.nextInt();
      if (searchType >= 1 && searchType <= 2){
         System.out.print("Enter search query: ");
         String search = sc.nextLine();
         ArrayList<Patient> patientList = new ArrayList<Patient>();
         for (int i = 0; i < numPatients; i++){
            if (pSearch(searchType, search, i)){
               patientList.add(patients[i]);
            }
         }
         return patientList;
      }else{
         return null;
      }
   }
   
   private boolean pSearch(int searchType, String search, int index) {
      if (searchType == 1){
         return patients.get(index).matchName(search);
      }else{
         return patients.get(index).matchId(search);
      }
   }
   
   public ArrayList<Staff> searchStaff() {
      System.out.println("Select field to search by:\n(1) Name\n(2) Employee Number");
      int searchType = sc.nextInt();
      if (searchType >= 1 && searchType <= 2){
         System.out.print("Enter search query: ");
         String search = sc.nextLine();
         ArrayList<Staff> staffList = new ArrayList<Staff>();
         for (int i = 0; i < numStaff; i++){
            if (sSearch(searchType, search, i)){
               staffList.add(staff[i]);
            }
         }
         return staffList;
      }else{
         return null;
      }
   }
   
   private boolean sSearch(int searchType, String search, int index) {
      if (searchType == 1){
         return staff.get(index).matchName(search);
      }else{
         return staff.get(index).matchEmployeeNumber(search);
      }
   }
   
   public Patient[] sortPatient() {
      System.out.println("Select field to sort by:\n(1) Name\n(2) Triage");
      int type = sc.nextInt();
      if (type >= 1 && type <= 2){
         Patient[] patientList = new Patient[numPatients];
         for (int i = 0; i < numPatients; i++){
            patientList[i] = patients.get(i);
         }
         boolean sorted = false;
         for (int i = 0; i < numPatients && sorted == false; i++){
            int index = 0;
            sorted = true;
            for (int j = 1; j < numPatients-i; j++){
               if (pSort(type, index, j) < 0){
                  Patient p = patientList[j];
                  patientList[j] = patientList[index];
                  patientList[index] = p;
                  index = j;
                  sorted = false;
               }
            }
         }
         return patientList;
      }else{
         return null;
      }
   }
   
   private int pSort(int type, int index, int other) {
      if (type == 1){
         return patients.get(index).compareName(patients.get(other));
      }else{
         return patients.get(index).compareTriage(patients.get(other));
      }
   }
   
   public Staff[] sortStaff() {
      System.out.println("Select field to sort by:\n(1) Name\n(2) Salary");
      int type = sc.nextInt();
      if (type >= 1 && type <= 2){
         Staff[] staffList = new Staff[numStaff];
         for (int i = 0; i < numPatients; i++){
            staffList[i] = staff.get(i);
         }
         boolean sorted = false;
         for (int i = 0; i < numStaff && sorted == false; i++){
            int index = 0;
            sorted = true;
            for (int j = 1; j < numPatients-i; j++){
               if (sSort(type, index, j) < 0){
                  Staff s = staffList[j];
                  staffList[j] = staffList[index];
                  staffList[index] = s;
                  index = j;
                  sorted = false;
               }
            }
         }
         return staffList;
      }else{
         return null;
      }
   }
   
   private int sSort(int type, int index, int other) {
      if (type == 1){
         return staff.get(index).compareName(staff.get(other));
      }else{
         return staff.get(index).compareSalary(staff.get(other));
      }
   }
   
   public double calculateProfit() {
      double income = budget;
      for (int i = 0; i < numWards; i++){
         income -= wards.get(i).getOperatingCost();
      }
      for (int i = 0; i < numStaff; i++){
         income -= staff.get(i).getMonthlySalary();
      }
      for (int i = 0; i < numPatient; i++){
         income += patient.get(i).bill();
      }
      return income;
   }
   
   public void exportStaff() {
      try{
         BufferedWriter write = new BufferedWriter(new FileWriter(dir + path, true));
         for (int i = 0; i < staff.size(); i++){
            Staff temp = staff.get(i);
            if (temp instanceof Doctor){
               write.write("d\n" + temp.getSpecialty());
            }else if (temp instanceof Medical){
               write.write("m");
            }else if (temp instanceof Admin){
               write.write("a");
            }else{
               write.write("s");
            }
            write.write(temp.getName() + "\n" + temp.getEmployeeNum + "\n" + temp.getSalary() + "\n" + temp.getOvertimeSalary());
         }
      }catch (IOException e){
      }
   }
}
