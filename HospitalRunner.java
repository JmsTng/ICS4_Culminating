import java.lang.reflect.Array;
import java.util.*;

public class HospitalRunner {
    static Hospital hospital = null;
    static boolean exit = false;
    public static void main(String[] args) {
        String name = "";
        char userInput;
        double budget;
        int wCap, pCap, sCap;
        boolean verified;
        Scanner sc = new Scanner(System.in);

        while (true) {
            exit = false;

            if (hospital == null) {
                System.out.println("HOSPITAL PROPERTIES    ");
                System.out.println("Name:                  ");
                name = sc.nextLine();
                System.out.println("Budget:                ");
                budget = Double.parseDouble(sc.nextLine());
                System.out.println("Maximum # of Wards:    ");
                wCap = Integer.parseInt(sc.nextLine());
                System.out.println("Maximum # of Patients: ");
                pCap = Integer.parseInt(sc.nextLine());
                System.out.println("Maximum # of Staff:    ");
                sCap = Integer.parseInt(sc.nextLine());
                hospital = new Hospital(name, budget, wCap, pCap, sCap);
            }

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

                    case '2':
                        patients();
                }

            }
        }
    }







    public static void ward() {
        int match, max;
        char userInput;
        Scanner sc = new Scanner (System.in);

        System.out.println(""" 
                Ward Options:
                0. Create a Ward
                1. Delete a Ward
                2. View Ward Information
                3. Add Equipment to Ward
                """);
        do {
            System.out.println("Enter a choice(0-3): ");
            userInput = sc.nextLine().charAt(0);
        } while (userInput < '0' || userInput > '3');

        switch (userInput) {
            case '0':


        }
    }









    public static void patients() { // PATIENT HISTORY ISN'T WORKING //
        String name = "";
        int userChoice = 0, quantity = 0;

        ArrayList<Staff> staff;
        ArrayList<Patient> patients;
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
                System.out.println("Enter a choice(0-9): ");
                userInput = sc.nextLine().charAt(0);
            } while (userInput < '0' || userInput > '9');

            switch (userInput) {
                case '0':
                    patients = hospital.searchPatient();
                    for (Patient admitted : patients) {
                        System.out.println(admitted);
                        System.out.println();
                    }

                case '1':
                    patientList = hospital.sortPatient();
                    for (Patient admitted : patientList) {
                        System.out.println(admitted);
                        System.out.println();
                    }

                case '2':
                    System.out.println("Name: ");
                    name = sc.nextLine();
                    hospital.addPatient(name);

                case '3':
                    int num = 0;
                    patients = hospital.searchPatient();
                    for (Patient admitted : patients) {
                        System.out.println(num + ". " + admitted.getName() + "\n\tEmployee Number:" + admitted.getId());
                        num++;
                    }

                    do {
                        System.out.println("Enter a choice: ");
                        try {
                            userChoice = Integer.parseInt(sc.nextLine());
                            cont = true;
                        } catch (NumberFormatException e) {
                            cont = false;
                        }
                    } while (!cont && userChoice < patients.size());
                    cont = true;

                    hospital.removePatient(patients.get(userChoice).getId());

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
                        System.out.println("Enter a choice: ");
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
                        System.out.println("Enter a choice: ");
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

                case '5':
                    int nums = 0;
                    patients = hospital.searchPatient();
                    for (Patient admitted : patients) {
                        System.out.println(nums + ". " + admitted.getName() + "\n\tEmployee Number:" + admitted.getId());
                        nums++;
                    }

                    do {
                        System.out.println("Enter a choice: ");
                        try {
                            userChoice = Integer.parseInt(sc.nextLine());
                            cont = true;
                        } catch (NumberFormatException e) {
                            cont = false;
                        }
                    } while (!cont && userChoice < patients.size());
                    cont = true;

                    patients.get(userChoice).

                case '6':
                    int numb = 0;
                    patients = hospital.searchPatient();
                    for (Patient admitted : patients) {
                        System.out.println(numb + ". " + admitted.getName() + "\n\tEmployee Number:" + admitted.getId());
                        numb++;
                    }

                    do {
                        System.out.println("Enter a choice: ");
                        try {
                            userChoice = Integer.parseInt(sc.nextLine());
                            cont = true;
                        } catch (NumberFormatException e) {
                            cont = false;
                        }
                    } while (!cont && userChoice < patients.size());
                    cont = true;

                case '7':
                    int selection = 0;
                    for (Ward wards: hospital.)

                case '8':
                    cont = false;

                case '9':
                    cont = false;
                    exit = true;
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
            System.out.println("""
                        
                        
                    Staff Options:\s
                    0. Search for Staff member
                    1. Sort Staff List
                    2. Hire staff member
                    3. Fire staff member
                    4. Staff uses equipment
                    5. Send to Ward
                    6. Exit Staff
                    7. Exit Program""");
            do {
                System.out.println("Enter a choice(0-7): ");
                userInput = sc.nextLine().charAt(0);
            } while (userInput < '0' || userInput > '7');

            switch (userInput) {
                case '0':
                    staff = hospital.searchStaff();
                    for (Staff member : staff) {
                        System.out.println(member);
                        System.out.println();
                    }

                case '1':
                    staffList = hospital.sortStaff();
                    for (Staff member : staffList) {
                        System.out.println(member);
                        System.out.println();
                    }

                case '2':
                    System.out.println("Name: ");
                    name = sc.nextLine();
                    System.out.println("Salary: ");
                    salary = sc.nextDouble();
                    System.out.println("Overtime Salary: ");
                    overtimesalary = sc.nextDouble();
                    hospital.addStaff(name, salary, overtimesalary);

                case '3':
                    int num = 0;
                    staff = hospital.searchStaff();
                    for (Staff member : staff) {
                        System.out.println(num + ". " + member.getName() + "\n\tEmployee Number:" + member.getEmployeeNum());
                        num++;
                    }

                    do {
                        System.out.println("Enter a choice: ");
                        try {
                            userChoice = Integer.parseInt(sc.nextLine());
                            cont = true;
                        } catch (NumberFormatException e) {
                            cont = false;
                        }
                    } while (!cont && userChoice < staff.size());
                    cont = true;

                    hospital.removeStaff(staff.get(userChoice).getEmployeeNum());

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
                        System.out.println("Enter a choice: ");
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
                            System.out.println("Equipment Name: ");
                            name = sc.nextLine();
                            System.out.println("Quantity: ");
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

                case '5':


                case '6':
                    cont = false;

                case '7':
                    cont = false;
                    exit = true;
            }
        }
    }

    public static boolean login () {
        ArrayList<Staff> staffMembers;
        ArrayList<Admin> administrators = new ArrayList<>();
        boolean cont;
        int userInput = 0;
        Scanner sc = new Scanner(System.in);
        staffMembers = hospital.searchStaff();
        for (Staff staffMember : staffMembers) {
            if (staffMember instanceof Admin) {
                administrators.add((Admin) staffMember);
            }
        }
        for (int i = 0; i < administrators.size(); i++) {
            System.out.println(i +". " + administrators.get(i).getName() + "\n\tEmployee Number: " + administrators.get(i).getEmployeeNum());
        }
        System.out.println((administrators.size() + 1) + ". Exit Program");
        do {
            System.out.println("Enter a choice: ");
            try {
                userInput = Integer.parseInt(sc.nextLine());
                cont = true;
            } catch (NumberFormatException e) {
                cont = false;
            }
        } while (!cont);

        if (userInput > administrators.size()) {
            exit = true;
            return false;
        } else {
            return administrators.get(userInput).login();
        }
    }
}
