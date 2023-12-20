package com.empresa.apireservaciones.services;

import com.empresa.apireservaciones.dto.ClienteRequest;
import com.empresa.apireservaciones.dto.ClienteRequestUpdate;
import com.empresa.apireservaciones.dto.ClienteResponse;
import com.empresa.apireservaciones.entities.Cliente;
import com.empresa.apireservaciones.exceptions.IdExistenteException;
import com.empresa.apireservaciones.exceptions.RecursoNoEncontradoException;
import com.empresa.apireservaciones.repositories.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
@Slf4j
public class ClienteServiceImpl implements IClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteResponse create(ClienteRequest clienteRequest) {
        var clienteExistente = clienteRepository.findById(clienteRequest.getNumDocumento());

        if (clienteExistente.isPresent()) {
            throw new IdExistenteException();
        }

        var clienteAPersistirBD = Cliente.builder()
                .numDocumento(clienteRequest.getNumDocumento())
                .idTributaria(clienteRequest.getIdTributaria())
                .nombres(clienteRequest.getNombres())
                .apellidos(clienteRequest.getApellidos())
                .fechaNacimiento(clienteRequest.getFechaNacimiento())
                .cantidadReservaciones(0)
                .build();

        var clientePersistido = clienteRepository.save(clienteAPersistirBD);

        return entityToResponse(clientePersistido);
    }

    @Override
    public ClienteResponse read(Long aLong) {
        return entityToResponse(clienteRepository.findById(aLong).orElseThrow(RecursoNoEncontradoException::new));
    }

    @Override
    public void remove(Long aLong) {
        var clienteBD = clienteRepository.findById(aLong).orElseThrow(RecursoNoEncontradoException::new);

        clienteRepository.delete(clienteBD);
    }


    public ClienteResponse update(ClienteRequestUpdate clienteRequest, Long aLong) {
        var clienteBD = clienteRepository.findById(aLong).orElseThrow(RecursoNoEncontradoException::new);

        clienteBD.setNombres(clienteRequest.getNombres());
        clienteBD.setApellidos(clienteRequest.getApellidos());
        clienteBD.setFechaNacimiento(clienteRequest.getFechaNacimiento());

        var clienteModificado = clienteRepository.save(clienteBD);

        return entityToResponse(clienteModificado);

    }

    public ClienteResponse entityToResponse(Cliente clienteEntity) {
        ClienteResponse response = new ClienteResponse();
        BeanUtils.copyProperties(clienteEntity, response);
        return response;
    }
}
