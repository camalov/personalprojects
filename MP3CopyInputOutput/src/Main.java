
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String fileName;

        System.out.print("Kopyalanacaq faylın adını (uzantısı ilə) daxil edin : ");
        
        fileName = scanner.nextLine();
        ReadWrite copy = new ReadWrite(fileName);
        
        System.out.print("Surəti çıxarılacaq faylın adı : ");
        
        fileName = scanner.nextLine();
        copy.write(fileName);
        
    }
}
