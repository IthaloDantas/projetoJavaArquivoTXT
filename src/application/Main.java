package application;

import java.io.*;// Usando o pacote java.io para a manipulação de arquivos
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        File arq = new File("C:\\Users\\Windows\\Documents\\projeto.txt"); // Pegando o caminho do arquivo

        if (!arq.exists()){
            arq.createNewFile();  // if para criar um arquivo caso não tenha nenhum criado
        }

        System.out.println("Escolha uma das opções : ");
        System.out.println(" 1 - Adicionar conteúdo no arquivo. ");
        System.out.println(" 2 - Exibir nomes presentes no arquivo. "); // sout padão para mostrar as opções
        System.out.println(" 3 - Apagar arquivo. ");

        int opcaoEscolhida = sc.nextInt(); // Pegando a opção escolhida com o scanner

        switch (opcaoEscolhida){
            /* Nesse caso 1 vai funcionar da seguinte forma o usuario vai digitar um conteudo e esse conteudo esta sendo salvo em um buffer que aloca esse conteudo
            * para depois inserir no arquivo txt e salvar */
            case 1:
                FileWriter conteudo = new FileWriter(arq); // instanciando o FileWriter passando como argumento o arquivo
                BufferedWriter bufferEscrita = new BufferedWriter(conteudo); // instanciando o buffer onde vai ser salvo oq ta sendo escrito para depois salvar no arquivo
                System.out.println(" Insira o texto que será salvo no arquivo : ");
                for (int i = 0; i<2; i++){ // Esse for serve para que quando ele der enter o conteudo ja seja salvo tem formas de melhorar por ex concatenar novos conteudos
                    String linha = sc.nextLine();
                    bufferEscrita.write(linha); // aqui ta pegando o conteudo escrito e alocando no buffer
                }
                bufferEscrita.close(); // fechando o buffer
                break; // break padrão para encerrar o processo

            case 2:
                FileReader lerArq = new FileReader(arq); // Instanciando o FileReader e passando o arquivo como parametro
                BufferedReader bufferLeitura = new BufferedReader(lerArq); // instanciando o buffer de leitura
                System.out.print("Conteúdo do arquivo : ");
                String conteudoArq; // Criando String onde vai ficar armazenado o conteudo do arquivo txt
                while (bufferLeitura.ready()){
                    conteudoArq = bufferLeitura.readLine(); // Esse while significa que enquanto tiver conteudo na linha ele vai pegar esse conteudo e printar
                    System.out.println(conteudoArq);
                }
                bufferLeitura.close(); // encerrando o buffer de leitura
                break;

            /* No caso 3 ele esta pegando o arquivo e deletando apenas  */
            case 3:
                arq.delete(); // pegando o arquivo e deletando
                System.out.println("Arquivo deletado");
                break;


            default:
                System.out.println("Por favor escolher uma opção valida. ");
        }

        /* FileWriterdestina-se a escrever fluxos de caracteres.
        *
        * BufferedWriter Grava texto em um fluxo de saída de caracteres, armazenando caracteres em buffer de modo a fornecer uma escrita eficiente de caracteres únicos,
        *  matrizes e strings.
        *
        * write do buffer = metodo que grava uma parte de uma String. (write é um metodo enquanto o File e Buffer são Classes)
        *
        * Metodo Close fecha o buffer e liberando ele
        *
        * FileReader destina-se à leitura de fluxos de caracteres
        *
        * BufferedReader Lê texto de um fluxo de entrada de caracteres, armazenando caracteres em buffer para fornecer uma leitura eficiente de caracteres, matrizes
        * e linhas.
        *
        * Metodo ready() do BufferedReader Informa se este fluxo está pronto para ser lido. (Informa se tem conteudo no arquivo)
        *
        * Metodo readLine() do BufferedReader Lê uma linha de texto.
        *
        * IOException Sinaliza que ocorreu uma exceção de E / S de algum tipo.
        *
        * A classe File é uma representação abstrata de nomes de caminho de arquivo e diretório.
        *
        *  Metodo da classe File delete() Exclui o arquivo ou diretório indicado por este nome de caminho abstrato.
        *
        * Metodo da classe File exist() Testa se o arquivo ou diretório indicado por este nome de caminho abstrato existe.
        *
        * Metodo da classe File createNewFile() Cria atomicamente um novo arquivo vazio nomeado por este nome de caminho abstrato se e somente se um arquivo com este
        *  nome ainda não existir.
        *
        **/





    }
}
