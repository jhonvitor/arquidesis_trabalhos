package teste;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import model.entidade.AlunoEntidade;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.AlunoDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlunoEntidadeTeste {
	AlunoEntidade AlunoEntidade, copia;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. Certifique-se também que sobrecarregou o equals na classe
	 * Cliente. Certifique-se que a fixture cliente1 foi criada no banco. Além
	 * disso, a ordem de execução dos testes é importante; por isso a anotação
	 * FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		AlunoEntidade = new AlunoEntidade(0, "Estranho", "Esta Rua", "28",
				"ap201", "12/12/82", "estranho@uol.com", "22222222",
				"999999999", "333333", "42414654805");
		copia = new AlunoEntidade(0, "Estranho", "Esta Rua", "28",
				"ap201", "12/12/82", "estranho@uol.com", "22222222",
				"999999999", "333333", "42414654805");
	}

	@Test
	public void test00Carregar() {
		// para funcionar o cliente 1 deve ter sido carregado no banco por fora
		// insert into cliente (id, nome, fone) values (1, 'nome1', 'fone1');
		AlunoEntidade fixture = new AlunoEntidade(28,
				"ACILDES FERNADES FULANO", "RUA QUALQUER LUGAR TA BOM", "452",
				"AP 201", "29/10/1980", "acildes@gmail.com", "1124585566",
				"11925543258", "155336655", "09170825750");
		AlunoEntidade novo = new AlunoEntidade(28, "", "", "", "", "", "", "", "", "", "09170825750");
		ArrayList<model.entidade.AlunoEntidade> arrayL = new ArrayList<AlunoEntidade>();
		arrayL = new AlunoDao().consultaPorCpf(novo);
		novo = arrayL.get(0);
		//JOptionPane.showMessageDialog(null, novo.getCpf());
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		new AlunoDao().incluir(AlunoEntidade);
		ArrayList<model.entidade.AlunoEntidade> arrayL = new ArrayList<AlunoEntidade>();
		arrayL = new AlunoDao().consultaPorCpf(AlunoEntidade);
		assertEquals("testa criacao", arrayL.get(0), copia);
	}

	@Test
	public void test02Atualizar() {
		AlunoEntidade.setTelRes("666666666");;
		copia.setTelRes("666666666");
		new AlunoDao().Alterar(AlunoEntidade);
		ArrayList<model.entidade.AlunoEntidade> arrayL = new ArrayList<AlunoEntidade>();
		arrayL = new AlunoDao().consultaPorCpf(AlunoEntidade);
		assertEquals("testa inclusao", arrayL.get(0), copia);
	}

	@Test
	public void test03Excluir() {
		
		AlunoEntidade copia = new AlunoEntidade();
		new AlunoDao().excluirPorCpf("42414654805");
		ArrayList<model.entidade.AlunoEntidade> arrayL = new ArrayList<AlunoEntidade>();
		arrayL = new AlunoDao().consultaPorCpf(AlunoEntidade);
		assertEquals("testa exclusao", arrayL.get(0), copia);
	}
}