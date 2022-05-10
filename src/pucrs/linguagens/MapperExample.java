package pucrs.linguagens;

import java.util.Collections;

public class MapperExample {

    public static class Aluno {
        private String nome;
        private String sobrenome;
        private String matricula;

        public Aluno(String nome, String sobrenome, String matricula) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.matricula = matricula;
        }
    }

    public static class AlunoDTO {
        private String nomeCompleto;
        private String matricula;

        public void setNomeCompleto(String nomeCompleto) {
            this.nomeCompleto = nomeCompleto;
        }

        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }

        @Override
        public String toString() {
            return this.nomeCompleto + " " + this.matricula;
        }
    }

    public static void executar() {
        Aluno alunoExmplo = new Aluno("João", "Silva", "12345");

        final var list = Collections.singletonList(alunoExmplo);

        list.stream()
                .map(MapperExample::getAlunoDTO)
                .forEach(System.out::println);
    }

    private static AlunoDTO getAlunoDTO(Aluno aluno) {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNomeCompleto(aluno.nome + " " + aluno.sobrenome);
        alunoDTO.setMatricula(aluno.matricula);
        return alunoDTO;
    }

}
