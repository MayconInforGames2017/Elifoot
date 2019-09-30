import java.util.Random;

public class Jogo {

	protected static String times[] = { "Alemanha", "Brasil" };
	protected static int peso[] = { 6, 5 };
	protected static Random r = new Random();
	protected static int goltime1 = 0;
	protected static int goltime2 = 0;
	protected static int lancesgol = 0;

	static int fatortecnica() {
		int time = 0;
		int tecnica1 = peso[0] * r.nextInt(4);
		int tecnica2 = peso[1] * r.nextInt(4);
		int fatortime1 = tecnica1 * r.nextInt(3) + 1;
		int fatortime2 = tecnica2 * r.nextInt(3) + 1;

		if (fatortime1 > fatortime2) {
			time = 1;
		} else if (fatortime2 > fatortime1) {
			time = 2;
		}
		return time;
	}

	public static int gol() {
		int sorteio = r.nextInt(2);
		if (sorteio == 0) {

		} else if (sorteio == 1) {

		}
		return sorteio;

	}

	public static int penalti() {
		int sorteio = r.nextInt(5) + 1;

		if (sorteio == 3) {
			if (fatortecnica() == 1) {
				System.out.println("Penalti para a " + times[0]);

				if (gol() == 1) {

					System.out.println("GOOLLLLL da " + times[0]);
					goltime1 += 1;
					System.out.println(times[0] + " " + goltime1 + " X " + goltime2 + " " + times[1]);

				} else {
					System.out.println("PEERRDEEELLLL, a " + times[0] + " perdeu o penalti");
				}

			} else if (fatortecnica() == 2) {
				System.out.println("Penalti para a " + times[1]);

				if (gol() == 1) {

					System.out.println("GOOLLLLL do " + times[1]);
					goltime2 += 1;
					System.out.println(times[0] + " " + goltime1 + " X " + goltime2 + " " + times[1]);

				} else {
					System.out.println("PEERRDEEELLLL, o " + times[1] + " perdeu o penalti");
				}

			}

		}
		return sorteio;

	}

	public static int lanceperigo() {

		int sorteio = r.nextInt(2);
		if (sorteio == 0) {

		} else if (sorteio == 1) {

			if (fatortecnica() == 1) {
				System.out.println("lance de gol da " + times[0]);
				lancesgol += 1;
				if (gol() == 1) {

					System.out.println("GOOLLLLL da " + times[0]);
					goltime1 += 1;
					System.out.println(times[0] + " " + goltime1 + " X " + goltime2 + " " + times[1]);

				} else {
					System.out.println("Chance perdida pela " + times[0]);
				}

			} else if (fatortecnica() == 2) {
				System.out.println("lance de gol do " + times[1]);
				lancesgol += 1;

				if (gol() == 1) {

					System.out.println("Ollhha o GOLLL, Ollhha o GOLLL, GOLLLLLLLLLL, é do " + times[1]);
					goltime2 += 1;
					System.out.println(times[0] + " " + goltime1 + " X " + goltime2 + " " + times[1]);

				} else {
					System.out.println("Chance perdida pela " + times[1]);
				}

			}

		}
		return sorteio;
	}

	public static void main(String[] args) {

		try {

			for (int n = 0; n <= 90; n++) {
				System.out.println(n + " min/jogados - Bola rolando...");

				if (n % 4 == 0) {
					int sorteio = r.nextInt(5);

					if (sorteio == 1) {
						System.out.println("Galvão: 'É um Classico Mundial amigos'");
					} else if (sorteio == 2) {
						System.out.println("Ronaldo: 'Ganha quem fizer mais GOL'");
					} else if (sorteio == 3) {
						System.out.println("Arnaldo: 'Foi claramente lance de penalti'");
					} else if (sorteio == 4) {
						System.out.println("Casa Grande: 'O tite montou um esquema muito defensivo.'");
					} else if (sorteio == 5) {
						System.out.println("Galvao: 'Haaajjjjaaa CORAÇÂOOO amigos'");
					}
				}

				if (n % 5 == 0) {
					lanceperigo();
				}

				if (n % 9 == 0) {
					penalti();
				}

				Thread.sleep(1000);

				if (n == 45) {
					System.out.println("Fim do Primeiro Tempo.");
					Thread.sleep(1000);
					System.out.println(
							"Resultado Parcial:" + times[0] + " " + goltime1 + " X " + goltime2 + " " + times[1]);
					Thread.sleep(1000);
					System.out.println("Os jogadores estao a caminho do vestiario");
					Thread.sleep(2000);

					if (goltime1 > goltime2) {
						System.out.println("David Luiz: 'Eu so queria dar alegria para o meu povo' ");
						System.out.println("Galvão: 'A Alemanha esta massacrando o Brasil' ");
					} else if (goltime2 > goltime1) {
						System.out.println("Galvão: 'O Brasil ate o momento consegue neutralizar a Alemanha' ");
					} else if (goltime2 == goltime1) {
						System.out.println("Galvão: 'O jogo Segue empatado' ");
					}
					Thread.sleep(2000);
					System.out.println("Lances de gol: " + lancesgol);
					Thread.sleep(2000);
					System.out.println("Os jogadores estao retornando ao gramado");
					Thread.sleep(1000);
					System.out.println("Começa o segundo tempo.");
				}

				if (n == 90) {
					System.out.println("Fim do jogo.");
					Thread.sleep(2000);
					System.out.println(
							"Resultado Final:" + times[0] + " " + goltime1 + " X " + goltime2 + " " + times[1]);

				}

			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}
}
