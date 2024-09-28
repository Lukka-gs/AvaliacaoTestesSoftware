import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import dao.ContatoDAOTest;

/**
 * Suite de testes para executar todos os testes do projeto.
 * Inclui todas as classes de teste existentes.
 * @author LuccaGSoares
 * @author TalesMCosta
 * @date 28/09/2024
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContatoDAOTest.class
})
public class AllTests {
    // Esta classe permanece vazia. É usada apenas como um contêiner para a anotação @Suite.SuiteClasses
}
