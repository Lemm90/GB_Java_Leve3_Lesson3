package ru.khorolskiy.level_3.lesson_3.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.khorolskiy.level_3.lesson_3.ProductRepository;

@Controller
public class MainController {
    private ProductRepository productRepository;

    public MainController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping ("/show_product")
    public String show(Model model){
        model.addAttribute("products", productRepository.getAllProducts());
        return "Products_page";
    }
}
