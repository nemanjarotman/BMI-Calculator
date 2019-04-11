package core;

public class Health {
    private String errorMessage;
    public String getErrorMessage(){
        return errorMessage;
    }

    public double calculateBMI(double heightCm, double weightKg){
        double bmiIndex = -1;
        if(heightCm <= 0 && weightKg <= 0){
            errorMessage = "Height and weight can't be 0 or less ";
        }else{
            bmiIndex = weightKg / ((heightCm / 100) * (heightCm / 100));
        }

        return bmiIndex;
    }

    public String bmiCategory(double bmiIndex){
        String bmiCat = "";

        if(bmiIndex < 16){
            bmiCat = "Severe Thinness";
        }else if(bmiIndex >= 16 && bmiIndex < 17){
            bmiCat = "Moderate Thinness";
        }else if(bmiIndex >= 17 && bmiIndex < 18.5){
            bmiCat = "Mild Thinness";
        }else if(bmiIndex >= 18.5 && bmiIndex < 25){
            bmiCat = "Normal";
        }else if(bmiIndex >= 25 && bmiIndex < 30){
            bmiCat = "Overweight";
        }else if(bmiIndex >= 30 && bmiIndex < 35){
            bmiCat = "Obese Class 1";
        }else if(bmiIndex >= 35 && bmiIndex < 40){
            bmiCat = "Obese Class 2";
        }else if(bmiIndex > 40){
            bmiCat = "Obese Class 3";
        }
        return bmiCat;
    }
}
