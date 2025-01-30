package com.test.tarifas.domain;

import java.time.LocalDateTime;

public class PriceDTO {
    private Long priceList;
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long productId;
    private Double price;
    private String curr;


    public PriceDTO(Long priceList, Long brandId, LocalDateTime startDate, LocalDateTime endDate, Long productId, Double price, String curr) {
        this.priceList = priceList;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.productId = productId;
        this.price = price;
        this.curr = curr;
    }


	public Long getPriceList() {
		return priceList;
	}


	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}


	public Long getBrandId() {
		return brandId;
	}


	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}


	public LocalDateTime getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}


	public LocalDateTime getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getCurr() {
		return curr;
	}


	public void setCurr(String curr) {
		this.curr = curr;
	}

   
}

