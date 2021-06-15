package com.litvak.mystore_lesson1.endpoint;

import com.litvak.mystore_lesson1.domain.Order;
import com.litvak.mystore_lesson1.dto.ProductDTO;
import com.litvak.mystore_lesson1.service.OrderService;
import com.litvak.mystore_lesson1.service.ProductService;
import com.litvak.mystore_lesson1.ws.orders.GetOrdersRequest;
import com.litvak.mystore_lesson1.ws.orders.GetOrdersResponse;
import com.litvak.mystore_lesson1.ws.orders.OrdersWS;
import com.litvak.mystore_lesson1.ws.products.GetProductsRequest;
import com.litvak.mystore_lesson1.ws.products.GetProductsResponse;
import com.litvak.mystore_lesson1.ws.products.ProductsWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigInteger;

@Endpoint
public class OrdersEndpoint {
    public static final String NAMESPACE_URL = "http://litvak.com/mystore_lesson1/ws/orders";

    private OrderService orderService;

    @Autowired
    public OrdersEndpoint(OrderService orderService) {
        this.orderService = orderService;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getOrdersRequest")
    @ResponsePayload
    public GetOrdersResponse getOrderWS(@RequestPayload GetOrdersRequest request) {
        GetOrdersResponse response = new GetOrdersResponse();
        orderService.getAll()
                .forEach(order -> response.getOrders().add(createOrderWs(order)));
        return response;
    }

    private OrdersWS createOrderWs(Order order) {
        OrdersWS ws = new OrdersWS();
        ws.setId(order.getId());
ws.setSumma(55);
ws.setProductAmount(new BigInteger("5"));
ws.setUsername("username");
//ws.setCreatedDate();
        return ws;
    }

//    public GetProductsResponse getProductWS(@RequestPayload GetProductsRequest request) {
//        GetProductsResponse response = new GetProductsResponse();
//        productService.getAll()
//                .forEach(dto -> response.getProducts().add(createProductWs(dto)));
//        return response;
//    }
//
//    private ProductsWS createProductWs(ProductDTO dto) {
//        ProductsWS ws = new ProductsWS();
//        ws.setId(dto.getId());
//        ws.setPrice(Double.parseDouble(dto.getPrice().toString()));
//        ws.setTitle(dto.getTitle());
//        return ws;
//    }
}
