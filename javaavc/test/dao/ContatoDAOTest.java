package dao;

import entities.Contato;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre contatos, realizadas pela classe {@link ContatoDAO}.
 * @author LuccaGSoares
 * @author TalesMCosta
 * @date 28/09/2024
 */
public class ContatoDAOTest {

    private ContatoDAO contatoDAO;

    /**
     * Configura o ambiente de teste antes de cada método.
     */
    @Before
    public void setUp() {
        /*===================== Fase1: Montagem do Cenário Global ===============================*/
        contatoDAO = new ContatoDAO();
        contatoDAO.adicionarContato(new Contato(1, "Lucca Soares", "lucca@luccasoares.com.br", true));
        contatoDAO.adicionarContato(new Contato(2, "Tales Costa", "tales@talescosta.com.br", true));
    }

    /**
     * Limpa o ambiente de teste após cada método.
     */
    @After
    public void tearDown() {
        /*===================== Fase4: Desmontagem do Cenário Global ===============================*/
        contatoDAO.limparContatos();
    }

    /**
     * Testa a adição de um novo contato à lista.
     */
    @Test
    public void testAdicionarContato() {
        /*===================== Fase1: Montagem do Cenário ===============================*/
        Contato novoContato = new Contato(3, "Alice Johnson", "alice@example.com", true);

        /*===================== Fase2: Execução do Teste ===============================*/
        contatoDAO.adicionarContato(novoContato);

        /*===================== Fase3: Verificação e Análise ==============================*/
        Contato contatoPesquisado = contatoDAO.pesquisarContatoPorId(3);
        assertNotNull(contatoPesquisado);
        assertEquals("Alice Johnson", contatoPesquisado.getNome());
        assertEquals("alice@example.com", contatoPesquisado.getEmail());
        assertTrue(contatoPesquisado.isAtivo());
        assertEquals(3, contatoDAO.obterTodosContatos().size());
    }

    /**
     * Testa a adição de um contato com ID duplicado.
     */
    @Test
    public void testAdicionarContatoDuplicado() {
        /*===================== Fase1: Montagem do Cenário ===============================*/
        Contato novoContato = new Contato(1, "Duplicate User", "duplicate@example.com", true);

        /*===================== Fase2: Execução do Teste ===============================*/
        contatoDAO.adicionarContato(novoContato);

        /*===================== Fase3: Verificação e Análise ==============================*/
        // Verifica se ainda existe apenas um contato com ID 1 e se ele não foi substituído.
        Contato contatoPesquisado = contatoDAO.pesquisarContatoPorId(1);
        assertNotNull(contatoPesquisado);
        assertEquals("Lucca Soares", contatoPesquisado.getNome()); // O nome do contato original é mantido
        assertEquals("lucca@luccasoares.com.br", contatoPesquisado.getEmail()); // O email do contato original é mantido
        assertTrue(contatoPesquisado.isAtivo()); // O status do contato é mantido
    }

    /**
     * Testa a remoção de um contato existente.
     */
    @Test
    public void testRemoverContato() {
        /*===================== Fase1: Montagem do Cenário ===============================*/
        int idContatoRemover = 1;

        /*===================== Fase2: Execução do Teste ===============================*/
        boolean contatoRemovido = contatoDAO.removerContato(idContatoRemover);

        /*===================== Fase3: Verificação e Análise ==============================*/
        assertTrue(contatoRemovido);
        assertNull(contatoDAO.pesquisarContatoPorId(idContatoRemover));
        assertEquals(1, contatoDAO.obterTodosContatos().size());
        assertEquals("Tales Costa", contatoDAO.pesquisarContatoPorId(2).getNome()); // verificando se não deletou o outro que tem no banco
        assertEquals("tales@talescosta.com.br", contatoDAO.pesquisarContatoPorId(2).getEmail()); // verificando se não deletou o outro que tem no banco
    }

    /**
     * Testa a remoção de um contato inexistente.
     */
    @Test
    public void testRemoverContatoInexistente() {
        /*===================== Fase1: Montagem do Cenário ===============================*/
        int idContatoRemover = 99;

        /*===================== Fase2: Execução do Teste ===============================*/
        boolean contatoRemovido = contatoDAO.removerContato(idContatoRemover);

        /*===================== Fase3: Verificação e Análise ==============================*/
        assertFalse(contatoRemovido);
        assertNull(contatoDAO.pesquisarContatoPorId(idContatoRemover));
    }

    /**
     * Testa a pesquisa de um contato pelo ID.
     */
    @Test
    public void testPesquisarContatoPorId() {
        /*===================== Fase1: Montagem do Cenário ===============================*/
        int idContatoPesquisar = 2;

        /*===================== Fase2: Execução do Teste ===============================*/
        Contato contato = contatoDAO.pesquisarContatoPorId(idContatoPesquisar);

        /*===================== Fase3: Verificação e Análise ==============================*/
        assertNotNull(contato);
        assertEquals("Tales Costa", contato.getNome());
    }

    /**
     * Testa a pesquisa de um contato inexistente pelo ID.
     */
    @Test
    public void testPesquisarContatoPorIdInexistente() {
        /*===================== Fase1: Montagem do Cenário ===============================*/
        int idContatoPesquisar = 99;

        /*===================== Fase2: Execução do Teste ===============================*/
        Contato contato = contatoDAO.pesquisarContatoPorId(idContatoPesquisar);

        /*===================== Fase3: Verificação e Análise ==============================*/
        assertNull(contato);
    }
}
