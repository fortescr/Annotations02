package br.projeto.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.projeto.entity.Cliente;
import br.projeto.model.ClienteDAO;

@ManagedBean
@ViewScoped
public class ClienteMB {


	private Cliente cliente;
	private List<Cliente> clientes;

	@PostConstruct
	public void init(){
		this.cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();
		clientes = clienteDAO.getLista();
	}

	public String salvar(){

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salva(cliente);

		clientes = clienteDAO.getLista();
		return "";
	}

	public String novo(){

		cliente = new Cliente();

		return "";
	}

	public String excluir(){

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.remove(cliente);
			
		return "";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}


}
