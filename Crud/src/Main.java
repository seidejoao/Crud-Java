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
        List<Object> obj;
        int id;

        while (true) {
            menu();
            System.out.print(" >> ");
            int r = sc.nextInt();
            sc.nextLine();
            switch (r) {
                case 1:
                    String nomeLivro;
                    do {
                        System.out.println("Qual o título do Livro?");
                        System.out.print(" >> ");
                        nomeLivro = sc.nextLine();
                        if (nomeLivro == "" || nomeLivro == null){
                            System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                        } else {
                            break;
                        }
                    } while (true);
                    object.setNome(nomeLivro);

                    String Autor;
                    do {
                        System.out.println("Qual o autor do Livro?");
                        System.out.print(" >> ");
                        Autor = sc.nextLine();
                        if (nomeLivro == "" || nomeLivro == null){
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
                        if (nomeLivro == "" || nomeLivro == null){
                            System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                        } else {
                            break;
                        }
                    } while (true);

                    crud.create(object);

                    System.out.println(crud.getMsg());
                    break;

                case 2:
                    obj = crud.read();
                    for (Object i : obj) {
                        System.out.println(i);
                    }

                    System.out.println(crud.getMsg());
                    break;

                case 3:
                    obj = crud.read();
                    for (Object i : obj) {
                        System.out.println(i);
                    }
                    System.out.println("De qual 'id' quer alterar?");
                    System.out.print(" >> ");
                    id = sc.nextInt();
                    object.setId(id);

                    for (Object i : obj) {
                        if (i.getId() == object.getId()){
                            break;
                        } else {
                            System.out.println("NÃO EXISTE esse objeto!!");
                        }
                    }

                    System.out.println("Qual atributo quer alterar?");
                    System.out.println("1 - Título");
                    System.out.println("2 - Autor");
                    System.out.println("3 - Gênero");
                    System.out.println("4 - Título e Autor");
                    System.out.println("5 - Título e Gênero");
                    System.out.println("6 - Autor e Gênero");
                    System.out.println("7 - Título, Autor e Gênero");
                    System.out.print(" >> ");
                    int rU = sc.nextInt();

                    String nomeCLivro;
                    String cAutor;
                    String cGenero;
                    switch (rU) {
                        case 1:
                            do {
                                System.out.println("Qual o título correto do livro do Livro?");
                                System.out.print(" >> ");
                                nomeCLivro = sc.nextLine();
                                if (nomeCLivro == "" || nomeCLivro == null){
                                    System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                } else {
                                    break;
                                }
                            } while (true);
                            object.setNome(nomeCLivro);
                            break;
                        case 2:
                            do {
                                System.out.println("Qual o autor correto do Livro?");
                                System.out.print(" >> ");
                                cAutor = sc.nextLine();
                                if (cAutor == "" || cAutor == null){
                                    System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                } else {
                                    break;
                                }
                            } while (true);
                            object.setAutor(cAutor);
                            break;
                        case 3:
                            do {
                                System.out.println("Qual o gênero correto do Livro?");
                                System.out.print(" >> ");
                                cGenero = sc.nextLine();
                                if (cGenero == "" || cGenero == null){
                                    System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                } else {
                                    break;
                                }
                            } while (true);
                            object.setGenero(cGenero);
                            break;
                        case 4:
                            do {
                                System.out.println("Qual o título correto do livro do Livro?");
                                System.out.print(" >> ");
                                nomeCLivro = sc.nextLine();
                                if (nomeCLivro == "" || nomeCLivro == null){
                                    System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                } else {
                                    break;
                                }
                            } while (true);
                            object.setNome(nomeCLivro);

                            do {
                                System.out.println("Qual o autor correto do Livro?");
                                System.out.print(" >> ");
                                cAutor = sc.nextLine();
                                if (cAutor == "" || cAutor == null){
                                    System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                } else {
                                    break;
                                }
                            } while (true);
                            object.setAutor(cAutor);
                            break;
                        case 5:
                            do {
                                System.out.println("Qual o título correto do livro do Livro?");
                                System.out.print(" >> ");
                                nomeCLivro = sc.nextLine();
                                if (nomeCLivro == "" || nomeCLivro == null){
                                    System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                } else {
                                    break;
                                }
                            } while (true);
                            object.setNome(nomeCLivro);

                            do {
                                System.out.println("Qual o gênero correto do Livro?");
                                System.out.print(" >> ");
                                cGenero = sc.nextLine();
                                if (cGenero == "" || cGenero == null){
                                    System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                } else {
                                    break;
                                }
                            } while (true);
                            object.setGenero(cGenero);
                            break;
                        case 6:
                            do {
                                System.out.println("Qual o autor correto do Livro?");
                                System.out.print(" >> ");
                                cAutor = sc.nextLine();
                                if (cAutor == "" || cAutor == null){
                                    System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                } else {
                                    break;
                                }
                            } while (true);
                            object.setAutor(cAutor);

                            do {
                                System.out.println("Qual o gênero correto do Livro?");
                                System.out.print(" >> ");
                                cGenero = sc.nextLine();
                                if (cGenero == "" || cGenero == null){
                                    System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                } else {
                                    break;
                                }
                            } while (true);
                            object.setGenero(cGenero);
                            break;
                        case 7:
                            do {
                                System.out.println("Qual o título correto do livro do Livro?");
                                System.out.print(" >> ");
                                nomeCLivro = sc.nextLine();
                                if (nomeCLivro == "" || nomeCLivro == null){
                                    System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                } else {
                                    break;
                                }
                            } while (true);
                            object.setNome(nomeCLivro);

                            do {
                                System.out.println("Qual o autor correto do Livro?");
                                System.out.print(" >> ");
                                cAutor = sc.nextLine();
                                if (cAutor == "" || cAutor == null){
                                    System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                } else {
                                    break;
                                }
                            } while (true);
                            object.setAutor(cAutor);

                            do {
                                System.out.println("Qual o gênero correto do Livro?");
                                System.out.print(" >> ");
                                cGenero = sc.nextLine();
                                if (cGenero == "" || cGenero == null){
                                    System.out.println("O valor NÃO pode ser nulo ou vazio!!");
                                } else {
                                    break;
                                }
                            } while (true);
                            object.setGenero(cGenero);
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                    crud.update(object);

                    System.out.println(crud.getMsg());
                    break;

                case 4:
                    boolean existe = true;
                    obj = crud.read();
                    for (Object i : obj) {
                        System.out.println(i);
                    }
                    System.out.println("\nQual livro pelo 'id' deseja deletar?");
                    System.out.print(" >> ");
                    id = sc.nextInt();

                    object.setId(id);

                    for (Object i : obj) {
                        if (i.getId() == object.getId()){
                            break;
                        } else{
                            existe = false;
                        }
                    }
                    if (existe == false) {
                        System.out.println("NÃO EXISTE esse objeto!!");
                        crud.setMsg("Esse objeto NÃO existe!!");
                    }

                    crud.delete(object.getId());

                    System.out.println(crud.getMsg());
                    break;

                default:
                    System.out.println("Opção inválida");
            }
            do {
                System.out.println("\nDeseja fazer outra operação?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                System.out.print(" >> "); r = sc.nextInt();
                sc.nextLine();
                if (r == 2){
                    System.out.println("Fechando o programa...");
                    return;
                } else if (r != 1) {
                    System.out.println("Opção inválida");
                }
            } while (r != 1);
        }
    }
}
