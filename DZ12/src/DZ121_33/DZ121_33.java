package DZ121_33;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.*;

public class DZ121_33 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input catalog:");
        ArrayList <File> catalogs;
        ArrayList<String> files = new ArrayList<>();//коллекция для файлов
        while (true){
            File file = new File(in.nextLine());
            try{
                catalogs = new ArrayList<>(Arrays.asList(file.listFiles()));//коллекция для директорий и файлов
                break;
            } catch (NullPointerException e){
                System.out.println("Catalog not found");
            }
        }
        System.out.println("Catalogs:");
        for (int i = 0; i<catalogs.size(); i++){
            if(catalogs.get(i).isDirectory()) {//является ли объект File директорией?
                System.out.println(catalogs.get(i));//если директория, печатаем путь
                ArrayList<File> temp;
                try {
                    temp = new ArrayList<>(Arrays.asList(catalogs.get(i).listFiles()));//коллекция для хранения вложенных файлов и директорий
                } catch (NullPointerException e ){
                    temp=new ArrayList<>();
                }
                for (int j=0; j<temp.size(); j++){//добавляем вложенные файлы и директории в основную коллекцию
                    catalogs.add(i+1+j, temp.get(j));
                }
            } else {files.add(catalogs.get(i).getName());}//если файл не директория - сохраняем имя в коллецию файлов
        }
        System.out.println();
//       печатаем коллекцию файлов
        System.out.println("Files: ");
        for(int i = 0; i<files.size(); i++){
            System.out.println(files.get(i));
        }
    }
}

