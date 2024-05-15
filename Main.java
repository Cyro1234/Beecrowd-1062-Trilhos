// Cyro Conde Garone Morelli 22.00077-0
// Thiago Calabresi 22.00388-6

import java.util.Scanner;

class Main {
    static final int MAX = 1000;

    static class Pilha {
        int[] vetor = new int[MAX];
        int topo = -1;

        void push(int id) {
            vetor[++topo] = id;
        }

        void pop() {
            topo--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int vagoes = scanner.nextInt();
            if (vagoes == 0) break;

            while (true) {
                Pilha p = new Pilha();
                boolean zero = false;
                boolean deuruim = false;
                int entrando = 1;

                for (int i = 0; i < vagoes && !deuruim && !zero; i++) {
                    int fora = scanner.nextInt();
                    if (fora == 0) {
                        zero = true;
                        break;
                    }

                    while (true) {
                        if (fora == entrando) {
                            entrando++;
                            break;
                        } else if (fora > entrando) {
                            p.push(entrando);
                            entrando++;
                        } else {
                            if (p.vetor[p.topo] == fora)
                                p.pop();
                            else {
                                deuruim = true;
                                for (; i < vagoes - 1; i++)
                                    scanner.nextInt();
                            }
                            break;
                        }
                    }
                }

                if (!zero) {
                    if (!deuruim)
                        System.out.println("Yes");
                    else
                        System.out.println("No");
                } else
                    break;
            }
            System.out.println();
        }
    }
}
