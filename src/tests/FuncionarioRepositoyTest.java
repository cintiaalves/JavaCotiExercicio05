package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Funcionario;
import factories.ConnectionFactory;
import interfaces.IFuncionarioRepository;
import repositories.FuncionarioRepository;

class FuncionarioRepositoyTest {
	
	private IFuncionarioRepository funcionarioRepository;
	private Funcionario funcionario; 
	

	@BeforeEach
	void setUp() throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		funcionarioRepository  = new FuncionarioRepository(factory.getConnection());
		
		funcionario = new Funcionario(null, "Fernando Alves", "115.568.624-69", 10000.0);
	}

	@Test
	void testCreate() throws Exception {
		funcionarioRepository.create(funcionario);
		assertNotNull(funcionario.getIdFuncionario());
		Funcionario funcionarioCriado = funcionarioRepository.findById(funcionario.getIdFuncionario());
		assertEquals(funcionario, funcionarioCriado);
	}
	
	@Test
	void testUpdate() throws Exception {
		funcionarioRepository.create(funcionario);
		funcionario.setNome("Paulo de Tarso");
		funcionario.setCpf("052.699.458-88");
		funcionario.setSalario(20000.0);
		funcionarioRepository.update(funcionario);
		Funcionario funcionarioAtualizado = funcionarioRepository.findById(funcionario.getIdFuncionario());
		assertEquals(funcionario, funcionarioAtualizado);
	}
	
	@Test
	void testDelete() throws Exception {
		funcionarioRepository.create(funcionario);
		funcionarioRepository.delete(funcionario);
		Funcionario funcionarioExcluido = funcionarioRepository.findById(funcionario.getIdFuncionario());
		assertNull(funcionarioExcluido);
	}
	
	@Test
	void testFindAll() throws Exception {
		funcionarioRepository.create(funcionario);
		List<Funcionario> lista = funcionarioRepository.findAll();
		Predicate<Funcionario> filtro = f -> f.getIdFuncionario().equals(funcionario.getIdFuncionario());
		Funcionario funcionarioConsulta = lista.stream()
											.filter(filtro)
											.findFirst()
											.orElse(null);		
		assertNotNull(funcionarioConsulta);
		assertEquals(funcionario, funcionarioConsulta);
	}
	
	@Test
	void testFindById() throws Exception {
		funcionarioRepository.create(funcionario);
		Funcionario funcionarioConsulta = funcionarioRepository.findById(funcionario.getIdFuncionario());
		assertNotNull(funcionarioConsulta);
		assertEquals(funcionario, funcionarioConsulta);
	}
	

}
