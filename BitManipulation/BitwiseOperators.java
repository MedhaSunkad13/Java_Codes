package BitManipulation;

public class BitwiseOperators {
    public static void main(String[] args) {
        
        //Bitwise AND
        System.out.println("Bitwise AND: " + (5 & 6));

        //Bitwise OR
        System.out.println("Bitwise OR: " + (5 | 6));

        //Bitwise XOR
        System.out.println("Bitwise XOR: " + (5 ^ 6));

        //Bitwise NOT
        System.out.println("Bitwise NOT: " + (~1));

        //Bitwise Left Shift
        System.out.println("Bitwise Left Shift: " + (5 << 30));

        // x >>> 1
        // 01111111 11111111 11111111 11111100  → 2147483644

        // x >> 1
        // 11111111 11111111 11111111 11111100  → -4

        //Check odd or even
        int n = 18;
        if((n & 1) == 0) {
            System.out.println("Even Number");
        }
        else{
            System.out.println("Odd Number");
        }

        int cnt = 0;
        int orgNum = n;
        while(n != 0) {
            if((n & 1) == 1){
                cnt += 1;
            }

            //Right shift by one position
            n = n >> 1;
        }

        System.out.println("Count of set bits in " + orgNum + ": " + cnt);

        //Swap two numbers using XOR
        int a = 10, b = 20;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a = " +a + " " + "b = " + b);

        //Remove last set bit
        int num = 15;
        num = num & (num - 1);
        System.out.println(num);

        //Count number of set bits
        int number = 15;
        int ct = 0;
        while(number != 0) {
            if(( number & 1 ) == 1) {
                ct++;
            }
            number = number >> 1;
        }

        System.out.println(ct);

        int arr[] = {1, 2, 2, 4};
        int xor = 1;

        for(int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }

        System.out.println(xor);
    }   
}
