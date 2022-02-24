package com.janawatECommerceSystem.janawatECommerceSystem;

import com.janawatECommerceSystem.janawatECommerceSystem.models.*;
import com.janawatECommerceSystem.janawatECommerceSystem.repository.*;
import com.janawatECommerceSystem.janawatECommerceSystem.services.PaymentMethodService;
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
    private ProductRepository productRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ProductModelRepository productModelRepository;
    @Autowired
    private ProductReviewRepository productReviewRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private ReceiveRepository receiveRepository;

    public static void main(String[] args) {
        SpringApplication.run(JanawatECommerceSystemApplication.class, args);
    }

    @PostConstruct
    public void createInitialData() {


        Address address = new Address(1, "Nuchit Atjanawat", "No.247 Soi village is prosperous.", "085 911 7659", "Wang Thonglang", "Bangkok", "10310");


        Customer customer = new Customer(1, "Customer Nuchit");


        User newUser = new User("nuchit", "1234", "jnuchit@gmail.com", "Nuchit", "Atjanawat");

        address.setCustomer(customer);
        newUser.setCustomer(customer);
        customer.setUser(newUser);


        userRepository.save(newUser);
        addressRepository.save(address);
        receiveRepository.save(new Receiver(newUser.getUsername(), address));


        PaymentMethod paymentMethod = new PaymentMethod(1, "NUCHIT", "creditCard", "Nuchit Atjanawat", "5555444466667777", "2024/12", "555");
        paymentMethodRepository.save(paymentMethod);


        List<Brand> lsBrand = new ArrayList<>();
        lsBrand.add(new Brand(1, "Adidas", "ยี่ห้อ Adidas", "https://logos-world.net/wp-content/uploads/2020/04/Adidas-Logo-700x394.png", "", "ACTIVE", new Date(), null));
        lsBrand.add(new Brand(2, "Converse", "ยี่ห้อ Converse", "https://adaymagazine.com/wp-content/uploads/2021/04/CV_Logo.jpg", "", "ACTIVE", new Date(), null));
        lsBrand.add(new Brand(3, "Nike", "ยี่ห้อ Nike", "https://www.popticles.com/wp-content/uploads/2020/09/Nike-Logo-1978-1-1024x640.jpg", "", "ACTIVE", new Date(), null));
        lsBrand.add(new Brand(4, "New balance", "ยี่ห้อ New balance", "https://seeklogo.com/images/N/New_Balance-logo-F34722CB97-seeklogo.com.png", "", "ACTIVE", new Date(), null));
        lsBrand.add(new Brand(5, "Onitsuka Tiger", "ยี่ห้อ Onitsuka Tiger", "", "", "ACTIVE", new Date(), null));
        brandRepository.saveAll(lsBrand);

        List<Shop> lsShop = new ArrayList<>();
        lsShop.add(new Shop(1, "Sneaker shop", "", "กำแพงเพชร", "", "", "ACTIVE", new Date(), null));
        lsShop.add(new Shop(2, "SUPERSPORTS ", "", "ตาก", "", "", "ACTIVE", new Date(), null));
        shopRepository.saveAll(lsShop);

        List<ProductModel> lsProductModel = new ArrayList<>();
        lsProductModel.add(new ProductModel(1, "Beluga", "ACTIVE", new Date(), null));
        lsProductModel.add(new ProductModel(2, "Pimeknit Core", "ACTIVE", new Date(), null));
        lsProductModel.add(new ProductModel(3, "PK Japan Triple", "ACTIVE", new Date(), null));
        lsProductModel.add(new ProductModel(4, "Sneakers Fashion", "ACTIVE", new Date(), null));
        lsProductModel.add(new ProductModel(5, "Color Core Black/Icey", "ACTIVE", new Date(), null));
        productModelRepository.saveAll(lsProductModel);

        List<ProductReview> lsProductReview = new ArrayList<>();
        lsProductReview.add(new ProductReview(3, 5, "ดีมาก", "ACTIVE", new Date(), null));
        lsProductReview.add(new ProductReview(4, 5, "ใช้งานดี", "ACTIVE", new Date(), null));
        productReviewRepository.saveAll(lsProductReview);

        List<Product> lsProduct = new ArrayList<>();
        lsProduct.add(new Product(1, "ADIDAS VS Set รองเท้าลำลองผู้ชาย", "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน", 750.0, 50.0, "2022-3-15", 0, 1, 5, "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/21/205/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/21/205/5.jpg"}, 1, 2, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
        lsProduct.add(new Product(2, "ADIDAS Lite Racer 2.0 รองเท้าลำลองผู้ชาย", "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน", 850.0, 50.0, "2022-4-15", 0, 2, 15, "http://supersports-media-live-th.s3.amazonaws.com/product/14/006/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/14/006/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/14/006/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/14/006/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/14/006/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/14/006/5.jpg"}, 1, 1, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
        lsProduct.add(new Product(3, "ADIDAS Lite Racer RBN 2.0 รองเท้าลำลองผู้ชาย", "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน", 1100.0, 25.0, "2022-5-15", 0, 3, 20, "http://supersports-media-live-th.s3.amazonaws.com/product/34/038/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/34/038/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/34/038/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/34/038/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/34/038/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/34/038/5.jpg"}, 1, 1, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
        lsProduct.add(new Product(4, "ADIDAS Questar Flow NXT รองเท้าลำลองผู้ชาย", "พรองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน", 1380.0, 30.0, "2022-6-25", 1, 4, 25, "http://supersports-media-live-th.s3.amazonaws.com/product/87/719/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/87/719/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/87/719/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/87/719/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/87/719/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/87/719/5.jpg"}, 2, 2, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
        lsProduct.add(new Product(5, "ADIDAS รองเท้ากีฬา รุ่น Advantage Base - สี Core Black", "รองเท้าลำลองผู้ชาย ADIDAS Questar Flow NXT น้ำหนักเบาและระบายอากาศได้ดีด้วยอัปเปอร์ผ้าตาข่ายถัก ที่พื้นรองเท้ามีโฟม Cloudfoam มอบความนุ่มสบายสูงสุด เหมาะสำหรับสวมใส่ได้ทุกวัน", 1840.0, 50.0, "2022-7-15", 0, 5, 30, "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/5.jpg"}, 1, 1, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));

        lsProduct.add(new Product(6, "ADIDAS รองเท้า ULTRABOOST 5.0 DNA", "พัฒนาจากห้วงอวกาศ สู่การสร้างสรรค์เพื่อโลกด้วยหัวใจ รองเท้าวิ่งอาดิดาส Ultraboost คู่นี้เฉลิมฉลองแด่การเป็นพันธมิตรร่วมกับ NASA ด้วยตราโครงการ Artemis บนลิ้นรองเท้า สามารถสวมเดินบนท้องถนนในเมือง หรือเก็บขยะริมชายหาดก็ได้ อัปเปอร์ผ้า adidas Primeknit สัมผัสนุ่มโอบกระชับเท้า ประกอบเข้ากับพื้นชั้นล่าง Boost มอบความสบายที่กล้าท้าให้คุณมาพิสูจน์", 1840.0, 50.0, "2022-7-15", 0, 5, 30, "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/5.jpg"}, 1, 1, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
        lsProduct.add(new Product(7, "ADIDAS รองเท้า ULTRABOOST 5.0 DNA...1", "พัฒนาจากห้วงอวกาศ สู่การสร้างสรรค์เพื่อโลกด้วยหัวใจ รองเท้าวิ่งอาดิดาส Ultraboost คู่นี้เฉลิมฉลองแด่การเป็นพันธมิตรร่วมกับ NASA ด้วยตราโครงการ Artemis บนลิ้นรองเท้า สามารถสวมเดินบนท้องถนนในเมือง หรือเก็บขยะริมชายหาดก็ได้ อัปเปอร์ผ้า adidas Primeknit สัมผัสนุ่มโอบกระชับเท้า ประกอบเข้ากับพื้นชั้นล่าง Boost มอบความสบายที่กล้าท้าให้คุณมาพิสูจน์", 1840.0, 50.0, "2022-7-15", 0, 5, 30, "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/5.jpg"}, 1, 1, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
        lsProduct.add(new Product(8, "ADIDAS รองเท้า ULTRABOOST 5.0 DNA...2", "พัฒนาจากห้วงอวกาศ สู่การสร้างสรรค์เพื่อโลกด้วยหัวใจ รองเท้าวิ่งอาดิดาส Ultraboost คู่นี้เฉลิมฉลองแด่การเป็นพันธมิตรร่วมกับ NASA ด้วยตราโครงการ Artemis บนลิ้นรองเท้า สามารถสวมเดินบนท้องถนนในเมือง หรือเก็บขยะริมชายหาดก็ได้ อัปเปอร์ผ้า adidas Primeknit สัมผัสนุ่มโอบกระชับเท้า ประกอบเข้ากับพื้นชั้นล่าง Boost มอบความสบายที่กล้าท้าให้คุณมาพิสูจน์", 1840.0, 50.0, "2022-7-15", 0, 5, 30, "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/5.jpg"}, 1, 1, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
        lsProduct.add(new Product(9, "ADIDAS รองเท้า ULTRABOOST 5.0 DNA...3", "พัฒนาจากห้วงอวกาศ สู่การสร้างสรรค์เพื่อโลกด้วยหัวใจ รองเท้าวิ่งอาดิดาส Ultraboost คู่นี้เฉลิมฉลองแด่การเป็นพันธมิตรร่วมกับ NASA ด้วยตราโครงการ Artemis บนลิ้นรองเท้า สามารถสวมเดินบนท้องถนนในเมือง หรือเก็บขยะริมชายหาดก็ได้ อัปเปอร์ผ้า adidas Primeknit สัมผัสนุ่มโอบกระชับเท้า ประกอบเข้ากับพื้นชั้นล่าง Boost มอบความสบายที่กล้าท้าให้คุณมาพิสูจน์", 1840.0, 50.0, "2022-7-15", 0, 5, 30, "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/5.jpg"}, 1, 1, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
        lsProduct.add(new Product(10, "ADIDAS รองเท้า ULTRABOOST 5.0 DNA...4", "พัฒนาจากห้วงอวกาศ สู่การสร้างสรรค์เพื่อโลกด้วยหัวใจ รองเท้าวิ่งอาดิดาส Ultraboost คู่นี้เฉลิมฉลองแด่การเป็นพันธมิตรร่วมกับ NASA ด้วยตราโครงการ Artemis บนลิ้นรองเท้า สามารถสวมเดินบนท้องถนนในเมือง หรือเก็บขยะริมชายหาดก็ได้ อัปเปอร์ผ้า adidas Primeknit สัมผัสนุ่มโอบกระชับเท้า ประกอบเข้ากับพื้นชั้นล่าง Boost มอบความสบายที่กล้าท้าให้คุณมาพิสูจน์", 1840.0, 50.0, "2022-7-15", 0, 5, 30, "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/5.jpg"}, 1, 1, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));

        lsProduct.add(new Product(11, "ADIDAS รองเท้า ULTRABOOST 5.0 DNA...11", "พัฒนาจากห้วงอวกาศ สู่การสร้างสรรค์เพื่อโลกด้วยหัวใจ รองเท้าวิ่งอาดิดาส Ultraboost คู่นี้เฉลิมฉลองแด่การเป็นพันธมิตรร่วมกับ NASA ด้วยตราโครงการ Artemis บนลิ้นรองเท้า สามารถสวมเดินบนท้องถนนในเมือง หรือเก็บขยะริมชายหาดก็ได้ อัปเปอร์ผ้า adidas Primeknit สัมผัสนุ่มโอบกระชับเท้า ประกอบเข้ากับพื้นชั้นล่าง Boost มอบความสบายที่กล้าท้าให้คุณมาพิสูจน์", 1840.0, 50.0, "2022-7-15", 0, 5, 30, "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/5.jpg"}, 1, 1, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
        lsProduct.add(new Product(12, "ADIDAS รองเท้า ULTRABOOST 5.0 DNA...12", "พัฒนาจากห้วงอวกาศ สู่การสร้างสรรค์เพื่อโลกด้วยหัวใจ รองเท้าวิ่งอาดิดาส Ultraboost คู่นี้เฉลิมฉลองแด่การเป็นพันธมิตรร่วมกับ NASA ด้วยตราโครงการ Artemis บนลิ้นรองเท้า สามารถสวมเดินบนท้องถนนในเมือง หรือเก็บขยะริมชายหาดก็ได้ อัปเปอร์ผ้า adidas Primeknit สัมผัสนุ่มโอบกระชับเท้า ประกอบเข้ากับพื้นชั้นล่าง Boost มอบความสบายที่กล้าท้าให้คุณมาพิสูจน์", 1840.0, 50.0, "2022-7-15", 0, 5, 30, "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/5.jpg"}, 1, 1, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));
        lsProduct.add(new Product(13, "ADIDAS รองเท้า ULTRABOOST 5.0 DNA...13", "พัฒนาจากห้วงอวกาศ สู่การสร้างสรรค์เพื่อโลกด้วยหัวใจ รองเท้าวิ่งอาดิดาส Ultraboost คู่นี้เฉลิมฉลองแด่การเป็นพันธมิตรร่วมกับ NASA ด้วยตราโครงการ Artemis บนลิ้นรองเท้า สามารถสวมเดินบนท้องถนนในเมือง หรือเก็บขยะริมชายหาดก็ได้ อัปเปอร์ผ้า adidas Primeknit สัมผัสนุ่มโอบกระชับเท้า ประกอบเข้ากับพื้นชั้นล่าง Boost มอบความสบายที่กล้าท้าให้คุณมาพิสูจน์", 1840.0, 50.0, "2022-7-15", 0, 5, 30, "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", new String[]{"http://supersports-media-live-th.s3.amazonaws.com/product/28/089/1.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/2.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/3.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/4.jpg", "http://supersports-media-live-th.s3.amazonaws.com/product/28/089/5.jpg"}, 1, 1, "ACTIVE", new Date(), null, new String[]{"36", "38", "40", "42", "44", "45", "50"}));


        productRepository.saveAll(lsProduct);
    }


}
