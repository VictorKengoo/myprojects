package Tela.Cadastro.Funcionario.Registra;

import Crud.Crud;
import Tela.EnumEstadoConsole;
import Tela.MaquinaEstadoConsole;

import java.io.IOException;
import java.util.Scanner;

public class EstadoConsoleRegistraFuncionario extends MaquinaEstadoConsole {
    @Override
    public boolean Executa() throws IOException {
        Crud crud = new Crud();
        Scanner scan = new Scanner(System.in);
        String Registro = "";
        System.out.println("------REGISTRO DE NOVOS FUNCIONARIOS-------");
        System.out.println("O novo registro de funcionario possui perfil de gerencia?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        String Tipo = "";
        do {
            if (scan.nextLine() == "1") {
                Registro = String.valueOf(crud.ProxId("Gerente.txt"));
                Tipo = "Gerente.txt";
            } else if (scan.nextLine() == "2") {
                Registro = String.valueOf(crud.ProxId("Funcionario.txt"));
                Tipo = "Funcionario.txt";
            }
        } while (scan.nextLine() != "1" || scan.nextLine() != "2");


        System.out.println("Digite o nome do Funcionario:");
        Registro += "|" + scan.nextLine();
        //funcionario.setNome(scan.nextLine());
        System.out.println("Digite o CPF do Funcionario:");
        Registro += "|" + scan.nextLine();
        System.out.println("Digite o salario do Funcionario:");
        Registro += "|" + scan.nextLine();
        crud.Insert(Registro, Tipo);
        System.out.println("Deseja imprimir novo registro?");
        System.out.println("1 - Imprimir");
        System.out.println("2 - Finalizar");
        //Colocar aqui o metodo de LOG;
        int opcao = scan.nextInt();
        switch(opcao) {
            case 1:
                //Metodo de impressao
                break;
            case 2:
                EnumEstadoConsole.MENU_CADASTRO.getEstadoMaquina();
                break;
        }
        return false;
    }
}