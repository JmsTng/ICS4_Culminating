import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Storage extends Ward {
    Scanner sc = new Scanner(System.in);

    public Storage() {
        this.numEquipment = 0;
        this.numPatient = 0;
        this.numMedical = 0;
        this.baseOperatingCost = 10000;
    }

    public double getOperatingCost() {
        double total = 0;
        for (Equipment equipment : equipmentList) {
            total += equipment.getMaintenanceCost() * equipment.getQuantity();
        }
        total /= 10;
        total += baseOperatingCost;
        return total;
    }

    public boolean addEquipment(String name, int num) {
        if (this.totalEquipment() < maxEquipment) {
            for (Equipment equipment : equipmentList) {
                if (Objects.equals(equipment.getName(), name)) {
                    equipment.setQuantity(equipment.getQuantity() + num);
                    return true;
                    //return true if equipment was added to existing object within array
                }
            }
            System.out.println("Enter in maintenance cost of new equipment: ");
            double cost = sc.nextInt();
            equipmentList.add(new Equipment(this, name, num, cost));
            return true;
            //or, return true if new equipment was made and added to array
        }
        return false;
    }

    public boolean addEquipment(Equipment e, int num) {
        if (this.totalEquipment() < maxEquipment) {
            for (Equipment equipment : equipmentList) {
                if (Objects.equals(equipment.getName(), e.getName())) {
                    equipment.setQuantity(equipment.getQuantity() + num);
                    return true;
                    //return true if equipment was added to existing object within array
                }
            }
            equipmentList.add(new Equipment(this, e.getName(), num, e.getMaintenanceCost()));
            //or, return true if new equipment was made and added to array
        }
        return false;
    }

    public boolean removeEquipment(String name, int num) {
        for (int i = 0; i < equipmentList.size(); i++) {
            if (Objects.equals(equipmentList.get(i).getName(), name)) {
                equipmentList.remove(i);
                numEquipment--;
                return true;
                //return true if equipment with matching name succesfully REMOVED from array
            }
        }
        return false;
        //return false if equipment with name not found
    }

    public boolean removeEquipment(Equipment e, int num) {
        for (int i = 0; i < equipmentList.size(); i++) {
            if (Objects.equals(equipmentList.get(i).getName(), e.getName())) {
                equipmentList.remove(i);
                numEquipment--;
                return true;
                //return true if equipment with matching name succesfully REMOVED from array
            }
        }
        return false;
        //return false if equipment with name not found
    }

    public boolean moveEquipment(Ward w, Equipment e, int num) {
        for (int i = 0; i < equipmentList.size(); i++) {
            if (Objects.equals(equipmentList.get(i).getName(), e.getName())) {
                equipmentList.remove(i);
                w.addEquipment(e, num);
                numEquipment--;
                return true;
                //return true if equipment with matching name succesfully REMOVED from array
            }
        }
        return false;
        //return false if equipment with name not found
    }

    public int totalEquipment() {
        int sum = 0;
        for (Equipment equipment : equipmentList) {
            sum += equipment.getQuantity();
        }
        return sum;
    }

    public boolean determineSuitability(Patient p) {
        //if for some reason they run this on Storage, return false
        return false;
    }

    public String toString() {
        return "Equipment Storage\nNumber of Equipment: " + this.totalEquipment();
    }
}