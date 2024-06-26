package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.TipoDestino;
import co.edu.icesi.viajes.repository.TipoDestinoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class TipoDestinoServiceImpl implements TipoDestinoService {

    @Autowired
    private TipoDestinoRepository tipoDestinoRepository;

    //    public TipoDestinoServiceImpl(TipoDestinoRepository tipoDestinoRepository) {
//        this.tipoDestinoRepository = tipoDestinoRepository;
//    }

    private final Logger log = LoggerFactory.getLogger(TipoDestinoServiceImpl.class);

    @Override
    public List<TipoDestino> findAll() {
        return tipoDestinoRepository.findAll();
    }

    @Override
    public Optional<TipoDestino> findById(Integer id) {
        return tipoDestinoRepository.findById(id);
    }

    @Override
    public TipoDestino save(TipoDestino entity) throws Exception {

        if(entity == null){
            throw new Exception("El tipo de destino no puede ser nulo");
        } else if (!tipoDestinoRepository.findByCodigo(entity.getCodigo()).isEmpty()){
            throw new Exception("El tipo de destino con el código " + entity.getCodigo() + " ya existe");
        }

        return tipoDestinoRepository.save(entity);
    }

    @Override
    public TipoDestino update(TipoDestino entity) throws Exception {
        return tipoDestinoRepository.save(entity);
    }

    @Override
    public void delete(TipoDestino entity) throws Exception {
        tipoDestinoRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        tipoDestinoRepository.deleteById(id);
    }

    @Override
    public void validate(TipoDestino entity) throws Exception {

    }

    @Override
    public Long count() {
        return tipoDestinoRepository.count();
    }

    @Override
    public TipoDestino findByIdTide(Integer id) {
        return tipoDestinoRepository.findByIdTide(id);
    }

    @Override
    public List<TipoDestino> findByCodigo(String codigo) {
        return tipoDestinoRepository.findByCodigo(codigo);
    }

    @Override
    public List<TipoDestino> findByCodigoAndEstado(String codigo, String estado) {
        return tipoDestinoRepository.findByCodigoAndEstado(codigo, estado);
    }

    @Override
    public List<TipoDestino> findByOrderByNombreAsc() {
        log.info("Buscando tipo de destino por nombre");
        return tipoDestinoRepository.findByOrderByNombreAsc();
    }
}
