package com.syed.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.imcs.syed.wsdl.CreateOrderRequest;
import com.imcs.syed.wsdl.CreateOrderResponse;
import com.imcs.syed.wsdl.GetAllProductsRequest;
import com.imcs.syed.wsdl.GetAllProductsResponse;
import com.imcs.syed.wsdl.GetProductsByNameAndCategoryRequest;
import com.imcs.syed.wsdl.GetProductsByNameAndCategoryResponse;
import com.imcs.syed.wsdl.GetProductsByNameRequest;
import com.imcs.syed.wsdl.GetProductsByNameResponse;
import com.imcs.syed.wsdl.Order;

public class ProductsClient extends WebServiceGatewaySupport {

	public GetAllProductsResponse getAllProducts() {
		GetAllProductsRequest request = new GetAllProductsRequest();
		GetAllProductsResponse response = (GetAllProductsResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:9090/ws/", request,
				new SoapActionCallback("http://syed.imcs.com/Product/getAllProductsRequest"));
		return response;
	}

	public GetProductsByNameResponse getListOfProducts(String productName) {
		GetProductsByNameRequest request = new GetProductsByNameRequest();
		GetProductsByNameResponse response = (GetProductsByNameResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:9090/ws/", request,
				new SoapActionCallback("http://syed.imcs.com/Product/getProductsByNameRequest"));
		return response;
	}

	public GetProductsByNameAndCategoryResponse getListOfProducts(String productName, String productCategory) {
		GetProductsByNameAndCategoryRequest request = new GetProductsByNameAndCategoryRequest();
		GetProductsByNameAndCategoryResponse response = (GetProductsByNameAndCategoryResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:9090/ws/", request,
						new SoapActionCallback("http://syed.imcs.com/Product/getProductsByNameAndCategoryRequest"));
		return response;
	}
	public CreateOrderResponse createOrder(Order newOrder) {
		CreateOrderRequest request = new CreateOrderRequest();
		CreateOrderResponse response = (CreateOrderResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:9090/ws/", request,
						new SoapActionCallback("http://syed.imcs.com/Product/createOrderRequest"));
		return response;
	}
}