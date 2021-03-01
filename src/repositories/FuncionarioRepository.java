package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Funcionario;
import interfaces.IFuncionarioRepository;

public class FuncionarioRepository implements IFuncionarioRepository {
	
	private Connection connection;
	
	public FuncionarioRepository(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void create(Funcionario funcionario) throws Exception {
		String query = "insert into funcionario values (null, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
		statement.setString(1, funcionario.getNome());
		statement.setString(2,  funcionario.getCpf());
		statement.setDouble(3,  funcionario.getSalario());
		statement.execute();
		
		ResultSet result = statement.getGeneratedKeys();
		if (result.next()) {
			funcionario.setIdFuncionario(result.getInt(1));
		}
		
		statement.close();
	}
	
	@Override
	public void update(Funcionario funcionario) throws Exception {
		String query = "update funcionario set nome = ?, cpf = ?, salario = ? where idfuncionario = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1,  funcionario.getNome());
		statement.setString(2, funcionario.getCpf());
		statement.setDouble(3, funcionario.getSalario());
		statement.setInt(4, funcionario.getIdFuncionario());
		statement.execute();
		statement.close();
	}
	
	@Override
	public void delete(Funcionario funcionario) throws Exception {
		String query = "delete from funcionario where idfuncionario = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, funcionario.getIdFuncionario());
		statement.execute();
		statement.close();
		
	}
	
	@Override
	public List<Funcionario> findAll() throws Exception {
		String query = "select * from funcionario";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet result = statement.executeQuery();
		List<Funcionario> lista = new ArrayList<Funcionario>();
		while (result.next()) {
			Funcionario funcionario = new Funcionario();
			funcionario.setIdFuncionario(result.getInt("idfuncionario"));
			funcionario.setNome(result.getString("nome"));
			funcionario.setCpf(result.getString("cpf"));  
			funcionario.setSalario(result.getDouble("salario"));
			lista.add(funcionario);
		}
		return lista;
	}
	
	@Override
	public Funcionario findById(Integer id) throws Exception {
		String query = "select * from funcionario where idfuncionario = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();
		if (result.next()) {
			Funcionario funcionario = new Funcionario();
			funcionario.setIdFuncionario(result.getInt("idfuncionario"));
			funcionario.setNome(result.getString("nome"));
			funcionario.setCpf(result.getString("cpf"));  
			funcionario.setSalario(result.getDouble("salario"));
			return funcionario;
		}
		else {
			return null;
		}
	
	}
	


}
