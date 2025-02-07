//Works Cited: https://www.jackrutorial.com/2018/03/how-to-read-and-write-csv-files-in-java.html

package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;

public class ETLpipeline {

    public static void main(String[] args) {
        String inputFilePath = "data/products.csv";
        String outputFilePath = "data/transformed_products.csv";
        
        List<Product> products = readProducts(inputFilePath);
        if (products != null) {
            transformProducts(products);
            writeTransformedData(outputFilePath, products);
        }
    }

    // Method to read products from the input CSV file
    private static List<Product> readProducts(String filePath) {
        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int productID = Integer.parseInt(values[0]);
                String name = values[1];
                double price = Double.parseDouble(values[2]);
                String category = values[3];
                
                Product product = new Product(productID, name, price, category, "");
                products.add(product);
            }
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
            return null;
        }
        return products;
    }

    // Method to apply transformations to the product data
    private static void transformProducts(List<Product> products) {
        for (Product product : products) {
            // Apply discount if category is Electronics
            if ("Electronics".equals(product.getCategory())) {
                product.setPrice(product.getPrice() * 0.9); // Apply 10% discount
            }
            
            // Convert name to uppercase
            product.setName(product.getName().toUpperCase());

            // Adjust category for premium electronics
            if (product.getPrice() > 500) {
                product.setCategory("Premium Electronics");
            }

            // Assign price range
            String priceRange = getPriceRange(product.getPrice());
            product.setPriceRange(priceRange);
        }
    }

    // Helper method to determine price range
    private static String getPriceRange(double price) {
        if (price <= 10) return "Low";
        if (price <= 100) return "Medium";
        if (price <= 500) return "High";
        return "Premium";
    }

    // Method to write the transformed product data into the output CSV file
    private static void writeTransformedData(String filePath, List<Product> products) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // Write header
            bw.write("ProductID,Name,Price,Category,PriceRange\n");
            for (Product product : products) {
                // Write each product's data
                bw.write(product.getProductID() + ","
                        + product.getName() + ","
                        + String.format("%.2f", product.getPrice()) + ","
                        + product.getCategory() + ","
                        + product.getPriceRange() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing the output file: " + e.getMessage());
        }
    }
}
