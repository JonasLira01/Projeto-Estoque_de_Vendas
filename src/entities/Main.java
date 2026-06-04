
package entities;
import java.util.Scanner;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        // Lista para armazenar os produtos lidos do arquivo
        List<Product> products = new ArrayList<>();
        String filePath = "products.csv";
        
        // Lê o arquivo e carrega os produtos
        loadProductsFromFile(filePath, products, sc);
        
        // Menu interativo para editar produtos
        boolean exit = false;
        while (!exit) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1 - Listar produtos");
            System.out.println("2 - Editar produto");
            System.out.println("3 - Adicionar produto");
            System.out.println("4 - Remover produto");
            System.out.println("5 - Salvar e sair");
            System.out.print("Escolha uma opção: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // Limpa o buffer
            
            switch (choice) {
                case 1:
                    // Lista todos os produtos
                    listProducts(products);
                    break;
                case 2:
                    // Edita um produto existente
                    editProduct(products, sc);
                    break;
                case 3:
                    // Adiciona um novo produto
                    addProduct(products, sc);
                    break;
                case 4:
                    // Remove um produto
                    removeProduct(products, sc);
                    break;
                case 5:
                    // Salva no arquivo e sai
                    saveProductsToFile(filePath, products);
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        
        sc.close();
        System.out.println("Programa finalizado!");
    }
    
    // Método para ler arquivo e carregar produtos
    public static void loadProductsFromFile(String filePath, List<Product> products, Scanner sc) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    String name = fields[0].trim();
                    double price = Double.parseDouble(fields[1].trim());
                    int quantity = Integer.parseInt(fields[2].trim());
                    products.add(new Product(name, price, quantity));
                }
            }
            System.out.println(products.size() + " produtos carregados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar arquivo: " + e.getMessage());
            }
        }
    }
    
    // Método para listar todos os produtos
    public static void listProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }
        System.out.println("\n===== LISTA DE PRODUTOS =====");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println((i + 1) + ". " + p.getName() + " - R$ " + 
                             String.format("%.2f", p.getPrice()) + " - Qtd: " + p.getQuantity());
        }
    }
    
    // Método para editar um produto
    public static void editProduct(List<Product> products, Scanner sc) {
        listProducts(products);
        if (products.isEmpty()) return;
        
        System.out.print("Digite o número do produto a editar: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();
        
        if (index < 0 || index >= products.size()) {
            System.out.println("Produto inválido!");
            return;
        }
        
        Product product = products.get(index);
        System.out.println("\nEditando: " + product.getName());
        System.out.print("Novo nome (atual: " + product.getName() + "): ");
        String newName = sc.nextLine();
        
        System.out.print("Novo preço (atual: " + product.getPrice() + "): ");
        double newPrice = sc.nextDouble();
        
        System.out.print("Nova quantidade (atual: " + product.getQuantity() + "): ");
        int newQuantity = sc.nextInt();
        sc.nextLine();
        
        // Atualiza o produto
        product.setName(newName.isEmpty() ? product.getName() : newName);
        product.setPrice(newPrice);
        product.setQuantity(newQuantity);
        
        System.out.println("Produto atualizado com sucesso!");
    }
    
    // Método para adicionar um novo produto
    public static void addProduct(List<Product> products, Scanner sc) {
        System.out.print("Nome do produto: ");
        String name = sc.nextLine();
        
        System.out.print("Preço: ");
        double price = sc.nextDouble();
        
        System.out.print("Quantidade: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        
        products.add(new Product(name, price, quantity));
        System.out.println("Produto adicionado com sucesso!");
    }
    
    // Método para remover um produto
    public static void removeProduct(List<Product> products, Scanner sc) {
        listProducts(products);
        if (products.isEmpty()) return;
        
        System.out.print("Digite o número do produto a remover: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();
        
        if (index < 0 || index >= products.size()) {
            System.out.println("Produto inválido!");
            return;
        }
        
        String removedName = products.get(index).getName();
        products.remove(index);
        System.out.println("Produto '" + removedName + "' removido com sucesso!");
    }
    
    // Método para salvar produtos no arquivo
    public static void saveProductsToFile(String filePath, List<Product> products) {
        try (FileWriter fw = new FileWriter(filePath)) {
            for (Product p : products) {
                fw.write(p.getName() + "," + p.getPrice() + "," + p.getQuantity() + "\n");
            }
            System.out.println("Arquivo salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}
