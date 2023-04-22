import br.com.iterasys.Calculadora;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testeVolumePiramideQuadrada {


    @Test
    public void TestVolumePiramideQuadrada() {
        double base = 3;
        double altura = 6;
        double resultadoEsperado = 18;

        double resultadoAtual = Calculadora.calcularVolumePiramideQuadrada(base, altura);

        assertEquals(resultadoAtual, resultadoEsperado);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "csv/massaVolumePiramideQuadrada.csv", numLinesToSkip = 1, delimiter = ',')
    public void testeVolumePiramideQuadradaLendoArquivo (String txtNum1, String txtNum2, String resultadoEsperado){ // inicio do teste do somar
        // Configura
        // Os dados de entrada e o resultado esperado vem da lista


        // Executa
        double resultadoAtual = Calculadora.calcularVolumePiramideQuadrada(Double.valueOf(txtNum1), Double.valueOf(txtNum2));

        // Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual, 0.01);
    } // final do teste do somar


    @ParameterizedTest
    @CsvSource(value = {
            "3.0, 4.5, 13.50",
            "4.2, 5.5, 32.34",
            "2.5, 3.8, 7.92",
            "5.1, 2.2, 19.074",
    }, delimiter = ',')
    public void testeVolumePiramideQuadradaLendoLista(String txtNum1, String txtNum2 , String resultadoEsperado){
        // configura
        // os dados de entrada e o resultado esperado vem da lista


        // executa
    //linha erro    double resultadoAtual = Calculadora.calcularVolumePiramideQuadrada(double.valueOf(txtNum1), double.valueOf(txtNum2)); // linha

        double resultadoAtual = Calculadora.calcularVolumePiramideQuadrada(Double.valueOf(txtNum1), Double.valueOf(txtNum2));

        // valida
        assertEquals (Double.valueOf(resultadoEsperado), resultadoAtual, 0.01);

    } //

} // final da classe

