package application;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.String.format;

/*
 * COMPOSIÇÃO
 *   - É um tipo de associação, que permite que um objeto contenha outro
 *
 *   - Relação "tem-um" ou "tem-varios"
 *
 *   - VANTAGENS:
 *       - Organização: divisão de responsabilidades
 *       - Coesão
 *       - Flexibilidade
 *       - Reuso
 *
 *   - NOTA: embora o símbolo UML para composição(todo-parte) seja o diamante preto,
 *     neste contexto estamos chamando de composição qualquer asociação tipo "tem-um" e "tem-varios".
 *
 *  Atividade: Ler os dados de um trabalhador com N contratos (N fornecido pelo usuário). Depois, solicitar do usuário um mês e mostrar qual foi o salário do funcionário
 *  nesse mês.
 * */
public class Program {
    public static void main(String[] args) {


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        HourContract hourContract = new HourContract();



        System.out.println("Enter department's name: ");
        String departament = sc.nextLine();


        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = sc.nextLine();

        System.out.print("Level: ");
        String workerLevel = sc.nextLine();

        System.out.print("Base Salary: ");
        Double workerBaseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, workerLevel.valueOf(workerLevel), workerBaseSalary, departament);

        System.out.print("How many contracts to this over ? ");
        int n = sc.nextInt();
        for(int i = 0; i>n; i++) {
            System.out.print("Enter contract" + i + "# data: ");
            System.out.print("Date (DD/MM/YYYY): ");


            System.out.print("Value per hour: ");
            hourContract.setValuePerHour(sc.nextDouble());
            System.out.print("Duration (hours): ");
            hourContract.setHours(sc.nextInt());

        }

        System.out.println("Enter the month and year to calculate income");

//        System.out.println("Name " + worker.getName());
//        System.out.println("Departament " + departament.getName());
//        System.out.println("Income for 08/2018: " + worker.income(2022,8));


        sc.close();
    }
}
