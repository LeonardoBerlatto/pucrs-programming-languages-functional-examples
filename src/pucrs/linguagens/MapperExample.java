package pucrs.linguagens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    static List<Aluno> alunos = Arrays.asList(
            new Aluno("João", "Silva", "12345"),
            new Aluno("Maria", "Silva", "54321"),
            new Aluno("Ana", "Silva", "13579"),
            new Aluno("Aldo", "Silva", "98765")
    );

    public static void mapperFuncional() {
        List<AlunoDTO> alunoDTOSList = alunos.stream()
                .map(MapperExample::createAlunoDTO)
                .collect(Collectors.toList());

        alunoDTOSList.forEach(System.out::println);
    }

    public static void mapperProcedural() {
        List<AlunoDTO> alunoDTOList = new ArrayList<>();
        for (Aluno aluno : alunos) {
            AlunoDTO alunoDTO = createAlunoDTO(aluno);
            alunoDTOList.add(alunoDTO);
        }

        for (AlunoDTO aluno : alunoDTOList) {
            System.out.println(aluno);
        }
    }

    private static AlunoDTO createAlunoDTO(Aluno aluno) {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setNomeCompleto(aluno.nome + " " + aluno.sobrenome);
        alunoDTO.setMatricula(aluno.matricula);
        return alunoDTO;
    }

}
