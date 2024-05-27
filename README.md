# ICS4_Culminating
| Create a hospital management system.
## Class Hierarchies
* Hospital -> main class; contains most things
* Staff
	* F name: String
	* F salary: double
	* SC Doctors
	* SC Nurses
	* SC Janitors
	* SC Administrators
* Patients
	* F sector: Department
	* F symptoms: Symptom[]
	* M bill
* Department
	* F equipment: Equipment[]
	* SC Wing
		* F name: String
* Equipment
	* F name: String
	* F sectors: Sector[]
	* F cost: double
* Symptom
	* F symptoms: Symptom[]