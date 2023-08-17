package map.Ordenacao;

import java.util.*;

public class LivrariaOnline {

    private Map<String, Livro> livrosMap;

    public LivrariaOnline() {
        this.livrosMap = new HashMap<>();
    }

    public void adicionarLivro(String link, Livro livro) {
        livrosMap.put(link, livro);
    }

    public void removerLivro(String titulo) {

        List<String> livroParaRemover = new ArrayList<>();

        for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            if (entry.getValue().getTitulo().equals(titulo)) {
                livroParaRemover.add(entry.getKey());
            }
        }

        if (!livroParaRemover.isEmpty()) {
            for (String link : livroParaRemover)
                livrosMap.remove(link);
            System.out.println("Livro removido: " + titulo);
        } else {
            System.out.println("Título não encontrado: " + titulo);
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {

        // para usar o metodo de ordenacao das Collections, crio uma lista para extrair chave e valor
        List<Map.Entry<String, Livro>> listaLivros = new LinkedList<>(livrosMap.entrySet());

        // para utilizar o metodo Collections.sort(), implementaremos um comparator que compara e ordena os elementos com base na ordem crescente de seus valores
        Collections.sort(listaLivros, new Comparator<Map.Entry<String, Livro>>() {
            @Override
            public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
                return (l1.getValue()).compareTo(l2.getValue());
            }
        });

        // criado LinkedHashMap para armazenar os elementos ordenados
        HashMap<String, Livro> livrosPorPreco = new LinkedHashMap<String, Livro>();
        for (Map.Entry<String, Livro> preco : listaLivros) {
            // elementos adicionados
            livrosPorPreco.put(preco.getKey(), preco.getValue());
        }

        return livrosPorPreco;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        Set<Map.Entry<String, Livro>> setLivrosPorAutor = new TreeSet<>(new ComparatorPorAutor());
        for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            if (entry.getValue().getAutor().equals(autor)) {
                setLivrosPorAutor.add(entry);
            }
        }

        Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry : setLivrosPorAutor) {
            livrosPorAutor.put(entry.getKey(), entry.getValue());
        }
        return livrosPorAutor;
    }

    public Livro obterLivroMaisCaro() {

        Livro livroMaisCaro = null;

        // NEGATIVE_INFINITY ou -1 são valores inválido para preços de livros. isso garante que
        // o primeiro livro encontrado (o ponto de partida) seja sempre considerado como o livro mais caro até o momento
        double precoMaisAlto = Double.NEGATIVE_INFINITY;

        for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            Livro livro = entry.getValue();
            if (livro.getPreco() > precoMaisAlto) {
                precoMaisAlto = livro.getPreco();
                livroMaisCaro = livro;
            }
        }
        return livroMaisCaro;
    }

    public Livro exibirLivroMaisBarato() {

        Livro livroMaisBarato = null;
        // garantir que seja um valor maior do que qualquer preço de livro possível
        //  garante que precoMaisBaixo comece com o MAIOR valor possível para um número
        //  ao percorrer os livros, atualiza o valor para o preço mais baixo encontrado
        double precoMaisBaixo = Double.MAX_VALUE;

        for (Map.Entry<String, Livro> entry : livrosMap.entrySet()) {
            Livro livro = entry.getValue();
            if (livro.getPreco() < precoMaisBaixo) {
                precoMaisBaixo = livro.getPreco();
                livroMaisBarato = livro;
            }
        }
        return livroMaisBarato;
    }

    public static void main(String[] args) {

        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Domain-Driven-Design-Eric-Evans/dp/8550800651/ref=pd_ci_mcx_mh_mcx_views_0?pd_rd_w=LFhup&content-id=amzn1.sym.6244f8fc-d9fe-4f51-896b-cf3e87c7b3b6%3Aamzn1.symc.40e6a10e-cbc4-4fa5-81e3-4435ff64d03b&pf_rd_p=6244f8fc-d9fe-4f51-896b-cf3e87c7b3b6&pf_rd_r=CV4QYCCX6KCND7BAXHG2&pd_rd_wg=0Q1bv&pd_rd_r=cf9c6175-de7d-47cd-9e7b-5ccf6fb46bd6&pd_rd_i=8550800651", new Livro("Domain-Driven Design: Atacando as complexidades no coração do software", "Eric Evans", 102.02));
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Pragmatic-Programmer-journey-mastery-Anniversary/dp/0135957052/ref=sr_1_4?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=17TSYI0W4590B&keywords=O+Programador+Pragm%C3%A1tico&qid=1692290131&s=books&sprefix=o+programador+pragm%C3%A1tico%2Cstripbooks%2C201&sr=1-4&ufe=app_do%3Aamzn1.fos.6a09f7ec-d911-4889-ad70-de8dd83c8a74", new Livro("The Pragmatic Programmer: Your Journey to Mastery", "David Thomas, Andrew Hunt", 235.59));
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/Entendendo-Algoritmos-Ilustrado-Programadores-Curiosos/dp/8575225634?ref_=Oct_d_otopr_d_7842670011_0&pd_rd_w=qw4Jz&content-id=amzn1.sym.578aa6a5-6bfa-4747-975c-cee0f889732e&pf_rd_p=578aa6a5-6bfa-4747-975c-cee0f889732e&pf_rd_r=G28TMRAC8X4B6X0AZJBB&pd_rd_wg=jxSTc&pd_rd_r=33e3224b-e993-47ea-9cdc-eccfc0c01bd7&pd_rd_i=8575225634", new Livro("Entendendo Algoritmos: Um Guia Ilustrado Para Programadores e Outros Curiosos", "Aditya Y. Bhargava ", 55.50));
        livrariaOnline.adicionarLivro("https://www.amazon.com.br/C%C3%B3digo-limpo-Robert-C-Martin/dp/8576082675?ref_=Oct_d_obs_d_7842670011_1&pd_rd_w=SAfEQ&content-id=amzn1.sym.21fe3f75-8033-45e9-8f13-11fbfa17d135&pf_rd_p=21fe3f75-8033-45e9-8f13-11fbfa17d135&pf_rd_r=G904XMVHQG26SSKAW9BJ&pd_rd_wg=tldba&pd_rd_r=235e8d5e-8c7c-4422-a417-54fb3a4e9a87&pd_rd_i=8576082675", new Livro("Código limpo: Habilidades práticas do Agile Software", "Robert C. Martin ", 91.99));

        System.out.println("Livros ordenados por preço " + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());
        System.out.println("Livro mais barato: " + livrariaOnline.exibirLivroMaisBarato());

        livrariaOnline.removerLivro("The Pragmatic Programmer: Your Journey to Mastery");

        System.out.println("Lista após remoção de um livro " + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        System.out.println("Pesquisa de livro por autor: " + livrariaOnline.pesquisarLivrosPorAutor("Eric Evans"));

    }

}
