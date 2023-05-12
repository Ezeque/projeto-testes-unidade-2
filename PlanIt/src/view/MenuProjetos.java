package view;

import controller.ProjetoController;
import controller.TarefaController;
import entity.Projeto;

import java.util.Scanner;

public class MenuProjetos  implements Menu {
    Projeto projeto;

    @Override
    public void exibirConteudo() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 3){
            System.out.println("PROJETOS: \n\n [1] Criar Projeto \n [2] Buscar Projeto \n [3] Voltar");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> exibirCriacaoProjeto();
                case 2 -> exibirBuscaProjeto();
            }
        }
    }

    private void exibirCriacaoProjeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o Nome Do Projeto: ");
        String nome = scanner.nextLine();
        ProjetoController.criaProjeto(Projeto.getNextId(), nome);
        System.out.println("Projeto \"" + nome + "\" Criado com Sucesso!");
    }

    private void exibirBuscaProjeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o Nome Do Projeto: ");
        String nome = scanner.nextLine();
        Projeto projeto = ProjetoController.pesquisarProjetoNome(nome);
        if(projeto.getId() != -1){
            this.projeto = projeto;
            System.out.println(projeto.getNome().toUpperCase() + ":\n ");
            System.out.println(" [1] Editar Nome do Projeto \n [2]Ver Tarefas \n [3] Deletar Projeto \n [4] Voltar");
            int opcao = scanner.nextInt();
            switch (opcao){
                case 1 -> editarProjeto();
                case 2 -> verTarefas();
                case 3 -> confirmarExclusao();
                case 4 -> exibirConteudo();
            }
        }
        else System.out.println("Projeto não encontrado.");
    }

    private void confirmarExclusao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tem Certeza Que Deseja Apagar o Projeto \"" + this.projeto.getNome() + "\"?");
        System.out.println(" [1] Sim \n [2] Não");
        int opcao = scanner.nextInt();
        switch (opcao){
            case 1 -> ProjetoController.excluirProjeto(this.projeto);
        }
    }

    private void verTarefas() {
    }

    private void editarProjeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira Um Novo Nome Para o Projeto:");
        String nome = scanner.nextLine();
        this.projeto.setNome(nome);
        ProjetoController.editarProjeto(this.projeto);
    }
}
