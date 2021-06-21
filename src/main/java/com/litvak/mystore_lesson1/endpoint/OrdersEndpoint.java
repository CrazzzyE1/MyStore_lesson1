package com.litvak.mystore_lesson1.endpoint;

import com.litvak.mystore_lesson1.domain.Order;
import com.litvak.mystore_lesson1.service.OrderService;
import com.litvak.mystore_lesson1.service.UserService;
import com.litvak.mystore_lesson1.ws.orders.GetOrdersRequest;
import com.litvak.mystore_lesson1.ws.orders.GetOrdersResponse;
import com.litvak.mystore_lesson1.ws.orders.OrdersWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;


@Endpoint
public class OrdersEndpoint {
    public static final String NAMESPACE_URL = "http://litvak.com/mystore_lesson1/ws/orders";

    private OrderService orderService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

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
        ws.setUsername(order.getUser().getName());
        ws.setStatus(String.valueOf(order.getStatus()));
        ws.setSumma(order.getSum());
        ws.setProductAmount(order.getDetails().get(0).getAmount());
        try {
            ws.setCreatedDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(order.getCreated().toString()));
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return ws;
    }
}
