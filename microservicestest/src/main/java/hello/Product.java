package hello;

public class Product {

    private final long id;
    private final String productName;
    private final String productTitle;
    private final String productDescription;
    private final Float productPrice;
    

    public Product(long id, String productName,String productTitle,String productDescription,Float productPrice) {
        this.id = id;
        this.productName = productName;
        this.productTitle = productTitle;
        this.productDescription=productDescription;
        this.productPrice=productPrice;
    }


	public long getId() {
		return id;
	}


	public String getProductName() {
		return productName;
	}


	public String getProductTitle() {
		return productTitle;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public Float getProductPrice() {
		return productPrice;
	}

   
}
