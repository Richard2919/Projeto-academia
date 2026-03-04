package com.example.academia.service; // (ajuste para o seu pacote)

import com.example.academia.entity.Aluno;
import com.example.academia.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FinanceiroService {

    @Autowired
    private AlunoRepository alunoRepository;

    //  O ROBÔ: Roda todo dia à meia-noite automaticamente
    @Scheduled(cron = "0 0 0 * * *")
    public void verificarMensalidadesVencidas() {
        LocalDate hoje = LocalDate.now();

        // Pega todos que "acham" que estão em dia, mas a data já venceu
        List<Aluno> alunosVencidos = alunoRepository.findByMensalidadeEmdiaTrueAndDataVencimentoBefore(hoje);

        for (Aluno aluno : alunosVencidos) {
            aluno.setMensalidadeEmdia(false); // Corta o acesso do aluno!
            alunoRepository.save(aluno);
        }

        System.out.println("=== Robô Financeiro: " + alunosVencidos.size() + " alunos ficaram inadimplentes hoje. ===");
    }

    //  A BAIXA DO PAGAMENTO: Quando o gestor clica em "Receber"
    public void confirmarPagamento(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        aluno.setMensalidadeEmdia(true); // Fica em dia
        aluno.setDataVencimento(LocalDate.now().plusMonths(1)); // Joga o vencimento para daqui a 1 mês exato!

        alunoRepository.save(aluno);
    }
}