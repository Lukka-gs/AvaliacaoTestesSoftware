package entities;

/**
 * Classe que representa um contato.
 * Contém os atributos e métodos para manipulação dos dados de um contato.
 * @author LuccaGSoares
 * @author TalesMCosta
 * @date 28/09/2024
 */
public class Contato {
    private int id;
    private String nome;
    private String email;
    private boolean ativo;

    /**
     * Construtor da classe Contato.
     * @param id ID do contato.
     * @param nome Nome do contato.
     * @param email Email do contato.
     * @param ativo Status do contato, se está ativo ou não.
     */
    public Contato(int id, String nome, String email, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.ativo = ativo;
    }

    // Getters e Setters
    /**
     * Retorna o ID do contato.
     * @return ID do contato.
     */
    public int getId() { return id; }

    /**
     * Define o ID do contato.
     * @param id Novo ID do contato.
     */
    public void setId(int id) { this.id = id; }

    /**
     * Retorna o nome do contato.
     * @return Nome do contato.
     */
    public String getNome() { return nome; }

    /**
     * Define o nome do contato.
     * @param nome Novo nome do contato.
     */
    public void setNome(String nome) { this.nome = nome; }

    /**
     * Retorna o email do contato.
     * @return Email do contato.
     */
    public String getEmail() { return email; }

    /**
     * Define o email do contato.
     * @param email Novo email do contato.
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Retorna o status ativo do contato.
     * @return true se o contato está ativo, false caso contrário.
     */
    public boolean isAtivo() { return ativo; }

    /**
     * Define o status ativo do contato.
     * @param ativo Novo status ativo do contato.
     */
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}
