package FIleExplorer;
import java.io.File;
import java.util.Scanner;

public class SimuladorFileExplorer {
   private File currentDirectory;

   public SimuladorFileExplorer(String path) {
       currentDirectory = new File(path);
   }

   public void pwd() {
       System.out.println("Diretório atual: " + currentDirectory.getAbsolutePath());
   }

   public void ls() {
       String[] files = currentDirectory.list();
       if (files != null) {
           for (String file : files) {
               System.out.println(file);
           }
       } else {
           System.out.println("Diretório vazio");
       }
   }

   public void cd(String path) {
       File newDirectory = new File(currentDirectory, path);
       if (newDirectory.isDirectory()) {
           currentDirectory = newDirectory;
       } else {
           System.out.println("Não é um diretório: " + path);
       }
   }

   public void mkdir(String name) {
       File newDirectory = new File(currentDirectory, name);
       if (newDirectory.mkdir()) {
           System.out.println("Diretório criado: " + name);
       } else {
           System.out.println("Falha ao criar diretório: " + name);
       }
   }

   public void rm(String name) {
       File fileToRemove = new File(currentDirectory, name);
       if (fileToRemove.delete()) {
           System.out.println("Arquivo removido: " + name);
       } else {
           System.out.println("Falha ao remover arquivo: " + name);
       }
   }

   public static void main(String[] args) {
       SimuladorFileExplorer explorer = new SimuladorFileExplorer("/");
       Scanner scanner = new Scanner(System.in);

       while (true) {
           System.out.print("Escolha o comando (pwd, ls, cd, mkdir, rm): ");
           String command = scanner.nextLine();

           switch (command) {
               case "pwd":
                  explorer.pwd();
                  break;
               case "ls":
                  explorer.ls();
                  break;
               case "cd":
                  System.out.print("Nome do diretório: ");
                  String cdDirectory = scanner.nextLine();
                  explorer.cd(cdDirectory);
                  break;
               case "mkdir":
                  System.out.print("Nome da pasta para criar: ");
                  String mkdirDirectory = scanner.nextLine();
                  explorer.mkdir(mkdirDirectory);
                  break;
               case "rm":
                  System.out.print("Nome do arquivo para remover: ");
                  String rmFile = scanner.nextLine();
                  explorer.rm(rmFile);
                  break;
               default:
                  System.out.println("Comando inválido");
                  break;
           }
       }
   }
}