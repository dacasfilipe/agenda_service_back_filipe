package com.agenda_service_back.servico;

import com.agenda_service_back.agendamento.Agendamento;
import com.agenda_service_back.categoria.Categoria;
import com.agenda_service_back.prestador.Prestador;
import com.agenda_service_back.telefone.Telefone;
import com.agenda_service_back.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data //-Getters -Setters Hash Equals toString
//@Getter
//@Setter
@AllArgsConstructor //usar com cuidado em tabelas com chave estrangeira
@NoArgsConstructor
@Entity
@Table(name = "servico")
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servico_id")
    private Long servico_id;

    @Column(name = "servico_nome", nullable = false, length = 255)
    private String servico_nome;

    @Column(name = "servico_descricao", nullable = false, length = 255)
    private String servico_descricao;

    @Column(name = "servico_informacoes_extras", nullable = false, length = 255)
    private String servico_informacoes_extras;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servico_categoria_id", nullable = false)
    private Categoria servico_categoria_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servico_prestador_id", nullable = false)
    private Prestador servico_prestador_id;

    @OneToMany(mappedBy = "agendamento_servico_id", fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos;

}


