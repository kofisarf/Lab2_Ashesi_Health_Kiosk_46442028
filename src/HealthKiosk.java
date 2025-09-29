import java.util.Scanner;
public class HealthKiosk {
    public static void main( String[] args){
        Scanner input = new Scanner(System.in);
        char service;
        int metric = 0;
        double weight;
        double height;
        double bmi = 0;
        double roundedBmi = 0;
        double dosage = 0;
        String category;
        final double TABLETS = 250;
        int numberTablet;
        double angle;
        double angleSin = 0;
        double angleCos = 0;
        double angleRad = 0;

        System.out.println("You are welcome");

        //Task 1
        System.out.println("Enter service code (P/L/T/C) :");
        service = input.next().toUpperCase().charAt(0);

        switch (service){
            case 'P':
                System.out.println("Go to: Pharmacy");
                break;
            case 'L':
                System.out.println("Go to: Lab Desk");
                break;
            case 'T':
                System.out.println("Go to: Triage Desk");
                break;
            case 'C':
                System.out.println("Go to: Counseling Desk");
                break;
            default:
                System.out.println("Invalid service code");
                break;
        }

        //Task 2
        if (service == 'T'){
            System.out.println("1. BMI \n2. Dosage round-up\n3. Simple trig helper");
            metric = input.nextInt();

            switch (metric) {
                case 1:
                    System.out.println("Enter your weight in kilogram");
                    weight = input.nextDouble();
                    System.out.println("Enter your height in meters");
                    height = input.nextDouble();

                    bmi = weight / Math.pow(height, 2);
                    roundedBmi = (Math.round(bmi * 10) / 10.0);
                    System.out.println("BMI :" + roundedBmi);

                    if (bmi < 18.5)
                        category = "Underweight";
                    else if (bmi <= 24.9)
                        category = "Normal";
                    else if (bmi <= 29.9)
                        category = "Overweight";
                    else
                        category = "Obese";

                    System.out.println("Category: " + category);
                    break;

                case 2:
                    System.out.println("Enter required dosage in mg");
                    dosage = input.nextDouble();
                    numberTablet = (int) Math.ceil((dosage / TABLETS));
                    System.out.println("Number of tablet :" + numberTablet);
                    break;

                case 3:
                    System.out.println("Enter angle in degree");
                    angle = input.nextDouble();
                    angleRad = Math.toRadians(angle);
                    angleSin = Math.round(Math.sin(angleRad) * 1000) / 1000.0;
                    angleCos = Math.round(Math.cos(angleRad) * 1000) / 1000.0;
                    System.out.println("Angle in sin: " + angleSin);
                    System.out.println("Angle in cos: " + angleCos);
                    break;

            }

        }

        //Task 3
        char randomLetter = (char) (65 + (int)(Math.random() * (26)));
        String studentId = Character.toString(randomLetter);

        studentId = studentId + (3 + (int) (Math.random() * (9 - 2)));
        studentId = studentId + (3 + (int) (Math.random() * (9 - 2)));
        studentId = studentId + (3 + (int) (Math.random() * (9 - 2)));
        studentId = studentId + (3 + (int) (Math.random() * (9 - 2)));

        if (studentId.length() == 5){
            if (Character.isLetter(studentId.charAt(0))){
                if (Character.isDigit(studentId.charAt(1)) && Character.isDigit(studentId.charAt(2)) &&Character.isDigit(studentId.charAt(3)) && Character.isDigit(studentId.charAt(4)))
                    System.out.println("ID is okay");
                else
                    System.out.println("Last 4 characters must be digits");
            }
            else
                System.out.println("First letter must be a string");
        }
        else
           System.out.println("Invalid length");

        // Task 4
        System.out.println("Enter your first name :");
        char base = input.next().toUpperCase().charAt(0);
        char shiftedLetter = (char)('A' + (base - 'A' + 2) % 26);
        String code = Character.toString(shiftedLetter);
        System.out.println(code);
        code = code + studentId.substring(studentId.length()-2);

        if (metric == 1 || metric == 2 || metric == 3) {
            if (metric == 1)
                code = (code + "-" + Math.round(bmi));
            else if (metric == 2)
                code = (code + "-" + Math.round(dosage));
            else
                code = (code + "-" + Math.round(angleSin * 100));
            System.out.println(code);
        }


        // Task 5
        switch (service){
            case 'P':
                System.out.println("Summary : PHARMACY |ID=" + studentId + "| Code=" + code);
                break;
            case 'T':
                if (metric == 1)
                    System.out.println("Summary : TRIAGE |ID=" + studentId + "| bmi=" + roundedBmi + "| Code=" + code);
                else
                    System.out.println("Summary : TRIAGE |ID=" + studentId + "| Code=" + code);
                break;
            case 'L':
                System.out.println("Summary : LAB |ID=" + studentId + "| Code=" + code);
                break;
            case 'C':
                System.out.println("Summary : COUNSELING |ID=" + studentId + "| Code=" + code);
                break;
            default:
                System.out.println("Invalid service code");
                break;
        }

    }
}
