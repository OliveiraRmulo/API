package org.serratec.backend.apiRestfulG5.controller;

import java.util.List;

import org.serratec.backend.apiRestfulG5.domain.Funcionario;
import org.serratec.backend.apiRestfulG5.domain.Produto;
import org.serratec.backend.apiRestfulG5.exception.FuncionarioNotFoundException;
import org.serratec.backend.apiRestfulG5.exception.ParameterException;
import org.serratec.backend.apiRestfulG5.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	@ApiOperation(value="Lista todos os funcionario", notes= "Listagem de funcionario")
	@ApiResponses(value = {
			@ApiResponse(code= 200, message ="Retorna todos os funcionario"),
			@ApiResponse(code= 401, message= "Erro de autenticação"),
			@ApiResponse(code= 403, message= "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code= 404, message= "Recurso não encontrado"),
			@ApiResponse(code= 405, message= "Quando ocorre uma exceção")
	})
	
	
	public List<Funcionario> listarTodos(){
		return funcionarioService.listar();
	}
	
	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody Funcionario funcionario) {
		funcionarioService.inserir(funcionario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}


	@GetMapping("/{id_funcionario}")
	public Funcionario pesquisarPorId(@PathVariable Integer id_funcionario) throws FuncionarioNotFoundException {
		return funcionarioService.pesquisarPorId(id_funcionario);
	}
	
	@PutMapping("/{id_funcionario}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer id_funcionario, @RequestBody(required = true) Funcionario funcionario)
			throws FuncionarioNotFoundException, ParameterException {
		funcionarioService.atualizar(id_funcionario, funcionario);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_funcionario}")
	public void deletarPorId(@PathVariable Integer id_funcionario) throws FuncionarioNotFoundException {
		funcionarioService.deletarPorId(id_funcionario);
	}
}