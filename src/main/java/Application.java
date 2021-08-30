import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Cipher cipher;
        Scanner scanner = new Scanner(System.in);
        String answer;
        boolean exit = false;

        System.out.print("Enter offset -> ");
        int offset = new Scanner(scanner.nextLine()).nextInt();

        cipher = new Cipher(offset);

        do{
            System.out.println("Enter command to execute:\n/exit\n/offset\n/encrypt\n/decrypt");

            answer = scanner.nextLine();

            if(answer.equals("/exit")){
                exit = true;
            }
            else if(answer.equals("/offset")){
                System.out.print("Enter new offset -> ");
                answer = scanner.nextLine();

                offset = new Scanner(answer).nextInt();

                cipher.setOffset(offset);
            }
            else if(answer.equals("/encrypt")){
                System.out.print("Enter text to get encrypted version -> ");
                answer = scanner.nextLine();

                System.out.println(cipher.encrypt(answer));
            }
            else if(answer.equals("/decrypt")){
                System.out.print("Enter text to get decrypted version -> ");
                answer = scanner.nextLine();

                System.out.println(cipher.decrypt(answer));
            }
        }while(!exit);
    }
}
