package avaliacao1;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Jogo {

    private String nome;
    private double preco;
    private List<CategoriaDeJogo> categorias;

    public Jogo() {
        this("", 0.0, new LinkedList<>());
    }

    public Jogo(String nome) {
        this(nome, 0.0, new LinkedList<>());
    }

    public Jogo(String nome, double preco, List<CategoriaDeJogo> categorias) {
        this.nome = nome;
        this.preco = preco;
        this.categorias = categorias;
    }

    public boolean adicionaCategoria(CategoriaDeJogo categoria) {
    	if (!this.categorias.contains(categoria)) {
    		this.categorias.add(categoria);
    		return true;
    	} else {
    		return false;
    	}
    } 
    
    public boolean ehDaCategoria(CategoriaDeJogo categoria) {
        for (CategoriaDeJogo cat : this.categorias) {
            if (cat.equals(categoria)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Jogo [nome=" + nome + ", preco=" + preco + "categorias=" + categorias + " ]";
    }

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogo other = (Jogo) obj;
		return Objects.equals(nome, other.nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<CategoriaDeJogo> getCategorias() {
        return this.categorias;
    }

	public void setCategorias(List<CategoriaDeJogo> categorias) {
        this.categorias = categorias;
    }
    
}
