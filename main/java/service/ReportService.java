package service;

import model.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReportService {
    public static Employee loadReport(){
        List<String> partTime = new ArrayList<>();
        List<String> fullTime = new ArrayList<>();
        Path caminho = Paths.get("src/data/funcionarios.txt");
        double mediaS = 0;
        double total = 0;
        double temp = 0;
        double temp2 = 0;

        try {
            List<String> linhas = Files.readAllLines(caminho);
                for (String linha : linhas){
                String [] partes = linha.split(";");
                if (partes[0].equalsIgnoreCase("Terceirizado")){
                    partTime.add(linha);
                } else if (partes[0].equalsIgnoreCase("Efetivo")) {
                    fullTime.add(linha);
                }
                if (partes[0].equalsIgnoreCase("Efetivo")){
                    temp = Double.parseDouble(partes[2]);
                } else {
                    temp2 = Double.parseDouble(partes[2]) + Double.parseDouble(partes[3]);
                }
                total = temp + temp2;
                mediaS = total / (fullTime.size() + partTime.size());

        }
        System.out.println("Quantidade de funcionários terceirizados: " + partTime.size());
            System.out.println("Quantidade de funcionários efetivados: " + fullTime.size());
            System.out.println("Total de salário: " + total);
            System.out.println("Média de salário: " + mediaS);

        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
