package com.george.cursomc.services;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.george.cursomc.domain.Categoria;
import com.george.cursomc.domain.Cidade;
import com.george.cursomc.domain.Cliente;
import com.george.cursomc.domain.Endereco;
import com.george.cursomc.domain.Estado;
import com.george.cursomc.domain.ItemPedido;
import com.george.cursomc.domain.Pagamento;
import com.george.cursomc.domain.PagamentoComBoleto;
import com.george.cursomc.domain.PagamentoComCartao;
import com.george.cursomc.domain.Pedido;
import com.george.cursomc.domain.Produto;
import com.george.cursomc.domain.enums.EstadoPagamento;
import com.george.cursomc.domain.enums.Perfil;
import com.george.cursomc.domain.enums.TipoCliente;
import com.george.cursomc.repositories.CategoriaRepository;
import com.george.cursomc.repositories.CidadeRepository;
import com.george.cursomc.repositories.ClienteRepository;
import com.george.cursomc.repositories.EnderecoRepository;
import com.george.cursomc.repositories.EstadoRepository;
import com.george.cursomc.repositories.ItemPedidoRepository;
import com.george.cursomc.repositories.PagamentoRepository;
import com.george.cursomc.repositories.PedidoRepository;
import com.george.cursomc.repositories.ProdutoRepository;

@Service
public class DBService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public void instantiateTestDatabase() throws Exception{
		Categoria cat1 = new Categoria(null, "Escritório");
		Categoria cat2 = new Categoria(null, "Informática");
		Categoria cat3 = new Categoria(null, "Eletrônico");
		Categoria cat4 = new Categoria(null, "Games");
		Categoria cat5 = new Categoria(null, "Eletrodomésitco");
		Categoria cat6 = new Categoria(null, "Vestuário");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		Cliente cli1 = new Cliente(null, "Maria", "georgemichel41@hotmail.com", "12158749366", TipoCliente.PESSOAFISICA, pe.encode("123"));
		Cliente cli2 = new Cliente(null, "Ana", "georgemmp@unipam.edu.br", "66440656007", TipoCliente.PESSOAFISICA, pe.encode("123"));
		
		Endereco e1 = new Endereco(null, "Rua tal", "12", "", "Centro", "38700000", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua tal", "45", "", "Jardim America", "38700000", cli1, c2);
		Endereco e3 = new Endereco(null, "Rua 05", "66", "", "Jardim Itália", "38700000", cli2, c3);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 10:32"), cli1, e2);
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, null, sdf.parse("200/10/2017 00:00"));
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		cli2.addPerfil(Perfil.ADMIN);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		cli1.getTelefones().addAll(Arrays.asList("32895641"));
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		cli2.getTelefones().addAll(Arrays.asList("38224569", "998654552"));
		cli2.getEnderecos().addAll(Arrays.asList(e3));
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}
