import connection.ConnectionDB;
import crud.CRUD;
import object.Object;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void menu(){
        System.out.println("|------------------------|");
        System.out.println("| BEM VINDO A BIBLIOTECA |");
        System.out.println("|------------------------|");
        System.out.println("");
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Criar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Deletar");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        CRUD crud = new CRUD();
        Object object = new Object();
        List<Object> obj;
        int id;

        menu();
        System.out.print(" >> "); int r = sc.nextInt();
        switch (r) {
            case 1:
                System.out.println("");
                System.out.println("Qual o título do Livro?");
                System.out.print(" >> ");
                String nomeLivro = sc.next();
                System.out.println("Qual o autor do Livro?");
                System.out.print(" >> ");
                String Autor = sc.next();
                System.out.println("Qual o gênero do Livro?");
                System.out.print(" >> ");
                String Genero = sc.next();

                object.setNome(nomeLivro);
                object.setAutor(Autor);
                object.setGenero(Genero);

                crud.create(object);

                System.out.println(crud.getMsg());
                return;

            case 2:
                obj = crud.read();
                for (Object i : obj) {
                    System.out.println(i);
                }

                System.out.println(crud.getMsg());
                return;

            case 3:
                obj = crud.read();
                for (Object i : obj) {
                    System.out.println(i);
                }
                System.out.println("Qual quer alterar?");
                System.out.print(" >> ");  id = sc.nextInt();
                object.setId(id);
                System.out.println("1 - Título");
                System.out.println("2 - Autor");
                System.out.println("3 - Gênero");
                System.out.println("4 - Título e Autor");
                System.out.println("5 - Título e Gênero");
                System.out.println("6 - Autor e Gênero");
                System.out.println("7 - Título, Autor e Gênero");
                System.out.print(" >> "); int rU = sc.nextInt();

                String nomeCLivro;
                String cAutor;
                String cGenero;
                switch (rU){
                    case 1:
                        System.out.println("Qual o título correto do livro do Livro?");
                        System.out.print(" >> "); nomeCLivro = sc.next();
                        object.setNome(nomeCLivro);
                        break;
                    case 2:
                        System.out.println("Qual o autor correto do Livro?");
                        System.out.print(" >> "); cAutor = sc.next();
                        object.setAutor(cAutor);
                        break;
                    case 3:
                        System.out.println("Qual o gênero correto do Livro?");
                        System.out.print(" >> "); cGenero = sc.next();
                        object.setGenero(cGenero);
                        break;
                    case 4:
                        System.out.println("Qual o título correto do livro do Livro?");
                        System.out.print(" >> ");
                        nomeCLivro = sc.next();
                        System.out.println("Qual o autor correto do Livro?");
                        System.out.print(" >> ");
                        cAutor = sc.next();
                        object.setNome(nomeCLivro);
                        object.setAutor(cAutor);
                        break;
                    case 5:
                        System.out.println("Qual o título correto do livro do Livro?");
                        System.out.print(" >> ");
                        nomeCLivro = sc.next();
                        System.out.println("Qual o gênero correto do Livro?");
                        System.out.print(" >> ");
                        cGenero = sc.next();
                        object.setNome(nomeCLivro);
                        object.setGenero(cGenero);
                        break;
                    case 6:
                        System.out.println("Qual o autor correto do Livro?");
                        System.out.print(" >> "); cAutor = sc.next();
                        System.out.println("Qual o gênero correto do Livro?");
                        System.out.print(" >> "); cGenero = sc.next();
                        object.setAutor(cAutor);
                        object.setGenero(cGenero);
                        break;
                    case 7:
                        System.out.println("Qual o título correto do livro do Livro?");
                        System.out.print(" >> "); nomeCLivro = sc.next();
                        System.out.println("Qual o autor correto do Livro?");
                        System.out.print(" >> "); cAutor = sc.next();
                        System.out.println("Qual o gênero correto do Livro?");
                        System.out.print(" >> "); cGenero = sc.next();
                        object.setNome(nomeCLivro);
                        object.setAutor(cAutor);
                        object.setGenero(cGenero);
                        break;
                    default:
                        System.out.println("Opção inválida");
                        return;
                }
                crud.update(object);
                return;

            case 4:
                obj = crud.read();
                for (Object i : obj) {
                    System.out.println(i);
                }
                System.out.println("");
                System.out.println("Qual livro deseja deletar?");
                System.out.print(" >> "); id = sc.nextInt();

                crud.delete(id);

                System.out.println(crud.getMsg());
                return;

            default:
                System.out.println("Opção inválida");
                return;
        }
    }

}
