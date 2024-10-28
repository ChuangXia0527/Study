
interface IMyPrime {
    int[] p = new int[100];

    default void output() {
        for (int i = 0; i < p.length; i++) {
            if (p[i] != 0) {
                System.out.print(p[i] + " ");
            }
        }
        System.out.println();
    }

    public void prime(int X);
}

class CB implements IMyPrime {
    public CB(){
        int[] p = new int[100];
    }
    public void prime(int X) {
        int a = 0;
        for (int i = 2; i < X; i++) {
            if (isPrime(i)) {
                a+=1;
                p[a] = i;
            }
        }
    }
    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

public class calprime {
    public static void main(String[] args) {
        CB objB = new CB();
        objB.prime(100);
        objB.output();
    }
}
