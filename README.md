# ICS4_Culminating
> Create a hospital management system.
## Class Hierarchies
* Hospital -> main class; contains most things
* *Staff*
	* F name: String
	* F id: String
	* F salary: double
	* SC Doctor
		* F patients: Patient[]
	* SC Nurse
		* F patients: Patient[]
	* SC Maintenance
	* SC Administrator
* Patient
	* F name: String
	* F id: String
	* F ward: Ward
	* F symptoms: Symptom[]
	* F record: MedicalHistory
	* F deceased: boolean
	* M bill
* Ward
	* F equipment: Equipment[]
	* F doctors: Doctor[]
	* SC <Wing Name>
		* F name: String
* Equipment
	* F name: String
	* F ward: Ward[]
	* F cost: double
	* SC MaintenanceEquipment
	* SC AdminEquipment
	* SC MedicalEquipment
* *Symptom*
	* F symptoms: Symptom[]
	* SC MildSymptom
	* SC ModerateSymptom
	* SC SevereSymptom
* MedicalHistory
	* F path: String
	* M addRecord
	* M deleteRecord
	* M printRecord
	* M saveRecord
