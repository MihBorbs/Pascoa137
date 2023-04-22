// 1 - pacote: conjunto de classes

package br.com.iterasys;

// 2 - bibliotecas

// 3 - classe (substantivo)
public class Calculadora { //inicio da classe
    // 3.1 - atributos - caracteristicas - campos

    // 3.2 - funções e métodos (verbo)
    public static double somarDoisNumeros(double num1, double num2) { //inicio da função
        return num1 + num2;
    } // final da função

    public static double subtrairDoisNumeros(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiplicarDoisNumeros(double num1, double num2) {
        return num1 * num2;
    }

    public static double dividirDoisNumeros(double num1, double num2) {
        return num1 / num2;
    }

    public static String dividirDoisNumerosInteiros(int numA, int numB) {
        try{
            return String.valueOf(numA / numB);
        }
        catch (Exception e) {
            return "Não é possivel dividir por zero";
        }
    }

    public static double calcularVolumePiramideQuadrada(double base, double altura){
        double volume = (base * base * altura) / 3;
        return volume;
    }

} // final da classe



