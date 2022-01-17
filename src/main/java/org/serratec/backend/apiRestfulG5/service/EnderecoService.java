package org.serratec.backend.apiRestfulG5.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.apiRestfulG5.domain.Endereco;
import org.serratec.backend.apiRestfulG5.exception.EnderecoNotFoundException;
import org.serratec.backend.apiRestfulG5.exception.ParameterException;
import org.serratec.backend.apiRestfulG5.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco inserir(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public List<Endereco> listar() {
		return enderecoRepository.findAll();
	}
	
	public Endereco pesquisarPorId(Integer id_endereco) throws EnderecoNotFoundException {
		Optional<Endereco> opEndereco = enderecoRepository.findById(id_endereco);

		if(opEndereco.isPresent()) {
			return opEndereco.get();
		}
		
		throw new EnderecoNotFoundException("Endereco com id " + id_endereco + " não encontrada");
	}
	public Endereco atualizar(Integer id_endereco, Endereco endereco) throws ParameterException, EnderecoNotFoundException {
		if(endereco == null) throw new ParameterException("Campo 'Endereco' é obrigatório");
		
		Endereco endereco1 = pesquisarPorId(id_endereco);
		
		if(endereco.getCep() != null) {
			endereco1.setCep(endereco.getCep());
		}
		
		if(endereco.getRua() != null) {
			endereco1.setRua(endereco.getRua());
		}
		
		if(endereco.getNumero() != null) {
			endereco1.setNumero(endereco.getNumero());
		}
		
		if(endereco.getComplemento() != null) {
			endereco1.setComplemento(endereco.getComplemento());
		}
		
		if(endereco.getBairro() != null) {
			endereco1.setBairro(endereco.getBairro());
		}
		
		if(endereco.getCidade() != null) {
			endereco1.setCidade(endereco.getCidade());
		}
		
		if(endereco.getEstado() != null) {
			endereco1.setEstado(endereco.getEstado());
		}
		
		return enderecoRepository.save(endereco1);
	}
	
	public void deletarPorId(Integer id_endereco) throws EnderecoNotFoundException{
		enderecoRepository.deleteById(id_endereco);
	
	}
}
