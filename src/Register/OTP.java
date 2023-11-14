package Register;

import java.util.Random;

public class OTP {
    public String randomGenerate(){
        String characters = "0123456789";

        StringBuilder randomStringBuilder = new StringBuilder(6);

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomStringBuilder.append(randomChar);
        }

        return randomStringBuilder.toString();
    }

    public boolean sendOTP(String s){
        //Here, the user should receive the otp. However, in our case, we cannot really send the user anything so the function
        //will return true in all cases
        return true;
    }
}
