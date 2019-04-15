public class Main {

    public static void main(String[] args) {
        System.out.println(Fibonacci(3));
    }

    public static int Fibonacci(int n) {
        if(n==1)  return 1;
        if(n==0)  return 0;
        int f_n2 = 0,f_n1 = 1;
        for(int i = 1;i<n;i++){
            int tmp = f_n1;
            f_n1 = f_n2 + f_n1;
            f_n2 = tmp;
        }
        return f_n1;
    }
    public static int Fibonacci01(int n) {
        if(n==1)  return 1;
        if(n==0)  return 0;
        return Fibonacci01(n-1)+Fibonacci01(n-2);
    }
}
