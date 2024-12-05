Package com.unifacisa.livraria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.livraria.entity.Descricao;
import com.unifacisa.livraria.repository.DescricaoRepository;

@Service
public class DescricaoService {

    @Autowired
    private DescricaoRepository descricaoRepository;

    public Optional<Descricao> buscarPorId(Long id) {
        return descricaoRepository.findById(id);
    }

    public Descricao salvar(Descricao descricao) {
        return descricaoRepository.save(descricao);
    }
}
