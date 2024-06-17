import java.util.*;

public class HospitalRunner {
    static Hospital hospital = null;
    static boolean exit = false;
    public static void main(String[] args) {
        String name = "";
        char userInput = '0';
        double budget;
        boolean verified;
        Scanner sc = new Scanner(System.in);

        while (true) {
            exit = false;

            if (hospital == null) {
                System.out.println("HOSPITAL PROPERTIES    ");
                System.out.print("Name: ");
                name = sc.nextLine();
                System.out.print("Budget: ");
                budget = Double.parseDouble(sc.nextLine());
                hospital = new Hospital(name, budget);
            }

            System.out.println("\nPlease Login:");

            verified = login();

            if (!verified) exit = true;
            else System.out.println("Welcome to " + name + " hospital!");

            while (!exit) {
                System.out.println("""
                        What aspect of the hospital would you like to manipulate?
                        1. Staff
                        2. Patients
                        3. Wards
                        4. Cash Flow
                        5. Exit Program""");
                do {
                    System.out.println("Enter a choice(1-5): ");
                    userInput = sc.nextLine().charAt(0);
                } while (userInput < '1' || userInput > '5');
                switch (userInput) {
                    case '1':
                        staff();
                        break;

                    case '2':
                        patients();
                        break;

                    case '3':
                        ward();
                        break;
                        
                    case '4':
                        System.out.println(name + " hospital has an income of $" + hospital.calculateProfit());
                        break;
                        
                    case '5':
                        exit = true;
                        break;
                }
            }
        }
    }







    public static void ward() {
        char userInput;
        int index;
        boolean cont = true;
        Scanner sc = new Scanner (System.in);
        ArrayList<Ward> wards = hospital.getWard();

        while (cont) {
            System.out.println("""
                            
                            
                    Ward Options:\s
                    0. Create a Ward
                    1. Delete a Ward
                    2. View Ward Information
                    3. Add Equipment to Storage
                    4. Move Equipment between Wards
                    5. Change operating cost
                    6. Exit Ward
                    7. Exit Program""");
            do {
                System.out.println("Enter a choice(0-6): ");
                userInput = sc.nextLine().charAt(0);
            } while (userInput < '0' || userInput > '7');

            switch (userInput) {

                case '0':
                    hospital.createWard();
                    break;

                case '1':
                    System.out.println("Index of ward to remove:");
                    index = sc.nextInt();
                    hospital.destroyWard(index);
                    break;

                case '2':
                    System.out.println("Storage:\n" + hospital.getStorage() + "\nOther Wards:");
                    for (int i = 0; i < wards.size(); i++) {
                        System.out.println(i + " " + wards.get(i));
                    }
                    break;

                    /*
                case '3':
                    if (!hospital.assignEquipment()) {
                        System.out.println("Failed to complete command");
                    } else{
                        System.out.println("Equipment successfully assigned");
                    }

                     */

                case '4':
                    int num = 0, from, to, quantity;
                    String name;
                    ArrayList<Ward> applicable = new ArrayList<>();

                    System.out.print("Equipment Name: ");
                    name = sc.nextLine();
                    System.out.print("Quantity: ");
                    quantity = sc.nextInt();
                    for (Ward ward: wards) {
                        if (ward.getEquipment(name) != null) applicable.add(ward);
                    }

                    System.out.println("\nGET FROM:");
                    for (Ward ward: applicable) {
                        System.out.println(num + ". " + ward);
                    }
                    do {
                        System.out.print("Enter a Choice: ");
                        from = sc.nextInt();
                    } while (from < 0 || from > applicable.size());


                    num = 0;
                    System.out.println("\nPUT IN:");
                    for (Ward ward: wards){
                        System.out.println(num + ". " + ward);
                        num++;
                    }
                    do {
                        System.out.print("Enter a Choice: ");
                        to = sc.nextInt();
                    } while (to < 0 || to > wards.size());

                    //applicable.get(from).
                    break;


                case '5':
                    int num1 = 0;
                    double cost;
                    for (Ward ward: wards){
                        System.out.println(num1 + ". " + ward);
                        num1++;
                    }
                    do {
                        System.out.print("Enter a Choice: ");
                        index = sc.nextInt();
                    } while (index < 0 || index > wards.size());
                    System.out.println("Old Operating Cost: " + wards.get(index).getBaseOperatingCost());
                    System.out.print("New Operating cost: ");
                    wards.get(index).setBaseOperatingCost(sc.nextDouble());
                    break;

                case '6':
                    cont = false;
                    break;

                case '7':
                    cont = false;
                    exit = true;
                    break;
            }
        }
    }









