package com.agenda_service_back.servico;

import com.agenda_service_back.categoria.Categoria;
import com.agenda_service_back.categoria.CategoriaService;
import com.agenda_service_back.prestador.Prestador;
import com.agenda_service_back.prestador.PrestadorDTO;
import com.agenda_service_back.prestador.PrestadorService;
import com.agenda_service_back.servico.exceptions.ServicoJaExistenteException;
import com.agenda_service_back.servico.exceptions.ServicoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private PrestadorService prestadorService;

    @Transactional
    public Servico salvarServico(ServicoDTO servicoDTO) {
//        validateServico(servicoDTO);

        Categoria categoria = categoriaService.buscarCategoriaPorId(servicoDTO.getServicoCategoria().getCategoria_id());
//        Prestador prestador = prestadorService.buscarPrestadorPorId(servicoDTO.getServicoPrestador().getPrestadorEndereco().getEndereco_id());

        Servico servico = new Servico();
        servico.setServico_nome(servicoDTO.getServicoNome());
        servico.setServico_descricao(servicoDTO.getServicoDescricao());
        servico.setServico_informacoes_extras(servicoDTO.getServicoInformacoesExtras());
        servico.setServico_categoria_id(categoria);
        servico.setServico_prestador_id(prestador);

        return servicoRepository.save(servico);
    }

    public Servico buscarServicoPorId(Long servicoId) {
        return servicoRepository.findById(servicoId)
                .orElseThrow(() -> new ServicoNaoEncontradoException("Serviço com ID " + servicoId + " não encontrado."));
    }

    public List<Servico> buscarTodosServicos() {
        return servicoRepository.findAll();
    }

    @Transactional
    public Servico atualizarServico(Long servicoId, ServicoDTO servicoDTO) {
//        validateServico(servicoDTO);

        Servico servico = buscarServicoPorId(servicoId);

        Categoria categoria = categoriaService.buscarCategoriaPorId(servicoDTO.getServicoCategoria().getCategoria_id());
        PrestadorDTO prestador = prestadorService.buscarPrestadorPorId(servicoDTO.getServicoPrestador().getPrestadorId());

        servico.setServico_nome(servicoDTO.getServicoNome());
        servico.setServico_descricao(servicoDTO.getServicoDescricao());
        servico.setServico_informacoes_extras(servicoDTO.getServicoInformacoesExtras());
        servico.setServico_categoria_id(categoria);
        servico.setServico_prestador_id(prestador);

        return servicoRepository.save(servico);
    }

    public void excluirServicoPorId(Long servicoId) {
        servicoRepository.deleteById(servicoId);
    }

    // Add methods for searching by specific criteria (e.g., by categoria, by prestador)
    // ...
}
