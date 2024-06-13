import Staff.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Hospital {
   private String name;
   private double budget;
   private int numWards;
   private int numPatients;
   private int numStaff;
   
   private ArrayList<Patient> patients = new ArrayList<Patient>();
   private ArrayList<Ward> wards = new ArrayList<Ward>();
   private ArrayList<Staff> staff = new ArrayList<Staff>();
   
   private Scanner sc;

   public Hospital(String name, double budget, int maxWards, int patientCap, int staffCap) {
      this.name = name;
      this.budget = budget;
      this.numWards = 0;
      this.numPatients = 0;
      this.numStaff = 0;
      
      this.sc = new Scanner(System.in);
   }

   public boolean createWard(int match, int max) {
      System.out.println("Select ward type to add:\n(1) ICU\n(2) Oncology\n(3) Emergency\n(4) Paediology\n(5) Other");
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
            wards.add(new Paediology(match, max));
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
   
   public boolean destroyWard(int index) {
       if (index < numWards){
         numWards--;
         wards.remove(index);
         return true;
       }else{
         return false;
       }
   }
   
   public boolean addStaff(String name, String id, double salary, double overtime) {
      System.out.println("Select staff to add:\n(1) Doctor\n(2) Medical\n(3) Admin\n(4) Other");
      switch (sc.nextInt()) {
         case 1 -> {
            staff.add(new Doctor(name, id, salary, overtime));
         }
         case 2 -> {
            staff.add(new Medical(name, id, salary, overtime));
         }
         case 3 -> {
            staff.add(new Admin(name, id, salary, overtime));
         }
         case 4 -> {
            staff.add(new Staff(name, id, salary, overtime));
         }
         default -> {
            return false;
         }
      }
      numStaff++;
      return true;
   }
   
   public boolean removeStaff(int index) {
       if (index < numStaff){
         numStaff--;
         staff.remove(index);
         return true;
       }else{
         return false;
       }
   }
   
   public void assignEquipment() {
   
   }
   
   public void addPatient(String name) {
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
   
   public void removePatient(int index) {
      if (index < numPatients){
         for (int i = index; i < numPatients; i++){
            patients[i] = patients[i+1];
         }
         numPatients--;
         patients[numPatients] = null;
         return true;
      }else{
         return false;
      }
   }
   
   public Arraylist<Patient> searchPatient() {
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
   
   public Arraylist<Staff> searchStaff() {
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
      ...
   }
}
