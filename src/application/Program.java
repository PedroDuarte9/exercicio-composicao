package application;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
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
    public static void main(String[] args) throws ParseException {


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter department's name: ");
        String departamentName = sc.nextLine();


        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = sc.nextLine();

        System.out.print("Level: ");
        String workerLevel = sc.nextLine();

        System.out.print("Base Salary: ");
        Double workerBaseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Departament(departamentName));

        System.out.print("How many contracts to this over ? ");
        int n = sc.nextInt();
        for(int i = 0; i<n; i++) {
            System.out.print("Enter contract" + i + "# data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContracts(contract);

        }
        System.out.println();
        System.out.println("Enter the month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        //SUBSTRING: Retorna uma nova string que é a substring de uma string especificada
        int month = Integer.parseInt(monthAndYear.substring(0,2));//Utilizamos está definição para recortar uma data, nesse caso aqui estamos recortando da posição 0 até a posoção 2 que será o mês
        int year = Integer.parseInt(monthAndYear.substring(3));//nesse caso aqui estamos recortando a partir da posição 3
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartament().getName() );
        System.out.println("Income: " + monthAndYear + " " + worker.income(year, month));


        sc.close();
    }
}
