import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Qual é o tamanho do arquivo e a escala [B, K, M, G, T]? Exemplo: 10 B, 10 T");
		long tamanho = scanner.nextInt();
		char escala = Character.toUpperCase(scanner.next().charAt(0));
		
		scanner.close();
		
		String nomeDoArquivo = tamanho+""+escala+".bin";
		
		switch(escala) {
		case 'T':
			tamanho*=1024;
		case 'G':
			tamanho*=1024;
		case 'M':
			tamanho*=1024;
		case 'K':
			tamanho*=1024;
		}

		System.out.println("Escrevendo...");
		
		FileWriter escrita = new FileWriter(new File("output"+File.separatorChar+nomeDoArquivo));
		for(long i=0; i<tamanho; i++) {
			escrita.append('\0');
		}
		escrita.close();
		
		System.out.println("Criado com sucesso.");
		System.out.println("Localização: output"+File.separatorChar+nomeDoArquivo);
	}
}