    public static void patients() { // PATIENT HISTORY ISN'T WORKING //
        String name = "";
        int userChoice = 0, quantity = 0;

        ArrayList<Staff> staff;
        ArrayList<Patient> patients;
        ArrayList<Ward> wards = hospital.getWard();
        Patient[] patientList;
        char userInput;
        boolean cont = true;
        Scanner sc = new Scanner(System.in);

        while (cont) {

            System.out.println("""
                        
                        
                    Patient Options:\s
                    0. Search for Patient
                    1. Sort Patient List
                    2. Admit patient
                    3. Discharge patient
                    4. Assign Doctor                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             \s
                    5. View Patient History
                    6. Change Patient History
                    7. Assign to Ward
                    8. Exit Patient
                    9. Exit Program""");
            do {
                System.out.print("Enter a choice(0-9): ");
                userInput = sc.nextLine().charAt(0);
            } while (userInput < '0' || userInput > '9');

            switch (userInput) {
                case '0':
                    patients = hospital.searchPatient();
                    for (Patient admitted : patients) {
                        System.out.println(admitted);
                        System.out.println();
                    }
                    break;

                case '1':
                    patientList = hospital.sortPatient();
                    for (Patient admitted : patientList) {
                        System.out.println(admitted);
                        System.out.println();
                    }
                    break;

                case '2':
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    hospital.addPatient(name);
                    break;

                case '3':
                    int num = 0;
                    patients = hospital.searchPatient();
                    for (Patient admitted : patients) {
                        System.out.println(num + ". " + admitted.getName() + "\n\tEmployee Number:" + admitted.getId());
                        num++;
                    }

                    do {
                        System.out.print("Enter a choice: ");
                        try {
                            userChoice = Integer.parseInt(sc.nextLine());
                            cont = true;
                        } catch (NumberFormatException e) {
                            cont = false;
                        }
                    } while (!cont && userChoice < patients.size());
                    cont = true;

                    hospital.removePatient(patients.get(userChoice).getId());
                    break;

                case '4': // CHECK FOR IF IN SAME WARD?
                    int number = 0;
                    Patient p;
                    patients = hospital.searchPatient();
                    ArrayList<Medical> medicsAvailable = new ArrayList<>();
                    for (Patient admitted : patients) {
                        System.out.println(number + ". " + admitted.getName() + "\n\tid: " + admitted.getId());
                        number++;
                    }

                    do {
                        System.out.print("Enter a choice: ");
                        try {
                            userChoice = Integer.parseInt(sc.nextLine());
                            cont = true;
                        } catch (NumberFormatException e) {
                            cont = false;
                        }
                    } while (!cont && userChoice < patients.size() && userChoice >= 0);
                    cont = true;

                    p = patients.get(userChoice);

                    staff = hospital.searchStaff();
                    for (Staff member: staff) {
                        if (member instanceof Medical) medicsAvailable.add((Medical)member);
                    }

                    number = 0;
                    for (Medical member : medicsAvailable) {
                        System.out.println(number + ". " + member.getName() + "\n\tid: " + member.getEmployeeNum());
                        number++;
                    }

                    do {
                        System.out.print("Enter a choice: ");
                        try {
                            userChoice = Integer.parseInt(sc.nextLine());
                            cont = true;
                        } catch (NumberFormatException e) {
                            cont = false;
                        }
                    } while (!cont && userChoice < staff.size() && userChoice >= 0);
                    cont = true;

                    if (p.assignMedicalStaff(medicsAvailable.get(userChoice)))
                        System.out.println("Staff member has been assigned!");
                    else System.out.println("Staff member is unavailable!");
                    break;

                case '5':
                    int nums = 0;
                    patients = hospital.searchPatient();
                    for (Patient admitted : patients) {
                        System.out.println(nums + ". " + admitted.getName() + "\n\tEmployee Number:" + admitted.getId());
                        nums++;
                    }

                    do {
                        System.out.print("Enter a choice: ");
                        try {
                            userChoice = Integer.parseInt(sc.nextLine());
                            cont = true;
                        } catch (NumberFormatException e) {
                            cont = false;
                        }
                    } while (!cont && userChoice < patients.size());
                    cont = true;

                    //patients.get(userChoice).
                    break;

                case '6':
                    int numb = 0;
                    patients = hospital.searchPatient();
                    for (Patient admitted : patients) {
                        System.out.println(numb + ". " + admitted.getName() + "\n\tEmployee Number:" + admitted.getId());
                        numb++;
                    }

                    do {
                        System.out.print("Enter a choice: ");
                        try {
                            userChoice = Integer.parseInt(sc.nextLine());
                            cont = true;
                        } catch (NumberFormatException e) {
                            cont = false;
                        }
                    } while (!cont && userChoice < patients.size());
                    cont = true;
                    break;

                case '7':
                    int selection = 0;
                    for (Ward ward: wards);
                    break;

                case '8':
                    cont = false;
                    break;

                case '9':
                    cont = false;
                    exit = true;
                    break;
            }
        }
    }









