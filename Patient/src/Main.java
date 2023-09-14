import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Patient {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Hospital {
    private List<Patient> registrationQueue;
    private List<String> treatments;
    private Random random = new Random();

    public Hospital() {
        registrationQueue = new ArrayList<>();
        treatments = new ArrayList<>();
        treatments.add("процедуру A");
        treatments.add("процедуру B");
        treatments.add("процедуру C");
        treatments.add("процедуру D");
        treatments.add("процедуру E");
    }

    public void registerPatient(Patient patient) {
        if (registrationQueue.size() < 10) {
            registrationQueue.add(patient);
            System.out.println("Пациент " + patient.getName() + " записан на прием.");
        } else {
            System.out.println("Нет мест в очереди для пациента " + patient.getName() + ".");
        }
    }

    public void startTreatment() {
        System.out.println("Начало приема пациентов:");
        for (Patient patient : registrationQueue) {
            String treatment = getRandomTreatment();
            System.out.println("Для пациента " + patient.getName() + " применяем лечение: " + treatment);
        }
        System.out.println("Все пациенты обслужены.");
        registrationQueue.clear();
    }

    private String getRandomTreatment() {
        int index = random.nextInt(treatments.size());
        return treatments.get(index);
    }
}

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();


        List<Patient> patients = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            patients.add(new Patient("Пациент " + i));
        }


        for (Patient patient : patients) {
            hospital.registerPatient(patient);
        }
 
        hospital.startTreatment();
    }
}
