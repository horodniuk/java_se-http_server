package lecture9_multithreading.hometask.copy_file;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CopyFileTaskTest {
    public static void main(String[] args) throws IOException, InterruptedException {
      /*   Path sourcePath = Paths.get("conspect.txt");
        Path destinationPath = Paths.get("resources/files_for_multithread_module/text.txt");
        Task taskCopyFile = new CopyFileTaskThread(sourcePath, destinationPath);
       System.out.println("If you want copy file " +  Paths.get("conspect.txt") + " to "
                           + Paths.get("resources/files_for_multithread_module/text.txt") + " Press Enter");
        Scanner s = new Scanner(System.in);
        if (s.hasNextLine()){
            taskCopyFile.start();

        }
        taskCopyFile.start();
        System.out.println("Download starting");

        String instruction = "Settings: \n 'i' - interrupt \n 'p' - view percent copy \n 'q' - cansel";
        System.out.println(instruction);
        while (true){
            String s = new Scanner(System.in).nextLine();
            if (s.equals("i")){
                taskCopyFile.interrupt();
                System.out.println("Interrupted " + taskCopyFile.getPersentProcesses() + "%");
                break;
            } else if (s.equals("p")){
                System.out.println("Current progress " + taskCopyFile.getPersentProcesses() + "%");
            } else if (s.equals("q")){
                break;
            }
        }*/
    }
}
