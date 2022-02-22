package com.janawatECommerceSystem.janawatECommerceSystem;

import com.janawatECommerceSystem.janawatECommerceSystem.models.*;
import com.janawatECommerceSystem.janawatECommerceSystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JanawatECommerceSystemApplication {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProductRepository productRepository;
	@Autowired
	BrandRepository brandRepository;
	@Autowired
	ShopRepository shopRepository;
	@Autowired
	ProductModelRepository productModelRepository;
	@Autowired
	ProductReviewRepository productReviewRepository;

	@PostConstruct
	public  void initializeHelloUserData() {

		List<User> lsUsers = new ArrayList<>();
		lsUsers.add(new User(1,"Nuchit1"));
		lsUsers.add(new User(2,"Nuchit2"));
		lsUsers.add(new User(3,"Nuchit3"));
		lsUsers.add(new User(4,"Nuchit4"));
		lsUsers.add(new User(5,"Nuchit5"));		
		userRepository.saveAll(lsUsers);
	}

	@PostConstruct
	public void initializeProductData() {

		List<Brand> lsBrand = new ArrayList<>();
		lsBrand.add(new Brand(1, "Adidas","ยี่ห้อ Adidas","https://logos-world.net/wp-content/uploads/2020/04/Adidas-Logo-700x394.png","","ACTIVE",new Date(),null));
		lsBrand.add(new Brand(2, "Converse","ยี่ห้อ Converse","https://adaymagazine.com/wp-content/uploads/2021/04/CV_Logo.jpg","","ACTIVE",new Date(),null));
		lsBrand.add(new Brand(3, "Nike","ยี่ห้อ Nike","https://www.popticles.com/wp-content/uploads/2020/09/Nike-Logo-1978-1-1024x640.jpg","","ACTIVE",new Date(),null));
		lsBrand.add(new Brand(4, "New balance","ยี่ห้อ New balance","https://seeklogo.com/images/N/New_Balance-logo-F34722CB97-seeklogo.com.png","","ACTIVE",new Date(),null));
		lsBrand.add(new Brand(5, "Onitsuka Tiger","ยี่ห้อ Onitsuka Tiger","","","ACTIVE",new Date(),null));
		brandRepository.saveAll(lsBrand);

		List<Shop> lsShop = new ArrayList<>();
		lsShop.add(new Shop(1, "Sneaker shop","","กำแพงเพชร","","","ACTIVE",new Date(),null));
		lsShop.add(new Shop(2, "SUPERSPORTS ","","ตาก","","","ACTIVE",new Date(),null));
		shopRepository.saveAll(lsShop);

		List<ProductModel> lsProductModel = new ArrayList<>();
		lsProductModel.add(new ProductModel(1, "Beluga","ACTIVE",new Date(),null));
		lsProductModel.add(new ProductModel(2, "Pimeknit Core","ACTIVE",new Date(),null));
		lsProductModel.add(new ProductModel(3, "PK Japan Triple","ACTIVE",new Date(),null));
		lsProductModel.add(new ProductModel(4, "Sneakers Fashion","ACTIVE",new Date(),null));
		lsProductModel.add(new ProductModel(5, "Color Core Black/Icey","ACTIVE",new Date(),null));
		productModelRepository.saveAll(lsProductModel);

		List<ProductReview> lsProductReview = new ArrayList<>();
		lsProductReview.add(new ProductReview(4, 5, "ดีมากครับ","ACTIVE",new Date(),null));
		lsProductReview.add(new ProductReview(4, 3, "ใช้งานได้ดี","ACTIVE",new Date(),null));
		productReviewRepository.saveAll(lsProductReview);

		List<Product> lsProduct = new ArrayList<>();
		lsProduct.add(new Product(1,"ADIDAS VS Set รองเท้าลำลองผู้ชาย", "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน",750,50,"2022-3-15",0,1,5,"http://supersports-media-live-th.s3.amazonaws.com/product/21/205/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/21/205/1.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/21/205/2.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/21/205/3.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/21/205/4.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/21/205/5.jpg"},1,2,"ACTIVE",new Date(),null, new String[]{"36","38","40","42","44","45","50"}));
		lsProduct.add(new Product(2,"ADIDAS Lite Racer 2.0 รองเท้าลำลองผู้ชาย", "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน",850,50,"2022-4-15",0,2,15,"http://supersports-media-live-th.s3.amazonaws.com/product/14/006/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/14/006/1.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/14/006/2.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/14/006/3.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/14/006/4.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/14/006/5.jpg"},1,1,"ACTIVE",new Date(),null, new String[]{"36","38","40","42","44","45","50"}));
		lsProduct.add(new Product(3,"ADIDAS Lite Racer RBN 2.0 รองเท้าลำลองผู้ชาย", "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน",1100,25,"2022-5-15",0,3,20,"http://supersports-media-live-th.s3.amazonaws.com/product/34/038/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/34/038/1.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/34/038/2.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/34/038/3.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/34/038/4.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/34/038/5.jpg"},1,1,"ACTIVE",new Date(),null, new String[]{"36","38","40","42","44","45","50"}));
		lsProduct.add(new Product(4,"ADIDAS Questar Flow NXT รองเท้าลำลองผู้ชาย", "พรองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน",1380,30,"2022-6-25",1,4,25,"http://supersports-media-live-th.s3.amazonaws.com/product/87/719/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/87/719/1.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/87/719/2.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/87/719/3.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/87/719/4.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/87/719/5.jpg"},2,2,"ACTIVE",new Date(),null, new String[]{"36","38","40","42","44","45","50"}));
		lsProduct.add(new Product(5,"ADIDAS Questar Flow NXT รองเท้าลำลองผู้ชาย", "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน",1840,50,"2022-7-15",0,5,30,"http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/28/089/2.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/28/089/3.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/28/089/4.jpg","http://supersports-media-live-th.s3.amazonaws.com/product/28/089/5.jpg"},1,1,"ACTIVE",new Date(),null, new String[]{"36","38","40","42","44","45","50"}));
		productRepository.saveAll(lsProduct);
	}

	public static void main(String[] args) {
		SpringApplication.run(
				JanawatECommerceSystemApplication.class, args);
	}

}
