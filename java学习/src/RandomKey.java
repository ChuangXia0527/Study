import java.util.Random;
public class RandomKey {
    public static void main(String[] args) {
      int number = 100;
      Random r = new Random();
        for (int i = 0; i < number; i++) {
            StringBuilder password = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                if(j%2==0){
                    int digit = r.nextInt(10);
                    password.append(digit);
                }
                else{
                    char letter = (char) ('A'+Math.random()*26);
                    password.append(letter);
                }
            }
            System.out.println(password);
        }
    }
}
