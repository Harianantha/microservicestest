package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriesController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/categories")
    public List<Category> categories() {
        Category books=new Category(1,"Books");
        Category clothing=new Category(2,"Clothing");
        
        List<Category> booksChildCategory= new ArrayList<Category>();
        List<Category> clothingChildCategory= new ArrayList<Category>();
        
        List<Product> bookProducts= new ArrayList<Product>();
        List<Product> clothingProducts= new ArrayList<Product>();
        
        
        Product book1=new Product(1,"MenAreFrom","Men are From Mars,Women are from Venus","Book about Psychoology",new Float("12.0"));
        Product book2=new Product(1,"Dummies","Java For Dummies","Java Starter book",new Float("10.0"));
        bookProducts.add(book1);
        bookProducts.add(book2);
        books.getProducts().addAll(bookProducts);
        
        Product cloth1=new Product(1,"Levis1","Levis 501","Classic Bluue Denim",new Float("30.0"));
        Product cloth2=new Product(1,"Formal1","Classic White Shirt","Formals",new Float("10.0"));
        
        clothingProducts.add(cloth1);
        clothingProducts.add(cloth2);
        clothing.getProducts().addAll(clothingProducts);
        
        Category fiction=new Category(3,"Fiction");
        Category management=new Category(4,"Management");
        booksChildCategory.add(fiction);
        booksChildCategory.add(management);
        books.getChildCategories().addAll(booksChildCategory);
        
        Category denims=new Category(5,"Denim");
        Category shirts=new Category(6,"Shirts");
        clothingChildCategory.add(denims);
        clothingChildCategory.add(shirts);
        clothing.getChildCategories().addAll(clothingChildCategory);
        
        List<Category> returnList=new ArrayList<Category>();
        returnList.add(books);
        returnList.add(clothing);
        return returnList;
        
        
        
    }
}