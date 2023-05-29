<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<c:set var="i" value="0"></c:set>
<c:forEach var="it" items="${list}">
<c:set var="i" value="${i+1}"></c:set>
<c:if test="${i <= 12}">

	<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
		<div class="card product-item border-0 mb-4">
			<div
				class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
				<img class="img-fluid w-100 p-5" src="img/${it.image}" alt="">
			</div>
			<div
				class="card-body border-left border-right text-center p-0 pt-4 pb-3">
				<h6 class="text-truncate mb-3">${it.pr_Name}</h6>
				<div class="d-flex justify-content-center">
					<h6>${it.price}VND</h6>
					<h6 class="text-muted ml-2">
						<del>Discount</del>
					</h6>
				</div>
			</div>
			<div
				class="card-footer d-flex justify-content-between bg-light border">
				
				<a href='<c:url value="/detail?idSelected=${it.ID_Product}"></c:url>' class="btn btn-sm text-dark p-0"><i
					class="fas fa-eye text-primary mr-1"></i>Chi tiết</a> 
					
					<a href='<c:url value="/addCart?id=${it.ID_Product}"></c:url>' class="btn btn-sm text-dark p-0">
					<i class="fas fa-shopping-cart text-primary mr-1"></i>Thêm vào giỏ</a>
			</div>
		</div>
	</div>
</c:if>
</c:forEach>
