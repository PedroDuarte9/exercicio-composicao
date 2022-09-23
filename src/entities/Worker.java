package entities;

import entities.enums.WorkerLevel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

    SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
    private String name;
    private WorkerLevel level; // Usando como atributo uma classe de constantes(Enumeração)
    private Double baseSalary;
    //Aqui está a composição
    private Departament departament;
    //Aqui usa-se uma lista pois são vários contratos
    private List<HourContract> contracts = new ArrayList<>();
    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void setContracts(List<HourContract> contracts) {
        this.contracts = contracts;
    }

        public void addContracts(HourContract contract){
       contracts.add(contract);
    }
    public void removeContracts(HourContract contract){
        contracts.remove(contract);
    }

    public Double income(int year, int month){
        double soma = baseSalary;
        Calendar cal = Calendar.getInstance();
            for (HourContract c : contracts) {
                cal.setTime(c.getDate());
                int c_year = cal.get(Calendar.YEAR);
                int c_month = 1 + cal.get(Calendar.MONTH);
                if(year == c_year && month == c_month){
                    soma += c.totalValue();
                }
        }
            return soma;
    }
}
