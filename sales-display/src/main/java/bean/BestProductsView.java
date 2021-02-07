package bean;

import dto.BestProducts;
import lombok.extern.log4j.Log4j;
import service.ProductService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Log4j
@Named
@ApplicationScoped
public class BestProductsView implements Serializable {

    @Inject
    private ProductService productService;

    @Inject
    private ReceiverConfigBean receiverConfigBean;

    @Inject
    @Push(channel = "bestProducts")
    private PushContext context;

    private BestProducts bestProducts;

    @PostConstruct
    public void init() {
        receiverConfigBean.openConnection();
        bestProducts = productService.getBestProducts();
    }

    public void updateStand() {
        log.info("Update...");
        bestProducts = productService.getBestProducts();
        context.send("update");
    }

    public BestProducts getBestProducts() {
        return bestProducts;
    }

}
