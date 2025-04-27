import crud.CRUD;
import object.Object;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void menu(){
        System.out.println("|------------------------|");
        System.out.println("| BEM VINDO A BIBLIOTECA |");
        System.out.println("|------------------------|");
        System.out.println("\nO que deseja fazer?");
        System.out.println("1 - Criar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Deletar");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CRUD crud = new CRUD();
        Object object = new Object();
        List<Object> lista;
        int id;
        boolean existe = false;

        while (true) {
            menu();
            System.out.print(" >> ");
            int resposta = sc.nextInt();
            sc.nextLine();
            switch (resposta) {
                case 1:
                    String nomeLivro;
                    do {
                        System.out.println("Qual o título do Livro?");
                        System.out.print(" >> ");
                        nomeLivro = sc.nextLine();
                        if (nomeLivro.isEmpty()){
                            System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                        } else {
                            break;
                        }
                    } while (true);
                    object.setTitulo(nomeLivro);

                    String Autor;
                    do {
                        System.out.println("Qual o autor do Livro?");
                        System.out.print(" >> ");
                        Autor = sc.nextLine();
                        if (Autor.isEmpty()){
                            System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                        } else {
                            break;
                        }
                    } while (true);
                    object.setAutor(Autor);

                    do {
                        System.out.println("Qual o gênero do Livro?");
                        System.out.print(" >> ");
                        String Genero = sc.nextLine();
                        object.setGenero(Genero);
                        if (Genero.isEmpty()){
                            System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                        } else {
                            break;
                        }
                    } while (true);

                    crud.setMsg("\nOBJETO CRIADO COM SUCESSO!!\n");

                    crud.create(object);

                    System.out.println(crud.getMsg());
                    break;

                case 2:
                    lista = crud.read();
                    if(lista.isEmpty()){
                        crud.setMsg("\nNÃO EXISTEM OBJETOS!!\n");
                        System.out.println(crud.getMsg());
                        break;
                    } else if(lista == null){
                        crud.setMsg("\nNÃO EXISTEM OBJETOS!!\n");
                        System.out.println(crud.getMsg());
                        break;
                    } else if(lista.size() == 0){
                        crud.setMsg("\nNÃO EXISTEM OBJETOS!!\n");
                        System.out.println(crud.getMsg());
                        break;
                    } else{
                        for (Object i : lista) {
                            System.out.println(i);
                        }

                        crud.setMsg("\nOBJETOS LISTADOS COM SUCESSO!!\n");

                        System.out.println(crud.getMsg());

                        break;
                    }

                case 3:
                    while (true) {
                        lista = crud.read();
                        for (Object i : lista) {
                            System.out.println(i);
                        }
                        System.out.println("De qual 'id' quer alterar?");
                        System.out.print(" >> ");
                        id = sc.nextInt();

                        for (Object i : lista) {
                            if (i.getId() == id){
                                existe = true;
                                break;
                            }
                        }
                        if (!existe) {
                            crud.setMsg("\nESSE OBJETO NÃO EXISTE!!\n");
                        } else{
                            while (true) {
                                System.out.println("Qual atributo quer alterar?");
                                System.out.println("1 - Título");
                                System.out.println("2 - Autor");
                                System.out.println("3 - Gênero");
                                System.out.println("4 - Título e Autor");
                                System.out.println("5 - Título e Gênero");
                                System.out.println("6 - Autor e Gênero");
                                System.out.println("7 - Título, Autor e Gênero");
                                System.out.print(" >> ");
                                int idUpdate = sc.nextInt();
                                sc.nextLine();

                                String tituloCorrigidoLivro;
                                String corrigidoAutor;
                                String corrigidoGenero;
                                switch (idUpdate) {
                                    case 1:
                                        do {
                                            System.out.println("Qual o título correto do Livro?");
                                            System.out.print(" >> ");
                                            tituloCorrigidoLivro = sc.nextLine();
                                            if (tituloCorrigidoLivro.isEmpty()){
                                                System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                            } else {
                                                break;
                                            }
                                        } while (true);
                                        crud.updateTitulo(tituloCorrigidoLivro, id);
                                        break;
                                    case 2:
                                        do {
                                            System.out.println("Qual o autor correto do Livro?");
                                            System.out.print(" >> ");
                                            corrigidoAutor = sc.nextLine();
                                            if (corrigidoAutor.isEmpty()){
                                                System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                            } else {
                                                break;
                                            }
                                        } while (true);
                                        crud.updateAutor(corrigidoAutor, id);
                                        break;
                                    case 3:
                                        do {
                                            System.out.println("Qual o gênero correto do Livro?");
                                            System.out.print(" >> ");
                                            corrigidoGenero = sc.nextLine();
                                            if (corrigidoGenero.isEmpty()){
                                                System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                            } else {
                                                break;
                                            }
                                        } while (true);
                                        crud.updateGenero(corrigidoGenero, id);
                                        break;
                                    case 4:
                                        do {
                                            System.out.println("Qual o título correto do livro do Livro?");
                                            System.out.print(" >> ");
                                            tituloCorrigidoLivro = sc.nextLine();
                                            if (tituloCorrigidoLivro.isEmpty()){
                                                System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                            } else {
                                                break;
                                            }
                                        } while (true);

                                        do {
                                            System.out.println("Qual o autor correto do Livro?");
                                            System.out.print(" >> ");
                                            corrigidoAutor = sc.nextLine();
                                            if (corrigidoAutor.isEmpty()){
                                                System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                            } else {
                                                break;
                                            }
                                        } while (true);
                                        crud.updateTituloAutor(tituloCorrigidoLivro, corrigidoAutor, id);
                                        break;
                                    case 5:
                                        do {
                                            System.out.println("Qual o título correto do livro do Livro?");
                                            System.out.print(" >> ");
                                            tituloCorrigidoLivro = sc.nextLine();
                                            if (tituloCorrigidoLivro.isEmpty()){
                                                System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                            } else {
                                                break;
                                            }
                                        } while (true);

                                        do {
                                            System.out.println("Qual o gênero correto do Livro?");
                                            System.out.print(" >> ");
                                            corrigidoGenero = sc.nextLine();
                                            if (corrigidoGenero.isEmpty()){
                                                System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                            } else {
                                                break;
                                            }
                                        } while (true);
                                        crud.updateTituloGenero(tituloCorrigidoLivro, corrigidoGenero, id);
                                        break;
                                    case 6:
                                        do {
                                            System.out.println("Qual o autor correto do Livro?");
                                            System.out.print(" >> ");
                                            corrigidoAutor = sc.nextLine();
                                            if (corrigidoAutor.isEmpty()){
                                                System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                            } else {
                                                break;
                                            }
                                        } while (true);

                                        do {
                                            System.out.println("Qual o gênero correto do Livro?");
                                            System.out.print(" >> ");
                                            corrigidoGenero = sc.nextLine();
                                            if (corrigidoGenero.isEmpty()){
                                                System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                            } else {
                                                break;
                                            }
                                        } while (true);
                                        crud.updateAutorGenero(corrigidoAutor, corrigidoGenero, id);
                                        break;
                                    case 7:
                                        do {
                                            System.out.println("Qual o título correto do livro do Livro?");
                                            System.out.print(" >> ");
                                            tituloCorrigidoLivro = sc.nextLine();
                                            if (tituloCorrigidoLivro.isEmpty()){
                                                System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                            } else {
                                                break;
                                            }
                                        } while (true);
                                        object.setTitulo(tituloCorrigidoLivro);

                                        do {
                                            System.out.println("Qual o autor correto do Livro?");
                                            System.out.print(" >> ");
                                            corrigidoAutor = sc.nextLine();
                                            if (corrigidoAutor.isEmpty()){
                                                System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                            } else {
                                                break;
                                            }
                                        } while (true);
                                        object.setAutor(corrigidoAutor);

                                        do {
                                            System.out.println("Qual o gênero correto do Livro?");
                                            System.out.print(" >> ");
                                            corrigidoGenero = sc.nextLine();
                                            if (corrigidoGenero.isEmpty()){
                                                System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                            } else {
                                                break;
                                            }
                                        } while (true);
                                        object.setGenero(corrigidoGenero);
                                        crud.updateTituloAutorGenero(object);
                                        crud.setMsg("\nOBJETO ALTERADO COM SUCESSO!!\n");
                                        break;
                                    default:
                                        System.out.println("Opção inválida");
                                        continue;
                                }

                                System.out.println(crud.getMsg());
                                return;
                            }
                        }
                    }

                case 4:
                    lista = crud.read();
                    while (true) {
                        for (Object i : lista) {
                            System.out.println(i);
                        }
                        System.out.println("\nQual livro pelo 'id' deseja deletar?");
                        System.out.print(" >> ");
                        id = sc.nextInt();

                        object.setId(id);

                        for (Object i : lista) {
                            if (i.getId() == object.getId()){
                                existe = true;
                                break;
                            }
                        }
                        if (!existe) {
                            crud.setMsg("\nESSE OBJETO NÃO EXISTE!!\n");
                        } else {
                            crud.setMsg("\nOBJETO DELETADO COM SUCESSO!!\n");

                            crud.delete(object.getId());
                            break;
                        }
                        System.out.println(crud.getMsg());
                    }

                    System.out.println(crud.getMsg());
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            do {
                System.out.println("\nDeseja fazer outra operação?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                System.out.print(" >> "); resposta = sc.nextInt();
                sc.nextLine();
                if (resposta == 2){
                    System.out.println("Fechando o programa...");
                    return;
                } else if (resposta != 1) {
                    System.out.println("Opção inválida");
                }
            } while (resposta != 1);
        }
    }
}
