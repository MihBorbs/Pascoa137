package unitTest;// bibliotecas

import br.com.iterasys.Calculadora;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

//classe
public class TesteCalculadora { // inicio da classe
    // atributos

    //funções e métodos

    @Test
    public void testeSomarDoisNumeros(){ // inicio do teste somar
        // configura
        // valores de entrada
        double num1 = 7;
        double num2 = 5;
        // valores de saida
        double resultadoEsperado = 12;

        // executa
        double resultadoAtual = Calculadora.somarDoisNumeros(num1, num2);

        // valida
        assertEquals (resultadoEsperado, resultadoAtual);

    } // final do teste somar


    @ParameterizedTest
    @CsvSource(value = {
            "7, 5, 12.0",
            "56, 44, 100.0",
            "10, 0, 10.0",
            "15, -5, 10.0",
            "-8, -6, -14.0",
    }, delimiter = ',')
    public void testeSomarDoisNumerosLendoLista (String txtNum1, String txtNum2 , String resultadoEsperado){ // inicio do teste somar
        // configura
        // os dados de entrada e o resultado esperado vem da lista


        // executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));

        // valida
        assertEquals (Double.valueOf(resultadoEsperado), resultadoAtual);

    } // final do teste somar

    @ParameterizedTest
    @CsvFileSource(resources = "csv/massaSomar.csv", numLinesToSkip = 1, delimiter = ',')
    public void testeSomarDoisNumerosLendoArquivo (String txtNum1, String txtNum2 , String resultadoEsperado){ // inicio do teste somar
        // configura
        // os dados de entrada e o resultado esperado vem da lista


        // executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));

        // valida
        assertEquals (Double.valueOf(resultadoEsperado), resultadoAtual);

    } // final do teste somar

    @Test
    public void testeSubtrairDoisNumeros(){
        double num1 = 10;
        double num2 = 5;

        double resultadoEsperado = 5;

        double resultadoAtual = Calculadora.subtrairDoisNumeros(num1, num2);

        assertEquals (resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testeMultiplicarDoisNumeros(){
        double num1 = 3;
        double num2 = 2;

        double resultadoEsperado = 6;

        double resultadoAtual = Calculadora.multiplicarDoisNumeros(num1, num2);

        assertEquals (resultadoAtual, resultadoEsperado);
    }
    @Test
    public void testeDividirDoisNumeros(){
        double num1 = 4;
        double num2 = 2;

        double resultadoEsperado = 2;

        double resultadoAtual = Calculadora.dividirDoisNumeros(num1, num2);

        assertEquals (resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testeDividirDoisNumerosInteiros(){
        // configura
        int numA = 8;
        int numB = 0;

        String resultadoEsperado = "Não é possivel dividir por zero";

        //executa
        String resultadoAtual = Calculadora.dividirDoisNumerosInteiros(numA, numB);

        //valida
        assertEquals (resultadoEsperado, resultadoAtual);
        System.out.println(numA + " / " + numB + " = " + resultadoAtual);
        System.out.println("O resultado esperado: " + resultadoEsperado);
    }

} // final da classe

