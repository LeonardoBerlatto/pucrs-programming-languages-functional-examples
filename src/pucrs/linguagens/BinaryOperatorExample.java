package pucrs.linguagens;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    public static final double TAXA_JUROS = 1.10;


    public static void calcularImpostoProcedural() {
        final var list = Arrays.asList(10.0, 10.0, 10.0);

        Double total = 0.0;
        for (Double valor : list) {
            total = (total + valor) * TAXA_JUROS;
        }
        System.out.println(total);

        Double totalSimples = 0.0;
        for (Double valor : list) {
            totalSimples = totalSimples + (valor * TAXA_JUROS);
        }
        System.out.println(totalSimples);
    }

    public static void calcularFuncional() {
        final var list = Arrays.asList(10.0, 10.0, 10.0);

        System.out.println(calcularImposto(list, BinaryOperatorExample::calcularImpostoComposto));
        System.out.println(calcularImposto(list, BinaryOperatorExample::calcularImpostoSimples));
    }

    private static Double calcularImposto(List<Double> parcelas, BinaryOperator<Double> jurosFunction) {
        return parcelas.stream().reduce(0.0, jurosFunction); // comentar sobre paralelismo
    }

    public static Double calcularImpostoSimples(Double acumulado, Double atual) {
        return acumulado + (atual * TAXA_JUROS);
    }

    public static Double calcularImpostoComposto(Double acumulado, Double atual) {
        return (acumulado + atual) * TAXA_JUROS;
    }
}
