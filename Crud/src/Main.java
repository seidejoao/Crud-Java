import connection.ConnectionDB;
import crud.CRUD;
import object.Object;

import java.util.Scanner;

public class Main {

    public static void menu(){
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

        menu();
        System.out.print(" >> "); int r = sc.nextInt();
        switch (r) {
            case 1:
                System.out.println("");
                System.out.println("Qual o nome do Livro?");
                System.out.print(" >> ");
                String nomeLivro = sc.next();
                System.out.println("Qual o autor do Livro?");
                System.out.print(" >> ");
                String Autor = sc.next();
                System.out.println("Qual o genero do Livro?");
                System.out.print(" >> ");
                String Genero = sc.next();

                object.setNome(nomeLivro);
                object.setAutor(Autor);
                object.setGenero(Genero);

                crud.create(object);
                return;

            case 4:
                System.out.println("");
                System.out.println("Qual livro deseja deletar?");
                System.out.print(" >> "); int id = sc.nextInt();

                crud.delete(id);
                return;

            default:
                System.out.println("Opção inválida");
        }
    }

}
