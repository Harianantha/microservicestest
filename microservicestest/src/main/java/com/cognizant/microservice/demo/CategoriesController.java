package com.cognizant.microservice.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

	private final static Logger LOGGER = Logger.getLogger(CategoriesController.class.getName()); 
    private final AtomicLong counter = new AtomicLong();
    private final static String CLASSNAME="CategoriesController";

    
    @RequestMapping(method=RequestMethod.GET)
    public List<Category> findAll() {
    	String methodName="categories";
    	LOGGER.entering(CLASSNAME, methodName);
    	
        Category books=new Category(10,"Books");
        Category clothing=new Category(20,"Clothing");
        Category electronics=new Category(30,"Electronics");
        Category hhutilities=new Category(40,"Household Utillities");
        
        List<Category> booksChildCategory= new ArrayList<Category>();
        
        List<Category> clothingChildCategory= new ArrayList<Category>();
        List<Category> electronicsCategory= new ArrayList<Category>();
        List<Category> hhCategory= new ArrayList<Category>();
        
        List<Product> bookProducts= new ArrayList<Product>();
        List<Product> clothingProducts= new ArrayList<Product>();
        List<Product> electronicsProducts= new ArrayList<Product>();
        List<Product> utiltiiesProducts= new ArrayList<Product>();
        
        
        Product book1=new Product(1,"MenAreFrom","Men are From Mars,Women are from Venus","Book about Psychoology",new Float("12.0"));
        Product book2=new Product(1,"Dummies","Java For Dummies","Java Starter book",new Float("10.0"));
        bookProducts.add(book1);
        bookProducts.add(book2);
        books.getProducts().addAll(bookProducts);
        LOGGER.logp(Level.INFO, CLASSNAME, methodName, "After getting products");
        Product cloth1=new Product(1,"Levis1","Levis 501","Classic Bluue Denim",new Float("30.0"));
        Product cloth2=new Product(1,"Formal1","Classic White Shirt","Formals",new Float("10.0"));
        
        clothingProducts.add(cloth1);
        clothingProducts.add(cloth2);
        clothing.getProducts().addAll(clothingProducts);
        
        
        Product electronics1=new Product(1,"iPAD","iPAD Air","Great tablet",new Float("1000.0"));
        Product electronics2=new Product(1,"SufacePro","Suface pro 128GB","Useful tablet",new Float("1000.0"));
        electronicsProducts.add(electronics1);
        electronicsProducts.add(electronics2);
        electronics.getProducts().addAll(electronicsProducts);
        
        Product utility1=new Product(1,"Window Screen","Window Screen","Green Table",new Float("10.0"));
        Product utility2=new Product(1,"Floor Mat","Floor Mat","Floor Mat",new Float("5.0"));
        utiltiiesProducts.add(utility1);
        utiltiiesProducts.add(utility2);
        hhutilities.getProducts().addAll(utiltiiesProducts);
        
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
        
        Category cellphones=new Category(7,"Cellphones");
        Category tablets=new Category(8,"Tablets");
        electronicsCategory.add(cellphones);
        electronicsCategory.add(tablets);
        electronics.getChildCategories().addAll(electronicsCategory);
        
        Category mats=new Category(70,"Mats");
        Category screen=new Category(80,"Screens");
        hhCategory.add(mats);
        hhCategory.add(screen);
        hhutilities.getChildCategories().addAll(hhCategory);
        
        List<Category> returnList=new ArrayList<Category>();
        returnList.add(books);
        returnList.add(clothing);
        returnList.add(electronics);
        returnList.add(hhutilities);
        LOGGER.exiting(CLASSNAME, methodName);
        return returnList;
        
        
        
    }
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Category findById(@PathVariable("id") long id) {
    	String methodName="findById";
    	LOGGER.entering(CLASSNAME, methodName);
    	LOGGER.logp(Level.INFO, CLASSNAME, methodName, "Getting category with ID:"+id);
    	//TODO ProperImplementation
    	Category category=null;
    	List<Category> categogires=findAll();
    	for(Category cgy:categogires){
    		if(cgy.getId()==id){
    			category=cgy;
    			break;
    		}
    	}
    	LOGGER.exiting(CLASSNAME, methodName);
        return category;
    }
    
}
