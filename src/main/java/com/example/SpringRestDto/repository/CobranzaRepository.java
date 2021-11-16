package com.example.SpringRestDto.repository;

import com.example.SpringRestDto.entity.Cliente;
import com.example.SpringRestDto.entity.Cobranza;
import com.example.SpringRestDto.entity.Inmueble;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
@Getter @Setter
public class CobranzaRepository {

    @Autowired
    private SistemaRepository sistemaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private InmuebleRepository inmuebleRepository;

    public void addCobranza(Cobranza cobranza) throws Exception {
        Optional<Cliente> optionalCliente= clienteRepository.buscarCliente(cobranza.getCliente().getDni());
        Optional<Inmueble> optionalInmueble= inmuebleRepository.buscarInmueble(cobranza.getInmueble().getCodigo());

        if(optionalCliente.isPresent() && optionalInmueble.isPresent()){
            sistemaRepository.getListaCobranzas().add(cobranza);
        }else{
            throw new Exception();
        }
    }

    public Optional<Cobranza> buscarCobranza(Integer numero){
        return sistemaRepository.getListaCobranzas().stream().filter(c->c.getNumero().equals(numero)).findFirst();
    }

}
