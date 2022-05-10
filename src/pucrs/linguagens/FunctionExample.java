package pucrs.linguagens;

import java.util.function.Function;

public class FunctionExample {

    public static void executarExemplo() {
        Function<String, String> montarCarro = (pecas) -> "Carro";

        Function<String, String> colorirCarro = carro -> carro + " colorido";

        Function<String, String> incluirArCondicionado = carro -> carro + " com ar condicionado";

        Function<String, String> incluirTravaEletrica = carro -> carro + " com trava eletrica";

        Function<String, String> incluirPortaMalas = carro -> carro + " com porta malas";

        // montar carro completo
        Function<String, String> montarCarroCompleto = montarCarro.andThen(colorirCarro)
                .andThen(incluirArCondicionado)
                .andThen(incluirTravaEletrica)
                .andThen(incluirPortaMalas);

        System.out.println(montarCarroCompleto.apply("Pecas"));
    }
}
