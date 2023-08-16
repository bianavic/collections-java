package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaDeNumeros {

    private List<Integer> numeros;

    public SomaDeNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numeros.add(numero);
    }

    public int calcularSoma() {

        int soma = 0;

        for (Integer numero : numeros)
            soma += numero;
        return soma;

    }

    public int encontrarMaiorNumero() {

        int maiorNumero = Integer.MIN_VALUE;

        if (!numeros.isEmpty()) {
            for (Integer numero : numeros) {
                if (numero >= maiorNumero) {
                    maiorNumero = numero;
                }
            }
            return maiorNumero;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }

    }

    public int encontrarMenorNumero() {

        int menorNumero = Integer.MAX_VALUE;

        if (!numeros.isEmpty()) {
            for (Integer numero : numeros) {
                if (numero <= menorNumero) {
                    menorNumero = numero;
                }
            }
            return menorNumero;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }

    }

    public void exibirNumeros() {

        if (!numeros.isEmpty()) {
            System.out.println(this.numeros);
        } else {
            System.out.println("A lista está vazia!");
        }

    }

    public static void main(String[] args) {

        SomaDeNumeros somaDeNumeros = new SomaDeNumeros();

        somaDeNumeros.adicionarNumero(1);
        somaDeNumeros.adicionarNumero(4);
        somaDeNumeros.adicionarNumero(10);
        somaDeNumeros.adicionarNumero(-100);
        somaDeNumeros.adicionarNumero(500);

        somaDeNumeros.exibirNumeros();

        System.out.println("A soma dos números é: " + somaDeNumeros.calcularSoma());
        System.out.println("O maior número é: " + somaDeNumeros.encontrarMaiorNumero());
        System.out.println("O menor número é: " + somaDeNumeros.encontrarMenorNumero());
    }

}
