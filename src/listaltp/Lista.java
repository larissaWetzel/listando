package listaltp;

import java.util.Scanner;

public class Lista {

    static Usuario inicio = null;
    static Usuario fim = null;
    static int qnt = 0;
    static Scanner aux = new Scanner(System.in);

    public static void main(String[] args) {
        int x = 0;
        do {
            menu();
            x = pedeInt("Informe a opção desejada:", 0, 11);

            switch (x) {
                case 1:
                    criaLista();
                    break;
                case 2:
                    inserirI();
                    break;
                case 3:
                    InserirF();
                    break;
                case 4:
                    mostra();
                    break;
                case 5:
                    verificaU();
                    break;
                case 6:
                    removeEspecifico();
                    break;
                case 7:
                    removeP();
                    break;
                case 8:
                    removeU();
                    break;
                case 9:
                    mostraIF();
                    break;
                case 10:
                    mostraFI();
                    break;
            }
        } while (x != 0);
    }

    public static void menu() {
        System.out.println("Menu ******** \n"
                + "1 - Criar lista. \n"
                + "2 - Inserir usuário no início da lista. \n"
                + "3 - inserir usuário no final da lista. \n"
                + "4 - Mostrar lista. \n"
                + "5 - Vereficar se existe um usuário especifico na lista. \n"
                + "6 - Remover um usuário especifico. \n"
                + "7 - Remover primeiro usuário da lista. \n"
                + "8 - Remover ultimo usuário da lista. \n"
                + "9 - Mostrar lista do início ao fim. \n"
                + "10 - Mostrar lista do fim ao início. \n"
                + "0 - Sair.");
    }

    public static Usuario criandoU() {
        Usuario u = new Usuario();
        u.setNome(pedeString("Informe o nome do usuário(> 1 e < 50 caracteres).", 1, 50));
        return u;
    }

    public static void criaLista() {
        inicio = criandoU();
        fim = inicio;
        inicio.setProximo(fim);
        fim.setProximo(null);
        qnt = qnt + 1;
    }

    public static void inserirI() {
        if (qnt == 0) {
            System.out.println("Lista vazia \n"
                    + "...craindo nova lista...");
            criaLista();
        } else {
            Usuario u = criandoU();
            u.setProximo(inicio);
            inicio = u;
        }
    }

    public static void InserirF() {
        if (qnt == 0) {
            System.out.println("Lista vazia \n"
                    + "...craindo nova lista...");
            criaLista();
        } else {
            Usuario u = criandoU();
            fim.setProximo(u);
            fim = u;
        }

    }

    public static void mostra() {
        if (qnt == 0) {
            System.out.println("Lista vazia \n"
                    + "...craindo nova lista...");
        } else {
            Usuario atual = inicio;
            while (atual != null) {
                System.out.println("-> " + atual.getNome());
                atual = atual.getProximo();
            }
        }

    }

    public static void verificaU() {
        if (qnt == 0) {
            System.out.println("Lista vazia \n"
                    + "...craindo nova lista...");
            criaLista();
        }
        boolean existe = false;
        Usuario atual;
        String nome = pedeString("Informe o nome do usuario (1 a 50 caracteres)", 1, 50);
        atual = inicio;
        while (atual != null) {
            if (atual.getNome().equals(nome)) {
                existe = true;
                break;
            }
            atual = atual.getProximo();
        }
        if (existe) {
            System.out.println("O nome existe na lista");
        } else {
            System.out.println("O nome existe na lista");
        }

    }

    public static void removeEspecifico() {
        if (qnt == 0) {
            System.out.println("Lista vazia \n"
                    + "...craindo nova lista...");
            criaLista();
        }
        Usuario atual;
        String nome = (pedeString("Informe o nome a ser excluído", 1, 100));
        if (nome.equals(inicio.getNome())) {
            removeP();
        } else if (nome.equals(fim.getNome())) {
            removeU();
        } else {
            atual = inicio;
            while (atual != null) {
                if (atual.getNome().equals(nome)) {
                    Usuario anterior = usuarioAntes(atual);
                    anterior.setProximo(atual.getProximo());
                    System.out.println("O nome: " + nome + ", foi removido com succeso");
                    break;
                }
                atual = atual.getProximo();
            }
        }

    }

    public static void removeP() {
        if (qnt == 0) {
            System.out.println("Lista vazia \n"
                    + "...craindo nova lista...");
        } else {
            //retira o inicio da lista.
            System.out.println("O nome: " + inicio.getNome() + ", foi removido com succeso");
            inicio = inicio.getProximo();

        }

    }

    public static void removeU() {
        if (qnt == 0) {
            System.out.println("Lista vazia \n"
                    + "...craindo nova lista...");
        } else {
            if (inicio == fim) {
                System.out.println("O nome: " + inicio.getNome() + ", foi removido com succeso");
                inicio = null;
                fim = null;
            } else {
                Usuario atual = inicio;
                while (atual != null) {
                    if (atual.getProximo().getProximo() == null) {
                        atual.setProximo(null);
                        System.out.println("O nome: " + fim.getNome() + ", foi removido com succeso");
                        fim = atual;
                        break;
                    }
                    atual = atual.getProximo();
                }
            }
        }

    }

    public static void mostraIF() {
        if (qnt == 0) {
            System.out.println("Lista vazia \n"
                    + "...craindo nova lista...");
        } else {
            //mostra a lista do inicio até o final (método convencional).
            Usuario atual = inicio;
            while (atual != null) {
                System.out.println("-> " + atual.getNome());
                atual = atual.getProximo();
            }
        }

    }

    public static void mostraFI() {
        if (qnt == 0) {
            System.out.println("Lista nula!");
        } else {
            Usuario atual = fim;
            while (atual != null) {
                System.out.println("-" + atual.getNome());
                if (atual != inicio) {
                    atual = usuarioAntes(atual);
                } else {
                    atual = null;
                }
            }
        }        

    }

    public static int pedeInt(String m, int min, int max) {
        int retorno = min - 1;
        return retorno;
    }

    public static String pedeString(String msg, int min, int max) {
        String retorno = "";
        boolean erro;
        do {
            erro = false;
            Scanner x = new Scanner(System.in);
            try {
                System.out.println(msg);
                retorno = x.next();
                if (retorno.length() < min || retorno.length() > max) {
                    System.out.println("Informe um nome de " + min + " a " + max + " caracteres");
                }
            } catch (Exception e) {
                erro = true;
            }
        } while (retorno.length() < min || retorno.length() > max || erro);
        return retorno;
    }
    
    public static Usuario usuarioAntes(Usuario u){
        Usuario retorno = null;
        Usuario atual = inicio;
        while (atual != null) {
            if (atual.getProximo() == u) {
                retorno = atual;
                break;
            }
            atual = atual.getProximo();
        }
        return retorno;
    }
}
