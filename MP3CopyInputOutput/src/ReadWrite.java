
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadWrite {

    private final ArrayList<Integer> contentByteArray = new ArrayList<>();
    private final String fileName;
    private FileInputStream fis = null;
    private FileOutputStream fos = null;

    public ReadWrite(String fileName) {
        this.fileName = fileName;
    }

    public void read() {

        try {
            fis = new FileInputStream(fileName);
            int value;

            // while dövründə məlumat oxunulur və massivə mənimsədilir.
            try {
                while ((value = fis.read()) != -1) {
                    contentByteArray.add(value);
                }
            } catch (IOException ex) {
                System.out.println("Faylı oxuma zamanı xəta baş verdi.");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Fayl mövcud deyil.");
        } catch (NullPointerException ex) {
            System.out.println("Faylı daxil edin.");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                System.out.println("Faylın bağlanması zamanı xəta baş verdi.");
            }
        }
    }

    public void write(String fileName) {

        read();
        Iterator arrIterator = contentByteArray.iterator();

        if (!arrIterator.hasNext()) {
            System.out.println("Element mövcud deyil.");
            System.exit(0);
        }
        /*
            while (arrIterator.hasNext()) {
            System.out.println(arrIterator.next());
            }
         */
        try {
            fos = new FileOutputStream(fileName);
        } catch (FileNotFoundException ex) {
            System.out.print("Faylın yaradılması vəya müraciəti zamanı xəta baş verdi.\nXəta növü : ");
            ex.printStackTrace();
        }

        // fayl kopiyalanır.
        try {

            long startingTime = System.currentTimeMillis();

            for (int element : contentByteArray) {
                fos.write(element);
            }

            long endTime = System.currentTimeMillis();
            
            int i = (int) (double) 3.2;
            System.out.println(i);
            /*
            for (int i = contentByteArray.size() - 1; i > 0; i--) {
                fos.write(contentByteArray.get(i));
            }
             */
            System.out.println(this.fileName + " faylı uğurla kopyalandı. \nKopyalanan yeni faylın adı : " + fileName + "\n"
                    + "Faylın surətinin çıxarılması üçün sərf olunan zaman ~ " + Math.round((double) (endTime - startingTime) / 1000) + " saniyə.");

        } catch (IOException ex) {
            System.out.println("Fayla informasiya yazılarkən xəta baş verdi.");
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                System.out.println("Faylın bağlanması zamanı xəta baş verdi.");
            }
        }

    }

}
