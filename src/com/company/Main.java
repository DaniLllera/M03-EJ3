package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        List<Datos> datosList = new ArrayList<>();
        LecturaCSV(datosList);
        Menu();

        int n = scanner.nextInt();
        switch(n) {
            case 1:
                datosList.stream().filter(p -> p.getIdentifier() > 4000).forEach(System.out::println);
                break;
            case 2:
                datosList.stream().map(Datos::getUsername).forEach(System.out::println);
                break;
            case 3:
                datosList.stream().map(Datos::getFirstname).distinct().forEach(System.out::println);
                break;
            case 4:
                System.out.println(datosList.stream().mapToInt(Datos::getIdentifier).max());
                break;
            case 5:
                System.out.println(datosList.stream().mapToInt(Datos::getIdentifier).min());
                break;
            case 6:
                System.out.println(datosList.stream().map(Datos::getIdentifier).count());
                break;
            case 7:
                datosList.stream().map(Datos::getLastname).sorted().forEach(System.out::println);
                break;

        }
    }

    private static void Menu() {
        System.out.println(" CONSULTAR DATOS");
        System.out.println("Que opcion quieres?");
        System.out.println("1.-Usuarios con la Identificación mas alta que 4000");
        System.out.println("2.-Mostrar Correos de los Usuarios");
        System.out.println("3.-Mostrar Nombres de Usuarios sin repetir");
        System.out.println("4.-Mostrar la Identificación  mas alta");
        System.out.println("5.-Mostrar la Identificación  mas baja");
        System.out.println("6.-Mostrar Numero total Usuarios registrados");
        System.out.println("7.-Mostrar Segundo nombre de los Usuarios Ordenado alfabeticamente");
    }

    private static List<Datos> LecturaCSV(List<Datos> datos) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String pathCSV = "https://support.staffbase.com/hc/en-us/article_attachments/360009197071/email.csv";
        URL url = new URL(pathCSV);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = bufferedReader.readLine();

        while ((line = bufferedReader.readLine()) != null) {
            String[] attributes = line.split(";");
            Datos dato = datos(attributes);
            datos.add(dato);
        }

        return datos;

    }

    
    private static Datos datos(String[] data) {
        String username = data[0];
        int identifier = Integer.parseInt(data[1]);
        String firstname = data[2];
        String lastname = data[3];

        return new Datos(username, identifier, firstname, lastname);
    }


}
