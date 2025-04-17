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

        menu();
        System.out.print(" >> "); int r = sc.nextInt();
        switch (r) {
            case 1:
                System.out.println("");
                System.out.println("Qual o título do Livro?");
                System.out.print(" >> "); String nomeLivro = sc.next();
                System.out.println("Qual o autor do Livro?");
                System.out.print(" >> "); String Autor = sc.next();
                System.out.println("Qual o gênero do Livro?");
                System.out.print(" >> "); String Genero = sc.next();

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



            case 4:
                obj = crud.read();
                for (Object i : obj) {
                    System.out.println(i);
                }
                System.out.println("");
                System.out.println("Qual livro deseja deletar?");
                System.out.print(" >> "); int id = sc.nextInt();

                crud.delete(id);

                System.out.println(crud.getMsg());
                return;

            default:
                System.out.println("Opção inválida");
        }
    }

}
