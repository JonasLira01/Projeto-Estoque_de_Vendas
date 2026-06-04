package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductFileReader {
    
    public static List<Product> readProductsFromCSV(String filePath) {
        List<Product> products = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // Pula linhas vazias
                }
                
                String[] data = line.split(",");
                
                if (data.length == 3) {
                    String name = data[0].trim();
                    double price = Double.parseDouble(data[1].trim());
                    int quantity = Integer.parseInt(data[2].trim());
                    
                    Product product = new Product(name, price, quantity);
                    products.add(product);
                    
                    System.out.println("Produto lido: " + name + " | Preço: " + price + " | Quantidade: " + quantity);
                }
            }
            
            System.out.println("\nTotal de produtos carregados: " + products.size());
            
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter dados: " + e.getMessage());
        }
        
        return products;
    }
}