    public static void staff() {
        String name = "";
        double salary, overtimesalary;
        int userChoice = 0, quantity = 0;

        ArrayList<Staff> staff;
        Staff[] staffList;
        char userInput;
        boolean cont = true;
        Scanner sc = new Scanner(System.in);

        while (cont) {
            System.out.print("Click 'ENTER' to continue: ");
            sc.nextLine();
            System.out.println("""
                        
                        
                    Staff Options:\s
                    0. Search for Staff member
                    1. Sort Staff List
                    2. Hire staff member
                    3. Fire staff member
                    4. Staff uses equipment
                    5. Change Information
                    6. Exit Staff
                    7. Exit Program""");
            do {
                System.out.print("Enter a choice(0-7): ");
                userInput = sc.nextLine().charAt(0);
            } while (userInput < '0' || userInput > '7');

            switch (userInput) {
                case '0':
                    staff = hospital.searchStaff();
                    for (Staff member : staff) {
                        System.out.println(member);
                        System.out.println();
                    }
                     break;

                case '1':
                    staffList = hospital.sortStaff();
                    for (Staff member : staffList) {
                        System.out.println(member);
                        System.out.println();
                    }
                    break;

                case '2':
                    System.out.println("Name: ");
                    name = sc.nextLine();
                    System.out.println("Salary: ");
                    salary = sc.nextDouble();
                    System.out.println("Overtime Salary: ");
                    overtimesalary = sc.nextDouble();
                    hospital.addStaff(name, salary, overtimesalary);
                    break;

                case '3':
                    int num = 0;
                    staff = hospital.searchStaff();
                    for (Staff member : staff) {
                        System.out.println(num + ". " + member.getName() + "\n\tEmployee Number:" + member.getEmployeeNum());
                        num++;
                    }

                    do {
                        System.out.print("Enter a choice: ");
                        try {
                            userChoice = Integer.parseInt(sc.nextLine());
                            cont = true;
                        } catch (NumberFormatException e) {
                            cont = false;
                        }
                    } while (!cont && userChoice < staff.size());
                    cont = true;

                    hospital.removeStaff(staff.get(userChoice).getEmployeeNum());
                    break;

                case '4':
                    int number = 0;
                    staff = hospital.searchStaff();
                    ArrayList<Medical> medics = null;
                    for (Staff member : staff) {
                        if (member instanceof Medical) medics.add((Medical) member);
                    }

                    for (Medical medic : medics) {
                        System.out.println(number + ". " + medic.getName() + "\n\tEmployee Number:" + medic.getEmployeeNum());
                        number++;
                    }

                    do {
                        System.out.print("Enter a choice: ");
                        try {
                            userChoice = Integer.parseInt(sc.nextLine());
                            cont = true;
                        } catch (NumberFormatException e) {
                            cont = false;
                        }
                    } while (!cont && userChoice < medics.size() && userChoice >= 0);
                    cont = true;


                    do {
                        try {
                            System.out.print("Equipment Name: ");
                            name = sc.nextLine();
                            System.out.print("Quantity: ");
                            quantity = Integer.parseInt(sc.nextLine());
                            cont = true;
                        } catch (NumberFormatException e) {
                            cont = false;
                        }
                    } while (!cont);
                    cont = true;

                    if (medics.get(userChoice).useEquipment(name, quantity))
                        System.out.println("Equipment is available and has been marked!");
                    else System.out.println("Equipment is unavailable!");
                    break;

                case '5':
                    int num1 = 0;
                    staff = hospital.searchStaff();
                    for (Staff member : staff) {
                        System.out.println(num1 + ". " + member.getName() + "\n\tEmployee Number:" + member.getEmployeeNum());
                        num1++;
                    }

                    do {
                        System.out.print("Enter a choice: ");
                        try {
                            userChoice = Integer.parseInt(sc.nextLine());
                            cont = true;
                        } catch (NumberFormatException e) {
                            cont = false;
                        }
                    } while (!cont && userChoice < staff.size());
                    cont = true;

                    staff.get(userChoice).updateInformation();
                    break;

                case '6':
                    cont = false;
                    break;

                case '7':
                    cont = false;
                    exit = true;
                    break;
            }
        }
    }

    public static boolean login () {
        ArrayList<Staff> staffMembers;
        ArrayList<Admin> administrators = new ArrayList<>();
        boolean cont;
        int userInput = -1;
        Scanner sc = new Scanner(System.in);
        staffMembers = hospital.getStaff();
        for (Staff staffMember : staffMembers) {
            if (staffMember instanceof Admin) {
                administrators.add((Admin) staffMember);
            }
        }
        for (int i = 0; i < administrators.size(); i++) {
            System.out.println(i +". " + administrators.get(i).getName() + "\tEmployee Number: " + administrators.get(i).getEmployeeNum());
        }
        System.out.println(administrators.size() + ". Exit Program");
        do {
            System.out.print("Enter a choice: ");
            try {
                userInput = Integer.parseInt(sc.nextLine());
                cont = true;
            } catch (NumberFormatException e) {
                cont = false;
            }
        } while (!cont);

        if (userInput == administrators.size()) {
            exit = true;
            return false;
        } else {
            return administrators.get(userInput).login();
        }
    }
}
