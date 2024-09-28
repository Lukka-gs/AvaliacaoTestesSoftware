package dao;

import entities.Contato;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar os dados dos contatos em memória.
 * Realiza operações de adição, remoção e pesquisa de contatos.
 * @author LuccaGSoares
 * @author TalesMCosta
 * @date 28/09/2024
 */
public class ContatoDAO {
    private List<Contato> contatos;

    /**
     * Construtor da classe ContatoDAO.
     * Inicializa a lista de contatos.
     */
    public ContatoDAO() {
        this.contatos = new ArrayList<>();
    }

    /**
     * Retorna a lista de todos os contatos.
     * @return Lista de contatos.
     */
    public List<Contato> getContatos() {
        return contatos;
    }

    /**
     * Adiciona um novo contato à lista de contatos.
     * @param contato Contato a ser adicionado.
     */
    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    /**
     * Remove um contato da lista de contatos.
     * @param idContato ID do contato a ser removido.
     * @return true se o contato foi removido, false caso contrário.
     */
    public boolean removerContato(int idContato) {
        return contatos.removeIf(contato -> contato.getId() == idContato);
    }

    /**
     * Pesquisa por um contato a partir do seu ID.
     * @param idContato ID do contato a ser pesquisado.
     * @return O contato pesquisado ou null, caso não seja encontrado.
     */
    public Contato pesquisarContatoPorId(int idContato) {
        return contatos.stream()
                .filter(contato -> contato.getId() == idContato)
                .findFirst()
                .orElse(null);
    }

    /**
     * Limpa a lista de contatos, removendo todos os elementos.
     */
    public void limparContatos() {
        contatos.clear();
    }
}
