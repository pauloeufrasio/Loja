
package br.com.alura.loja.modelo;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

// A anotação @Entity indica que a classe Produto é uma entidade JPA e será mapeada para uma tabela no banco de dados.
@Entity
// A anotação @Table especifica o nome da tabela no banco de dados em que a entidade será armazenada.
@Table(name = "produto")
public class Produto {

    // A anotação @Id indica que o campo id é a chave primária da tabela.
    @Id
    // A anotação @GeneratedValue especifica a estratégia de geração de valores para a chave primária. Nesse caso, está configurado para usar uma estratégia de identidade.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // A anotação @Column é usada para mapear o campo nome para a coluna "nome" na tabela do banco de dados.
    @Column(name = "nome")
    private String nome;

    // A anotação @Column é usada para mapear o campo descricao para a coluna "descricao" na tabela do banco de dados.
    @Column(name = "descricao")
    private String descricao;

    // A anotação @Column é usada para mapear o campo preco para a coluna "preco" na tabela do banco de dados.
    @Column(name = "preco")
    private BigDecimal preco;

    // A anotação @Column é usada para mapear o campo dataCadastro para a coluna "dataCadastro" na tabela do banco de dados.
    @Column(name = "dataCadastro")
    private LocalDate dataCadastro = LocalDate.now();

    // A anotação @ManyToOne indica que a relação entre Produto e Categoria é muitos para um, ou seja, vários produtos podem estar associados a uma única categoria.
    @ManyToOne
    private Categoria categoria;

    // Construtor padrão da classe Produto.
    public Produto() {}

    // Construtor da classe Produto que recebe os dados do produto como argumentos.
    public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    // Métodos getters e setters para os campos da classe.

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
