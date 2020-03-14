package Tela;

//Alterar o metodo de validação de usuario e senha para chamar os nossos metodos.

import Crud.Crud;
import Models.FuncionarioModel;
import Models.Usuario;
import Tela.Cadastro.Singleton.Config;

import java.io.IOException;
import java.util.Scanner;

public class EstadoConsoleLogin extends MaquinaEstadoConsole {

    public boolean Executa() throws IOException {
        boolean sair = false;
        Crud crud = new Crud();
        FuncionarioModel user = new FuncionarioModel();
        String usuario = null;
        String password = null;

        Scanner scan = new Scanner(System.in);
        System.out.println("**** LOGIN ****");

        while(crud.ProcuraUser(usuario) == null){
            System.out.println("Digite seu usuário: ");
            usuario = scan.nextLine();

            if(crud.ProcuraUser(usuario) == null){
                System.out.println("Usuário não existe !");
            }
        }

        while(crud.ProcuraUser(usuario) == null){
            System.out.println("Digite sua senha: ");
            password = scan.nextLine();

            if(crud.ProcuraUser(usuario).split("|")[2] != password){
                System.out.println("Senha errada!");
            }
        }

        Usuario UsuarioLogado = new Usuario();
        UsuarioLogado.setUsername(usuario);
        UsuarioLogado.setPassword(password);
        UsuarioLogado.setFuncionarioId(Integer.parseInt(crud.ProcuraUser(usuario).split("|")[3]));
        UsuarioLogado.setTipoUsuario(Integer.parseInt(crud.ProcuraUser(usuario).split("|")[4]));

        Config.getInstance().setUsuario(UsuarioLogado);
        EnumEstadoConsole.MENU_CADASTRO.getEstadoMaquina();
        return true;
    }
}
