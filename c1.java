import java.util.Scanner;

public class c1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        here:
        while (n>0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            boolean isFind = false;
            if (b-a >= 2) {
                System.out.println("Yes");
                n--;
                isFind = true;
                continue;
            }
            for (int i=1;i<=b;i++) {
                for (int j=i+1;j<=b;j++) {
                    if (i*j <= a) {
                        int t = a - i*j;
                        if (t<a && t<b) {
                            System.out.println("Yes");
                            isFind = true;
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
                if (isFind) {
                    n--;
                    continue;
                }
            }
            System.out.println("No");
            n--;
        }
    }
}
