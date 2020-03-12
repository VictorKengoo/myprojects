package Tela.Cadastro;

import Models.ClienteModel;

import java.io.IOException;
import java.util.Scanner;
import Crud.Crud;
import Tela.EnumEstadoConsole;
import Tela.MaquinaEstadoConsole;

public class EstadoConsoleCadastraCliente extends MaquinaEstadoConsole {
    @Override
    public boolean Executa() throws IOException {
        Crud crud = new Crud();
        Boolean sair = false;
        //FuncionarioModel funcionario = new FuncionarioModel();
        Scanner scan = new Scanner(System.in);
        System.out.println("**** CADASTRO DE CLIENTE ****");
        String Registro = String.valueOf(crud.ProxId("Cliente.txt"));
        System.out.println("Escolha a opção desejada:");
        System.out.println("1 - Cadastrar novo cliente");
        System.out.println("2 - Atualizar os dados de um cliente");
        System.out.println("3 - Deletar o registro de um cliente");
        System.out.println("0 - Sair");
        int opcao = scan.nextInt();
        switch(opcao) {
            case 1:
                EnumEstadoConsole.REGISTRA_CLIENTE.getEstadoMaquina();
            case 2:
                EnumEstadoConsole.ATUALIZA_CLIENTE.getEstadoMaquina();
            case 3:
                EnumEstadoConsole.DELETA_CLIENTE.getEstadoMaquina();
            case 0:
                EnumEstadoConsole.MENU_CADASTRO.getEstadoMaquina();
        }

        Registro += scan.nextLine();
        //funcionario.setNome(scan.nextLine());
        System.out.println("Digite o CPF do Cliente:");
        Registro += "|" + scan.nextLine();
        //funcionario.setCPF(scan.nextLine());
        //funcionario.setSalario(Double.parseDouble( scan.nextLine() ));

        crud.Insert(Registro, "Cliente.txt");

        return false;
    }
}
